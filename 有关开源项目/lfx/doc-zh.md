# Karmada 自签名证书生成与复用方案

## 1. 背景与问题说明

### 1.1 背景介绍

- **Karmada 多集群管理方案**
  Karmada 支持跨集群的应用调度与管理，核心组件包括 API Server、Controller Manager、Scheduler、Aggregated API Server 等，以及多个客户端组件（如控制器、代理等）。
- **现状问题**
  目前所有组件使用统一的自签证书，导致各组件身份混淆、缺乏唯一标识，而且存在安全风险，不符合业界最佳实践。

### 1.2 问题描述

- **服务器证书**
  每个服务器组件需拥有独立的证书。在生成时，证书的 Subject.CommonName (CN) 必须设置为组件名称，用以明确组件身份，并在扩展密钥使用中包含 `ExtKeyUsageServerAuth`。
- **客户端证书复用**
  议题要求“同一客户端可以为不同的服务器使用一致的证书”，即：一个客户端组件仅生成一份客户端证书，当该客户端需要与多个服务器建立 TLS 连接时，均可复用这张证书。

------

## 2. 设计目标

- **单一 CA 签发**
  使用统一 CA 证书对所有组件签发证书，确保信任链的一致性。
- **组件级的证书定制**
  - **服务器组件**：为每个服务器组件生成单独服务器证书，证书中 CN 为组件名称，扩展密钥用途设置为 `ExtKeyUsageServerAuth`。
  - **客户端组件**：为每个客户端生成唯一的客户端证书，证书中 CN 为客户端名称，扩展密钥用途设置为 `ExtKeyUsageClientAuth`。该证书由同一客户端在与不同服务器连接时复用。

------

## 3. 方案设计思路

### 3.1 证书生成逻辑调整

#### 3.1.1 服务器组件证书生成

- **目标**：
  对于预定义的服务器组件（大约8个），逐一调用证书生成接口，传入组件名称，以确保证书中 Subject.CommonName 正确反映对应组件。
- **关键点**：
  - 接口中增加传入组件名称参数；
  - 设置 X509 证书模板时，CN 设置为组件名称；
  - 设置扩展密钥使用为 `x509.ExtKeyUsageServerAuth`；
  - 使用统一 CA 签发，并以 PEM 格式输出证书及私钥。

#### 3.1.2 客户端组件证书生成与复用

- **目标**：
  为每个客户端组件生成单一客户端证书（大约11个），后续同一客户端在与多个服务器建立 TLS 连接时均复用该证书。
- **澄清说明**：
  - 复用是指 **同一客户端** 使用一致证书与不同服务器进行安全通信，而 **多个不同客户端** 必须各自生成独立证书；
  - 这样既保证身份唯一性、便于审计，也确保各组件的访问权限互不干扰。
- **关键点**：
  - 将客户端标识（例如 “karmada-scheduler”）传入证书生成接口，设置为 Subject.CommonName；
  - 设置扩展密钥使用为 `x509.ExtKeyUsageClientAuth`；
  - 输出单一客户端证书后，存入 Kubernetes Secret（例如 `karmada-client-<clientName>-cert`），供客户端加载后复用。

#### 示例伪代码

```go
func GenerateComponentCert(componentName string, caCert *x509.Certificate, caKey interface{}, forServer bool) (certPEM, keyPEM []byte, err error) {
    tmpl := &x509.Certificate{
        SerialNumber: big.NewInt(time.Now().UnixNano()),
        Subject: pkix.Name{
            CommonName:   componentName, // 使用组件名称作为 CN
            Organization: []string{"Karmada"},
        },
        NotBefore:             time.Now(),
        NotAfter:              time.Now().Add(365 * 24 * time.Hour),
        KeyUsage:              x509.KeyUsageDigitalSignature | x509.KeyUsageKeyEncipherment,
        ExtKeyUsage:           []x509.ExtKeyUsage{},
        BasicConstraintsValid: true,
    }
    if forServer {
        tmpl.ExtKeyUsage = append(tmpl.ExtKeyUsage, x509.ExtKeyUsageServerAuth)
    } else {
        tmpl.ExtKeyUsage = append(tmpl.ExtKeyUsage, x509.ExtKeyUsageClientAuth)
    }
    // 生成私钥、进行签名并编码为 PEM 格式
    return certPEM, keyPEM, nil
}
```

- ### 3.2 工作流任务调整

  - **初始化任务调整**：  
    在初始化过程中修改或扩展 `tasks.NewCertTask()`（或相关任务中的证书生成部分），对预定义的服务器组件依次调用生成服务器证书接口，并将证书和私钥导入对应的 Kubernetes Secret 中（例如 `karmada-apiserver-cert`、`karmada-controller-manager-cert` 等）。

  - **客户端证书处理**：  
    如果某个客户端组件需要与多个服务器建立安全连接，则在生成证书时只生成一份，并在 Secret 命名中标明（例如 `karmada-client-<clientName>-cert`），确保该客户端在各服务器侧均能加载相同的证书内容。

  ### 3.3 配置管理和参数扩展

  - **配置项增加**：  
    在项目配置文件或命令行中增加相关参数，以便定义各组件的名称、证书有效期、生成策略等。例如，可以在 `karmadactl init` 的参数中加入 `--component-certs-config` 参数，使得证书生成任务根据配置列表完成多组件证书生成。

  - **映射表设计**：  
    定义一个组件名称与其证书用途（服务器或客户端）的映射表，硬编码在代码中或通过 YAML 文件配置，使得后续扩展和管理更加灵活。

  ### 3.4 安全性与合规性

  - **信任链管理**：  
    所有服务器和客户端必须提前配置信任同一 CA 证书，确保在 TLS 握手过程中对客户端证书进行校验。

  - **证书更新机制**：  
    设计证书更新流程，包括定期检查有效期、提前生成更新证书、无缝替换 Secret 等，降低因证书过期导致的中断风险。

------

## 4. 客户端证书“复用”方案解析

### 4.1 客户端证书生成

- **明确唯一标识**
  每个客户端组件（例如 “karmada-scheduler”）应有唯一名称，该名称在证书中作为 CN 使用。
- **生成流程**
  利用上述 `GenerateComponentCert` 接口，传入客户端名称和 `forServer=false` 生成客户端证书；同时设定 `ExtKeyUsageClientAuth` 标识。
- **存储方式**
  将生成的证书与私钥存入 Kubernetes Secret（例如 `karmada-client-<clientName>-cert`），作为客户端运行时加载的凭据。

### 4.2 客户端证书使用

- **加载与应用**
  客户端在启动时从对应 Secret 中加载证书和私钥，并保存到内存或本地文件，供 TLS 模块使用。
- **与服务器建立 TLS 连接**
  客户端在与不同服务器发起 TLS 连接时均使用同一份加载的客户端证书，前提是这些服务器都已配置统一信任同一 CA 签发的证书。

### 4.3 服务器端验证要求

- **统一 CA 签发与信任**
  所有服务器组件在初始化时须加载统一的 CA 证书，用于验证客户端证书的合法性。
- **TLS 握手验证**
  服务器在 TLS 握手过程中，通过检查客户端证书是否由信任的 CA 签发，并解析证书中的 CN 来确认客户端身份。

### 4.4 证书更新与集中管理

- **更新机制**
  客户端证书在临近过期或出现密钥泄露时可集中更新，只需更新存储在 Secret 中的证书内容，无需对每个服务器端重复操作。
- **运维优势**
  通过统一管理单一客户端证书，降低维护复杂度，确保同一客户端在多服务器间保持一致身份，便于审计与故障排查。

------

## 5. 实现计划与测试策略

###  实现计划

1. **完善证书生成模块**
   - **修改和扩展现有证书生成函数**  
     在 `operator/pkg/certs` 下实现或扩展包括：  
     - `GenerateComponentCert(componentName string, caCert, caKey, forServer bool)`；  
     - 根据传入的 `forServer` 参数决定扩展密钥用途。  
     - 生成后的证书及私钥应统一以 PEM 格式返回。
2. **调整工作流任务**
   - **证书生成任务调整**  
     修改 `tasks.NewCertTask()`：  
     - 遍历预定义的服务器组件列表，每个组件调用 `GenerateComponentCert(name, ...)`，并将生成的证书写入对应 Secret；  
     - 针对客户端组件，采用同样方式生成单一客户端证书，并保证后续各目标服务器能够加载、验证。
   - **Secret 存储及命名**  
     建议 Secret 命名方式示例：  
     - 服务器证书：`<component>-server-cert`；  
     - 客户端证书：`<component>-client-cert`。  
       存储时建议使用 Kubernetes 原生的 TLS 类型 Secret 或 Opaque 类型，根据实际需求选择。
3. **增加配置支持**
   - **命令行和配置文件扩展**  
     在 `cmdinit` 模块或相关 CLI 命令中，增加用于调整证书策略的参数，例如：  
     - `--cert-validity-period`（证书有效期）；  
     - `--ca-cert-file` 与 `--ca-key-file`（自定义 CA 文件）；  
     - 组件证书映射表路径等。
   - **映射表的使用**  
     将组件列表（服务器和客户端）及其用途通过 YAML 文件或代码硬编码定义，供初始化任务读取，动态生成各组件对应的证书。
4. **测试验证**
   - **单元测试**：  
     针对证书生成逻辑、Secret 创建功能进行单元测试，验证生成证书内容正确（CN、KeyUsage、有效期等）。
   - **集成测试**：  
     在 Karmada 部署集群上进行全流程测试，验证各组件启动后是否能正确加载对应证书，以及客户端与多个服务器的 TLS 连接是否顺畅。

   - **安全验证**：  
     检查信任链配置及证书替换机制，确保在证书更新时不会影响系统正常通信。
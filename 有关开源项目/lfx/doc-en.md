# Karmada Self-Signed Certificate Generation and Reuse Plan

## 1. Background and Problem Description

### 1.1 Background Introduction

- **Karmada Multi-Cluster Management Solution**
  Karmada supports cross-cluster application scheduling and management. Core components include the API Server, Controller Manager, Scheduler, Aggregated API Server, etc., along with multiple client components (e.g., controllers, proxies, etc.).
- **Current Issues**
  Currently, all components use a unified self-signed certificate, which leads to confusion of identities, a lack of unique identification, and potential security risks, which does not align with industry best practices.

### 1.2 Problem Description

- **Server Certificates**
  Each server component needs to have a separate certificate. When generating the certificate, the Subject.CommonName (CN) must be set to the component name to clearly identify the component. The `ExtKeyUsageServerAuth` should also be included in the extended key usage.
- **Client Certificate Reuse**
  The goal is to allow "the same client to use a consistent certificate for different servers", meaning that a client component should generate only one client certificate. When the client needs to establish TLS connections with multiple servers, it can reuse this certificate.

------

## 2. Design Goals

- **Single CA Issuance**
  Use a unified CA certificate to issue certificates for all components, ensuring the consistency of the trust chain.
- **Component-Level Certificate Customization**
  - **Server Components**: Generate separate server certificates for each server component, where the CN is the component name and the extended key usage is set to `ExtKeyUsageServerAuth`.
  - **Client Components**: Generate a unique client certificate for each client, where the CN is the client name and the extended key usage is set to `ExtKeyUsageClientAuth`. This certificate is reused by the same client when connecting to different servers.

------

## 3. Solution Design Approach

### 3.1 Certificate Generation Logic Adjustments

#### 3.1.1 Server Component Certificate Generation

- **Goal**:
  For predefined server components (about 8 components), sequentially call the certificate generation interface, passing the component name to ensure that the CN in the certificate reflects the corresponding component.
- **Key Points**:
  - Add a parameter for the component name to the interface.
  - Set the CN to the component name when creating the X509 certificate template.
  - Set the extended key usage to `x509.ExtKeyUsageServerAuth`.
  - Use a unified CA for issuance and output the certificate and private key in PEM format.

#### 3.1.2 Client Component Certificate Generation and Reuse

- **Goal**:
  Generate a single client certificate (about 11 components) for each client. This certificate will be reused when the same client establishes TLS connections with multiple servers.
- **Clarification**:
  - Reuse means **the same client** uses the same certificate to communicate securely with different servers, whereas **different clients** must generate separate certificates.
  - This approach ensures unique identification, facilitates auditing, and prevents interference in access permissions.
- **Key Points**:
  - Pass the client identifier (e.g., "karmada-scheduler") to the certificate generation interface, setting it as the Subject.CommonName.
  - Set the extended key usage to `x509.ExtKeyUsageClientAuth`.
  - After generating the client certificate, store it in a Kubernetes Secret (e.g., `karmada-client-<clientName>-cert`) for the client to load and reuse.

#### Example Pseudo Code

```go
func GenerateComponentCert(componentName string, caCert *x509.Certificate, caKey interface{}, forServer bool) (certPEM, keyPEM []byte, err error) {
    tmpl := &x509.Certificate{
        SerialNumber: big.NewInt(time.Now().UnixNano()),
        Subject: pkix.Name{
            CommonName:   componentName, // Use component name as CN
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
    // Generate private key, sign, and encode as PEM format
    return certPEM, keyPEM, nil
}
```

### 3.2 Workflow Task Adjustments

- **Initialization Task Adjustments**:
  Modify or extend `tasks.NewCertTask()` (or relevant tasks involving certificate generation) to sequentially call the server certificate generation interface for predefined server components. Import the generated certificates and private keys into the corresponding Kubernetes Secrets (e.g., `karmada-apiserver-cert`, `karmada-controller-manager-cert`, etc.).
- **Client Certificate Handling**:
  If a client component needs to connect to multiple servers, generate only one certificate and store it in the Secret (e.g., `karmada-client-<clientName>-cert`), ensuring that the client can load and use the same certificate across all servers.

### 3.3 Configuration Management and Parameter Expansion

- **Configuration Item Addition**:
  Add related parameters in the project configuration files or command-line options to define component names, certificate validity periods, and generation policies. For example, the `--component-certs-config` parameter could be added to `karmadactl init`, allowing the certificate generation task to generate certificates for multiple components based on a configuration list.
- **Mapping Table Design**:
  Define a mapping table for component names and their certificate usage (server or client), either hardcoded in the code or configured via a YAML file. This approach will make future expansion and management more flexible.

### 3.4 Security and Compliance

- **Trust Chain Management**:
  All servers and clients must pre-configure and trust the same CA certificate to ensure proper verification of client certificates during the TLS handshake.
- **Certificate Update Mechanism**:
  Design a certificate update process that includes regularly checking expiration dates, generating updated certificates in advance, and seamlessly replacing Secrets. This will reduce the risk of disruption caused by expired certificates.

------

## 4. Client Certificate "Reuse" Solution Analysis

### 4.1 Client Certificate Generation

- **Clear Unique Identification**
  Each client component (e.g., "karmada-scheduler") should have a unique name, which is used as the CN in the certificate.
- **Generation Process**
  Use the `GenerateComponentCert` interface mentioned above, passing the client name and setting `forServer=false` to generate the client certificate. The `ExtKeyUsageClientAuth` flag should be set.
- **Storage**
  Store the generated certificate and private key in Kubernetes Secrets (e.g., `karmada-client-<clientName>-cert`) to be used as credentials by the client at runtime.

### 4.2 Client Certificate Usage

- **Loading and Application**
  The client loads the certificate and private key from the corresponding Secret during startup, storing them in memory or local files for TLS usage.
- **Establishing TLS Connection with Servers**
  The client uses the same loaded client certificate when establishing TLS connections with different servers, as long as those servers trust the same CA certificate.

### 4.3 Server-Side Validation Requirements

- **Unified CA Issuance and Trust**
  All server components must load a unified CA certificate during initialization to validate the legality of client certificates.
- **TLS Handshake Validation**
  During the TLS handshake, the server checks if the client certificate was issued by a trusted CA and verifies the client's identity by parsing the CN from the certificate.

### 4.4 Certificate Update and Centralized Management

- **Update Mechanism**
  When a client certificate is nearing expiration or key compromise occurs, it can be updated centrally by simply updating the certificate content stored in the Secret. No operation is required on each server side.
- **Operational Advantages**
  Centralized management of a single client certificate reduces maintenance complexity and ensures consistent client identity across multiple servers, facilitating auditing and troubleshooting.

------

## 5. Implementation Plan and Testing Strategy

### Implementation Plan

1. **Enhance Certificate Generation Module**

   - Modify and Extend Existing Certificate Generation Functions

     Implement or extend functions under `operator/pkg/certs`, including:

     - `GenerateComponentCert(componentName string, caCert, caKey, forServer bool)`;
     - Decide on the extended key usage based on the `forServer` parameter.
     - Return the generated certificate and private key in PEM format.

2. **Adjust Workflow Tasks**

   - **Certificate Generation Task Adjustments**
     Modify `tasks.NewCertTask()`:
     - Iterate over predefined server components, calling `GenerateComponentCert(name, ...)` for each, and write the generated certificates to the corresponding Secret.
     - For client components, generate a single client certificate using the same approach and ensure that subsequent target servers can load and validate the certificate.
   - **Secret Storage and Naming**
     Recommended Secret naming conventions:
     - Server certificates: `<component>-server-cert`;
     - Client certificates: `<component>-client-cert`.
       Store them in Kubernetes-native TLS-type Secrets or Opaque-type Secrets, depending on actual needs.

3. **Add Configuration Support**

   - **CLI and Configuration File Expansion**
     Add parameters to the `cmdinit` module or relevant CLI commands to adjust certificate policies, such as:
     - `--cert-validity-period` (certificate validity period);
     - `--ca-cert-file` and `--ca-key-file` (custom CA files);
     - Path for the component certificate mapping table, etc.
   - **Mapping Table Usage**
     Define the list of components (servers and clients) and their usage (server or client) through a YAML file or hardcoded in the code. This will be read by the initialization task to dynamically generate corresponding certificates for each component.

4. **Testing and Verification**

   - **Unit Testing**:
     Test the certificate generation logic and Secret creation functionality, verifying that the generated certificate content (CN, KeyUsage, validity, etc.) is correct.
   - **Integration Testing**:
     Perform end-to-end testing on a Karmada deployment cluster, verifying that each component loads the correct certificates and that clients can establish TLS connections with multiple servers.
   - **Security Validation**:
     Check the trust chain configuration and certificate replacement mechanism to ensure that updates do not affect normal communication in the system.
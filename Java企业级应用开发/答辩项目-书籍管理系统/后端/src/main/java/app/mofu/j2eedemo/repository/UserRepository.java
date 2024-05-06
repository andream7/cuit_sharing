package app.mofu.j2eedemo.repository;

import app.mofu.j2eedemo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

// @Component 注解标明这个类是一个 Spring 组件，Spring 会自动把这个类扫描并注入到 Spring 容器中
@Component
// 定义一个接口继承 CrudRepository 接口，
// 泛型的第一个参数是实体类类型，第二个参数是主键的类型
public interface UserRepository extends CrudRepository<User, Integer> {
    // 利用 JPA 的方法命名规则，我们只需要定义方法的签名，而不需要提供具体的实现
    // Spring Data JPA 会根据方法名自动生成相应的 SQL 查询
    User findByUsername(String username);  // 根据用户名查询用户
}
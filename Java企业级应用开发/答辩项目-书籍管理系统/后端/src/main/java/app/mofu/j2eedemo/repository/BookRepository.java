package app.mofu.j2eedemo.repository;

import app.mofu.j2eedemo.model.Book;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

// @Component注解表示这是一个Spring组件，Spring会自动扫描到这个组件并将其注入到Spring容器中
@Component
// 定义一个接口继承ListCrudRepository接口，
// 泛型第一个参数是实体类类型，第二个参数是主键的类型
public interface BookRepository extends ListCrudRepository<Book, Long> {
    // 利用JPA的方法命名规则，只需定义方法签名即可，不需要具体实现，Spring Data JPA会根据方法名自动生成相应的SQL查询
    Optional<Book> findById(Long id);  // 根据ID查找员工
}
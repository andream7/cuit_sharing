package app.mofu.j2eedemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

// @Entity 注解标明这是一个数据库实体类
// @Data 注解用于简化代码，它将为类的所有字段自动生成 getter 和 setter
@Entity
@Data
public class User {
    // @Id 注解表示这个字段是主键
    @Id
    private String username; // 用户名
    private String password; // 密码
}
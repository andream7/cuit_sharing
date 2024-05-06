package app.mofu.j2eedemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

// @Entity注解表示这个类是一个数据库实体类
// @Data注解用于简化代码，它会为类的所有字段自动生成 getters 和 setters
@Entity
@Data
public class Book {
    // @Id注解表示这个字段是主键
    // @GeneratedValue注解表示这个字段的值是自动生成的，其中strategy参数表示生成策略是自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //书籍ID
    private String name; //书名
    private String type; //类型
    private String author; //作者
    private String email; //出版社邮件
    private String address; //出版社地址
    private String publishing; //出版社
    private String code; //书码
    private Date release_date; //书籍发布日期
    private Double price; //价格
}
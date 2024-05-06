package app.mofu.j2eedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data 注解用于简化代码，它会自动生成 getter、setter、equals、hashCode 和 toString 方法
// @AllArgsConstructor 注解会为这个类生成一个包含所有变量的构造函数
// @NoArgsConstructor 注解会为这个类生成一个无参的构造函数
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private boolean success; //表示请求是否成功
    private Object payload; //表示请求返回的数据
    private String msg; //表示请求返回的信息
}
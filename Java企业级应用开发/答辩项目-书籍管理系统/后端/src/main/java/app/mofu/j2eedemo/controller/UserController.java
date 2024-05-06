package app.mofu.j2eedemo.controller;

import app.mofu.j2eedemo.dto.ResponseDto;
import app.mofu.j2eedemo.model.User;
import app.mofu.j2eedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// @RestController注解表示该类为一个HTTP API的控制器
// @RequestMapping注解表示该控制器的API路径前缀为/user
@RestController
@RequestMapping(path = "/user")
public class UserController {
    // @Autowired注解表示自动注入 UserRepository 类型的bean.
    // Spring会在运行时自动创建一个UserRepository的实例（如果有必要的话）并传递给这个变量
    @Autowired
    private UserRepository userRepository;

    // @GetMapping注解表示使用HTTP的GET方法访问/add路径时会调用这个方法
    // @ResponseBody注解表示将方法返回的对象直接序列化为JSON或XML，而不是寻找模板
    // 这个方法接收两个参数，分别从GET请求的查询字符串中获取
    @GetMapping(path = "/add")
    public @ResponseBody ResponseDto addUser(@RequestParam String username, @RequestParam String password) {
        User user = new User(); // 创建一个新的用户实例
        user.setUsername(username); // 设置用户名
        user.setPassword(password); // 设置密码
        userRepository.save(user); // 使用userRepository保存用户到数据库中
        return new ResponseDto(true, null, "ok"); // 返回成功的响应
    }
}
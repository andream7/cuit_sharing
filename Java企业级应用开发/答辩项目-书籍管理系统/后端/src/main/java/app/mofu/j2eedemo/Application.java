package app.mofu.j2eedemo;

import app.mofu.j2eedemo.dto.ResponseDto;
import app.mofu.j2eedemo.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 启动 Spring Boot 应用
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173") // 允许跨域请求来源
                        .allowCredentials(true) // 允许携带凭证，如cookies
                        .allowedMethods("GET", "POST", "PUT", "DELETE"); // 允许的请求方式
            }
        };
    }
}

@Configuration
class WebConfig implements WebMvcConfigurer {
    @Autowired
    private AuthInterceptor authInterceptor; // 自动注入 AuthInterceptor

    // 重写 addInterceptors 方法，添加自定义的 AuthInterceptor 拦截器并配置拦截路径
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor) // 添加 AuthInterceptor
                .addPathPatterns("/**") // 所有路径都被拦截
                .excludePathPatterns("/login", "/user/add"); // 除了 "/login" 和 "/user/add" 之外的所有路径
    }
}

// 全局异常处理类，当 Controller 层出现异常时这个类会接受并处理
@ControllerAdvice
class GlobalExceptionHandler {
    // 方法上的 @ExceptionHandler 注解使得当出现 Exception 类型的异常时，该方法会被调用。
    @ExceptionHandler(Exception.class)
    @ResponseBody // 将返回的数据写入 HTTP 响应体
    public ResponseDto handleException(Exception ex) {
        return new ResponseDto(false, null, ex.getMessage()); // 创建并返回一个包含异常消息的 ResponseDto 对象
    }
}
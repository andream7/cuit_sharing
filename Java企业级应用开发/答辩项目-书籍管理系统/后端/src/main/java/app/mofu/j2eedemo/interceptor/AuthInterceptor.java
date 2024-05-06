package app.mofu.j2eedemo.interceptor;

import app.mofu.j2eedemo.dto.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// @Component注解表示这个类将被Spring自动扫描并创建实例
// AuthInterceptor类实现了HandlerInterceptor接口，所以它是一个处理器拦截器，可以在请求处理之前或之后执行某些操作
@Component
public class AuthInterceptor implements HandlerInterceptor {
    // preHandle方法将在请求被具体的Controller处理之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);  // 从请求中获取会话 （如果当前请求没有与任何会话关联，并且create为false，则此方法返回null）
        if (session != null && session.getAttribute("username") != null) {
            return true;  // 如果会话存在，并且“username”属性也存在，则请求继续处理并返回true
        }
        ObjectMapper mapper = new ObjectMapper();   // 创建一个新的ObjectMapper实例，它可以将Java对象转换为JSON字符串，或者将JSON字符串转换为Java对象
        response.setContentType("application/json"); // 设置响应的内容类型为JSON
        // 将一个新的ResponseDto实例转换为JSON字符串，并写入响应的输出流。同时设置认证失败的信息
        response.getWriter().write(mapper.writeValueAsString(new ResponseDto(false, null, "unauthorized")));
        return false;  // 禁止请求继续处理并返回false
    }
}
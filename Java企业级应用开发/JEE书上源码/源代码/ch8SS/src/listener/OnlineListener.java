package listener;
import java.util.ArrayList;  
import java.util.List;  
import javax.servlet.ServletContext;  
import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;  
import javax.servlet.http.HttpSessionAttributeListener;  
import javax.servlet.http.HttpSessionBindingEvent;
public class OnlineListener implements ServletContextListener, HttpSessionAttributeListener{      
    private ServletContext application = null;  
    /**
     * 应用上下文初始时会回调的方法  
     */
    @Override  
    public void contextInitialized(ServletContextEvent e) {  
        //初始化一个application对象  
        application = e.getServletContext();  
        //设置一个列表属性，用于保存在线用户名  
        this.application.setAttribute("online", new ArrayList<String>());  
    }  
    /**
     * 往会话中添加属性时的回调方法  
     */
    @Override  
    public void attributeAdded(HttpSessionBindingEvent e) {  
        //取得用户名列表  
        List<String> onlines = (List<String>) this.application.getAttribute("online");  
        onlines.add((String) e.getValue());  
        //将添加后的列表重新设置到application属性中.  
        this.application.setAttribute("online", onlines);  
    }  
}

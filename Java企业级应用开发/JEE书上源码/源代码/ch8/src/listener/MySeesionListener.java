package listener;
import java.io.Serializable;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
public class MySeesionListener implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable {  
    private static final long serialVersionUID = -4780592776386225973L;  
    private String name;  
    /**
     * 活化
     */
    public void sessionDidActivate(HttpSessionEvent se) {  
        HttpSession session = se.getSession();  
        System.out.println(this + "已经成功从硬盘中加载。sessionId: " + session.getId());  
    }  
    /**
     * 即将被钝化到硬盘时  
     */
    public void sessionWillPassivate(HttpSessionEvent se) {  
        HttpSession session = se.getSession();  
        System.out.println(this + "即将保存到硬盘。sessionId: " + session.getId());  
    }  
  
    /**
     * 绑定到session  
     */
    public void valueBound(HttpSessionBindingEvent event) {  
        HttpSession session = event.getSession();  
        String name = event.getName();  
        System.out.println(this + "被绑定到session \"" + session.getId() + "\"的" + name + "属性上");  
    }  
  
    /**
     * 从session中移除后  
     */
    public void valueUnbound(HttpSessionBindingEvent event) {  
        HttpSession session = event.getSession();  
        String name = event.getName();  
        System.out.println(this + "被从session \"" + session.getId() + "\"的" + name + "属性上移除");  
    }  
    @Override  
    public String toString() {  
        return "MySeesionListener(" + name + ")";  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
}

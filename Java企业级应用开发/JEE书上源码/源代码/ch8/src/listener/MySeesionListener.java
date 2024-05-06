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
     * �
     */
    public void sessionDidActivate(HttpSessionEvent se) {  
        HttpSession session = se.getSession();  
        System.out.println(this + "�Ѿ��ɹ���Ӳ���м��ء�sessionId: " + session.getId());  
    }  
    /**
     * �������ۻ���Ӳ��ʱ  
     */
    public void sessionWillPassivate(HttpSessionEvent se) {  
        HttpSession session = se.getSession();  
        System.out.println(this + "�������浽Ӳ�̡�sessionId: " + session.getId());  
    }  
  
    /**
     * �󶨵�session  
     */
    public void valueBound(HttpSessionBindingEvent event) {  
        HttpSession session = event.getSession();  
        String name = event.getName();  
        System.out.println(this + "���󶨵�session \"" + session.getId() + "\"��" + name + "������");  
    }  
  
    /**
     * ��session���Ƴ���  
     */
    public void valueUnbound(HttpSessionBindingEvent event) {  
        HttpSession session = event.getSession();  
        String name = event.getName();  
        System.out.println(this + "����session \"" + session.getId() + "\"��" + name + "�������Ƴ�");  
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

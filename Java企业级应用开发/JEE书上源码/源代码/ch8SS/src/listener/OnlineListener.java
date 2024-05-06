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
     * Ӧ�������ĳ�ʼʱ��ص��ķ���  
     */
    @Override  
    public void contextInitialized(ServletContextEvent e) {  
        //��ʼ��һ��application����  
        application = e.getServletContext();  
        //����һ���б����ԣ����ڱ��������û���  
        this.application.setAttribute("online", new ArrayList<String>());  
    }  
    /**
     * ���Ự���������ʱ�Ļص�����  
     */
    @Override  
    public void attributeAdded(HttpSessionBindingEvent e) {  
        //ȡ���û����б�  
        List<String> onlines = (List<String>) this.application.getAttribute("online");  
        onlines.add((String) e.getValue());  
        //����Ӻ���б��������õ�application������.  
        this.application.setAttribute("online", onlines);  
    }  
}

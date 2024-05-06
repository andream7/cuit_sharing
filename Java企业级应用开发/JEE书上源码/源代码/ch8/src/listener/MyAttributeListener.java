package listener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
public class MyAttributeListener implements HttpSessionAttributeListener{
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
	     String name = se.getName();  
	     System.out.println("新建session属性：" + name + ", 值为：" + se.getValue());
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		HttpSession session = se.getSession();  
        String name = se.getName();  
        Object oldValue = se.getValue();  
        System.out.println("修改session属性：" + name + ", 原值：" + oldValue + ", 新值：" + session.getAttribute(name));  
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) { 
	     String name = se.getName();  
	     System.out.println("删除session属性：" + name + ", 值为：" + se.getValue()); 
	}
}

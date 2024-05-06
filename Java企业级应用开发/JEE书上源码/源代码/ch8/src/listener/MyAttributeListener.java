package listener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
public class MyAttributeListener implements HttpSessionAttributeListener{
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
	     String name = se.getName();  
	     System.out.println("�½�session���ԣ�" + name + ", ֵΪ��" + se.getValue());
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		HttpSession session = se.getSession();  
        String name = se.getName();  
        Object oldValue = se.getValue();  
        System.out.println("�޸�session���ԣ�" + name + ", ԭֵ��" + oldValue + ", ��ֵ��" + session.getAttribute(name));  
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) { 
	     String name = se.getName();  
	     System.out.println("ɾ��session���ԣ�" + name + ", ֵΪ��" + se.getValue()); 
	}
}

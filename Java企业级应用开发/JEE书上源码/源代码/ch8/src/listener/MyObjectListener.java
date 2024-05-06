package listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
public class MyObjectListener implements HttpSessionListener,ServletContextListener,ServletRequestListener{
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		 HttpSession session = se.getSession();  
	     System.out.println("新创建一个session, ID为: " + session.getId());  
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		 HttpSession session = se.getSession();  
		 System.out.println("销毁一个session, ID为: " + session.getId());
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		 ServletContext servletContext = sce.getServletContext();  
		 System.out.println("即将启动" + servletContext.getContextPath());  
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();  
		System.out.println("即将关闭" + servletContext.getContextPath());
	}
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();    
        String uri = request.getRequestURI();  
        uri = request.getQueryString() == null ? uri : (uri + "?" + request.getQueryString());  
        request.setAttribute("dateCreated", System.currentTimeMillis());  
        System.out.println("IP " + request.getRemoteAddr() + " 请求 " + uri); 
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		 HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();  
	     long time = System.currentTimeMillis() - (Long) request.getAttribute("dateCreated");  
	     System.out.println(request.getRemoteAddr() + "请求处理结束, 用时" + time + "毫秒。 ");  
	}
}

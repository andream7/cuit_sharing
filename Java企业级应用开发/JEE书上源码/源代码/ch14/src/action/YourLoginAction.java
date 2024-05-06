package action;
import java.util.Map;
import model.MyUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class YourLoginAction extends ActionSupport implements ModelDriven<MyUser>{
	private static final long serialVersionUID = 1L;
	// MyUser为JavaBean类
private MyUser u = new MyUser();
    //声明map对象
   private Map<String,Object> request;
   private Map<String,Object> session;
   private Map<String,Object> application;
    //构造方法，初始化map对象
    public YourLoginAction(){
    	//获取ActionContext实例，通过该实例访问Servlet API
    	ActionContext ctx = ActionContext.getContext();
    	request = (Map<String,Object>)ctx.get("request");
    	session = ctx.getSession();
    	application = ctx.getApplication();
    }
    public String execute(){
    	if("陈恒".equals(u.getUserName()) 
    			&& "123456".equals(u.getUserpwd())){
    		session.put("usersession", u);
    		application.put("userapplication", u);
    		return SUCCESS;//跳转到yourLoginSuccess.jsp页面
    	}else{
    		//类似request.setAtrribute("userrequest",u);
    		request.put("userrequest", u);
    		return "fail";//跳转到yourLoginFail.jsp页面
    	}
    }
	@Override
	public MyUser getModel() {
		// TODO Auto-generated method stub
		return u;
	}
}

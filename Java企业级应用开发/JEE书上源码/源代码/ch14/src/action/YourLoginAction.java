package action;
import java.util.Map;
import model.MyUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class YourLoginAction extends ActionSupport implements ModelDriven<MyUser>{
	private static final long serialVersionUID = 1L;
	// MyUserΪJavaBean��
private MyUser u = new MyUser();
    //����map����
   private Map<String,Object> request;
   private Map<String,Object> session;
   private Map<String,Object> application;
    //���췽������ʼ��map����
    public YourLoginAction(){
    	//��ȡActionContextʵ����ͨ����ʵ������Servlet API
    	ActionContext ctx = ActionContext.getContext();
    	request = (Map<String,Object>)ctx.get("request");
    	session = ctx.getSession();
    	application = ctx.getApplication();
    }
    public String execute(){
    	if("�º�".equals(u.getUserName()) 
    			&& "123456".equals(u.getUserpwd())){
    		session.put("usersession", u);
    		application.put("userapplication", u);
    		return SUCCESS;//��ת��yourLoginSuccess.jspҳ��
    	}else{
    		//����request.setAtrribute("userrequest",u);
    		request.put("userrequest", u);
    		return "fail";//��ת��yourLoginFail.jspҳ��
    	}
    }
	@Override
	public MyUser getModel() {
		// TODO Auto-generated method stub
		return u;
	}
}

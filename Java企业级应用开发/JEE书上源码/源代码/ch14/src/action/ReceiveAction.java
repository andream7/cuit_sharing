package action;
import com.opensymphony.xwork2.ActionSupport;
public class ReceiveAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//用来封装用户请求中用户名的信息
	private String uname;
	//用来封装用户请求中年龄的信息
	private int uage;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	/**
	 * 处理用户请求的方法
	 */
	public String execute(){
		System.out.println("uname:"+uname);
		System.out.println("uage:"+uage);
		return SUCCESS;
	}
}

package action;
import com.opensymphony.xwork2.ActionSupport;
public class ReceiveAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//������װ�û��������û�������Ϣ
	private String uname;
	//������װ�û��������������Ϣ
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
	 * �����û�����ķ���
	 */
	public String execute(){
		System.out.println("uname:"+uname);
		System.out.println("uage:"+uage);
		return SUCCESS;
	}
}

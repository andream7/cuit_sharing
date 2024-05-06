package pojo;

public class MyUser {
	private String uname;
	private String upwd;
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String toString() {
		return "myUser [uname=" + uname +", upwd=" + upwd + "]";
	}
}

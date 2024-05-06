package model;
public class Information {
	//用来封装用户请求中用户名的信息，请求参数uname与属性名相同
		private String uname;
		//用来封装用户请求中年龄的信息，请求参数uage与属性名相同
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
}

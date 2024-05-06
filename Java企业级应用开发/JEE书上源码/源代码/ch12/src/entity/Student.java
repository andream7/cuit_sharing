package entity;

public class Student {
	String sno;
	String sname;
	int sage;
	String sdept;
	public Student(String sno, String sname, int sage, String sdept) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.sdept = sdept;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
}

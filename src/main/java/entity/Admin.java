package entity;

public class Admin {
	public Admin(String aname, String apassword) {
		super();
		this.aname = aname;
		this.apassword = apassword;
	}
	public Admin() {
		super();
	}
	public Admin(int aid, String aname, String apassword) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apassword = apassword;
	}
	private int aid;
	private String aname;
	private String apassword;
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", apassword="
				+ apassword + "]";
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
}

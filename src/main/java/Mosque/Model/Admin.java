package Mosque.Model;

public class Admin {

	private int AdminID;
	private String AdminName;
	private String adminEmail;
	private String AdminPassword;
	private String AdminPhoneNum;
	private boolean valid;
	
	public int getAdminID() {
		return AdminID;
	}
	public void setAdminID(int adminID) {
		AdminID = adminID;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return AdminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}
	public String getAdminPhoneNum() {
		return AdminPhoneNum;
	}
	public void setAdminPhoneNum(String adminPhoneNum) {
		AdminPhoneNum = adminPhoneNum;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
}

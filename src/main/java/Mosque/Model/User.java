package Mosque.Model;

public class User {
	
	
	private int UserID;
	private String Username;
	private String UserPassword;
	private String UserEmail;
	private String UserAddress;
	private String userPhoneNo;
	private boolean valid;
	
	public User() {}
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	


}

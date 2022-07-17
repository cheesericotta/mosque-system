package Mosque.Model;

import java.sql.Time;
import java.util.Date;

public class Registration {
	private int userID;
	private String activityID;
	private Date registrationDate;
	private Time registrationTime;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getActivityID() {
		return activityID;
	}
	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Time getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(Time registrationTime) {
		this.registrationTime = registrationTime;
	}
	
	
}

package Mosque.Model;

import java.sql.Time;
import java.sql.Date;

public class Activity {
	String ActivityID;
	String ActivityTitle;
	Date ActivityDate;
	String ActivityType;
	Time ActivityStartTime;
	Time ActivityEndTime;
	int AdminID;

	public String getActivityID() {
		return ActivityID;
	}
	public void setActivityID(String activityID) {
		ActivityID = activityID;
	}
	public String getActivityTitle() {
		return ActivityTitle;
	}
	public void setActivityTitle(String activityTitle) {
		ActivityTitle = activityTitle;
	}
	
	public Date getActivityDate() {
		return ActivityDate;
	}
	public void setActivityDate(Date activityDate) {
		ActivityDate = activityDate;
	}
	
	public String getActivityType() {
		return ActivityType;
	}
	public void setActivityType(String activityType) {
		ActivityType = activityType;
	}
	public Time getActivityStartTime() {
		return ActivityStartTime;
	}
	public void setActivityStartTime(Time activityStartTime) {
		ActivityStartTime = activityStartTime;
	}
	public Time getActivityEndTime() {
		return ActivityEndTime;
	}
	public void setActivityEndTime(Time activityEndTime) {
		ActivityEndTime = activityEndTime;
	}
	public int getAdminID() {
		return AdminID;
	}
	public void setAdminID(int adminID) {
		AdminID = adminID;
	}
	
}

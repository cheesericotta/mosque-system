package Mosque.Model;
import java.sql.Date;

public class Report {

	private String ActivityTitle;
	private int Count;
	private String ActivityID;
	private Date ActivityDate;
	
	
	
	public Date getActivityDate() {
		return ActivityDate;
	}
	public void setActivityDate(Date activityDate) {
		ActivityDate = activityDate;
	}
	public String getActivityTitle() {
		return ActivityTitle;
	}
	public void setActivityTitle(String activityTitle) {
		ActivityTitle = activityTitle;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public String getActivityID() {
		return ActivityID;
	}
	public void setActivityID(String activityID) {
		ActivityID = activityID;
	}
	
	
}

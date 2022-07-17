package Mosque.Model;

public class Seminar extends Activity{
	String SeminarLocation;
	Double SeminarFee;
	String InstructorName;
	String ActivityID;
	
	public String getActivityID() {
		return ActivityID;
	}
	public void setActivityID(String activityID) {
		ActivityID = activityID;
	}
	public String getSeminarLocation() {
		return SeminarLocation;
	}
	public void setSeminarLocation(String seminarLocation) {
		SeminarLocation = seminarLocation;
	}
	public Double getSeminarFee() {
		return SeminarFee;
	}
	public void setSeminarFee(Double seminarFee) {
		SeminarFee = seminarFee;
	}
	public String getInstructorName() {
		return InstructorName;
	}
	public void setInstructorName(String instructorName) {
		InstructorName = instructorName;
	}
	
}

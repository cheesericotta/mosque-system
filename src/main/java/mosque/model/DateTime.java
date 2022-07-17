package mosque.model;

import java.sql.Time;
import java.sql.Date;

public class DateTime {
	private Date date;
	private Time time;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
}

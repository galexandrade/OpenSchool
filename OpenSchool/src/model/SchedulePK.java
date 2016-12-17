package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the schedule database table.
 * 
 */
@Embeddable
public class SchedulePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int ID_Teacher;

	private int ID_Class;

	private int ID_Matter;

	private int weekday;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date timeStart;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date timeEnd;

	public SchedulePK() {
	}
	public int getID_Teacher() {
		return this.ID_Teacher;
	}
	public void setID_Teacher(int ID_Teacher) {
		this.ID_Teacher = ID_Teacher;
	}
	public int getID_Class() {
		return this.ID_Class;
	}
	public void setID_Class(int ID_Class) {
		this.ID_Class = ID_Class;
	}
	public int getID_Matter() {
		return this.ID_Matter;
	}
	public void setID_Matter(int ID_Matter) {
		this.ID_Matter = ID_Matter;
	}
	public int getWeekday() {
		return this.weekday;
	}
	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}
	public java.util.Date getTimeStart() {
		return this.timeStart;
	}
	public void setTimeStart(java.util.Date timeStart) {
		this.timeStart = timeStart;
	}
	public java.util.Date getTimeEnd() {
		return this.timeEnd;
	}
	public void setTimeEnd(java.util.Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SchedulePK)) {
			return false;
		}
		SchedulePK castOther = (SchedulePK)other;
		return 
			(this.ID_Teacher == castOther.ID_Teacher)
			&& (this.ID_Class == castOther.ID_Class)
			&& (this.ID_Matter == castOther.ID_Matter)
			&& (this.weekday == castOther.weekday)
			&& this.timeStart.equals(castOther.timeStart)
			&& this.timeEnd.equals(castOther.timeEnd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ID_Teacher;
		hash = hash * prime + this.ID_Class;
		hash = hash * prime + this.ID_Matter;
		hash = hash * prime + this.weekday;
		hash = hash * prime + this.timeStart.hashCode();
		hash = hash * prime + this.timeEnd.hashCode();
		
		return hash;
	}
}
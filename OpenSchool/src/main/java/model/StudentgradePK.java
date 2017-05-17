package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the studentgrade database table.
 * 
 */
@Embeddable
public class StudentgradePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int ID_Student;

	private int ID_Class;

	private int ID_Matter;

	private int season;

	public StudentgradePK() {
	}
	public int getID_Student() {
		return this.ID_Student;
	}
	public void setID_Student(int ID_Student) {
		this.ID_Student = ID_Student;
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
	public int getSeason() {
		return this.season;
	}
	public void setSeason(int season) {
		this.season = season;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StudentgradePK)) {
			return false;
		}
		StudentgradePK castOther = (StudentgradePK)other;
		return 
			(this.ID_Student == castOther.ID_Student)
			&& (this.ID_Class == castOther.ID_Class)
			&& (this.ID_Matter == castOther.ID_Matter)
			&& (this.season == castOther.season);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ID_Student;
		hash = hash * prime + this.ID_Class;
		hash = hash * prime + this.ID_Matter;
		hash = hash * prime + this.season;
		
		return hash;
	}
}
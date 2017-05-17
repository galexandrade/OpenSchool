package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the classpresence database table.
 * 
 */
@Embeddable
public class ClasspresencePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int ID_Teacher;

	private int ID_Class;

	private int ID_Matter;

	private int ID_Student;

	@Temporal(TemporalType.DATE)
	private java.util.Date date;

	public ClasspresencePK() {
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
	public int getID_Student() {
		return this.ID_Student;
	}
	public void setID_Student(int ID_Student) {
		this.ID_Student = ID_Student;
	}
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ClasspresencePK)) {
			return false;
		}
		ClasspresencePK castOther = (ClasspresencePK)other;
		return 
			(this.ID_Teacher == castOther.ID_Teacher)
			&& (this.ID_Class == castOther.ID_Class)
			&& (this.ID_Matter == castOther.ID_Matter)
			&& (this.ID_Student == castOther.ID_Student)
			&& this.date.equals(castOther.date);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ID_Teacher;
		hash = hash * prime + this.ID_Class;
		hash = hash * prime + this.ID_Matter;
		hash = hash * prime + this.ID_Student;
		hash = hash * prime + this.date.hashCode();
		
		return hash;
	}
}
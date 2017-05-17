package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pickupstudentuppermit database table.
 * 
 */
@Entity
@NamedQuery(name="Pickupstudentuppermit.findAll", query="SELECT p FROM Pickupstudentuppermit p")
public class Pickupstudentuppermit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ID_Student;

	private int ID_Person;

	public Pickupstudentuppermit() {
	}

	public int getID_Student() {
		return this.ID_Student;
	}

	public void setID_Student(int ID_Student) {
		this.ID_Student = ID_Student;
	}

	public int getID_Person() {
		return this.ID_Person;
	}

	public void setID_Person(int ID_Person) {
		this.ID_Person = ID_Person;
	}

}
package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int ID_Class;

	//uni-directional one-to-one association to Person
	@OneToOne
	@JoinColumn(name="ID_Person")
	private Person person;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getID_Class() {
		return this.ID_Class;
	}

	public void setID_Class(int ID_Class) {
		this.ID_Class = ID_Class;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
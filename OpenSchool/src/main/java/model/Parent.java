package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parent database table.
 * 
 */
@Entity
@NamedQuery(name="Parent.findAll", query="SELECT p FROM Parent p")
public class Parent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int ID_user;

	//uni-directional one-to-one association to Person
	@OneToOne
	@JoinColumn(name="ID_Person")
	private Person person;

	public Parent() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getID_user() {
		return this.ID_user;
	}

	public void setID_user(int ID_user) {
		this.ID_user = ID_user;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
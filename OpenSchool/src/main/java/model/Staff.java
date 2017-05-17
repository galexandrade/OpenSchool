package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the staff database table.
 * 
 */
@Entity
@NamedQuery(name="Staff.findAll", query="SELECT s FROM Staff s")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int ID_School;

	private int ID_User;

	//bi-directional one-to-one association to Person
	@OneToOne(mappedBy="staff")
	private Person person;

	//uni-directional one-to-one association to Role
	@OneToOne
	@JoinColumn(name="ID_Role")
	private Role role;

	public Staff() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getID_School() {
		return this.ID_School;
	}

	public void setID_School(int ID_School) {
		this.ID_School = ID_School;
	}

	public int getID_User() {
		return this.ID_User;
	}

	public void setID_User(int ID_User) {
		this.ID_User = ID_User;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
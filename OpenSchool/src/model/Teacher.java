package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int ID_Staff;

	public Teacher() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getID_Staff() {
		return this.ID_Staff;
	}

	public void setID_Staff(int ID_Staff) {
		this.ID_Staff = ID_Staff;
	}

}
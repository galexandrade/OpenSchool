package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the school database table.
 * 
 */
@Entity
@NamedQuery(name="School.findAll", query="SELECT s FROM School s")
public class School implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int ID_Media;

	private String name;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="school")
	private List<RoomClass> classes;

	public School() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getID_Media() {
		return this.ID_Media;
	}

	public void setID_Media(int ID_Media) {
		this.ID_Media = ID_Media;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RoomClass> getRoomClasses() {
		return this.classes;
	}

}
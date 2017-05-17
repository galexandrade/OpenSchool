package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the matter database table.
 * 
 */
@Entity
@NamedQuery(name="Matter.findAll", query="SELECT m FROM Matter m")
public class Matter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int ID_Media;

	private String name;

	public Matter() {
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

}
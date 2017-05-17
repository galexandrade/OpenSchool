package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the news database table.
 * 
 */
@Entity
@Table(name="news")
@NamedQuery(name="New.findAll", query="SELECT n FROM New n")
public class New implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String description;

	private int ID_Gallery;

	private int ID_Media;

	private int ID_School;

	private String resume;

	public New() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getID_Gallery() {
		return this.ID_Gallery;
	}

	public void setID_Gallery(int ID_Gallery) {
		this.ID_Gallery = ID_Gallery;
	}

	public int getID_Media() {
		return this.ID_Media;
	}

	public void setID_Media(int ID_Media) {
		this.ID_Media = ID_Media;
	}

	public int getID_School() {
		return this.ID_School;
	}

	public void setID_School(int ID_School) {
		this.ID_School = ID_School;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

}
package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the media database table.
 * 
 */
@Entity
@NamedQuery(name="Media.findAll", query="SELECT m FROM Media m")
public class Media implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String description;

	private String fullPath;

	private byte is_Picture;

	private byte is_Video;

	private String name;

	public Media() {
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

	public String getFullPath() {
		return this.fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public byte getIs_Picture() {
		return this.is_Picture;
	}

	public void setIs_Picture(byte is_Picture) {
		this.is_Picture = is_Picture;
	}

	public byte getIs_Video() {
		return this.is_Video;
	}

	public void setIs_Video(byte is_Video) {
		this.is_Video = is_Video;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
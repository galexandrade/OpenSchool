package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gallery database table.
 * 
 */
@Entity
@NamedQuery(name="Gallery.findAll", query="SELECT g FROM Gallery g")
public class Gallery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String description;

	private String resume;

	//uni-directional many-to-many association to Media
	@ManyToMany
	@JoinTable(
		name="galerymedia"
		, joinColumns={
			@JoinColumn(name="ID_Galery")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_Media")
			}
		)
	private List<Media> medias;

	public Gallery() {
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

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public List<Media> getMedias() {
		return this.medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

}
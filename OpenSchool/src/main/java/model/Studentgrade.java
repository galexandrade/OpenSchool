package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the studentgrade database table.
 * 
 */
@Entity
@NamedQuery(name="Studentgrade.findAll", query="SELECT s FROM Studentgrade s")
public class Studentgrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudentgradePK id;

	private float score;

	public Studentgrade() {
	}

	public StudentgradePK getId() {
		return this.id;
	}

	public void setId(StudentgradePK id) {
		this.id = id;
	}

	public float getScore() {
		return this.score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}
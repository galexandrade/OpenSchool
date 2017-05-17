package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eventcomment database table.
 * 
 */
@Entity
@NamedQuery(name="Eventcomment.findAll", query="SELECT e FROM Eventcomment e")
public class Eventcomment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EventcommentPK id;

	public Eventcomment() {
	}

	public EventcommentPK getId() {
		return this.id;
	}

	public void setId(EventcommentPK id) {
		this.id = id;
	}

}
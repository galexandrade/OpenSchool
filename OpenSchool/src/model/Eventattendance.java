package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eventattendance database table.
 * 
 */
@Entity
@NamedQuery(name="Eventattendance.findAll", query="SELECT e FROM Eventattendance e")
public class Eventattendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EventattendancePK id;

	private byte isGoing;

	@Lob
	private String note;

	public Eventattendance() {
	}

	public EventattendancePK getId() {
		return this.id;
	}

	public void setId(EventattendancePK id) {
		this.id = id;
	}

	public byte getIsGoing() {
		return this.isGoing;
	}

	public void setIsGoing(byte isGoing) {
		this.isGoing = isGoing;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
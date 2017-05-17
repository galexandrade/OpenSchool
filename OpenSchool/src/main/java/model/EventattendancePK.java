package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the eventattendance database table.
 * 
 */
@Embeddable
public class EventattendancePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int ID_Event;

	private int ID_Parent;

	public EventattendancePK() {
	}
	public int getID_Event() {
		return this.ID_Event;
	}
	public void setID_Event(int ID_Event) {
		this.ID_Event = ID_Event;
	}
	public int getID_Parent() {
		return this.ID_Parent;
	}
	public void setID_Parent(int ID_Parent) {
		this.ID_Parent = ID_Parent;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EventattendancePK)) {
			return false;
		}
		EventattendancePK castOther = (EventattendancePK)other;
		return 
			(this.ID_Event == castOther.ID_Event)
			&& (this.ID_Parent == castOther.ID_Parent);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ID_Event;
		hash = hash * prime + this.ID_Parent;
		
		return hash;
	}
}
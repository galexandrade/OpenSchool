package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the eventcomment database table.
 * 
 */
@Embeddable
public class EventcommentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int ID_Event;

	private int ID_Comment;

	public EventcommentPK() {
	}
	public int getID_Event() {
		return this.ID_Event;
	}
	public void setID_Event(int ID_Event) {
		this.ID_Event = ID_Event;
	}
	public int getID_Comment() {
		return this.ID_Comment;
	}
	public void setID_Comment(int ID_Comment) {
		this.ID_Comment = ID_Comment;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EventcommentPK)) {
			return false;
		}
		EventcommentPK castOther = (EventcommentPK)other;
		return 
			(this.ID_Event == castOther.ID_Event)
			&& (this.ID_Comment == castOther.ID_Comment);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ID_Event;
		hash = hash * prime + this.ID_Comment;
		
		return hash;
	}
}
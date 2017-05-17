package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the schedule database table.
 * 
 */
@Entity
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SchedulePK id;

	public Schedule() {
	}

	public SchedulePK getId() {
		return this.id;
	}

	public void setId(SchedulePK id) {
		this.id = id;
	}

}
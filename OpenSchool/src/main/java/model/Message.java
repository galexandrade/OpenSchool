package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int ID_PersonFrom;

	private int ID_PersonTo;

	@Lob
	private String message;

	private Time time;

	public Message() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getID_PersonFrom() {
		return this.ID_PersonFrom;
	}

	public void setID_PersonFrom(int ID_PersonFrom) {
		this.ID_PersonFrom = ID_PersonFrom;
	}

	public int getID_PersonTo() {
		return this.ID_PersonTo;
	}

	public void setID_PersonTo(int ID_PersonTo) {
		this.ID_PersonTo = ID_PersonTo;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
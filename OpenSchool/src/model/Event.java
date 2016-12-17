package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Lob
	private String description;

	private Time dime;

	@Temporal(TemporalType.DATE)
	private Date dueDate;

	private Time dueTime;

	private int ID_Class;

	private int ID_Gallery;

	private int ID_Media;

	private byte isCanceled;

	private byte isConfirmationRequired;

	private String title;

	public Event() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Time getDime() {
		return this.dime;
	}

	public void setDime(Time dime) {
		this.dime = dime;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Time getDueTime() {
		return this.dueTime;
	}

	public void setDueTime(Time dueTime) {
		this.dueTime = dueTime;
	}

	public int getID_Class() {
		return this.ID_Class;
	}

	public void setID_Class(int ID_Class) {
		this.ID_Class = ID_Class;
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

	public byte getIsCanceled() {
		return this.isCanceled;
	}

	public void setIsCanceled(byte isCanceled) {
		this.isCanceled = isCanceled;
	}

	public byte getIsConfirmationRequired() {
		return this.isConfirmationRequired;
	}

	public void setIsConfirmationRequired(byte isConfirmationRequired) {
		this.isConfirmationRequired = isConfirmationRequired;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
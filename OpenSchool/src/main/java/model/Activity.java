package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the activity database table.
 * 
 */
@Entity
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActivityPK id;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Lob
	private String description;

	@Temporal(TemporalType.DATE)
	private Date dueDate;

	private Time dueTime;

	private int ID_Gallery;

	private int ID_Media;

	private String resume;

	private Time time;

	//uni-directional many-to-many association to Comment
	@ManyToMany
	@JoinTable(
		name="activitycomment"
		, joinColumns={
			@JoinColumn(name="ID_Class", referencedColumnName="ID_Class"),
			@JoinColumn(name="ID_Matter", referencedColumnName="ID_Matter"),
			@JoinColumn(name="ID_Sequence", referencedColumnName="ID_Sequence"),
			@JoinColumn(name="ID_Teacher", referencedColumnName="ID_Teacher")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_Comment")
			}
		)
	private List<Comment> comments;

	//bi-directional many-to-one association to Activityscore
	@OneToMany(mappedBy="activity")
	private List<Activityscore> activityscores;

	public Activity() {
	}

	public ActivityPK getId() {
		return this.id;
	}

	public void setId(ActivityPK id) {
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

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Activityscore> getActivityscores() {
		return this.activityscores;
	}

	public void setActivityscores(List<Activityscore> activityscores) {
		this.activityscores = activityscores;
	}

	public Activityscore addActivityscore(Activityscore activityscore) {
		getActivityscores().add(activityscore);
		activityscore.setActivity(this);

		return activityscore;
	}

	public Activityscore removeActivityscore(Activityscore activityscore) {
		getActivityscores().remove(activityscore);
		activityscore.setActivity(null);

		return activityscore;
	}

}
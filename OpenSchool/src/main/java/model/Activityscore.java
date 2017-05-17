package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the activityscore database table.
 * 
 */
@Entity
@NamedQuery(name="Activityscore.findAll", query="SELECT a FROM Activityscore a")
public class Activityscore implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActivityscorePK id;

	private float score;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_Class", referencedColumnName="ID_Class"),
		@JoinColumn(name="ID_Matter", referencedColumnName="ID_Matter"),
		@JoinColumn(name="ID_Sequence", referencedColumnName="ID_Sequence"),
		@JoinColumn(name="ID_Teacher", referencedColumnName="ID_Teacher")
		})
	private Activity activity;

	//uni-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="ID_Student")
	private Student student;

	//uni-directional one-to-one association to Comment
	@OneToOne
	@JoinColumn(name="ID_Comment")
	private Comment comment;

	public Activityscore() {
	}

	public ActivityscorePK getId() {
		return this.id;
	}

	public void setId(ActivityscorePK id) {
		this.id = id;
	}

	public float getScore() {
		return this.score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
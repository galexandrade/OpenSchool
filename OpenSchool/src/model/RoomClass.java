package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the class database table.
 * 
 */
@Entity(name="class")
@NamedQuery(name="RoomClass.findAll", query="SELECT c FROM RoomClass c")
public class RoomClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String description;

	private String name;

	private BigInteger year;

	//bi-directional many-to-one association to School
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID", referencedColumnName="Description"),
		@JoinColumn(name="ID_School")
		})
	private School school;

	//uni-directional one-to-one association to Media
	@OneToOne
	@JoinColumn(name="ID_Media")
	private Media media;

	//uni-directional many-to-many association to Student
	@ManyToMany
	@JoinTable(
		name="studentclass"
		, joinColumns={
			@JoinColumn(name="ID_Class")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_Student")
			}
		)
	private List<Student> students;

	//bi-directional many-to-many association to Teacher
	@ManyToMany(mappedBy="clazzs")
	private List<Teacher> teachers;

	public RoomClass() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getYear() {
		return this.year;
	}

	public void setYear(BigInteger year) {
		this.year = year;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Media getMedia() {
		return this.media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return this.teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

}
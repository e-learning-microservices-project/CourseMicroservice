package tn.esprit.microservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="course")
public class Course implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int teacher_id;
	private String subject,description,language;
	public int getId() {
		return id;
	}
	
	public Course() {
		super();
	}

	public Course(int teacher_id, String subject, String description, String language) {
		super();
		this.teacher_id = teacher_id;
		this.subject = subject;
		this.description = description;
		this.language = language;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public Course(String subject) {
		super();
		this.subject = subject;
	}
	
}

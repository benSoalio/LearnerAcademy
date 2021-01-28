package com.learnerAcademy.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Classe {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String classeName;
	
	
	@ManyToOne
	private Teacher teacher;
	
	@ManyToOne
	private Subject subject;
	
	@OneToMany(mappedBy="classe")
	private List<Student> students = new ArrayList<Student>();

	public Classe(int id, String classeName, Teacher teacher, Subject subject) {
		super();
		this.id = id;
		this.classeName = classeName;
		this.teacher = teacher;
		this.subject = subject;
		
	}

	
	
	

	public Classe(String classeName, Teacher teacher, Subject subject) {
		super();
		this.classeName = classeName;
		this.teacher = teacher;
		this.subject = subject;
	}
	
	

	public Classe() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClasseName() {
		return classeName;
	}

	public void setClasseName(String classeName) {
		this.classeName = classeName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}

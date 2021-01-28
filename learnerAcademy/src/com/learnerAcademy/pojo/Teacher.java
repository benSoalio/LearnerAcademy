package com.learnerAcademy.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Teacher {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String teacherName;
	
	@OneToMany(mappedBy="teacher")
	private List<Classe> classes = new ArrayList<Classe>();

	public Teacher(int id, String teacherName, List<Classe> classes) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.classes = classes;
	}

	public Teacher(String teacherName, List<Classe> classes) {
		super();
		this.teacherName = teacherName;
		this.classes = classes;
	}

	public Teacher() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	
	
	
}

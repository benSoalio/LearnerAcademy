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
public class Subject {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String subjectName;
	
	@OneToMany(mappedBy="subject")
	private List<Classe> classes = new ArrayList<Classe>();

	public Subject() {
		super();
	}

	public Subject(String subjectName, List<Classe> classes) {
		super();
		this.subjectName = subjectName;
		this.classes = classes;
	}

	public Subject(int id, String subjectName, List<Classe> classes) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.classes = classes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	
	
}

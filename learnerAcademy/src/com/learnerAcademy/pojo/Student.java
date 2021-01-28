package com.learnerAcademy.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String studentName;
	
	@ManyToOne
	private Classe classe;

	public Student(int id, String studentName, Classe classe) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.classe = classe;
	}

	public Student(String studentName, Classe classe) {
		super();
		this.studentName = studentName;
		this.classe = classe;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	
}

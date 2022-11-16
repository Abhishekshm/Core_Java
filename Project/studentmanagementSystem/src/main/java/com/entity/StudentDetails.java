package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_detail")
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// variables
	@Column(name = "id")
	private int id;

	@Column(name = "Class")
	private String standard;

	@Column(name = "Age")
	private int age;

	@OneToOne(mappedBy = "student_detail", cascade = CascadeType.ALL)
	private Student student;

	// default constructor
	public StudentDetails() {

	}

	// Parameterized Constructor
	public StudentDetails(String standard, int age) {
		this.standard = standard;
		this.age = age;

	}

	// getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", standard=" + standard + ", age=" + age + ", student=" + student + "]";
	}
}

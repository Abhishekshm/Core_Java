package com.entity;

/*
Program :- Creating Pojo class Of Student class And Creating relation many to many
@Author :- Abhishek Sharma
Date :-24/11/2022
*/
import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student", catalog = "studentdb") // table name

//declaring class
public class Student implements Serializable {

	// Instance variables
	@Id // -----Primary key--------//
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generated Function
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "Name", unique = true, nullable = false, length = 20)
	private String Name;

	@Column(name = "Age", nullable = false)
	private int age;

	@Column(name = "email", unique = true, nullable = false, length = 20)
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private Course course;

	// ---default Constructor----//
	public Student() {
		super();

	}

//------Paramaterized Constructor---------//
	public Student(String Name, int age, String email) {
		super();
		this.Name = Name;
		this.age = age;
		this.email = email;
	}

	// ------Paramaterized Constructor---------//
	public Student(String Name, int age, String email, Course course) {
		super();
		this.Name = Name;
		this.age = age;
		this.email = email;
		this.course = course;
	}

	// --------Setter And Getters--------------//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	// ----------To-String-------------//
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", age=" + age + ", email=" + email + ", course=" + course
				+ "]";
	}

}

package com.entity;

/*
Program :- Creating Pojo class Of Student class And Creating relation many to many
@Author :- Abhishek Sharma
Date :-24/11/2022
*/
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student", catalog = "studentdb") // table name

//declaring class
public class Student implements Serializable {

	// Instance variables
	@Id // -----Primary key--------//
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generated Function
	@Column(name = "student_id", unique = true, nullable = false)
	private int id;

	@Column(name = "Name", unique = true, nullable = false, length = 20)
	private String Name;

	@Column(name = "Age", nullable = false)
	private int age;

	@Column(name = "email", unique = true, nullable = false, length = 20)
	private String email;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
	private Set<Course> course = new HashSet<Course>(0);

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
	public Student(String Name, int age, String email, Set<Course> course) {
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

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	// ----------To-String-------------//
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", age=" + age + ", email=" + email + ", course=" + course
				+ "]";
	}

}

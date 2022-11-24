package com.entity;

/*
Program :- Creating Pojo class Of Course class And Creating relation many to many
@Author :- Abhishek Sharma
Date :-24/11/2022
*/
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "course", catalog = "studentdb", uniqueConstraints = { @UniqueConstraint(columnNames = "Course_Name"),
		@UniqueConstraint(columnNames = "Course_duration") }) // table name

//declaring class
public class Course implements Serializable {
	// Instance variables
	@Id // -----Primary key--------//
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generated Function
	@Column(name = "course_id", unique = true, nullable = false)
	private int id;

	@Column(name = "Course_Name", unique = true, nullable = false, length = 20)
	private String Name;

	@Column(name = "Course_duration", unique = true, nullable = false, length = 10)
	private String duration;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", catalog = "studentdb", joinColumns = {
			@JoinColumn(name = "student_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "course_id", nullable = false, updatable = false) })
	private Set<Student> students = new HashSet<Student>(0);

	// ---default Constructor----//
	public Course() {
		super();

	}

	// ------Paramaterized Constructor---------//
	public Course(String Name, String duration) {
		super();
		this.Name = Name;
		this.duration = duration;
	}

	// ------Paramaterized Constructor---------//
	public Course(String Name, String duration, Set<Student> students) {
		super();
		this.Name = Name;
		this.duration = duration;
		this.students = students;
	}

	// --------Setter And Getters--------------//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String firstName) {
		this.Name = firstName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	// ----------To-String-------------//
	@Override
	public String toString() {
		return "Course [id=" + id + ", Name=" + Name + ", duration=" + duration + ", students=" + students + "]";
	}

}

package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name= "student_details")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "Student_id")
	private int id;
	
	@Column(name="Student_name",nullable = false)
	private String studentName;
	
	@Column(name = "phone_no",nullable=false)
	private long phone;
	
	@Column(nullable=false)
	private String email;
}

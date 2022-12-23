package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	private int id;
	
	@Column(name="studentname")
	private String studentname;
	
	@Column(name = "phoneno")
	private long phone;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne
	private Address address;

	@Builder
	public Student(String studentname, long phone, String email) {
		super();
		this.studentname = studentname;
		this.phone = phone;
		this.email = email;
	}
	
	
}

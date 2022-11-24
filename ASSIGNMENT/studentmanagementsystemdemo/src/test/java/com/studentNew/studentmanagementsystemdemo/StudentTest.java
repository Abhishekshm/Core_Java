package com.studentNew.studentmanagementsystemdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dao.StudentDao;
import com.entity.Course;
import com.entity.Student;

class StudentTest {
	private Student s;
	private StudentDao dao;
	private Course c;

	@BeforeEach
	void createStudent() {

		s = new Student();
		dao = new StudentDao();

	}

	@DisplayName("delete test case")
	@Test
	void deleteStudentTest() {
		s = new Student();
		s.setId(1);
		s.setName("Abhishek");
		s.setEmail("Abh@123");
		s.setAge(23);
		dao.saveStudent(s);
		c = new Course();
		c.setId(1);
		c.setName("B.tech");
		c.setDuration("$ months");

		assertEquals(true, dao.deleteStudent(1));
	}

}

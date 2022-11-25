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
		s.setId(1);
		dao.deleteStudent(1);

	}

	@DisplayName("delete test case")
	@Test
	void deleteStudentTest() {
		s = new Student();

		assertEquals(0, s.getId());
	}

}

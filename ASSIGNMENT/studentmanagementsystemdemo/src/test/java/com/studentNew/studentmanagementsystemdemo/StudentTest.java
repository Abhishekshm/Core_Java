package com.studentNew.studentmanagementsystemdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dao.StudentDao;
import com.entity.Student;

class StudentTest {

	private StudentDao dao;

	@BeforeEach
	void init() throws Exception {

		dao = new StudentDao();

	}

	@After
	void tearDown() {
		dao = null;
	}

	@DisplayName("delete test case")
	@Test
	void deleteStudentTest() {

		Student s1 = dao.deleteStudent(4);

		assertEquals(null, s1);
	}

	@DisplayName("Already Existing Test")
	@Test
	void alreadyTest() {
		Student s2 = new Student("Abhishek", 23, "abh123@gmail.com", 80000);
		assertEquals(s2.getName(), dao.getStudent(3).getName());
	}

	@Test
	void feeTest() {
		boolean fee1 = dao.fee(3);
//		assertEquals(fee1, dao.fee(3));
		assertTrue(fee1);
	}
}

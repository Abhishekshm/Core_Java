package com.student.studentmanagementSystem;

import java.util.List;

import com.dao.StudentDao;
import com.entity.Student;
import com.entity.StudentDetails;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// Save two instructors
		Student student = new Student("Abhishek", "Sharma", "as56014@gmail.com");
		StudentDetails studentDetail = new StudentDetails("12th", 23);
		studentDetail.setStudent(student);
		student.setStudent_detail(studentDetail);

		Student student1 = new Student("Rahul", "Shaw", "Rahul123@gmail.com");
		StudentDetails studentDetail1 = new StudentDetails("B.tech", 24);
		studentDetail1.setStudent(student1);
		student1.setStudent_detail(studentDetail1);

		StudentDao studentDao = new StudentDao();
		studentDao.saveInstructor(student);
		studentDao.saveInstructor(student1);

		// Get all instructors
		List<Student> students = studentDao.getAllInstructor();
		students.forEach(StudentTemp -> System.out.println(StudentTemp.getFirstName()));
	}
}

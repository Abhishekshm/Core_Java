package com.student.studentmanagementSystem;

import java.util.ArrayList;
import java.util.List;

import com.dao.SchoolDetailDao;
import com.dao.StudentDao;
import com.entity.SchoolDetails;
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

		Student student2 = new Student("KAran", "Razak", "KAran777@gmail.com");
		StudentDetails studentDetail2 = new StudentDetails("B.sc", 29);
		studentDetail2.setStudent(student2);
		student2.setStudent_detail(studentDetail2);

		StudentDao studentDao = new StudentDao();
		studentDao.saveStudent(student);
		studentDao.saveStudent(student1);
		studentDao.saveStudent(student2);

		// updating---------------------------- student name
		student.setFirstName("Mohan");
		studentDao.updateStudent(student1);

//		-------------------------------- deleting id
//		studentDao.deleteStudent(2);

//		List<Student> student2 = studentDao.getAllInstructor();
//		student2.forEach(instructorTemp -> System.out.println(instructorTemp.getFirstName()));
		List<SchoolDetails> school = new ArrayList<>();
		SchoolDetails s1 = new SchoolDetails("CIT");
		s1.setStudent(student);
		school.add(s1);
		SchoolDetailDao schN = new SchoolDetailDao();
		schN.saveSchool(s1);

		SchoolDetails s2 = new SchoolDetails("FIT");
		s2.setStudent(student1);
		school.add(s2);
		SchoolDetailDao schN1 = new SchoolDetailDao();
		schN1.saveSchool(s2);

		SchoolDetails s3 = new SchoolDetails("MIT");
		s3.setStudent(student2);
		SchoolDetailDao schN2 = new SchoolDetailDao();
		school.add(s3);
		schN2.saveSchool(s3);

	}
}

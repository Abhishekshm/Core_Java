package com.studentNew.studentmanagementsystemdemo;

/*
Program :- Creating Student object and setting course
@Author :- Abhishek Sharma
Date :-24/11/2022
*/
import com.dao.StudentDao;
import com.entity.Course;
import com.entity.Student;

public class App {
	public static void main(String[] args) {

		Student student = new Student("Abhishek", 23, "abh123@gmail.com");
		Course course = new Course("B.tech", "4 months");
		course.setStudents(student);
		student.setCourse(course);

		Student student1 = new Student("Rahul", 22, "ral123@gmail.com");
		Course course1 = new Course("B.sc", "6 months");
		course1.setStudents(student1);
		student1.setCourse(course1);
		Student student2 = new Student("Shekhar", 23, "Shekhar123@gmail.com");
		Course course2 = new Course("M.tech", "2 months");
		course2.setStudents(student2);
		student2.setCourse(course2);
		StudentDao s = new StudentDao();
		s.saveStudent(student1);
		s.saveStudent(student2);
		s.saveStudent(student);

//		// ---------Delete Student------------//
//		s.deleteStudent(1);
//
//		// --------Updating Student-------------//
//		student2.setAge(31);
//		s.updateStudent(student2);

		// ---------Get particular Student------------//
//		s.getStudent(3);

		// -------Printing All students-----------//
//		List<Student> studentDetails = s.getAllStudent();
//		studentDetails.forEach(std -> System.out.println("Name"+std.getFirst() + " Age" + std.getAge() + " "));
	}
}

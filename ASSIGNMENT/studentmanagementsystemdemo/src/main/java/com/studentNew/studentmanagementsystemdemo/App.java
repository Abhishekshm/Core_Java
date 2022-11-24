package com.studentNew.studentmanagementsystemdemo;

import java.util.HashSet;
import java.util.Set;

import com.dao.CourseDao;
import com.dao.StudentDao;
import com.entity.Course;
import com.entity.Student;

public class App {
	public static void main(String[] args) {

		Student student = new Student("Abhishek", 23, "abh123@gmail.com");
		Course course = new Course("B.tech", "4 months");
		Student student1 = new Student("Rahul", 22, "ral123@gmail.com");
		Course course1 = new Course("B.sc", "6 months");
		Student student2 = new Student("Shekhar", 23, "Shekhar123@gmail.com");
		Course course2 = new Course("M.tech", "2 months");
		StudentDao s = new StudentDao();
		s.saveStudent(student1);
		s.saveStudent(student2);
		s.saveStudent(student);
		CourseDao c = new CourseDao();
		c.saveCourse(course);
		c.saveCourse(course1);
		c.saveCourse(course2);

		Set<Student> students = new HashSet<Student>();
		Set<Course> courses = new HashSet<Course>();

		students.add(student);
		students.add(student1);
		students.add(student2);
		courses.add(course);
		courses.add(course1);
		courses.add(course2);

	}
}

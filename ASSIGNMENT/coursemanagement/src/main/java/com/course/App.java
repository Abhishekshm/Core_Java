package com.course;

import java.util.ArrayList;
import java.util.List;

import com.doa.CourseDao;
import com.doa.InstructorDao;
import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class App {
	public static void main(String[] args) {
		// Save two instructors
		Instructor instructor = new Instructor("sekhar", "kk", "amitv45@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Piano");
		instructorDetail.setInstructor(instructor);
		instructor.setInstructorDetail(instructorDetail);

		Instructor instructor1 = new Instructor("parv", "shaw", "shreekumar@gmail.com");
		InstructorDetail instructorDetail1 = new InstructorDetail("http://www.youtube.com", "Guitar");
		instructorDetail1.setInstructor(instructor1);
		instructor1.setInstructorDetail(instructorDetail1);

		InstructorDao instructorDao = new InstructorDao();
		instructorDao.saveInstructor(instructor);
		instructorDao.saveInstructor(instructor1);

		List<Course> course = new ArrayList<>();
		Course co = new Course("B.tech");
		co.setInstructor(instructor);
		course.add(co);
		CourseDao cod = new CourseDao();
		cod.saveCourse(co);
	}
}

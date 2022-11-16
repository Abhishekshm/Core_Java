package com.course;



import java.util.List;

import com.doa.InstructorDao;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class App 
{
    public static void main( String[] args )
    {
        // Save two instructors
        Instructor instructor = new Instructor("Amit", "Varma", "amitv45@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Piano");
        instructorDetail.setInstructor(instructor);
        instructor.setInstructorDetail(instructorDetail);
       
        Instructor instructor1 = new Instructor("Shree", "Kumar", "shreekumar@gmail.com");
        InstructorDetail instructorDetail1 = new InstructorDetail("http://www.youtube.com", "Guitar");
        instructorDetail1.setInstructor(instructor1);
        instructor1.setInstructorDetail(instructorDetail1);
       
        InstructorDao instructorDao = new InstructorDao();
        instructorDao.saveInstructor(instructor);
        instructorDao.saveInstructor(instructor1);
       
        // Get all instructors
        List<Instructor> instructors = instructorDao.getAllInstructor();
        instructors.forEach(instructorTemp -> System.out.println(instructorTemp.getFirstName()));
    }
}

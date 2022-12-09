package com.student.service;

import java.util.List;

import com.student.entity.Student;
import com.student.model.StudentDto;



public interface StudentService {

	String createStudent(Student student);
	StudentDto updateStudent(int id,Student student);
	StudentDto getStudent(int id);	
	List<StudentDto> getAllStudent();
	String deleteStudent(int id);
	void deleteAllStudent();
}

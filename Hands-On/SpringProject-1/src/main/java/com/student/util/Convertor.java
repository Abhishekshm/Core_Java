package com.student.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.student.entity.Student;
import com.student.model.StudentDto;


@Component
public class Convertor {

	//convert studentdto to entity(student)
	public Student convertToEntity(StudentDto studentDto) {
		
		Student student = new Student();
		if(studentDto!=null) {
			BeanUtils.copyProperties(studentDto, student);
		}
		return student;
	}
	
	//convert entity(student) to studentdto
	public StudentDto convertToDto(Student student) {
		StudentDto studentDto=new StudentDto();
		if(student!=null) {
			BeanUtils.copyProperties(student, studentDto);
		}
		return studentDto;
	 }
	}


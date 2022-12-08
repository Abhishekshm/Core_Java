package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.model.StudentDto;
import com.student.service.StudentService;
import com.student.util.Convertor;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Convertor convertor;
	
	@PostMapping("/createStudent")
	public String createStudent(@RequestBody StudentDto studentDto) {
		
		final Student student = convertor.convertToEntity(studentDto);
		return studentService.createStudent(student);
	}
}

package com.student.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import com.student.util.Convertor;

@Service
public class StudentServiceimpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private Convertor convertor;
	@Override
	public String createStudent(Student student) {
		
		String message=null;
		studentRepository.save(student);
		if(student!=null) {
			message = "..........Student Added Successfully.........";
		}
		return message;
	}

	
}

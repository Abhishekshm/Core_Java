package com.student.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.model.StudentDto;
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
	@Override
	public StudentDto updateStudent(int id, Student student) {
		Student existngStudent=studentRepository.findById(id).get();
		existngStudent.setStudentname(student.getStudentname());
		existngStudent.setPhone(student.getPhone());
		existngStudent.setEmail(student.getEmail());
		
		studentRepository.save(existngStudent);
		return convertor.convertToDto(existngStudent);
	}
	@Override
	public StudentDto getStudent(int id) {
		
		Student student1 = studentRepository.findById(id).get();
		
		return convertor.convertToDto(student1);
	}
	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> studentList= studentRepository.findAll();
		List<StudentDto> studentDtoList = new ArrayList<>();
		for(Student s: studentList) {
			studentDtoList.add(convertor.convertToDto(s));
		}
		return studentDtoList;
	}
	@Override
	public String deleteStudent(int id) {
		String message=null;
		Optional<Student> student=studentRepository.findById(id);
		if(student.isPresent()) {
			
			studentRepository.deleteById(id);
			message = "..........Student Delteted  Successfully.........";
		}
		else {
			message = ".........Student Details are not found........";
		}
		return message;
	}
	@Override
	public void deleteAllStudent() {
 studentRepository.deleteAll();
  }
  
	
}

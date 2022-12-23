package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/updateStudent/{identity}")
	public StudentDto updateStudent(@PathVariable("identity") int id ,@RequestBody StudentDto studentDto) {
		Student student1=convertor.convertToEntity(studentDto);
		return studentService.updateStudent(id, student1);
	}
	
	@GetMapping("/getStudent/{identity}")
	public StudentDto getStudent(@PathVariable("identity") int id) {
		
		return studentService.getStudent(id);
		}

	@GetMapping("/getAll")
	public List<StudentDto> getAllStudent(){
		
		return studentService.getAllStudent();
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		return studentService.deleteStudent(id);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		 studentService.deleteAllStudent();
		 
		 return new ResponseEntity<String>("All Students details"+ "have been deleted",HttpStatus.OK);
	}
	
	@GetMapping("/getStudentName/{name}")
	public List<StudentDto> getStudentByName(@PathVariable("name") String studentName){
		
		return studentService.getStudentByName(studentName);
	}
	
	@GetMapping("/getStudentByEmail/{email}")
	public List<StudentDto> getStudentByEmail(@PathVariable("email") String studentEmail){
		return studentService.getStudentByEmail(studentEmail);
	}
	
	@PostMapping("/assignAddress/{studentId}/{addressId}")
	public StudentDto assignAddressToStudent(@PathVariable("studentId") int id,@PathVariable("addressId") int addressId) {
		
		return studentService.assignAddressToStudent(id, addressId);
	}
	
	@DeleteMapping("/del/{id}")
	public void deleteaddressbyid(@PathVariable("id") int id) {
		studentService.deleteaddressbyid(id);
	}

}

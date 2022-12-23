package com.student;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import com.student.util.Convertor;

@SpringBootTest
class StudentServiceTest {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Convertor convertor;
	
	@MockBean
	private StudentRepository studentRepository;
	
	@Test
	void createStudentTest() {
		Student student = new Student();
		student.setStudentname("Abhishek");
		student.setEmail("abhishek@gmail.com");
		student.setPhone(90908938);
//		Student student = Student.builder().studentname("Abhishek").email("Abhishek@gmail.com").phone(767678783).build();
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		assertThat(studentService.createStudent(student)).isEqualTo("..........Student Added Successfully.........");
	}

}

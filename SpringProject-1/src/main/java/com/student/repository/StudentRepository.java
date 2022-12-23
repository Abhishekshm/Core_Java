package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("from Student where studentName like :s%")
	List<Student> getStudentByName(@Param("s") String studentName);
	
	@Query("from Student where email =:s")
	List<Student> getStudentByEmail(@Param("s") String studentEmail);
	
	@Query("delete from Student where addressId =:s")
	void deleteAddressbyId(@Param("s") int id) ;
}

package com.dao;

/*
Program :- Implemeting dao class of Student 
@Author :- Abhishek Sharma
Date :-24/11/2022
*/
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Student;
import com.util.HibernateUtil;

//declare class
public class StudentDao {

	// declare method to create student
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(student);
			System.out.println(student.getFirst() + "  Student details are save");
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// declare method to update student
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(student);
			System.out.println(student.getFirst() + "  Student details are Updated");

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// declare method to delete student
	public void deleteStudent(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a instructor object
			Student student = session.get(Student.class, id);
			if (student != null) {
				session.delete(student);
				System.out.println(student.getFirst() + "  Student details are deleted");

			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	// declare method to Find perticular student
	public Student getStudent(int id) {

		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an instructor object
			student = session.get(Student.class, id);
			// commit transaction
			System.out.println("ID ==" + student.getId() + " Name= " + student.getFirst());
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}

	// declare method to show all student
	public List<Student> getAllStudent() {

		Transaction transaction = null;
		List<Student> listOfStudent = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an instructor object

			listOfStudent = session.createQuery("from Student").getResultList();
			System.out.println("The List of Students are ");
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfStudent;
	}
}

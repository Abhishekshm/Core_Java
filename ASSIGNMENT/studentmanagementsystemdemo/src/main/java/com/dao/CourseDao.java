package com.dao;

/*
Program :- Implemeting dao class of Course
@Author :- Abhishek Sharma
Date :-24/11/2022
*/
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Course;
import com.util.HibernateUtil;

//decclaring class
public class CourseDao {
	// declare method to create course
	public void saveCourse(Course course) {

		// Creating Instance of Transaction
		Transaction transaction = null;

		// Try--Catch block
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the Course object
			session.save(course);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			// if block
			if (transaction != null) {
				transaction.rollback();
			} // end of if
			e.printStackTrace();
		} // end of try-catchs
	}// end of method

	// declare method to update course
	public void updateCourse(Course course) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(course);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// declare method to show particular course
	public Course getCourse(int id) {

		Transaction transaction = null;
		Course course = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an instructor object
			course = session.get(Course.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return course;
	}
}

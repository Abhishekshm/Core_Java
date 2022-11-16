package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.StudentDetails;
import com.util.HibernateUtil;

public class StudentDetailsDao {

	public class InstructorDetailDao {
		public void saveInstructorDetail(StudentDetails studentDetaill) {
			Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the student object
				session.save(studentDetaill);
				// commit transaction
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
		}

		public void updateInstructorDetail(StudentDetails studentDetaill) {
			Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
				// save the student object
				session.update(studentDetaill);
				// commit transaction
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
		}

		public StudentDetails getInstructorDetail(int id) {

			Transaction transaction = null;
			StudentDetails student = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
				// get an instructor object
				student = session.get(StudentDetails.class, id);
				// commit transaction
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			return student;
		}
	}
}

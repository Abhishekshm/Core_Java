package com.doa;


import org.hibernate.Session;
import org.hibernate.Transaction;



import com.entity.InstructorDetail;
import com.util.HibernateUtil;


public class InstructorDetailDao {
    public void saveInstructorDetail(InstructorDetail instructorDetail) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(instructorDetail);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

 

    public void updateInstructorDetail(InstructorDetail instructorDetail) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(instructorDetail);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

 

    public InstructorDetail getInstructorDetail(int id) {

 

        Transaction transaction = null;
        InstructorDetail instructor = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an instructor object
            instructor = session.get(InstructorDetail.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return instructor;
    }
}

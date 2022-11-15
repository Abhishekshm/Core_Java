

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		// Create Configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);

		// Create Session Factory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Initialize Session Object
		Session session = sessionFactory.openSession();

		Student s1 = new Student();

		s1.setId(1);
		s1.setFirst("Abhishek");
		s1.setLast("Sharma");
		s1.setAge(22);
		s1.setAdd("Kolkata");
		s1.setCourse("B.tech");
		session.beginTransaction();

		// Here we have used
		// save() method of JPA
		session.save(s1);

		session.getTransaction().commit();
	}
}

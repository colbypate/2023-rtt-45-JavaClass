package jpa.entitymodels;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {

	public void update(Student student) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(student);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Student student) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(student);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Student> getAllStudents() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Student c";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		List<Student> result = query.getResultList();
		session.close();
		return result;
	}
		

	public Student getStudentByEmail(String email) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Student s where s.email = :idParam";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("idParam",email);
		Student result = query.getSingleResult();
		session.close();
		return result;
	}
	
	public List<Student> findByContactFirstName(String name) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Student c where c.contact_firstname = :firstname";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("firstname", name);
		List<Student> result = query.getResultList();
		session.close();
		return result;
	}


	public void insert(Student student) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();


		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();

	}
}

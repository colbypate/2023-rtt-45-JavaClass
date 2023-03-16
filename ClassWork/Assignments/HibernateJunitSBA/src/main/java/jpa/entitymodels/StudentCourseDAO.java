package jpa.entitymodels;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentCourseDAO {

	
	public List<Student> getAllStudents() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Student s";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		List<Student> result = query.getResultList();
		session.close();
		return result;
	}
		

	public Student getStudentByEmail(String email) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Student s where s.email = :email";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("email",email);
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


	public void registerStudentToCourse(Student student) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();


		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();

	}
	
	public List<Course> getStudentCourses(Integer studentId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Course c where c.id in (select s.courseId from StudentCourse s where s.studentId = :id)";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("id", studentId);
		List<Course> result = query.getResultList();
		session.close();
		return result;
	}
}

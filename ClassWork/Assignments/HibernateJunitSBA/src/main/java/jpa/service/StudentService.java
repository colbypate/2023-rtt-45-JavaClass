package jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.StudentCourse;
import jpa.entitymodels.StudentDAO;

public class StudentService implements StudentDAO {

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
		String hql = "FROM Student s where s.sEmail = :email";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("email", email);
		Student result = query.getSingleResult();
		session.close();
		return result;
	}

	public boolean validateStudent(String email, String password) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Student s where s.sEmail = :email and s.sPass = :password";
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		boolean result = query.equals(null);
		session.close();
		return result;
	}

	public void registerStudentToCourse(Student student, Course course) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		StudentCourse sc = new StudentCourse();
		sc.setStudent(student);
		sc.setCourse(course);
		session.getTransaction().begin();
		session.save(sc);
		session.getTransaction().commit();

	}

	public List<Course> getStudentCourses(Student student) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Course c where c.id in (select sc.course.cId from StudentCourse sc where sc.student.sId = :x)";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("x", student.getSId());
		List<Course> result = query.getResultList();
		session.close();
		return result;
	}


}

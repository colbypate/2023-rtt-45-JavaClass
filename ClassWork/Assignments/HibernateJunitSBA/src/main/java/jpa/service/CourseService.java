package jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.CourseDAO;

public class CourseService implements CourseDAO{

	public List<Course> getAllCourses() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Course c";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		List<Course> result = query.getResultList();
		session.close();
		return result;
	}

	public Course getCourseById(int number) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Course c where c.id = :number";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("number",number);
		Course result = query.getSingleResult();
		session.close();
		return result;
	}

	
}

package jpa.entitymodels;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface CourseDAO {

	List<Course> getAllCourses();
	

}

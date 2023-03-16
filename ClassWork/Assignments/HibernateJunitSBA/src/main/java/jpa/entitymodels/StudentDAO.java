package jpa.entitymodels;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface StudentDAO {
	
	List<Student> getAllStudents();

	Student getStudentByEmail(String email);

	boolean validateStudent(String email, String password);

	void registerStudentToCourse(Student student, Course course);

	List<Course> getStudentCourses(Student student);
	
}

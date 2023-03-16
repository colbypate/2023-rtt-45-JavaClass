package jpa.service;

import jpa.entitymodels.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class StudentServiceTest {

	private static StudentService studentService;

	@BeforeAll
	public static void setUp() {
		studentService = new StudentService();
	}

	@Test
	public void getStudentByEmail() {

		// given
		Student expected = new Student();
		expected.setSId(1);
		expected.setSName("Alexandra Iannitti");
		expected.setSPass("TWP4hf5j");

		// when
		Student actual = studentService.getStudentByEmail("aiannitti7@is.gd");

		// then
		Assertions.assertEquals(expected.getSId(), actual.getSId());
		Assertions.assertEquals(expected.getSName(), actual.getSName());
		Assertions.assertEquals(expected.getSPass(), actual.getSPass());
	}
	
}

package jpa.entitymodels;
import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {
	private Scanner scanner;
	private StringBuilder sb;
	private CourseService courseService;
	private StudentService studentService;
	private Student currentStudent;
	
	public SMSRunner() {
		scanner = new Scanner(System.in);
		sb = new StringBuilder();
		courseService = new CourseService();
		studentService = new StudentService();
		
	}

	public static void main(String[] args) {

		SMSRunner sms = new SMSRunner();
		sms.run();
	}

	private void run() {
		// Login or quit
		switch (menu1()) {
		case 1:
			if (studentLogin()) {
				registerMenu();
			}
			break;
		case 2:
			out.println("Goodbye!");
			break;

		default:

		}
	}

	private int menu1() {
		sb.append("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
		out.print(sb.toString());
		sb.delete(0, sb.length());

		return scanner.nextInt();
	}

	private boolean studentLogin() {
		boolean retValue = false;
		out.print("Enter your email address: ");
		String email = scanner.next();
		out.print("Enter your password: ");
		String password = scanner.next();

		Student student = studentService.getStudentByEmail(email);
		if (student != null) {
			currentStudent = student;
		}
		if(currentStudent != null && currentStudent.getSPass().equals(password)) {
			List<Course> courses = studentService.getStudentCourses(student);
			out.println("MyClasses");
			for (Course course : courses) {
				out.println(course);
			}
			retValue = true;
		} else {
			out.println("User Validation failed. GoodBye!");
		}
		return retValue;
	}

	private void registerMenu() {
		sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
		out.print(sb.toString());
		sb.delete(0, sb.length());

		switch (scanner.nextInt()) {
		case 1:
			List<Course> allCourses = courseService.getAllCourses();
			List<Course> studentCourses = studentService.getStudentCourses(currentStudent);
			allCourses.removeAll(studentCourses);
			out.printf("%5s%15S%15s\n", "ID", "Course", "Instructor");
			for (Course course : allCourses) {
				out.println(course);
			}
			out.println();
			out.print("Enter Course Number: ");
			int number = scanner.nextInt();
			Course newCourse = courseService.getCourseById(number);

			if (newCourse != null) {
				studentService.registerStudentToCourse(currentStudent, newCourse);
				Student temp = studentService.getStudentByEmail(currentStudent.getSEmail());
				
				StudentCourseDAO scDao = new StudentCourseDAO();
				List<Course> sCourses = scDao.getStudentCourses(temp.getSId());
				

				out.println("MyClasses");
				for (Course course : sCourses) {
					out.println(course);
				}
			}
			break;
		case 2:
		default:
			out.println("Goodbye!");
		}
	}
}
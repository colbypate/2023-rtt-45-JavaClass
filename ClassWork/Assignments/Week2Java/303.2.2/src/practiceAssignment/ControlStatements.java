package practiceAssignment;

import java.util.Scanner;

public class ControlStatements {
	public static void main(String[] args) {
		
		ControlStatements cs = new ControlStatements();
		cs.problem1();
		cs.problem2();
		cs.problem3();
		cs.problem4();
		cs.problem5();
		
	}
	
	public void problem1() {
		int x = 7;
//		int x = 15;
		if(x < 10) {
			System.out.println("Less than 10");
		}
	}
	
	public void problem2() {
		int x = 7;
		x = 15;
		if(x < 10) {
			System.out.println("Less than 10");
		}else if(x > 10) {
			System.out.println("Greater than 10");
		}
	}
	
	public void problem3() {
		int x = 15;
		if(x < 10) {
			System.out.println("Less than 10");
		}else if(x > 10 && x < 20) {
			System.out.println("Between 10 and 20");
		}else if (x >= 20) {
			System.out.println("Greater than or equal to 20");
		}
	}
	
	public void problem4() {
//		int x = 15;
		int x = 5;
		if(x < 10 || x > 20) {
			System.out.println("Out of range");
		}else {
			System.out.println("In range");
		}
	}
	
	public void problem5() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter test score: ");
		int grade = scanner.nextInt();
		if(grade > 100 || grade < 0) {
			System.out.println("Score out of range");
		}else if(grade >= 90 && grade <= 100) {
			System.out.println("A");
		}else if(grade >= 80 && grade < 90) {
			System.out.println("B");
		}else if(grade >= 70 && grade < 80) {
			System.out.println("C");
		}else if(grade >= 60 && grade < 70) {
			System.out.println("D");
		}else if(grade < 60 && grade >= 0) {
			System.out.println("F");
		}
	}
	
	public void problem6() {
		int x = Math.random;
		switch(x>)
		
	}
}
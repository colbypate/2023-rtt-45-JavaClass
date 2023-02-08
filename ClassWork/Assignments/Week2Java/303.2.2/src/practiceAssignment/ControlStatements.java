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
		cs.problem6();
		cs.problem7();
		
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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number between 1 and 7: ");
		int num = scanner.nextInt();
		while(num < 1 || num > 7) {
			System.out.println("Try again... Enter a number between 1 and 7: ");
			num = scanner.nextInt();

		}
		
		switch(num) {
		case 1: System.out.println("Monday"); break;
		case 2: System.out.println("Tuesday"); break;
		case 3: System.out.println("Wednesday"); break;
		case 4: System.out.println("Thursday"); break;
		case 5: System.out.println("Friday"); break;
		case 6: System.out.println("Saturday"); break;
		case 7: System.out.println("Sunday"); break;
		default: System.out.println("This is not possible."); break;
		}
		
	}
	
	public void problem7() {
		System.out.println("Let's Do your taxes...");
		System.out.println("Select the filing status that applies to you: \n"
				+ "1 for Filing Single \n"
				+ "2 for Married fFiling Joinlty or Qualified Widow(er)\n"
				+ "3 for Married Filing Separately \n"
				+ "4 for Head of Household \n"
				+ "Type response here: ");
		Scanner scanner = new Scanner(System.in);
		int status = scanner.nextInt();
		while(status < 1 || status > 4) {
			System.out.println("Try again... Enter a number between 1 and 4: ");
			status = scanner.nextInt();
		}
		System.out.println("What is your total taxables income? \n"
				+ "Enter total here: ");
		int income = scanner.nextInt();
		while(income < 0) {
			System.out.println("What is your total taxables income? \n"
					+ "Enter total here: ");
			income = scanner.nextInt();
		}
		if(status == 1) {
			if(income >= 0 && income <= 8350) {
				double incomeTax = .10 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 8351 && income <= 33950) {
				double incomeTax = .15 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 33951 && income <= 82250) {
				double incomeTax = .25 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 82251 && income <= 171550) {
				double incomeTax = .28 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 171551 && income <= 372950) {
				double incomeTax = .33 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 372951) {
				double incomeTax = .35 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}
		}else if(status == 2) {
			if(income >= 0 && income <= 16700) {
				double incomeTax = .10 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 16701 && income <= 67900) {
				double incomeTax = .15 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 67901 && income <= 137050) {
				double incomeTax = .25 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 137051 && income <= 208850) {
				double incomeTax = .28 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 208851 && income <= 372950) {
				double incomeTax = .33 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 372951) {
				double incomeTax = .35 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}
		}else if(status == 3) {
			if(income >= 0 && income <= 8350) {
				double incomeTax = .10 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 8351 && income <= 33950) {
				double incomeTax = .15 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 33951 && income <= 68525) {
				double incomeTax = .25 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 68526 && income <= 104425) {
				double incomeTax = .28 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 104426 && income <= 186475) {
				double incomeTax = .33 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 186476) {
				double incomeTax = .35 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}
		}else if(status == 4) {
			if(income >= 0 && income <= 11950) {
				double incomeTax = .10 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 11951 && income <= 45500) {
				double incomeTax = .15 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 45501 && income <= 117450) {
				double incomeTax = .25 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 117451 && income <= 190200) {
				double incomeTax = .28 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 190201 && income <= 372950) {
				double incomeTax = .33 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}else if(income >= 372951) {
				double incomeTax = .35 * income;
				System.out.println("Your federal personal income tax comes out to $"
						+ incomeTax);
			}
		}
	}
	
	
}
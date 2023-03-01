package practiceAssignment;

import java.util.Scanner;

public class Loops {
	public static void main(String[] args) {
		Loops loops = new Loops();
		loops.problem1();
		loops.problem2();
		loops.problem3();
	}
	
	public void problem1() {
		for(int i = 1; i <= 12; i++) {
			for(int x = 1; x <= 12; x++) {
				System.out.println("\t"+i*x);
			}
			System.out.println(" ");
			
		}
	}
	
	public void problem2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a positive integer: ");
		int x = scanner.nextInt();
		if(x != (int)x) {
			System.out.println("Oops... Enter a positive whole number please: ");
			x = scanner.nextInt();
		}
		System.out.println("Enter another positive integer: ");
		int y = scanner.nextInt();
		if(y != (int)y) {
			System.out.println("Try again... Enter a positive whole number please:  ");
			y = scanner.nextInt();
		}
		int gcd; 
		if(x > y) {
			int j = y;
			gcd = j;
			while(x % j != 0 || y % j != 0) {
					j--;
					gcd = j;
				}
			System.out.println("The Greatest Common Denominator of "+x+" and "+y
					+" is "+gcd);
				
			}
		else{
			int j = x;
			gcd = j;
			while(x % j != 0 || y % j != 0) {
					j--;
					gcd = j;
				}
			System.out.println("The Greatest Common Denominator of "+x+" and "+y
					+" is "+gcd);
				
			}
		}
	public void problem3() {
		int year = 0;
		double tuition = 10000;
		for(int i = 0; tuition < 20000; i++) {
			tuition = tuition*1.07;
			System.out.println(tuition);
			year++;
		}
		System.out.println("In year "+year+" your tuition will have doubled from"
				+ " $10,000 to "+String.format("%.2f", tuition));
		
	}
		
}

package com.perscholas.java_basics;

//Write a program that declares 2 integer variables, assigns an integer to each,
//and adds them together. Assign the sum to a variable. Print out the result.
//	DONE

//Write a program that declares 2 double variables, assigns a number to each,
//and adds them together. Assign the sum to a variable. Print out the result.
//	DONE

//Write a program that declares an integer variable and a double variable,
//assigns numbers to each, and adds them together. Assign the sum to a variable. 
//Print out the result. What variable type must the sum be?
//	 DONE 

//Write a program that declares 2 integer variables, assigns an integer to each,
//and divides the larger number by the smaller number. Assign the result to a 
//variable. Print out the result. Now change the larger number to a decimal.
//What happens? What corrections are needed?
// 	DONE

//Write a program that declares 2 double variables, assigns a number to each,
//and divides the larger by the smaller. Assign the result to a variable. 
//Print out the result. Now, cast the result to an integer. Print out the
//result again.
// 	DONE

//Write a program that declares two integer variables, x, and y, and assigns 5
//to x and 6 to y. Declare a variable q and assign y/x to it and print q. 
//Now, cast y to a double and assign it to q. Print q again.
// 	DONE

//Write a program that declares a named constant and uses it in a calculation.
//Print the result.
// 	DONE

//Write a program where you create 3 variables that represent products at a cafe.
//The products could be beverages like coffee, cappuccino, espresso, green tea, etc.
//Assign prices to each product. Create 2 more variables called subtotal and
//totalSale and complete an “order” for 3 items of the first product, 4 items of 
//the second product, and 2 items of the third product. Add them all together to
//calculate the subtotal. Create a constant called SALES_TAX and add sales tax 
//to the subtotal to obtain the totalSale amount. Format the results to 2 decimal places.
// 	DONE

public class JavaBasicsClass {
	public static void main(String[] args) {
		int a = 8;
		int b = 3;
		int sumAB = a+b;
		System.out.println("a + b = "+sumAB);
		
		int s = 7;
		int t = 5;
		int sumST = s+t;
		System.out.println("s + t = "+sumST);
		
		int c = 3;
		double d = 15;
		double sumCD = c+d;
		System.out.println("c + d = "+sumCD +"  double");
		
		double v = 12;
		int w = 4;
		double quotientVW = v/w;
		System.out.println("v / w = "+quotientVW+ "  The quotient has to be changed to "
				+ "double type");
		
		double e = 68;
		double f = 12;
		double quotientEF = e/f;
		System.out.println("e / f = "+quotientEF);
		System.out.println("e / f = "+(int)quotientEF);
		
		int x = 5;
		int y = 6;
		double q = y/x;
		System.out.println("q = "+q);
		q = (double)y/x;
		System.out.println("q = "+q);
		
		final double PI = 3.14159;
		int radiusOfCircle = 3;
		double areaOfCircle = PI*radiusOfCircle;
		System.out.println("The area of a circle with a radius of "+radiusOfCircle+
				" cm is "+areaOfCircle+" cm squared.");
		
		double cappuccino = 4.29;
		double caramelMacchiato = 5.69;
		double espresso = 6.50;
		double subtotal = 3*cappuccino + 4*caramelMacchiato + 2*espresso;
		final double SALES_TAX = .10 * subtotal;
		double totalSale = subtotal + SALES_TAX;
		System.out.println("Your total at the coffeeshop is $"+String.format
				("%.2f", totalSale));
		
		
	} 
	
}

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Homework1 {

	public static void main(String[] args) {
		// make this in a new Homework1 class
		// I want to see a list of all customers that have made a payment larger than
		// <amount> in a particular <state>
		// Print the checkNumber, amount (formatted to $#.00 ), and the customer name
		// ordred by the largest amount first
		// input variables for the scanner are 1) the amount and 2) 2 digit state code.

		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "password";
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the name(first or last) you want to search for: ");
			String name = scanner.nextLine();
			Connection connection = DriverManager.getConnection(dburl, user, password);

			String SelectSQL = "Select * FROM employees where firstName = ? or lastName = ?";

			// This is a JDBC class that creates the statement to run the SQL
			// Using the prepared statement protects our code from sql injection
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);

			// This says to take the first ? in the statement above = to firstName
			stmt.setString(1, name);
			stmt.setString(2, name);

			// executes the query and puts the result into the ResultSet object
			ResultSet result = stmt.executeQuery();

			// loops over the result set
			while (result.next()) {
				String EmployeeID = result.getString("employeeNumber");
				String fname = result.getString("firstName");
				String lname = result.getString("lastName");
				String email = result.getString("email");
				System.out.println(EmployeeID + " | " + fname + "|" + lname + "| " + email);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}

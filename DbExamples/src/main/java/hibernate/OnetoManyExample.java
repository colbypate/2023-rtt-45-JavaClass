package hibernate;

import java.util.Date;

public class OnetoManyExample {

	public static void main(String[] args) {
		
		CustomerDAO customerDao = new CustomerDAO();
		EmployeeDAO employeeDao = new EmployeeDAO();
		
		Employee e = employeeDao.findById(1166);
		System.out.println(e);
		
		for(Customer customer : e.getCustomers()) {
			System.out.println(customer);
		}
	
		Customer customer = new Customer();
		customer.setCustomerName("Hibernate Customer");
		customer.setContactFirstname("First Name");
		customer.setContactLastname("Last Name");
		customer.setPhone("205-444-4444");
		customer.setState("AL");
		customer.setCity("Birmingham");
		customer.setCountry("USA");
		customer.setAddressLine1("Address Line 1");
		
		e.getCustomers().add(customer);
		employeeDao.update(e);
		
		Payment p = new Payment();
		p.setAmount(50000.55);
		p.setPaymentDate(new Date());
		p.setCustomer(customer);
		p.setCheckNumber("12345");
		
		customer.getPayments().add(p);
		customerDao.update(customer);
	}
}

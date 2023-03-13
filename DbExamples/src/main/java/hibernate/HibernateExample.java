package hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

	public static void main(String[] args) {
		// HibernateExample he = new HibernateExample();
		CustomerDAO customerDao = new CustomerDAO();
		
		Customer customer = new Customer();
		customer.setCustomerName("Hibernate Customer");
		customer.setContactFirstname("First Name");
		customer.setContactLastname("Last Name");
		customer.setPhone("205-444-4444");
		customer.setState("AL");
		customer.setCity("Birmingham");
		customer.setCountry("USA");
		customer.setAddressLine1("Address Line 1");
		
		Customer first = customerDao.findById(497);
		System.out.println(first.toString());
		
		first.setAddressLine1("This is an update");
		first.setPostalCode("79797");
		first.setCreditLimit(100000.35);
		
		customerDao.update(first);
//		List<Customer> firstNames = he.findByContactFirstName("Leslie");
//		for(Customer c : firstNames) {
//			System.out.println(c);
//		}

	}
	
	
}

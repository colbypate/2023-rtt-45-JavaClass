package hibernate;

import java.util.Date;

public class OrderExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderDAO orderDao = new OrderDAO();
		Order order = orderDao.findById(10100);
		System.out.println(order);
		
		
		Order order1 = new Order();
		CustomerDAO customer = new CustomerDAO();
		Customer c = customer.findById(499);
		order1.setCustomer(c);
		order1.setOrderDate(new Date());
		order1.setRequiredDate(new Date());
		order1.setShippedDate(new Date());
		order1.setStatus("Shipped");
		
		orderDao.insert(order1);

	}

}

package hibernate;

import java.util.List;

public class ProductExample {

	public static void main(String[] args) {

		ProductDAO productDao = new ProductDAO();
		Product product = productDao.findById(1);
		System.out.println(product);

		List<Product> product1 = productDao.findByProductName("harley");
		System.out.println(product1);
		
		

//		Product product1 = new Product();
//		CustomerDAO customer = new CustomerDAO();
//		Customer c = customer.findById(499);
//		order1.setCustomer(c);
//		order1.setOrderDate(new Date());
//		order1.setRequiredDate(new Date());
//		order1.setShippedDate(new Date());
//		order1.setStatus("Shipped");
//		
//		ProductDAO.insert(order1);

	}

}

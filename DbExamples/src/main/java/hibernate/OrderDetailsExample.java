package hibernate;

import java.util.List;

public class OrderDetailsExample {

	public static void main(String[] args) {
		

		OrderDetailsDAO oDdao = new OrderDetailsDAO();
		List<OrderDetails> oD = oDdao.findByOrderId(10100);
		System.out.println("Order Details-----> ");
		System.out.println(oD);
		
		OrderDetails oD1 = new OrderDetails();
		

//		List<Product> product1 = productDao.findByProductName("harley");
//		System.out.println(product1);
		

	}

}

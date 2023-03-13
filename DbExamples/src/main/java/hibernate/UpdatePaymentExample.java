package hibernate;

public class UpdatePaymentExample {

	public static void main(String[] args) {
		
		PaymentDAO pDao = new PaymentDAO();
		Payment p = pDao.findById(1);
		p.setCheckNumber("3434");
		p.setAmount(11111.11);
		pDao.update(p);

	}

}

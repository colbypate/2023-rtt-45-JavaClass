package hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDetailsDAO {

	public void insert(OrderDetails orderDetails) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.save(orderDetails);
		session.getTransaction().commit();

	}

	public void update(OrderDetails orderDetails) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(orderDetails);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(OrderDetails orderDetails) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(orderDetails);
		session.getTransaction().commit();
		session.close();
	}

	public List<OrderDetails> findByOrderId(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM OrderDetails od where od.orderId = :idParam";
		TypedQuery<OrderDetails> query = session.createQuery(hql, OrderDetails.class);
		query.setParameter("idParam", id);
		List<OrderDetails> result = query.getResultList();
		session.close();
		return result;
	}
}

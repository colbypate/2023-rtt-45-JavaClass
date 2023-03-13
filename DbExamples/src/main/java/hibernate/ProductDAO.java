package hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {

	
	public void update(Product Product) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(Product);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Product Product) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(Product);
		session.getTransaction().commit();
		session.close();
	}
		

	public Product findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Product p where p.id = :idParam";
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("idParam", id);
		Product result = query.getSingleResult();
		session.close();
		return result;
	}
	
	public List<Product> findByProductName(String name) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Product p where p.productName like CONCAT('%', :name, '%')";
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("name",name);
		List<Product> result = query.getResultList();
		session.close();
		return result;
	}


	public void insert(Product Product) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();


		session.getTransaction().begin();
		session.save(Product);
		session.getTransaction().commit();

	}
}

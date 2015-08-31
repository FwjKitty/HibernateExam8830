package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.CustomerDaoI;
import model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDaoI{

	@Autowired
	private SessionFactory sessionFactory;
	public void save(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		session.close();
	}
	public Customer query(Customer customer) {
		String sql = "FROM customer WHERE first_name=? AND last_name=? AND email=? AND address_id=?";//HQL语句
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(sql);
		query.setParameter(0, customer.getFirst_name());
		query.setParameter(1, customer.getLast_name());
		query.setParameter(2, customer.getEmail());
		query.setParameter(3, customer.getAddress_id());
		List customers = query.list();
		if(customers.size() != 0){
			customer = (Customer) customers.get(0);
		}
		tx.commit();
		System.out.println("ID:"+customer.getCustomer_id());
		session.close();
		return customer;
	}
	
	public Customer queryById(int id) {
		String sql = "FROM customer WHERE customer_id=?";//HQL语句
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(sql);
		query.setParameter(0, id);
		List customers = query.list();
		Customer customer = null;
		if(customers.size() != 0){
			customer = (Customer) customers.get(0);
		}
		tx.commit();
		session.close();
		return customer;
	}
	
	public int delete(int id) {
		Customer customer = queryById(id);
		if(customer != null){
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(customer);
			tx.commit();
			session.close();
			return 1;
		}else{
			return 0;
		}
	}
}
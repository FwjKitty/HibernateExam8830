package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.AddressDaoI;
import model.Address;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDaoI {

	@Autowired
	private SessionFactory sessionFactory;
	public Address queryById(int id) {
		
		Address address = null;
		String sql = "FROM address WHERE address_id=?";//HQL语句
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery(sql);
		query.setParameter(0, id);
		List addresses = query.list();
		if(addresses.size() != 0){
			address = (Address) addresses.get(0);
		}
		tx.commit();
		return address;
	}
}
package dao;

import model.Customer;

public interface CustomerDaoI {

	void save(Customer customer);
	Customer query(Customer customer);
	Customer queryById(int id);
	int delete(int id);
}
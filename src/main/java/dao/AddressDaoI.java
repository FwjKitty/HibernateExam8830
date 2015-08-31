package dao;

import org.hibernate.SessionFactory;

import model.Address;

public interface AddressDaoI {

	Address queryById(int id);
}
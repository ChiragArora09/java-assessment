package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.exception.ResourceNotFoundException;
import com.model.Customers;

public class CustomerService {
	CustomerDao dao = new CustomerDaoImpl();

	public int insertCustomer(Customers customer) throws SQLException{
		return dao.insertCustomer(customer);
	}

	public List<Customers> getAllCustomer() throws SQLException {
		return dao.getAllCustomers();
	}

	public int updateCustomer(int id, String email, String phoneNumber, String address) throws SQLException {
		return dao.updateCustomer(id, email, phoneNumber, address);
	}

	public int deleteCustomer(int id) throws SQLException {
		return dao.deleteCustomer(id);
	}

	public Customers getParticularCustomer(int id) throws SQLException, ResourceNotFoundException {
		Customers c = dao.getParticularCustomer(id);
		if(c.getId() == 0) {
			throw new ResourceNotFoundException("Customer not found");
		}
		return c;
	}

	public int getTotalOrders(int id) throws SQLException{
		return dao.calculateTotalOrders(id); 
	}

}

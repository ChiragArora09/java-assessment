package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OrderDetailsDao;
import com.dao.OrderDetailsDaoImpl;
import com.model.OrderDetails;

public class OrderDetailsService {
	OrderDetailsDao dao = new OrderDetailsDaoImpl();

	public List<OrderDetails> getAllOrderDetails() throws SQLException{
		return dao.allOrderDetails();
	}

	public double calculateSubtotal(int id) throws SQLException {
		return dao.calculateSubtotal(id);
	}

	public int updateQuantity(int id, int value) throws SQLException {
		return dao.updateQuantity(id, value);
	}

	public int addDiscount(int id, double discount) throws SQLException {
		return dao.addDiscount(id, discount);
	}

}

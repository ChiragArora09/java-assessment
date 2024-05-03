package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import com.dto.OrderProductsDetailsDto;
import com.model.Orders;

public class OrdersService {
	OrderDao dao = new OrderDaoImpl();

	public List<Orders> getAllOrders() throws SQLException {
		return dao.allOrders();
	}

	public double getTotalAmount() throws SQLException {
		return dao.calculateTotalAmount();
	}

	public OrderProductsDetailsDto getOrderdetails(int id) throws SQLException {
		return dao.getOrderDetails(id);
	}

	public int updateOrderStatus(int id, String status) throws SQLException {
		return dao.updateOrderStatus(id, status);
	}

	public int cancelOrder(int id) throws SQLException {
		return dao.cancelOrder(id);
	}

}

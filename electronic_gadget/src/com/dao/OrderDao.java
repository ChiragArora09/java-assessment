package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.OrderProductsDetailsDto;
import com.model.Orders;

public interface OrderDao {
	List<Orders> allOrders() throws SQLException;
	double calculateTotalAmount() throws SQLException;
	OrderProductsDetailsDto getOrderDetails(int orderId) throws SQLException;
    int updateOrderStatus(int orderId, String status) throws SQLException;
    int cancelOrder(int orderID) throws SQLException;
}

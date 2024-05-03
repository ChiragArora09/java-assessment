package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.OrderDetails;

public interface OrderDetailsDao {
	List<OrderDetails> allOrderDetails() throws SQLException;
	double calculateSubtotal(int orderDetailId) throws SQLException;
    int updateQuantity(int orderDetailId, int quantity) throws SQLException;
    int addDiscount(int orderDetailId, double discount) throws SQLException;

}

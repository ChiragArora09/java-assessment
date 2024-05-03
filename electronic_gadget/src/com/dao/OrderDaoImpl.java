package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.OrderProductsDetailsDto;
import com.model.Orders;
import com.utility.DBConnection;

public class OrderDaoImpl implements OrderDao {
	@Override
	public List<Orders> allOrders() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM orders";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Orders> list = new ArrayList<>();
		while(rst.next()) {
			int id = rst.getInt("id");
			String date = rst.getString("order_date");
			Double totalAmount = rst.getDouble("total_amount");
			int customerId = rst.getInt("customer_id");
			String status = rst.getString("status");
			
			Orders o = new Orders(id, date, totalAmount, customerId, status);
			list.add(o);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public double calculateTotalAmount() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT SUM(total_amount) as amount from orders";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		if(rst.next()) {
			int totalAmount = rst.getInt("amount");
			return totalAmount;
		}
		DBConnection.dbClose();
		return 0;
	}

	@Override
	public OrderProductsDetailsDto getOrderDetails(int orderId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select o.id as order_id, p.product_name, od.quantity, o.total_amount, p.price from order_details od JOIN orders o ON o.id=od.orders_id JOIN products p ON p.id=od.products_id WHERE o.id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderId);
		ResultSet rst = pstmt.executeQuery();
		
		OrderProductsDetailsDto details = new OrderProductsDetailsDto();
		if(rst.next()) {
			details.setOrderId(rst.getInt("order_id"));
			details.setPrice(rst.getDouble("price"));
			details.setProductName(rst.getString("product_name"));
			details.setQuantity(rst.getInt("quantity"));
			details.setTotalAmount(rst.getDouble("total_amount"));
		}
		DBConnection.dbClose();
		return details;
		
	}

	@Override
	public int updateOrderStatus(int orderId, String status) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE orders SET status=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, status);
		pstmt.setInt(2, orderId);
		
		int updated = pstmt.executeUpdate();
		
		DBConnection.dbClose();		
		return updated;
	}

	@Override
	public int cancelOrder(int orderId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE orders SET status='cancelled' WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderId);
		
		int updated = pstmt.executeUpdate();
		
		DBConnection.dbClose();		
		return updated;
		
	}

}

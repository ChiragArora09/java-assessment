package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.OrderDetails;
import com.utility.DBConnection;

public class OrderDetailsDaoImpl implements OrderDetailsDao{

	@Override
	public List<OrderDetails> allOrderDetails() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM order_details";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<OrderDetails> list = new ArrayList<>();
		while(rst.next()) {
			int id = rst.getInt("id");
			int orderId = rst.getInt("orders_id");
			int productId = rst.getInt("products_id");
			int quantity = rst.getInt("quantity");
			double discount = rst.getDouble("discount");
			
			OrderDetails od = new OrderDetails(id, orderId, productId, quantity, discount);
			list.add(od);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public double calculateSubtotal(int orderDetailId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT o.orders_id, p.product_name, (o.quantity * p.price) as subtotal FROM order_details o JOIN products p ON o.products_id=p.id WHERE o.id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderDetailId);
		ResultSet rst = pstmt.executeQuery();
		if(rst.next()) {
			double total = rst.getDouble("subtotal");
			return total;
		}
		DBConnection.dbClose();
		return 0;
	}

	@Override
	public int updateQuantity(int orderDetailID, int quantity) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE order_details SET quantity=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, orderDetailID);
		
		int status = pstmt.executeUpdate();
		
		DBConnection.dbClose();		
		return status;
	}

	@Override
	public int addDiscount(int orderDetailID, double discount) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE order_details SET discount=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, discount);
		pstmt.setInt(2, orderDetailID);
		
		int status = pstmt.executeUpdate();
		
		DBConnection.dbClose();		
		return status;
	}

}

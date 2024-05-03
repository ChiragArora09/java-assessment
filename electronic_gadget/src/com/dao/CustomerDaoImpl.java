package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.ResourceNotFoundException;
import com.model.Customers;
import com.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public int insertCustomer(Customers customer) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO customer(first_name, last_name, phone_number, email, address) VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customer.getFirstName());
		pstmt.setString(2, customer.getLastName());
		pstmt.setString(3, customer.getPhoneNumber());
		pstmt.setString(4, customer.getEmail());
		pstmt.setString(5, customer.getAddress());
		
		int status = pstmt.executeUpdate();
		
		DBConnection.dbClose();		
		return status;
	}

	@Override
	public int updateCustomer(int customerId, String email, String phoneNumber, String address) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE customer SET email=?, phone_number=?, address=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, phoneNumber);
		pstmt.setString(3, address);
		pstmt.setInt(4, customerId);
		
		int status = pstmt.executeUpdate();
		
		DBConnection.dbClose();		
		return status;
	}

	@Override
	public int deleteCustomer(int customerId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "DELETE FROM customer WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		
		int status = pstmt.executeUpdate();
		
		DBConnection.dbClose();		
		return status;
	}

	@Override
	public Customers getParticularCustomer(int customerId) throws SQLException, ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM customer WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		ResultSet rst = pstmt.executeQuery();
		Customers c = new Customers();
		if(rst.next()) {
			c.setId(rst.getInt("id"));
			c.setFirstName(rst.getString("first_name"));
			c.setLastName(rst.getString("last_name"));
			c.setPhoneNumber(rst.getString("phone_number"));
			c.setEmail(rst.getString("email"));
			c.setAddress(rst.getString("address"));
		}
		DBConnection.dbClose();
		return c;
	}

	@Override
	public List<Customers> getAllCustomers() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM customer";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Customers> list = new ArrayList<>();
		while(rst.next()) {
			int id = rst.getInt("id");
			String firstName = rst.getString("first_name");
			String lastName = rst.getString("last_name");
			String phoneNumber = rst.getString("phone_number");
			String address = rst.getString("address");
			String email = rst.getString("email");
			
			Customers c = new Customers(id, firstName, lastName, email, phoneNumber, address);
			list.add(c);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public int calculateTotalOrders(int customerId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select COUNT(o.customer_id) as total_orders from customer c JOIN orders o ON o.customer_id=c.id group by c.id HAVING c.id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		ResultSet rst = pstmt.executeQuery();
		if(rst.next()) {
			int totalOrders = rst.getInt("total_orders");
			return totalOrders;
		}
		DBConnection.dbClose();
		return 0;
	}
}

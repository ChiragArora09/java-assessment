package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.SellingQuantityDto;
import com.model.Products;
import com.utility.DBConnection;

public class ProductDaoImpl implements ProductDao {

	@Override
	public int createProduct(Products product) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO products(product_name, description, price) VALUES(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, product.getProductName());
		pstmt.setString(2, product.getDescription());
		pstmt.setDouble(3, product.getPrice());
		
		int status = pstmt.executeUpdate();
		
		DBConnection.dbClose();		
		return status;
	}

	@Override
	public int deleteProduct(int productId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "DELETE FROM products WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productId);
		
		int status = pstmt.executeUpdate();
		
		DBConnection.dbClose();		
		return status;
		
	}

	@Override
	public int updateProductInfo(int productId, String productName, String description, double price) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE products SET product_name=?, description=?, price=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, productName);
		pstmt.setString(2, description);
		pstmt.setDouble(3, price);
		pstmt.setInt(4, productId);
		
		int status = pstmt.executeUpdate();
		
		DBConnection.dbClose();		
		return status;
	}

	@Override
	public Products particularProduct(int productId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM products WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productId);
		ResultSet rst = pstmt.executeQuery();
		Products p = new Products();
		if(rst.next()) {
			p.setId(rst.getInt("id"));
			p.setProductName(rst.getString("product_name"));
			p.setDescription(rst.getString("description"));
			p.setPrice(rst.getDouble("price"));
		}
		DBConnection.dbClose();
		return p;
	}

	@Override
	public List<Products> getAllProducts() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM products";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Products> list = new ArrayList<>();
		while(rst.next()) {
			int id = rst.getInt("id");
			String name = rst.getString("product_name");
			String description = rst.getString("description");
			double price = rst.getDouble("price");
			
			Products p = new Products(id, name, description, price);
			list.add(p);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public boolean isProductInStock(int productId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * from inventory WHERE products_id=? AND quantity_in_stock>0";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productId);
		ResultSet rst = pstmt.executeQuery();
		boolean inStock = rst.next();
		DBConnection.dbClose();
		return inStock;
	}

	@Override
	public List<SellingQuantityDto> sellingQuantity() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select p.product_name, COUNT(o.products_id)*o.quantity as quantity from order_details o JOIN products p ON p.id=o.products_id group by o.products_id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<SellingQuantityDto> list = new ArrayList<>();
		while(rst.next()) {
			String name = rst.getString("product_name");
			int quantity = rst.getInt("quantity");
			
			SellingQuantityDto p = new SellingQuantityDto(name, quantity);
			list.add(p);
		}
		DBConnection.dbClose();
		return list;
	}

}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.InventoryProductsDto;
import com.dto.InventoryValueDto;
import com.model.Inventory;
import com.utility.DBConnection;

public class InventoryDaoImpl implements InventoryDao{

	@Override
	public List<Inventory> getAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM inventory";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Inventory> list = new ArrayList<>();
		while(rst.next()) {
			int id = rst.getInt("id");
			int quantityInStock = rst.getInt("quantity_in_stock");
			String lastStockUpdate = rst.getString("last_stock_update");
			int productId = rst.getInt("products_id");
			
			Inventory i = new Inventory(id, quantityInStock, lastStockUpdate, productId);
			list.add(i);
		}
		DBConnection.dbClose();
		return list;
		
	}

	@Override
	public List<InventoryProductsDto> getProductsByInventory() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT i.id, i.quantity_in_stock, i.last_stock_update, p.id as product_id, p.product_name, p.description, p.price FROM inventory i JOIN products p ON p.id=i.products_id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<InventoryProductsDto> list = new ArrayList<>();
		while(rst.next()) {
			int id = rst.getInt("id");
			int quantityInStock = rst.getInt("quantity_in_stock");
			String lastStockUpdate = rst.getString("last_stock_update");
			int productId = rst.getInt("product_id");
			String productName = rst.getString("product_name");
			String description = rst.getString("description");
			double price = rst.getDouble("price");
			
			InventoryProductsDto obj = new InventoryProductsDto(id, quantityInStock, lastStockUpdate, productId, productName, description, price);
			list.add(obj);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<InventoryProductsDto> productQuantityInStock() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT p.product_name, i.quantity_in_stock FROM inventory i JOIN products p ON p.id=i.products_id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<InventoryProductsDto> list = new ArrayList<>();
		while(rst.next()) {
			int quantityInStock = rst.getInt("quantity_in_stock");
			String productName = rst.getString("product_name");
			InventoryProductsDto obj = new InventoryProductsDto(quantityInStock, productName);
			list.add(obj);
		}
		DBConnection.dbClose();
		return list;		
	}

	@Override
	public int addToInventory(int id, int quantity) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE inventory SET quantity_in_stock=quantity_in_stock+? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, id);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public int removeFromInventory(int id, int quantity) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE inventory SET quantity_in_stock=quantity_in_stock-? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, id);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public int updateStockQuantity(int id, int value) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE inventory SET quantity_in_stock=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, value);
		pstmt.setInt(2, id);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public boolean isProductAvailable(int productId, int quantity) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * from inventory WHERE id=? AND quantity_in_stock>?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productId);
		pstmt.setInt(2, quantity);
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public List<InventoryValueDto> getInventoryValue() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT p.product_name, (p.price*i.quantity_in_stock) as inventory_value FROM inventory i JOIN products p ON p.id=i.products_id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<InventoryValueDto> list = new ArrayList<>();
		while(rst.next()) {
			String productName = rst.getString("product_name");
			int value = rst.getInt("inventory_value");
			InventoryValueDto detail = new InventoryValueDto(productName, value);
			list.add(detail);
		}
		DBConnection.dbClose();
		return list;	
		
	}

	@Override
	public List<InventoryProductsDto> lowStockProducts(int threshold) throws SQLException { // (int quantityInStock, String productName)
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT p.product_name, i.quantity_in_stock FROM inventory i JOIN products p ON p.id=i.products_id WHERE i.quantity_in_stock<?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, threshold);
		ResultSet rst = pstmt.executeQuery();
		List<InventoryProductsDto> list = new ArrayList<>();
		while(rst.next()) {
			int quantityInStock = rst.getInt("quantity_in_stock");
			String productName = rst.getString("product_name");
			InventoryProductsDto obj = new InventoryProductsDto(quantityInStock, productName);
			list.add(obj);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public List<InventoryProductsDto> outOfStockProducts() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT p.product_name, i.quantity_in_stock FROM inventory i JOIN products p ON p.id=i.products_id WHERE i.quantity_in_stock=0";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<InventoryProductsDto> list = new ArrayList<>();
		while(rst.next()) {
			int quantityInStock = rst.getInt("quantity_in_stock");
			String productName = rst.getString("product_name");
			InventoryProductsDto obj = new InventoryProductsDto(quantityInStock, productName);
			list.add(obj);
		}
		DBConnection.dbClose();
		return list;
	}

}

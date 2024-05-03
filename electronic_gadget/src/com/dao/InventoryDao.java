package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.InventoryProductsDto;
import com.dto.InventoryValueDto;
import com.model.Inventory;

public interface InventoryDao {
	List<Inventory> getAll() throws SQLException;
	List<InventoryProductsDto> getProductsByInventory() throws SQLException;
	List<InventoryProductsDto> productQuantityInStock() throws SQLException;
	int addToInventory(int id, int quantity) throws SQLException;
	int removeFromInventory(int id, int quantity) throws SQLException;
	int updateStockQuantity(int id, int value) throws SQLException;
	boolean isProductAvailable(int productId, int quantity) throws SQLException;
	List<InventoryValueDto> getInventoryValue() throws SQLException;
	List<InventoryProductsDto> lowStockProducts(int threshold) throws SQLException;
	List<InventoryProductsDto> outOfStockProducts() throws SQLException;
}

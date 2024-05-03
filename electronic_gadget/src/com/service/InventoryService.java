package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.InventoryDao;
import com.dao.InventoryDaoImpl;
import com.dto.InventoryProductsDto;
import com.dto.InventoryValueDto;
import com.model.Inventory;

public class InventoryService {
	InventoryDao dao = new InventoryDaoImpl();

	public List<InventoryProductsDto> getProducts() throws SQLException{
		return dao.getProductsByInventory();
	}

	public List<InventoryProductsDto> productQuantityInStock() throws SQLException {
		return dao.productQuantityInStock();
	}

	public List<Inventory> getAll() throws SQLException {
		return dao.getAll();
	}

	public int addToInventory(int id, int quantity) throws SQLException {
		return dao.addToInventory(id, quantity);
	}

	public int removeFromInventory(int id, int quantity) throws SQLException {
		return dao.removeFromInventory(id, quantity);
	}

	public int updateInventory(int id, int quantity) throws SQLException{
		return dao.updateStockQuantity(id, quantity);
	}

	public boolean isProductAvailable(int id, int quantity) throws SQLException {
		return dao.isProductAvailable(id, quantity);
	}

	public List<InventoryValueDto> getInventoryValue() throws SQLException {
		return dao.getInventoryValue();
	}

	public List<InventoryProductsDto> lowProductStock(int value) throws SQLException{
		return dao.lowStockProducts(value);
	}

	public List<InventoryProductsDto> outOfStock() throws SQLException{
		return dao.outOfStockProducts();
	}

}

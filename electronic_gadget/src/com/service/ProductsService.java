package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.dto.SellingQuantityDto;
import com.model.Products;

public class ProductsService {
	ProductDao dao = new ProductDaoImpl();

	public int insertProduct(Products p) throws SQLException {
		return dao.createProduct(p);
	}

	public List<Products> getAllProducts() throws SQLException {
		return dao.getAllProducts();
	}

	public int deleteProduct(int id) throws SQLException {
		return dao.deleteProduct(id);
	}

	public int updateProduct(int id, String productName, String description, double price) throws SQLException {
		return dao.updateProductInfo(id, productName, description, price);
	}

	public Products particularProduct(int id) throws SQLException {
		return dao.particularProduct(id); 
	}

	public boolean checkInStock(int id) throws SQLException {
		return dao.isProductInStock(id);
	}

	public List<SellingQuantityDto> productSellingQuantity() throws SQLException {
		return dao.sellingQuantity();
	}

}

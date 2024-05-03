package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.SellingQuantityDto;
import com.model.Products;

public interface ProductDao {
	int createProduct(Products product) throws SQLException;
    int deleteProduct(int productId) throws SQLException;
    int updateProductInfo(int productId, String productName, String description, double price) throws SQLException;
    Products particularProduct(int productId) throws SQLException;
    List<Products> getAllProducts() throws SQLException;
    boolean isProductInStock(int productId) throws SQLException;
    List<SellingQuantityDto> sellingQuantity() throws SQLException;

}

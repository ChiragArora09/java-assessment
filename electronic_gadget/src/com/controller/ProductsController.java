package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.SellingQuantityDto;
import com.model.Products;
import com.service.ProductsService;

public class ProductsController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductsService productService = new ProductsService();
		
		while(true) {
			System.out.println("------------Products Menu------------"); // MAIN MENU
			System.out.println("Press 1. Create a Product");
			System.out.println("Press 2. Delete a Product");
			System.out.println("Press 3. Update product info");
			System.out.println("Press 4. Particular Product");
			System.out.println("Press 5. All Products");
			System.out.println("Press 6. Is Product in Stock");
			System.out.println("Press 7. Product and selling quantity");
			System.out.println("Press 0. EXIT");
			
			int input = sc.nextInt();
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			case 1:
				try {
					System.out.println("Enter Product Name");
					sc.nextLine();
					String productName = sc.nextLine();
					System.out.println("Enter Product description");
					String description = sc.nextLine();
					System.out.println("Enter Price of Product");
					double price = sc.nextDouble();
					
					Products p = new Products(productName, description, price);
					int status = productService.insertProduct(p);
					if(status==1) {
						System.out.println("Product created successfully");
					}
					
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 2:
				try {
					List<Products> products = productService.getAllProducts();
					
					for(Products p : products) {
						System.out.println(p.toString());
					}
					
					System.out.println("Enter Product ID you want to delete...");
					int id = sc.nextInt();
					int status = productService.deleteProduct(id);
					if(status==1) {
						System.out.println("Product deleted successfully");
					}
					
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}

				break;
				
			case 3:
				try {
					List<Products> products = productService.getAllProducts();
					
					for(Products p : products) {
						System.out.println(p.toString());
					}
					System.out.println("Enter the ID of the product you want to update:");
					int id = sc.nextInt();
					System.out.println("Enter Product new name");
					sc.nextLine();
					String productName = sc.nextLine();
					System.out.println("Enter Product new description");
					String description = sc.nextLine();
					System.out.println("Enter new Price of Product");
					double price = sc.nextDouble();
					
					int status = productService.updateProduct(id, productName, description, price);
					if(status==1) {
						System.out.println("Product updated successfully");
					}
					
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				try {
					List<Products> products = productService.getAllProducts();
					
					for(Products p : products) {
						System.out.println(p.toString());
					}
					
					System.out.println("Enter the ID of the product you want to see:");
					int id = sc.nextInt();
					
					Products product = productService.particularProduct(id);
					
					System.out.println("ID: " + product.getId());
					System.out.println("NAME: " + product.getProductName());
					System.out.println("DESCRIPTION: " + product.getDescription());
					System.out.println("PRICE: " + product.getPrice());
					
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}

				break;
				
			case 5:
				try {
					List<Products> p = productService.getAllProducts();
					
					for(Products pro : p) {
						System.out.println(pro.toString());
					}
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 6:
				try {
					List<Products> p = productService.getAllProducts();
					
					for(Products pro : p) {
						System.out.println(pro.toString());
					}
					
					System.out.println("Enter the ID of the product you want to check:");
					int id = sc.nextInt();
					
					boolean inStock = productService.checkInStock(id);
					
					if(inStock) {
						System.out.println("Product is in stock");
					}else {
						System.out.println("Product is not in stock");
					}
					
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
				
				break;
			
			case 7:
				try {
					List<SellingQuantityDto> list = productService.productSellingQuantity();
					for(SellingQuantityDto p : list) {
						System.out.println(p.toString());
					}	
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
				break;
				
			default:
				System.out.println("Invalid Input");
				break;
			}			
		}						
	}
	public static void ProductsMenu() {
		String[] menu= {""};
		main(menu);
	}

}

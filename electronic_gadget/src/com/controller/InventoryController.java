package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.InventoryProductsDto;
import com.dto.InventoryValueDto;
import com.model.Inventory;
import com.service.InventoryService;

public class InventoryController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InventoryService inventoryService = new InventoryService();
		
		while(true) {
			System.out.println("----------Inventory Menu------------"); // MAIN MENU
			System.out.println("Press 1. Get Product");
			System.out.println("Press 2. Quantity in stock");
			System.out.println("Press 3. Add to inventory");
			System.out.println("Press 4. Remove from inventory");
			System.out.println("Press 5. Update Stock quantity");
			System.out.println("Press 6. Is product available");
			System.out.println("Press 7. Get inventory value");
			System.out.println("Press 8. Low stock products");
			System.out.println("Press 9. Out of stock");
			System.out.println("Press 0. EXIT");
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			case 1:
				try {
					List<InventoryProductsDto> list = inventoryService.getProducts();
					for(InventoryProductsDto l : list) {
						System.out.println(l.toString());
					}
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
	
				break;
				
			case 2:
				try {
					List<InventoryProductsDto> list = inventoryService.productQuantityInStock();
					
					for(InventoryProductsDto l : list) {
						System.out.println(l.toString());
					}
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				try {
					List<Inventory> l = inventoryService.getAll();
					
					for(Inventory i : l) {
						System.out.println(i.toString());
					}
					
					System.out.println("Please select inventory ID:");
					int id = sc.nextInt();
					System.out.println("Please select new quantity:");
					int quantity = sc.nextInt();
					
					int status = inventoryService.addToInventory(id, quantity);
					
					if(status == 1) {
						System.out.println("inventory updated");
					}
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				try {
					List<Inventory> l = inventoryService.getAll();
					
					for(Inventory i : l) {
						System.out.println(i.toString());
					}
					
					System.out.println("Please select inventory ID:");
					int id = sc.nextInt();
					System.out.println("Please select new quantity:");
					int quantity = sc.nextInt();
					
					int status = inventoryService.removeFromInventory(id, quantity);
					
					if(status == 1) {
						System.out.println("inventory updated");
					}
					
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 5:
				try {
					List<Inventory> l = inventoryService.getAll();
					
					for(Inventory i : l) {
						System.out.println(i.toString());
					}
					
					System.out.println("Please select inventory ID:");
					int id = sc.nextInt();
					System.out.println("Please select new quantity:");
					int quantity = sc.nextInt();
					
					int status = inventoryService.updateInventory(id, quantity);
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}				
				break;
				
			case 6:
				try {
					List<Inventory> l = inventoryService.getAll();
					
					for(Inventory i : l) {
						System.out.println(i.toString());
					}
					
					System.out.println("Please select inventory ID:");
					int id = sc.nextInt();
					System.out.println("Please select the minimum quantity:");
					int quantity = sc.nextInt();
					
					boolean status = inventoryService.isProductAvailable(id, quantity);
					
					if(status) {
						System.out.println("Yes available");
					}else {
						System.out.println("not available");
					}
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}				
				break;
				
			case 7:
				try {
					List<InventoryValueDto> list = inventoryService.getInventoryValue();
					
					for(InventoryValueDto l : list) {
						System.out.println(l.toString());
					}
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 8:
				try {
					System.out.println("Please enter the minimum value: ");
					int value = sc.nextInt();
					List<InventoryProductsDto> list = inventoryService.lowProductStock(value);
					
					for(InventoryProductsDto l : list) {
						System.out.println(l.toString());
					}
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}				
				break;
				
			case 9:
				try {
					List<InventoryProductsDto> list = inventoryService.outOfStock();
					
					for(InventoryProductsDto l : list) {
						System.out.println(l.toString());
					}
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}				
				break;
				
			default:
				System.out.println("Invalid Input");
				break;
			}			
		}

	}
	public static void InventoryMenu() {
		String[] menu= {""};
		main(menu);
	}

}

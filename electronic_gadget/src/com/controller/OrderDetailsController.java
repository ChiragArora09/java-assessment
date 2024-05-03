package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.OrderProductsDetailsDto;
import com.model.OrderDetails;
import com.service.OrderDetailsService;
import com.service.OrdersService;

public class OrderDetailsController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OrderDetailsService od = new OrderDetailsService();
		OrdersService orderService = new OrdersService();
	
		while(true) {
			System.out.println("----------Order Details Menu------------"); // MAIN MENU
			System.out.println("Press 1. All order details");
			System.out.println("Press 2. Calculate Sub total");
			System.out.println("Press 3. Get order detail Info");
			System.out.println("Press 4. Update Quantity");
			System.out.println("Press 5. Add Discount");
			System.out.println("Press 0. EXIT");
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			case 1:
				try {
					List<OrderDetails> list = od.getAllOrderDetails();
					
					for(OrderDetails orders : list) {
						System.out.println(orders.toString());
					}
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:
				try {
					List<OrderDetails> list = od.getAllOrderDetails();
					
					for(OrderDetails orders : list) {
						System.out.println(orders.toString());
					}
					
					System.out.println("Enter order details id:");
					int id = sc.nextInt();
					
					double subTotal = od.calculateSubtotal(id);
					
					System.out.println("Your subtotal for order id and the respective product of given product id in the mention quantity is: " + subTotal);
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				try {
					List<OrderDetails> list = od.getAllOrderDetails();
					
					for(OrderDetails orders : list) {
						System.out.println(orders.toString());
					}
					
					System.out.println("Enter the order ID respective to the order details id:");
					int id = sc.nextInt();
					
					OrderProductsDetailsDto info = orderService.getOrderdetails(id);
					
					System.out.println(info.toString());
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				try {
					List<OrderDetails> list = od.getAllOrderDetails();
					
					for(OrderDetails orders : list) {
						System.out.println(orders.toString());
					}
					
					System.out.println("Enter order detail id to update:");
					int id = sc.nextInt();
					
					System.out.println("Enter the new quantity value:");
					int value = sc.nextInt();
					
					int status = od.updateQuantity(id, value);
					
					if(status==1) {
						System.out.println("quantity updated");
					}
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 5:
				try {
					List<OrderDetails> list = od.getAllOrderDetails();
					
					for(OrderDetails orders : list) {
						System.out.println(orders.toString());
					}
					
					System.out.println("Enter order detail id to add discount:");
					int id = sc.nextInt();
					
					System.out.println("Enter the new discount value");
					double discount = sc.nextDouble();
					
					int status = od.addDiscount(id, discount);
					
					if(status==1) {
						System.out.println("discount added");
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
	public static void OrderDetailsMenu() {
		String[] menu= {""};
		main(menu);
	}

}

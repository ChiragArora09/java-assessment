package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.OrderProductsDetailsDto;
import com.model.Orders;
import com.service.OrdersService;

public class OrdersController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OrdersService orderService = new OrdersService();
		
		while(true) {
			System.out.println("----------Orders Menu------------");
			System.out.println("Press 1. All orders");
			System.out.println("Press 2. Total amount");
			System.out.println("Press 3. Order Details");
			System.out.println("Press 4. Update order Status");
			System.out.println("Press 5. Cancel Order");
			System.out.println("Press 0. EXIT");
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			case 1:
				try {
					List<Orders> list = orderService.getAllOrders();
					
					for(Orders order : list) {
						System.out.println(order.toString());
					}
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:
				try {
					double totalAmounts = orderService.getTotalAmount();
					System.out.println("Total amount of all the orders is: " + totalAmounts);
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}

				break;
				
			case 3:
				try {
					List<Orders> list = orderService.getAllOrders();
					
					for(Orders order : list) {
						System.out.println(order.toString());
					}
					
					System.out.println("SELECT ID from orders: ");
					int id = sc.nextInt();
					OrderProductsDetailsDto details = orderService.getOrderdetails(id);
					System.out.println(details.toString());
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}

				break;
				
			case 4:
				try {
					List<Orders> list = orderService.getAllOrders();
					
					for(Orders order : list) {
						System.out.println(order.toString());
					}
					
					System.out.println("SELECT ID from orders where you want to change the status: ");
					int id = sc.nextInt();
					
					System.out.println("Type the new status (delivered, shipped, completed)");
					sc.nextLine();
					String status1 = sc.nextLine();
					
					int status = orderService.updateOrderStatus(id, status1);
					
					if(status == 1) {
						System.out.println("Status changed successfully");
					}
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 5: 
				try {
					List<Orders> list = orderService.getAllOrders();
					
					for(Orders order : list) {
						System.out.println(order.toString());
					}
					
					System.out.println("SELECT ID from orders where you want to change the status: ");
					int id = sc.nextInt();
					
					int status = orderService.cancelOrder(id);
					
					if(status == 1) {
						System.out.println("order cancelled");
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
	public static void OrdersMenu() {
		String[] menu= {""};
		main(menu);
	}

}

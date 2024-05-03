package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.ResourceNotFoundException;
import com.model.Customers;
import com.service.CustomerService;

public class CustomerController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		
		while(true) {
			System.out.println("----------Customer Menu------------"); // MAIN MENU
			System.out.println("Press 1. Insert a Customer");
			System.out.println("Press 2. Update a customer");
			System.out.println("Press 3. Delete a customer");
			System.out.println("Press 4. Particular Customer");
			System.out.println("Press 5. Get all customer");
			System.out.println("Press 6. Calculate total orders of a particular customer");
			System.out.println("Press 0. EXIT");
			
			int input = sc.nextInt(); 
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			case 1:
				try {
					System.out.println("Enter First Name of Customer");
					sc.nextLine();
					String firstName = sc.nextLine();
					System.out.println("Enter Last Name of Customer");
					String lastName = sc.nextLine();
					System.out.println("Enter Email address of Customer");
					String email = sc.nextLine();
					System.out.println("Enter Phone Number of Customer");
					String phoneNumber = sc.nextLine();
					System.out.println("Enter Address of Customer");
					String address = sc.nextLine();
					
					Customers customer = new Customers(firstName, lastName, email, phoneNumber, address);
					int status = customerService.insertCustomer(customer);
					if(status==1) {
						System.out.println("Customer inserted successfully");
					}
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
	
				break;
				
			case 2:
				try {
					List<Customers> list = customerService.getAllCustomer();
					for(Customers c : list) {
						System.out.println(c.toString());
					}
					
					System.out.println("Enter customer ID: ");
					int id = sc.nextInt();
					System.out.println("Enter new email address: ");
					sc.nextLine();
					String email = sc.nextLine();
					System.out.println("Enter new phone number: ");
					String phoneNumber = sc.nextLine();
					System.out.println("Enter new address: ");
					String address = sc.nextLine();
					
					int status = customerService.updateCustomer(id, email, phoneNumber, address);
					
					if(status == 1) {
						System.out.println("Customer updated successfully");
					}
					
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				try {
					List<Customers> list = customerService.getAllCustomer();
					for(Customers c : list) {
						System.out.println(c.toString());
					}
					System.out.println("Enter customer ID you want to delete");
					int id = sc.nextInt();
					
					int status = customerService.deleteCustomer(id);
					if(status == 1) {
						System.out.println("Customer deleted successfully");
					}
					
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}

				break;
				
			case 4:
				try {
					List<Customers> list = customerService.getAllCustomer();
					for(Customers c : list) {
						System.out.println(c.toString());
					}
					System.out.println("Enter customer ID you want to see");
					int id = sc.nextInt();
					
					Customers customer = customerService.getParticularCustomer(id);
					System.out.println("ID: " + customer.getId());
					System.out.println("First Name: " + customer.getFirstName());
					System.out.println("Last Name: " + customer.getLastName());
					System.out.println("Email: " + customer.getEmail());
					System.out.println("Address: " + customer.getAddress());
					System.out.println("Phone: " + customer.getPhoneNumber());
					
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}catch(ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}

				break;
				
			case 5:
				try {
					List<Customers> list = customerService.getAllCustomer();
					for(Customers c : list) {
						System.out.println(c.toString());
					}
					
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 6:
				try {
					List<Customers> list = customerService.getAllCustomer();
					for(Customers c : list) {
						System.out.println(c.toString());
					}
					System.out.println("Enter customer ID you want to see total orders from...");
					int id = sc.nextInt();
					
					int orders = customerService.getTotalOrders(id);
					System.out.println("Total orders are: " + orders);
					
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
	public static void customerMenu() {
		String[] menu= {""};
		main(menu);
	}

}

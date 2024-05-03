package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.exception.ResourceNotFoundException;
import com.model.Customers;
import com.service.CustomerService;

public class CustomerServiceTest {
	CustomerService customerService = new CustomerService();
	
   @Test
	public void TestInsert() throws SQLException {
	   Customers customer = new Customers("Chirag", "Arora","chirag@gmail.com","8345389","Bhopal");
       int result = customerService.insertCustomer(customer);
       assertEquals(1, result);
   }
   
   @Test
   public void testUpdateCustomerInfo() throws SQLException, ResourceNotFoundException {
       int customerId = 1; 
       String updatedEmail = "chiragarora@email.com";
       String updatedPhoneNumber = "23842984893";
       String updatedAddress = "New Delhi";

       // Execution: Update customer information
       customerService.updateCustomer(customerId, updatedEmail, updatedPhoneNumber, updatedAddress);

       Customers updatedCustomer = customerService.getParticularCustomer(customerId);
       assertEquals(updatedEmail, updatedCustomer.getEmail());
       assertEquals(updatedPhoneNumber, updatedCustomer.getPhoneNumber());
       assertEquals(updatedAddress, updatedCustomer.getAddress());
   }
   
   @Test
   public void testGetAllCustomers() throws SQLException {
       List<Customers> customers = customerService.getAllCustomer();
       assertEquals(9, customers.size());
   }
}
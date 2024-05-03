package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.ResourceNotFoundException;
import com.model.Customers;

public interface CustomerDao {
    int insertCustomer(Customers customer) throws SQLException;
    int updateCustomer(int customerId, String email, String phoneNumber, String address) throws SQLException;
    int deleteCustomer(int customerId) throws SQLException;
    Customers getParticularCustomer(int customerId) throws SQLException, ResourceNotFoundException;
    List<Customers> getAllCustomers() throws SQLException;
    int calculateTotalOrders(int customerID) throws SQLException;
}

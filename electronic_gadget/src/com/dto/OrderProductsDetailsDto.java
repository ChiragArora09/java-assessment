package com.dto;

public class OrderProductsDetailsDto {
	private int orderId;
	private String productName;
	private int quantity;
	private double totalAmount;
	private double price;
	
	public OrderProductsDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderProductsDetailsDto(int orderId, String productName, int quantity, double totalAmount, double price) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderProductsDetailsDto [orderId=" + orderId + ", productName=" + productName + ", quantity=" + quantity
				+ ", totalAmount=" + totalAmount + ", price=" + price + "]";
	}
	
}

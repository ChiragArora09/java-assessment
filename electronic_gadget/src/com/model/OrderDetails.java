package com.model;

public class OrderDetails {
	private int id;
	private int orderId;
	private int productId;
	private int quantity;
	private double discount;
	
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetails(int id, int orderId, int productId, int quantity, double discount) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.discount = discount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity
				+ ", discount=" + discount + "]";
	}	

}

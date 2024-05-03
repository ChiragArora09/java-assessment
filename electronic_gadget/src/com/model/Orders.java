package com.model;

public class Orders {
	private int id;
	private String orderDate;
	private double totalAmount;
	private int customerId;
	private String status;
	
	public Orders(int id, String orderDate, double totalAmount, int customerId, String status) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.customerId = customerId;
		this.status = status;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", customerId="
				+ customerId + ", status=" + status + "]";
	}

}

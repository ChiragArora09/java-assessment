package com.model;

public class Inventory {
	private int id;
	private int quantityInStock;
	private String lastStockUpdate;
	private int productId;
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(int id, int quantityInStock, String lastStockUpdate, int productId) {
		super();
		this.id = id;
		this.quantityInStock = quantityInStock;
		this.lastStockUpdate = lastStockUpdate;
		this.productId = productId;
	}

	public Inventory(int quantityInStock, String lastStockUpdate, int productId) {
		super();
		this.quantityInStock = quantityInStock;
		this.lastStockUpdate = lastStockUpdate;
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getLastStockUpdate() {
		return lastStockUpdate;
	}

	public void setLastStockUpdate(String lastStockUpdate) {
		this.lastStockUpdate = lastStockUpdate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", quantityInStock=" + quantityInStock + ", lastStockUpdate=" + lastStockUpdate
				+ ", productId=" + productId + "]";
	}
	
}

package com.dto;

public class InventoryProductsDto {
	 private int id;
	 private int quantityInStock;
	 private String lastStockUpdate;
	 private int productId;
	 private String productName;
	 private String description;
	 private double price;
	
	 public InventoryProductsDto() {
		super();
		// TODO Auto-generated constructor stub
	 }

	public InventoryProductsDto(int id, int quantityInStock, String lastStockUpdate, int productId, String productName,
			String description, double price) {
		super();
		this.id = id;
		this.quantityInStock = quantityInStock;
		this.lastStockUpdate = lastStockUpdate;
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
	}

	public InventoryProductsDto(int quantityInStock, String productName) {
		super();
		this.quantityInStock = quantityInStock;
		this.productName = productName;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "InventoryProductsDto [id=" + id + ", quantityInStock=" + quantityInStock + ", lastStockUpdate="
				+ lastStockUpdate + ", productId=" + productId + ", productName=" + productName + ", description="
				+ description + ", price=" + price + "]";
	}
	 
	 
	 
	 

}

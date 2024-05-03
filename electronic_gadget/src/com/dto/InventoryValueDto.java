package com.dto;

public class InventoryValueDto {
	private String productName;
	private int inventoryValue;
	
	public InventoryValueDto(String productName, int inventoryValue) {
		super();
		this.productName = productName;
		this.inventoryValue = inventoryValue;
	}
	
	public InventoryValueDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getInventoryValue() {
		return inventoryValue;
	}
	public void setInventoryValue(int inventoryValue) {
		this.inventoryValue = inventoryValue;
	}
	
	@Override
	public String toString() {
		return "InventoryValueDto [productName=" + productName + ", inventoryValue=" + inventoryValue + "]";
	}
	

}

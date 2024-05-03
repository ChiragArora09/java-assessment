package com.dto;

public class SellingQuantityDto {
	private String productName;
	private int totalQuantity;
	
	public SellingQuantityDto(String productName, int totalQuantity) {
		super();
		this.productName = productName;
		this.totalQuantity = totalQuantity;
	}

	public SellingQuantityDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	@Override
	public String toString() {
		return "SellingQuantityDto [productName=" + productName + ", totalQuantity=" + totalQuantity + "]";
	}

}

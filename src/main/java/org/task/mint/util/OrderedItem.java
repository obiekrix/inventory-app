package org.task.mint.util;

import java.math.BigDecimal;

public class OrderedItem {

	private int productId;
	private int quantity;
	private BigDecimal soldPrice;

	public OrderedItem() {
		
	}
	
	/**
	 * @param productId
	 * @param quantity
	 * @param soldPrice
	 */
	public OrderedItem(int productId, int quantity, BigDecimal soldPrice) {
		this.productId = productId;
		this.quantity = quantity;
		this.soldPrice = soldPrice;
	}

	public int getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getSoldPrice() {
		return soldPrice;
	}

	@Override
	public String toString() {
		return "OrderedItem [productId=" + productId + ", quantity=" + quantity + ", soldPrice=" + soldPrice + "]";
	}

}

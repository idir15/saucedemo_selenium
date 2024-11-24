package com.logwire.model;

public record InventoryItem(String itemName, String itemPrice, String itemDescription, String itemQuantity) {

	public InventoryItem(String itemName, String itemPrice, String itemDescription) {
		this(itemName, itemPrice, itemDescription, "1");
	}

}

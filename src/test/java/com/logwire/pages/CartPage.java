package com.logwire.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.logwire.model.InventoryItem;

public class CartPage {

	@FindBy(className = "cart_item")
	private List<WebElement> cartItems;

	private final WebDriver webDriver;

	public CartPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public InventoryItem getFirstCartItem() {
		InventoryItem item = cartItems.stream().findFirst().map(this::mapToItem).orElse(null);
		return item;
	}

	private InventoryItem mapToItem(WebElement element) {
		String cartItemDescription = element.findElement(By.className("inventory_item_desc")).getText();
		String cartItemName = element.findElement(By.className("inventory_item_name")).getText();
		String cartItemQuantity = element.findElement(By.className("cart_quantity")).getText();
		String cartItemPrice = element.findElement(By.className("inventory_item_price")).getText();
		InventoryItem item = new InventoryItem(cartItemName, cartItemPrice, cartItemDescription, cartItemQuantity);
		return item;
	}
}

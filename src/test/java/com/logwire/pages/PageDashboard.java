package com.logwire.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.logwire.model.InventoryItem;

public class PageDashboard {
	
	@FindBy(className = "title")
	private WebElement successLoginText;

	@FindBy(className = "inventory_item")
	private List<WebElement> inventoryItems;

	@FindBy(css = "a.shopping_cart_link")
	private WebElement cartButton;

	private final WebDriver webDriver;

	public PageDashboard(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public boolean isLoggedIn() {
		final WebDriverWait waiter = new WebDriverWait(webDriver, Duration.ofSeconds(1));

		waiter.until(ExpectedConditions.visibilityOf(successLoginText));
		System.out.println(successLoginText.getText());
		return successLoginText.isDisplayed();
	}

	public void clickOnCartButton() {
		cartButton.click();
	}

	private void clickToInventoryItemAddButton(WebElement inventoryElement) {
		inventoryElement.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	}

	public InventoryItem addFirstItemToCart() {
		InventoryItem item = inventoryItems.stream().peek(this::clickToInventoryItemAddButton).findFirst()
				.map(this::mapToItem).orElse(null);
		return item;
	}

	private InventoryItem mapToItem(WebElement element) {
		String inventoryItemName = element.findElement(By.className("inventory_item_name")).getText();
		String inventoryItemDescription = element.findElement(By.className("inventory_item_desc")).getText();
		String inventoryItemPrice = element.findElement(By.className("inventory_item_price")).getText();
		InventoryItem item = new InventoryItem(inventoryItemName, inventoryItemPrice, inventoryItemDescription);
		return item;
	}
}

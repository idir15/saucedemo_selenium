package com.logwire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.logwire.model.InventoryItem;
import com.logwire.pages.CartPage;
import com.logwire.pages.PageDashboard;
import com.logwire.pages.SauceDemoLoginPage;
import com.logwire.utils.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addToCartStepDefinition {

	private WebDriver webDriver;
	private PageDashboard pageDashboard;
	private CartPage cartPage;
	private InventoryItem itemData;
	private SauceDemoLoginPage sauceDemoLoginPage;

	public addToCartStepDefinition() {
		webDriver = DriverFactory.getWebDriver();
		sauceDemoLoginPage = new SauceDemoLoginPage(webDriver);
		pageDashboard = new PageDashboard(webDriver);
		cartPage = new CartPage(webDriver);
	}
	
	@Given("I am on the webpage {string}")
	public void anExampleScenario(String url) {
		webDriver.get(url);
	}

	@When("I enter my username {string} and I enter my password {string} and click on the login button")
	public void i_enter_my_username_and_i_enter_my_password_and_click_on_the_login_button(String username,
			String password) {
		sauceDemoLoginPage.login(username, password);
	}

	@Then("I am logged in to my account")
	public void login() {
		pageDashboard = new PageDashboard(webDriver);
		boolean isLoggedIn = pageDashboard.isLoggedIn();
		assertTrue(isLoggedIn);
	}

	@When("I click on add to cart on the first item in the list")
	public void clickonItemAddButton() {
		itemData = pageDashboard.addFirstItemToCart();
	}

	@When("I click on the cart button")
	public void clickOnCart() {
		pageDashboard.clickOnCartButton();	
	}

	@Then("the cart should containt the selected item")
	public void itemCompare() {
		InventoryItem cartItem = cartPage.getFirstCartItem();
		assertEquals(cartItem,itemData);
	}

}


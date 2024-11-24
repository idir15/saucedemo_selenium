package com.logwire.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoLoginPage {

	@FindBy(id = "user-name")
	private WebElement usernameInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(className = "title")
	private WebElement succesLoginText;

	@FindBy(className = "error-button")
	private WebElement errorMessage;

	private final WebDriver webDriver;

	public SauceDemoLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	private void enterUserName(String username) {
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}

	private void enterPassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	private void clickLoginButton() {
		loginButton.click();
	}

	public void login(String username, String password) {

		final WebDriverWait waiter = new WebDriverWait(webDriver, Duration.ofSeconds(5));

		waiter.until(ExpectedConditions.visibilityOf(usernameInput));
		enterUserName(username);
		enterPassword(password);
		clickLoginButton();

	}

	public boolean isFailedLogin() {
		final WebDriverWait waiter = new WebDriverWait(webDriver, Duration.ofSeconds(5));

		waiter.until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.isDisplayed();
	}

}

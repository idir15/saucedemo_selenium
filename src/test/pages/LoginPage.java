package com.logwire.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
   
   
    WebDriver driver;
    private WebDriverWait wait;

  

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button') and contains(@class, 'orangehrm-login-button') and text()=' Login ']")
    private WebElement Button;

    // @FindBy(css = "span[data-test='title']")
    // private WebElement produittitre;

    // @FindBy(id = "add-to-cart-sauce-labs-backpack")
    // private WebElement addToCartButton;

    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    public void saisirUserName(String username) {
       
        this.usernameField.clear();
        this.usernameField.sendKeys(username);
    }   

    public void saisirPassword(String password) {
       
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(Button));
        Button.click();
    }

    // public void clickAddToCartButton() {

    //     addToCartButton.click();
    // }


   

}

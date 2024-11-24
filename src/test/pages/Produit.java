package com.logwire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Produit {

    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#header_container > div.primary_header > div.header_label > div")
    private WebElement swagLabs;

    @FindBy(id = "back-to-products")
    private WebElement boutonBackHome;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement buttonAjout;

    public Produit(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        PageFactory.initElements(driver, this);
    }

   
    public boolean verifySwaLabs() {
        wait.until(ExpectedConditions.visibilityOf(swagLabs));
        return swagLabs.isDisplayed(); 
    }

    public void boutonAjout() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonAjout)); 
        buttonAjout.click();
    }

    
    public void cliquesBoutonBackHome() {
        wait.until(ExpectedConditions.elementToBeClickable(boutonBackHome)); 
        boutonBackHome.click(); 
    }
}

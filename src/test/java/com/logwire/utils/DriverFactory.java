package com.logwire.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static WebDriver webDriver;

	public static WebDriver getWebDriver() {
		if (webDriver == null) {
			defineWebDriver();
		}
		return webDriver;
	}

	public static void quitDriver() {
		if (webDriver != null) {
			webDriver.quit();
			webDriver = null;
		}
	}

	private static void defineWebDriver() {

		String chosenWebDriver = System.getProperty("driver", "dafault").toLowerCase();
		System.out.println(chosenWebDriver);
		webDriver = switch (chosenWebDriver) {
		case "chrome" -> {
			WebDriverManager.chromedriver().setup();
			yield new ChromeDriver();
		}
		case "firefox" -> {
			WebDriverManager.firefoxdriver().setup();
			yield new FirefoxDriver();
		}
		case "edge" -> {
			WebDriverManager.edgedriver().setup();
			yield new EdgeDriver();
		}
		default -> {
			WebDriverManager.chromedriver().setup();
			yield new ChromeDriver();
		}
		};
	}
}

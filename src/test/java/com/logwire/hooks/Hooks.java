package com.logwire.hooks;

import com.logwire.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	  @Before
	    public void setUp() {
	        // Get a new instance before each scenario
		  DriverFactory.getWebDriver();
	    }

	    @After
	    public void tearDown() {
	        // Close webDriver after each scenario
	    	DriverFactory.quitDriver();
	    }
}

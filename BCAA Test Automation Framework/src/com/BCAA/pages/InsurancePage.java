package com.BCAA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BCAA.executor.BrowserFactory;

public class InsurancePage {
	private WebDriver driver;
	BrowserFactory browserFactory = new BrowserFactory();
	
	/**
	 * 
	 * @param locDriver
	 */
	
	public InsurancePage(WebDriver locDriver){		
		this.driver=locDriver;
	}
	
	By quotesAndPolicies = By.linkText("Quotes and Policies");
	
	/**
	 * Navigating to Quotes and Policies tab
	 */
	
	public void quotesAndPoliciesTab(){
			driver = browserFactory.selectModule(driver, quotesAndPolicies);
	}
	
	


}

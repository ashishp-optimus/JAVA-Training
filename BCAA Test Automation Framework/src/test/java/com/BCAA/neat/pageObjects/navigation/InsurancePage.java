package com.BCAA.neat.pageObjects.navigation;

import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.executor.Browser;

/**
 * @author Optimus
 */
public class InsurancePage {

	Browser browser = new Browser();

	private By quotesAndPolicies = By.linkText("Quotes and Policies");

	Button selectQuotesAndPolicies = new Button(quotesAndPolicies);

	/**
	 * Navigating to Quotes and Policies tab
	 */

	public void navigateToQuotesAndPoliciesTab() {
		selectQuotesAndPolicies.click();

	}

}

package com.BCAA.neat.pageObjects.navigation;

import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * @author Optimus
 */
public class InsurancePage {

	Browser browser = new Browser();

	By quotesAndPolicies = By.linkText("Quotes and Policies");
	PageElement selectQuotesAndPolicies = new PageElement(quotesAndPolicies,null,InputType.BUTTON);

	/**
	 * Navigating to Quotes and Policies tab
	 */

	public void quotesAndPoliciesTab() {
		browser.setElement(selectQuotesAndPolicies);

	}

}

package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

public class OptionsTabPage {

	Logger logger = Logger.getLogger(OptionsTabPage.class);
	Browser browser = new Browser();

	private final String DEFAULT_POLICY_MESSAGE = "The selected policy option cannot be removed from the policy since it is included with the product plan.";
	private final String VALUE = "value";
	private static final String DELETING_OPTION = "Deleting policy option, please wait...";

	By optionsTabId = By.id("OptionsTab");
	By verifyOptionsButtonId = By.id("btnOptionsTabVerifyOptionsId");
	By addEditDeleteOptionsXpath = By.xpath("//*[@id='OptionsTabPanel']/div[1]/span[2]/input");
	By policyRecordId = By.id("productOptionActive_1_1");
	By policyOptionsXpath = By.xpath(".//td[contains(@class,'policyOptionTitle')]");
	By annualPremiumAmountId = By.id("text_annualPremiumAmount");
	By removeButtonId = By.id("removeButton");
	By returnPolicyButtonId = By.id("returnToPolicyButton");
	By deletingPolicyOptionBoxId = By.id("wait");
	By productOptionActive = By.xpath("//tr[contains(@id,'productOptionActive')]/following-sibling::tr/child::td[5]");

	PageElement optionsTab = new PageElement(optionsTabId, null, InputType.BUTTON);
	PageElement verifyOptionsButton = new PageElement(verifyOptionsButtonId, null, InputType.BUTTON);
	PageElement addEditDeleteOptions = new PageElement(addEditDeleteOptionsXpath, null, InputType.BUTTON);
	PageElement policyRecord = new PageElement(policyRecordId, null, InputType.BUTTON);
	PageElement removeButton = new PageElement(removeButtonId, null, InputType.BUTTON);
	PageElement returnPolicyButton = new PageElement(returnPolicyButtonId, null, InputType.BUTTON);
	PageElement annualPremiumAmount = new PageElement(annualPremiumAmountId, VALUE);
	PageElement policyOptions = new PageElement(policyOptionsXpath, VALUE);
	PageElement deletingPolicyOptionBox = new PageElement(deletingPolicyOptionBoxId, DELETING_OPTION);
	PageElement activePolicyOptions = new PageElement(productOptionActive, null);
	
	public void navigateToOptionsTab() {
		logger.info("Inside navigateToOptionsTab method in OptionsTabPage Class");
		browser.setElement(optionsTab);
	}

	/**
	 * 
	 * To verify the options with blank premium are removed
	 * 
	 * @param option
	 *            Locator of the options list
	 */

	public void removePolicyWithNoPremium(PageElement option) {
		logger.info("Inside removePolicyWithNoPremium method in OptionsTabPage Class");
		int i = 0;
		while (Browser.driver.findElements(option.getLocatorType()).size() != i) {
			Browser.driver.findElements(option.getLocatorType()).get(i).click();
			PageElement optionValue = browser.getTextByAttribute(annualPremiumAmount);
			String premiumAmount = optionValue.getOutValue().toString();
			if (org.apache.commons.lang3.StringUtils.isBlank(premiumAmount)) {
				browser.setElement(removeButton);
				browser.acceptAlertButton();
				browser.waitForInvisibility(deletingPolicyOptionBox);
				if (Browser.driver.getPageSource().contains(DEFAULT_POLICY_MESSAGE)) {
					i++;
				}
			} else {
				i++;
			}
		}
		browser.setElement(returnPolicyButton);

	}

	/**
	 * To verify options for a policy
	 * 
	 */

	public void verifyOptions() {
		logger.info("Inside verifyOptions method in OptionsTabPage Class");
		navigateToOptionsTab();
		browser.setElement(verifyOptionsButton);
		browser.setElement(policyRecord);
		browser.setElement(addEditDeleteOptions);
		removePolicyWithNoPremium(policyOptions);
		navigateToOptionsTab();
	}
	
	public void verifyPremiums() {
		logger.info("Inside verifyPremiums method in OptionsTabPage Class");
		browser.verifyPremium(activePolicyOptions);
		
	}

}

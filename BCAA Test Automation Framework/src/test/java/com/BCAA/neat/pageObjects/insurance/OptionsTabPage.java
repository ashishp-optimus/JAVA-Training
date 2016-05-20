package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

public class OptionsTabPage {

	Logger logger = Logger.getLogger(OptionsTabPage.class);
	Browser browser = new Browser();

	private final static String DEFAULT_POLICY_MESSAGE = "The selected policy option cannot be removed from the policy since it is included with the product plan.";
	private final static String VALUE = "value";
	private final static String DELETING_OPTION = "Deleting policy option, please wait...";

	
	private By verifyOptionsBtnId = By.id("btnOptionsTabVerifyOptionsId");
	private By addEditDeleteOptionsBtnXpath = By.xpath("//*[@id='OptionsTabPanel']/div[1]/span[2]/input");
	private By policyRecordBtnId = By.id("productOptionActive_1_1");
	private By policyOptionsXpath = By.xpath(".//td[contains(@class,'policyOptionTitle')]");
	private By annualPremiumAmountId = By.id("text_annualPremiumAmount");
	private By removeBtnId = By.id("removeButton");
	private By returnPolicyBtnId = By.id("returnToPolicyButton");
	private By deletingPolicyOptionBoxId = By.id("wait");
	private By productOptionActive = By
			.xpath("//tr[contains(@id,'productOptionActive')]/following-sibling::tr/child::td[5]");

	
	Button verifyOptionsButton = new Button(verifyOptionsBtnId);
	Button addEditDeleteOptions = new Button(addEditDeleteOptionsBtnXpath);
	Button policyRecord = new Button(policyRecordBtnId);
	Button removeButton = new Button(removeBtnId);
	Button returnPolicyButton = new Button(returnPolicyBtnId);

	PageElement annualPremiumAmount = new PageElement(annualPremiumAmountId, VALUE);
	PageElement policyOptions = new PageElement(policyOptionsXpath, VALUE);
	PageElement deletingPolicyOptionBox = new PageElement(deletingPolicyOptionBoxId, DELETING_OPTION);
	PageElement activePolicyOptions = new PageElement(productOptionActive);


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
				removeButton.click();
				browser.acceptAlertButton();
				browser.waitForInvisibilityOfText(deletingPolicyOptionBox);
				if (Browser.driver.getPageSource().contains(DEFAULT_POLICY_MESSAGE)) {
					i++;
				}
			} else {
				i++;
			}
		}
		returnPolicyButton.click();

	}

	/**
	 * To verify options for a policy
	 * 
	 */

	public void verifyOptions() {
		logger.info("Inside verifyOptions method in OptionsTabPage Class");

		//navigateToOptionsTab();

		verifyOptionsButton.click();
		policyRecord.click();
		addEditDeleteOptions.click();

		removePolicyWithNoPremium(policyOptions);
		//navigateToOptionsTab();
	}

	public void verifyPremiums() {
		logger.info("Inside verifyPremiums method in OptionsTabPage Class");

		browser.waitForInvisibilityOfElement(activePolicyOptions);

	}

}

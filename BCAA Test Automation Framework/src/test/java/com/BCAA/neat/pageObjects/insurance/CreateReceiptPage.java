package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

/**
 * This class is for Create Receipts page
 * 
 * @author Optimus
 */

public class CreateReceiptPage {
	Logger logger = Logger.getLogger(CreateReceiptPage.class);

	private final static String VALUE = "value";

	private By createNewReceiptBtnId = By.id("btnCreateReceiptCreateNewReceiptId");
	private By policyNumTextboxCss = By.cssSelector(".readonlyField");
	private By openPaymentPlanBtnId = By.id("btnCreateReceiptOpenAPaymentPlanId");

	Button createNewReceiptBtn = new Button(createNewReceiptBtnId);
	Button openPaymentPlanBtn = new Button(openPaymentPlanBtnId);

	PageElement getActivePolicyNumTextbox = new PageElement(policyNumTextboxCss, VALUE);

	public void selectCreateReceipt() {
		logger.info("Inside selectCreateReceipt method in Create Receipt page class");

		createNewReceiptBtn.click();
	}

	public void selectOpenPaymentPlan() {
		logger.info("Inside selectOpenPaymentPlan method in Create Receipt page class");

		openPaymentPlanBtn.click();
	}

	/**
	 * To retrieve the active policy number
	 * 
	 * @return Policy Number
	 */
	public PageElement getActivePolicyNum() {
		logger.info("Inside getActivePolicyNum method in Create Receipt page class");

		Browser browser = new Browser();

		PageElement pageElementObj = browser.getTextByAttribute(getActivePolicyNumTextbox);
		return pageElementObj;
	}

}

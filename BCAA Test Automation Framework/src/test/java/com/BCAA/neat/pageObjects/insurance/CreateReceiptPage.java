package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * This class is for Create Receipts page
 * 
 * @author Optimus
 */

public class CreateReceiptPage {
	Logger logger = Logger.getLogger(CreateReceiptPage.class);

	private final String VALUE = "value";

	By createNewReceiptBtnId = By.id("btnCreateReceiptCreateNewReceiptId");
	By policyNumTextboxCss = By.cssSelector(".readonlyField");
	By openPaymentPlanBtnId = By.id("btnCreateReceiptOpenAPaymentPlanId");

	PageElement createNewReceiptBtn = new PageElement(createNewReceiptBtnId, null, InputType.BUTTON);
	PageElement getActivePolicyNumTextbox = new PageElement(policyNumTextboxCss, VALUE);
	PageElement openPaymentPlanBtn = new PageElement(openPaymentPlanBtnId, null, InputType.BUTTON);

	public void selectCreateReceipt() {
		logger.info("Inside selectCreateReceipt method in Create Receipt page class");

		Button button = new Button();
		button.click(createNewReceiptBtn);
	}

	public void selectOpenPaymentPlan() {
		logger.info("Inside selectOpenPaymentPlan method in Create Receipt page class");

		Button button = new Button();
		button.click(openPaymentPlanBtn);
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

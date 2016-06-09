package com.BCAA.neat.pageObjects.insurance;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;

/**
 * This class is for Create Receipts page
 * 
 * @author Optimus
 */

public class CreateReceiptPage {
	Logger logger;
	Browser browser;

	public CreateReceiptPage() {
		logger = Logger.getLogger(CreateReceiptPage.class);
		browser = new Browser();
	}

	private final static String VALUE = "value";
	private final static String CREATE_RECEIPT = "Create Receipt";

	private By createNewReceiptBtnId = By.id("btnCreateReceiptCreateNewReceiptId");
	private By policyNumTextboxCss = By.cssSelector(".readonlyField");
	private By openPaymentPlanBtnId = By.id("btnCreateReceiptOpenAPaymentPlanId");
	private By createReceiptHeader = By.xpath("//div[@id='export_sale_to_pos']/h2");
	private By cancelBtnId = By.id("btnCreateReceiptCancelId");

	private Button createNewReceiptBtn = new Button(createNewReceiptBtnId);
	private Button openPaymentPlanBtn = new Button(openPaymentPlanBtnId);
	private Button cancelBtn = new Button(cancelBtnId);

	private TextBox getActivePolicyNumTextbox = new TextBox(policyNumTextboxCss, VALUE);	
	private TextBox verifyCreateReceiptHeader = new TextBox(createReceiptHeader, CREATE_RECEIPT);	
	private TextBox createReceiptHeaderText = new TextBox(createReceiptHeader);


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
	public TextBox getActivePolicyNum() {
		logger.info("Inside getActivePolicyNum method in Create Receipt page class");

		TextBox activePolicyNumber = getActivePolicyNumTextbox.getTextByAttribute();
		return activePolicyNumber;
	}

	/**
	 * 
	 */
	public void verifyCreateReceiptHeader() {
		logger.info("Inside verifyCreateReceiptHeader method in Create Receipt page class");

		createReceiptHeaderText.waitUntilMsgBoxIsDisplayed();
		verifyCreateReceiptHeader.verifyText();
	}

	public void clickOnCancelButton() {
		logger.info("Inside clickOnCancelButton method in EditQuotesOrPolicyPage Class");

		cancelBtn.click();
	}

}

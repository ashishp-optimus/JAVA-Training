package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

public class InsuranceQuotePolicy {
	Logger logger = Logger.getLogger(EditQuotesOrPolicyPage.class);

	private final static String CANCEL_POLICY = "Cancel Policy";
	private final static String DUPLICATE = "Duplicate Policy";
	private final static String NOTE_DATA = "Duplicate Policy - No Notes Required";
	private final static String VALUE = "value";
	private final static String CANCELLATION_REQUEST = "Print a cancellation request form";
	private final static String REFUND_CHEQUE = "Request a refund cheque";
	private final static String VOID_POLICY_HEADER = "Void Policy";
	private final static String YES = "Yes";

	private By cancelPolicyHeader = By.xpath("//div[@id='cancel_policy_details']/h2");
	private By reason = By.xpath(".//*[@id='Reason data']/select");
	private By noteData = By.id("Notes data");
	private By calculateRefundBtn = By.xpath("//input[contains(@value,'Recalculate Refund')]");
	private By refundAmount = By.xpath(".//*[@id='refund amount data']/input");
	private By originalRefundAmount = By.xpath(".//*[@id='orig refund amount data']/input");
	private By okBtn = By.xpath(".//*[@id='cancel_policy_details']/div/input[contains(@value,'OK')]");
	private By printcancelText = By.xpath(".//*[@id='dialog1']/div[2]/form/table/tbody/tr[1]/td");
	private By refundCheqText = By.xpath(".//*[@id='dialog1']/div[2]/form/table/tbody/tr[2]/td");
	private By popUpOkBtn = By.id("yui-gen2-button");
	private By voidPolicyHeader = By.xpath(".//*[@id='voidpolicy']/h2/span");
	private By policyVoidTextBox = By.xpath(".//*[@id='voidpolicy']/table/tbody/tr/td/input");
	private By voidPolicyOkBtn = By.xpath(".//*[@id='voidpolicy']/div/input[contains(@value,'Ok')]");

	Button clickCalculateRefund = new Button(calculateRefundBtn);
	Button clickVoidPolicyOkBtn = new Button(voidPolicyOkBtn);
	Button clickOkBtn = new Button(okBtn);
	Button clickPopUpOkBtn = new Button(popUpOkBtn);

	DropDown reasonDropdown = new DropDown(reason, DUPLICATE);

	PageElement verifyCancelPolicyHeader = new PageElement(cancelPolicyHeader, CANCEL_POLICY);
	PageElement verifyNoteData = new PageElement(noteData, NOTE_DATA);
	PageElement verifyRefundAmount = new PageElement(refundAmount, VALUE);
	PageElement verifyOriginalRefundAmount = new PageElement(originalRefundAmount, VALUE);
	PageElement verifyPrintCancellationText = new PageElement(printcancelText, CANCELLATION_REQUEST);
	PageElement verifyRefundCheqText = new PageElement(refundCheqText, REFUND_CHEQUE);
	PageElement verifyVoidPolicyHeader = new PageElement(voidPolicyHeader, VOID_POLICY_HEADER);

	TextBox sendYesInPolicyVoidTextBox = new TextBox(policyVoidTextBox, YES);

	public void verifyCancelPolicyHeader() {
		logger.info("Inside verifyCancelPolicyHeader method in InsuranceQuotePolicy Class");

		Browser browser = new Browser();

		browser.verifyText(verifyCancelPolicyHeader);
	}

	/**
	 * 
	 */
	public void selectReasonDropDown() {
		logger.info("Inside selectReasonDropDown method in InsuranceQuotePolicy Class");

		Browser browser = new Browser();

		browser.waitForVisibility(reasonDropdown);
		reasonDropdown.selectValue();

	}

	/**
	 * 
	 */
	public void clickOnRecalcualteRefundBtn() {
		logger.info("Inside clickOnRecalcualteRefundBtn method in InsuranceQuotePolicy Class");

		clickCalculateRefund.click();
	}

	/**
	 * 
	 */
	public void verifyNoteData() {
		logger.info("Inside verifyNoteData method in InsuranceQuotePolicy Class");

		Browser browser = new Browser();
		browser.verifyText(verifyNoteData);
	}

	/**
	 * 
	 */
	public void refundAndActualRefundNotNull() {
		logger.info("Inside refundAndActualRefundNotNull method in InsuranceQuotePolicy Class");

		Browser browser = new Browser();

		browser.verifyAttributeValueNotNull(verifyRefundAmount);
		browser.verifyAttributeValueNotNull(verifyOriginalRefundAmount);
	}

	/**
	* 
	*/
	public void clickOkButton() {
		logger.info("Inside clickOkButton method in InsuranceQuotePolicy Class");

		clickOkBtn.click();
	}

	/**
	* 
	*/
	public void verifyPopUp() {
		logger.info("Inside verifyPopUp method in InsuranceQuotePolicy Class");

		Browser browser = new Browser();

		browser.verifyText(verifyPrintCancellationText);
		browser.verifyText(verifyRefundCheqText);

		clickPopUpOkBtn.click();
	}

	/**
	* 
	*/
	public void verifyVoidPolicyHeader() {
		logger.info("Inside verifyVoidPolicyHeader method in InsuranceQuotePolicy Class");

		Browser browser = new Browser();

		browser.verifyText(verifyVoidPolicyHeader);
	}

	/**
	 * 
	 */
	public void sendYesInPolicyVoidTextBox() {
		logger.info("Inside sendYesInPolicyVoidTextBox method in InsuranceQuotePolicy Class");

		sendYesInPolicyVoidTextBox.enterTextInField();
	}

	/**
	 * 
	 */
	public void clickOnVoidPolicyOkBtn() {
		logger.info("Inside clickOnVoidPolicyOkBtn method in InsuranceQuotePolicy Class");

		clickVoidPolicyOkBtn.click();
	}

}

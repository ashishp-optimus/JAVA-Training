package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;

/**
 * This class is for Insurance Quote/Policy page
 * 
 * @author Optimus
 */

public class InsuranceQuotePolicy {
	Logger logger;
	Browser browser;

	public InsuranceQuotePolicy() {
		logger = Logger.getLogger(InsuranceQuotePolicy.class);
		browser = new Browser();
	}

	private final static String CANCEL_POLICY = "Cancel Policy";
	private final static String DUPLICATE = "Duplicate Policy";
	private final static String NOTE_DATA = "Duplicate Policy - No Notes Required";
	private final static String VALUE = "value";
	private final static String CANCELLATION_REQUEST = "Print a cancellation request form";
	private final static String REFUND_CHEQUE = "Request a refund cheque";
	private final static String VOID_POLICY_HEADER = "Void Policy";
	private final static String YES = "Yes";

	private By cancelPolicyHeader = By
			.xpath("//div[@id='cancel_policy_details']/h2");
	private By reason = By.xpath(".//*[@id='Reason data']/select");
	private By noteData = By.id("Notes data");
	private By calculateRefundBtn = By
			.xpath("//input[contains(@value,'Recalculate Refund')]");
	private By refundAmount = By.xpath(".//*[@id='refund amount data']/input");
	private By originalRefundAmount = By
			.xpath(".//*[@id='orig refund amount data']/input");
	private By okBtn = By
			.xpath(".//*[@id='cancel_policy_details']/div/input[contains(@value,'OK')]");
	private By printcancelText = By
			.xpath(".//*[@id='dialog1']/div[2]/form/table/tbody/tr[1]/td");
	private By refundCheqText = By
			.xpath(".//*[@id='dialog1']/div[2]/form/table/tbody/tr[2]/td");
	private By popUpOkBtn = By.id("yui-gen2-button");
	private By voidPolicyHeader = By.xpath(".//*[@id='voidpolicy']/h2/span");
	private By policyVoidTextBox = By
			.xpath(".//*[@id='voidpolicy']/table/tbody/tr/td/input");
	private By voidPolicyOkBtn = By
			.xpath(".//*[@id='voidpolicy']/div/input[contains(@value,'Ok')]");

	private Button clickCalculateRefund = new Button(calculateRefundBtn);
	private Button clickVoidPolicyOkBtn = new Button(voidPolicyOkBtn);
	private Button clickOkBtn = new Button(okBtn);
	private Button clickPopUpOkBtn = new Button(popUpOkBtn);

	private DropDown reasonDropdown = new DropDown(reason, DUPLICATE);
	
	private TextBox verifyOriginalRefundAmount = new TextBox(
		originalRefundAmount, VALUE);	
	private TextBox verifyPrintCancellationText = new TextBox(printcancelText,
			CANCELLATION_REQUEST);
	private TextBox verifyRefundCheqText = new TextBox(refundCheqText, REFUND_CHEQUE);
	private TextBox verifyVoidPolicyHeader = new TextBox(voidPolicyHeader,
			VOID_POLICY_HEADER);
	private TextBox verifyCancelPolicyHeader = new TextBox(cancelPolicyHeader,
			CANCEL_POLICY);
	private TextBox verifyNoteData = new TextBox(noteData, NOTE_DATA);
	private TextBox verifyRefundAmount = new TextBox(refundAmount, VALUE);
	private TextBox sendYesInPolicyVoidTextBox = new TextBox(policyVoidTextBox, YES);

	/**
	 * To verify Cancel Policy page header
	 */
	public void verifyCancelPolicyHeader() {
		logger.info("Inside verifyCancelPolicyHeader method in InsuranceQuotePolicy Class");

		verifyCancelPolicyHeader.verifyText();
	}

	/**
	 * Select a value in the reason dropdown
	 */
	public void selectReasonDropDown() {
		logger.info("Inside selectReasonDropDown method in InsuranceQuotePolicy Class");

		browser.waitForVisibilityOfElement(reasonDropdown);
		reasonDropdown.selectValue();

	}

	public void clickOnRecalcualteRefundBtn() {
		logger.info("Inside clickOnRecalcualteRefundBtn method in InsuranceQuotePolicy Class");

		clickCalculateRefund.waitForVisibilityAndClick();
		
	}

	/**
	 * To verify the data entered as a Note
	 */
	public void verifyNoteData() {
		logger.info("Inside verifyNoteData method in InsuranceQuotePolicy Class");

		verifyNoteData.verifyText();
	}

	/**
	 * To verify the refund value is not null
	 */
	public void refundAndActualRefundNotNull() {
		logger.info("Inside refundAndActualRefundNotNull method in InsuranceQuotePolicy Class");

		browser.verifyAttributeValueNotNull(verifyRefundAmount);
		browser.verifyAttributeValueNotNull(verifyOriginalRefundAmount);
	}

	public void clickOkButton() {
		logger.info("Inside clickOkButton method in InsuranceQuotePolicy Class");

		clickOkBtn.click();
	}

	public void verifyPopUp() {
		logger.info("Inside verifyPopUp method in InsuranceQuotePolicy Class");

		verifyPrintCancellationText.verifyText();
		verifyRefundCheqText.verifyText();

		clickPopUpOkBtn.click();
	}

	/**
	 * Verify text in the Void Policy page header
	 */
	public void verifyVoidPolicyHeader() {
		logger.info("Inside verifyVoidPolicyHeader method in InsuranceQuotePolicy Class");

		verifyVoidPolicyHeader.verifyText();
	}

	public void sendYesInPolicyVoidTextBox() {
		logger.info("Inside sendYesInPolicyVoidTextBox method in InsuranceQuotePolicy Class");

		sendYesInPolicyVoidTextBox.enterTextInField();
	}

	public void clickOnVoidPolicyOkBtn() {
		logger.info("Inside clickOnVoidPolicyOkBtn method in InsuranceQuotePolicy Class");

		clickVoidPolicyOkBtn.click();
	}

}

package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

public class InsuranceQuotePolicy {
	Logger logger = Logger.getLogger(EditQuotesOrPolicyPage.class);
	Browser browser = new Browser();

	private final String CANCEL_POLICY = "Cancel Policy";
	private final String DUPLICATE = "Duplicate Policy";
	private final String NOTE_DATA = "Duplicate Policy - No Notes Required";
	private final String VALUE = "value";
	private final String CANCELLATION_REQUEST = "Print a cancellation request form";
	private final String REFUND_CHEQUE = "Request a refund cheque";
	private final String VOID_POLICY_HEADER = "Void Policy";
	private final String YES = "Yes";

	By cancelPolicyHeader = By.xpath("//div[@id='cancel_policy_details']/h2");
	By reason = By.xpath(".//*[@id='Reason data']/select");
	By noteData = By.id("Notes data");
	By calculateRefundBtn = By.xpath("//input[contains(@value,'Recalculate Refund')]");
	By refundAmount = By.xpath(".//*[@id='refund amount data']/input");
	By originalRefundAmount = By.xpath(".//*[@id='orig refund amount data']/input");
	By okBtn = By.xpath(".//*[@id='cancel_policy_details']/div/input[contains(@value,'OK')]");
	By printcancelText = By.xpath(".//*[@id='dialog1']/div[2]/form/table/tbody/tr[1]/td");
	By refundCheqText = By.xpath(".//*[@id='dialog1']/div[2]/form/table/tbody/tr[2]/td");
	By popUpOkBtn = By.id("yui-gen2-button");
	By voidPolicyHeader = By.xpath(".//*[@id='voidpolicy']/h2/span");
	By policyVoidTextBox = By.xpath(".//*[@id='voidpolicy']/table/tbody/tr/td/input");
	By voidPolicyOkBtn = By.xpath(".//*[@id='voidpolicy']/div/input[contains(@value,'Ok')]");

	PageElement verifyCancelPolicyHeader = new PageElement(cancelPolicyHeader, CANCEL_POLICY);
	PageElement reasonDropdown = new PageElement(reason, DUPLICATE, InputType.DROPDOWN);
	PageElement verifyNoteData = new PageElement(noteData, NOTE_DATA);
	PageElement clickCalculateRefund = new PageElement(calculateRefundBtn, null, InputType.BUTTON);
	PageElement verifyRefundAmount = new PageElement(refundAmount, VALUE);
	PageElement verifyOriginalRefundAmount = new PageElement(originalRefundAmount, VALUE);
	PageElement clickOkBtn = new PageElement(okBtn, null, InputType.BUTTON);
	PageElement verifyPrintCancellationText = new PageElement(printcancelText, CANCELLATION_REQUEST);
	PageElement verifyRefundCheqText = new PageElement(refundCheqText, REFUND_CHEQUE);
	PageElement clickPopUpOkBtn = new PageElement(popUpOkBtn, null, InputType.BUTTON);
	PageElement verifyVoidPolicyHeader = new PageElement(voidPolicyHeader, VOID_POLICY_HEADER);
	PageElement sendYesInPolicyVoidTextBox = new PageElement(policyVoidTextBox, YES, InputType.TEXT_BOX);
	PageElement clickVoidPolicyOkBtn = new PageElement(voidPolicyOkBtn, null, InputType.BUTTON);

	/**
	 * 
	 */
	public void verifyCancelPolicyHeader() {
		browser.verifyText(verifyCancelPolicyHeader);

	}

	/**
	 * 
	 */
	public void selectDropDown() {
		browser.waitForVisibility(reasonDropdown);
		browser.setElement(reasonDropdown);

	}

	/**
	 * 
	 */
	public void clickOnRecalcualteRefundBtn() {
		browser.setElement(clickCalculateRefund);
	}

	/**
	 * 
	 */
	public void verifyNoteData() {
		browser.verifyText(verifyNoteData);
	}

	/**
	 * 
	 */
	public void refundAndActualRefundNotNull() {
		browser.verifyAttributeValueNotNull(verifyRefundAmount);
		browser.verifyAttributeValueNotNull(verifyOriginalRefundAmount);
	}

	/**
	* 
	*/
	public void clickOkBtn() {
		browser.setElement(clickOkBtn);
	}

	/**
	* 
	*/
	public void verifyPopUp() {
		browser.verifyText(verifyPrintCancellationText);
		browser.verifyText(verifyRefundCheqText);
		browser.setElement(clickPopUpOkBtn);
	}

	/**
	* 
	*/
	public void verifyVoidPolicyHeader() {
		browser.verifyText(verifyVoidPolicyHeader);
	}

	/**
	 * 
	 */
	public void sendYesInPolicyVoidTextBox() {
		browser.setElement(sendYesInPolicyVoidTextBox);
	}

	/**
	 * 
	 */
	public void clickOnVoidPolicyOkBtn() {
		browser.setElement(clickVoidPolicyOkBtn);
	}

}

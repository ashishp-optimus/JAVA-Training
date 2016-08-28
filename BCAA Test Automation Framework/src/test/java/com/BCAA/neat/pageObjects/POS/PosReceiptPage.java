package com.BCAA.neat.pageObjects.POS;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.CheckBox;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is for POS receipt page
 * 
 * @author Optimus
 */

public class PosReceiptPage {
	Logger logger;
	Browser browser;

	public PosReceiptPage() {
		logger = Logger.getLogger(PosReceiptPage.class);
		browser = new Browser();
	}

	private final static String POS_RECEIPT_SUCCESS_MESSAGE = "New POS receipt is successfully created. ";
	private final static String RECEIPT_PAYMENT_SUCCESS_MESSAGE = "New receipt payment has been added successfully. ";
	private final static String VALUE = "value";
	private final static String TYPE_CASH = "Cash";
	private final static String TYPE_VISA = "Visa";
	private final static String CREATE_RECEIPT = "Inside createReceipt method in POS Receipt Page";

	private By paymentMethodCodeDropdownId = By.id("paymentMethodCode");
	private By successMessageId = By.id("msgbox");
	private By printerMessageId = By.id("errorMsgBox");
	private By addPaymentButtonId = By.id("addPaymentButtonId");
	private By printReceiptCheckboxId = By.id("printReceiptFlagCheckBox");
	private By receiptNumberId = By.id("receiptNumber");
	private By saveAndExitButtonId = By.id("saveAndExitButtonId");
	private By identificationTypeDropdownId = By.id("identificationTypeLookupCode");
	private By identificationIssuePlaceTextboxId = By.id("identificationIssuePlace");
	private By identificationNumberTextboxId = By.id("identificationNumber");
	private By okButtonId = By.id("btnIDInformatinOk");
	private By idInformationBoxId = By.id("TB_window");
	private By idInformationBoxFrameId = By.id("TB_iframeContent");
	private By useMonerisCheckBoxId = By.id("useMonerisFlagCheckBox");

	private Button addPaymentButton = new Button(addPaymentButtonId);
	private Button saveAndExitButton = new Button(saveAndExitButtonId);
	private Button okButton = new Button(okButtonId);

	private CheckBox checkPrintReceiptCheckbox = new CheckBox(printReceiptCheckboxId);
	private CheckBox useMonerisCheckBox = new CheckBox(useMonerisCheckBoxId);

	private DropDown cashPaymentMethodDropdown = new DropDown(paymentMethodCodeDropdownId, TYPE_CASH);
	private DropDown visaPaymentMethodDropdown = new DropDown(paymentMethodCodeDropdownId, TYPE_VISA);
	private DropDown identificationTypeDropdown = new DropDown(identificationTypeDropdownId,
			PropertiesReader.readProperty("idType"));

	private PageElement idInformationBox = new PageElement(idInformationBoxId);
	private PageElement idInformationBoxFrame = new PageElement(idInformationBoxFrameId);

	private TextBox identificationIssuePlaceTextbox = new TextBox(identificationIssuePlaceTextboxId,
			PropertiesReader.readProperty("issuePlace"));
	private TextBox identificationNumberTextbox = new TextBox(identificationNumberTextboxId,
			PropertiesReader.readProperty("idNumber"));
	private TextBox paymentSuccessMessage = new TextBox(successMessageId, RECEIPT_PAYMENT_SUCCESS_MESSAGE);
	private TextBox posSuccessMessage = new TextBox(successMessageId, POS_RECEIPT_SUCCESS_MESSAGE);
	private TextBox receiptNumber = new TextBox(receiptNumberId, VALUE);
	private TextBox printerMessage = new TextBox(printerMessageId);

	public void createReceipt() {
		logger.info(CREATE_RECEIPT);

		posSuccessMessage.verifyText();

		addPayment(PropertiesReader.readProperty("type"));
		paymentSuccessMessage.verifyText();
		checkPrintReceiptCheckbox.selectCheckbox();
		// selectPrinter.selectValue(); - Commented since printer is shown
		// as Not A Real Printer
		TextBox currentReceiptNumber = receiptNumber.getTextByAttribute();
		saveAndExitButton.clickAndWaitForProcessingBoxToDisappear();
		browser.waitForVisibilityOfElement(idInformationBox);
		browser.switchToFrame(idInformationBoxFrame);
		identificationTypeDropdown.selectValue();
		
		identificationIssuePlaceTextbox.enterTextInField();
		identificationNumberTextbox.enterTextInField();
		
		okButton.click();

		String receiptSuccessMessage = "The receipt " + currentReceiptNumber.getOutValue()
				+ " has been committed successfully. ";

		TextBox currentReceiptSuccessMessage = new TextBox(successMessageId, receiptSuccessMessage);

		currentReceiptSuccessMessage.verifyText();
		printerMessage.waitUntilMsgBoxIsDisplayed();

		/*
		 * This is commented since option displayed is Not A Real Printer. But
		 * test case requires ISD-RCT1 as printer. Coding is complete. But this
		 * code wont be executed
		 * 
		 * String printSuccessMessage =
		 * "Document Receipt was printed to printer " +
		 * PropertiesReader.readProperty("printer") + ".";
		 * 
		 * TextBox currentPrintSuccessMessage = new TextBox(printerMessageId,
		 * printSuccessMessage);
		 * 
		 * printerMessage.waitUntilMsgBoxIsDisplayed();
		 * 
		 * currentPrintSuccessMessage.verifyText();
		 * 
		 */

	}

	public void addPayment(String paymentType) {
		if (paymentType.equals(TYPE_CASH)) {
			cashPaymentMethodDropdown.selectValue();
			addPaymentButton.click();
		} else if (paymentType.equals(TYPE_VISA)) {

			visaPaymentMethodDropdown.selectValue();
			useMonerisCheckBox.selectCheckbox();
			addPaymentButton.click();
			// monerisMessage.waitUntilTextIsPresent();
			// TODO: Further code yet to be written since moneris website is
			// displaying error and we are unable to proceed
			// Refer Redmine ticket 61755
		}
	}

}

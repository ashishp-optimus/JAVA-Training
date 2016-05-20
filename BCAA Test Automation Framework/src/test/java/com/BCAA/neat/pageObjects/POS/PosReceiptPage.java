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
	Logger logger = Logger.getLogger(PosReceiptPage.class);

	private final static String POS_RECEIPT_SUCCESS_MESSAGE = "New POS receipt is successfully created. ";
	private final static String RECEIPT_PAYMENT_SUCCESS_MESSAGE = "New receipt payment has been added successfully. ";
	private final static String VALUE = "value";
	private final static String TYPE_CASH = "Cash";
	private final static String TYPE_VISA = "Visa";
	private final static String LOADING_MONERIS_MESSAGE = "Loading Moneris credit card transaction page, please wait ...";

	private By paymentMethodCodeDropdownId = By.id("paymentMethodCode");
	private By successMessageId = By.id("msgbox");
	private By printerMessageId = By.id("errorMsgBox");
	private By addPaymentButtonId = By.id("addPaymentButtonId");
	private By printReceiptCheckboxId = By.id("printReceiptFlagCheckBox");
	private By printerId = By.id("printerPath");
	private By receiptNumberId = By.id("receiptNumber");
	private By saveAndExitButtonId = By.id("saveAndExitButtonId");
	private By identificationTypeDropdownId = By.id("identificationTypeLookupCode");
	private By identificationIssuePlaceTextboxId = By.id("identificationIssuePlace");
	private By identificationNumberTextboxId = By.id("identificationNumber");
	private By okButtonId = By.id("btnIDInformatinOk");
	private By idInformationBoxId = By.id("TB_window");
	private By idInformationBoxFrameId = By.name("TB_iframeContent");
	private By useMonerisCheckBoxId = By.id("useMonerisFlagCheckBox");
	private By monerisMessageXpath = By.xpath("//*[@id='body']/center/b");

	Button addPaymentButton = new Button(addPaymentButtonId);
	Button saveAndExitButton = new Button(saveAndExitButtonId);
	Button okButton = new Button(okButtonId);

	CheckBox checkPrintReceiptCheckbox = new CheckBox(printReceiptCheckboxId);
	CheckBox useMonerisCheckBox = new CheckBox(useMonerisCheckBoxId);

	DropDown cashPaymentMethodDropdown = new DropDown(paymentMethodCodeDropdownId, TYPE_CASH);
	DropDown visaPaymentMethodDropdown = new DropDown(paymentMethodCodeDropdownId, TYPE_VISA);
	DropDown identificationTypeDropdown = new DropDown(identificationTypeDropdownId,
			PropertiesReader.readProperty("idType"));

	PageElement posSuccessMessage = new PageElement(successMessageId, POS_RECEIPT_SUCCESS_MESSAGE);
	PageElement selectPrinter = new PageElement(printerId, PropertiesReader.readProperty("printer"));
	PageElement receiptNumber = new PageElement(receiptNumberId, VALUE);
	PageElement paymentSuccessMessage = new PageElement(successMessageId, RECEIPT_PAYMENT_SUCCESS_MESSAGE);
	PageElement idInformationBox = new PageElement(idInformationBoxId);
	PageElement idInformationBoxFrame = new PageElement(idInformationBoxFrameId);
	PageElement monerisMessage = new PageElement(monerisMessageXpath, LOADING_MONERIS_MESSAGE);

	TextBox identificationIssuePlaceTextbox = new TextBox(identificationIssuePlaceTextboxId,
			PropertiesReader.readProperty("issuePlace"));
	TextBox identificationNumberTextbox = new TextBox(identificationNumberTextboxId,
			PropertiesReader.readProperty("idNumber"));

	public void createReceipt() {
		logger.info("Inside createReceipt method in POS Receipt Page");

		Browser browser = new Browser();

		browser.verifyText(posSuccessMessage);

		addPayment(PropertiesReader.readProperty("type"));
		browser.verifyText(paymentSuccessMessage);
		checkPrintReceiptCheckbox.selectCheckbox();
		// browser.setElement(selectPrinter); - Commented since printer is shown
		// as Not A Real Printer
		String currentReceiptNumber = browser.getTextByAttribute(receiptNumber).toString();
		saveAndExitButton.click();

		// TODO: This is not working yet due to inability to switch to a frame
		/*
		 * browser.switchToFrame(idInformationBoxFrame);
		 * browser.setElement(identificationTypeDropdown);
		 * browser.setElement(identificationIssuePlaceTextbox);
		 * browser.setElement(identificationNumberTextbox);
		 * browser.setElement(okButton);
		 * 
		 * String receiptSuccessMessage = "The receipt "+ currentReceiptNumber +
		 * " has been committed successfully. "; PageElement
		 * currentReceiptSuccessMessage = new
		 * PageElement(successMessageId,receiptSuccessMessage);
		 * 
		 * String printSuccessMessage =
		 * "Document Receipt was printed to printer "+
		 * PropertiesReader.readProperty("printer") +"."; PageElement
		 * currentPrintSuccessMessage = new
		 * PageElement(printerMessageId,printSuccessMessage);
		 * 
		 * browser.verifyText(currentReceiptSuccessMessage);
		 * browser.verifyText(currentPrintSuccessMessage);
		 */

	}

	public void addPayment(String paymentType) {
		if (paymentType == "Cash") {
			cashPaymentMethodDropdown.selectValue();
			addPaymentButton.click();
		} else if (paymentType == "Visa") {
			Browser browser = new Browser();
			visaPaymentMethodDropdown.selectValue();
			useMonerisCheckBox.selectCheckbox();
			addPaymentButton.click();
			browser.waitUntilTextIsPresent(monerisMessage);
			// TODO: Further code yet to be written since moneris website is
			// displaying error and we are unable to proceed
		}
	}

}

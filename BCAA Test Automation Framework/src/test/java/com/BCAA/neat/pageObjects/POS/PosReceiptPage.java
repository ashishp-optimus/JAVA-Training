package com.BCAA.neat.pageObjects.POS;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;


/**
 * This class is for POS receipt page
 * @author Optimus
 */

public class PosReceiptPage {
	Logger logger = Logger.getLogger(PosReceiptPage.class);
	Browser browser = new Browser();


	private final String POS_RECEIPT_SUCCESS_MESSAGE = "New POS receipt is successfully created. ";
	private final String RECEIPT_PAYMENT_SUCCESS_MESSAGE = "New receipt payment has been added successfully. ";
	private final String VALUE = "value";

	By paymentMethodCodeDropdownId = By.id("paymentMethodCode");
	By successMessageId = By.id("msgbox");
	By printerMessageId = By.id("errorMsgBox");
	By addPaymentButtonId = By.id("addPaymentButtonId");
	By printReceiptCheckboxId = By.id("printReceiptFlagCheckBox");
	By printerId = By.id("printerPath");
	By receiptNumberId = By.id("receiptNumber");
	By saveAndExitButtonId = By.id("saveAndExitButtonId");
	By identificationTypeDropdownId = By.id("identificationTypeLookupCode");
	By identificationIssuePlaceTextboxId = By.id("identificationIssuePlace");
	By identificationNumberTextboxId = By.id("identificationNumber");
	By okButtonId = By.id("btnIDInformatinOk");
	By idInformationBoxId = By.id("TB_window");
	By idInformationBoxFrameId = By.name("TB_iframeContent");
	

	PageElement posSuccessMessage = new PageElement(successMessageId, POS_RECEIPT_SUCCESS_MESSAGE);
	PageElement paymentMethodCodeDropdown = new PageElement(paymentMethodCodeDropdownId,PropertiesReader.readProperty("type"),InputType.DROPDOWN);
	PageElement addPaymentButton = new PageElement(addPaymentButtonId, null, InputType.BUTTON);
	PageElement checkPrintReceiptCheckbox = new PageElement(printReceiptCheckboxId,null,InputType.CHECK_CHECKBOX);
	PageElement selectPrinter = new PageElement(printerId,PropertiesReader.readProperty("printer"),InputType.DROPDOWN);
	PageElement receiptNumber = new PageElement(receiptNumberId,VALUE);
	PageElement saveAndExitButton = new PageElement(saveAndExitButtonId,null,InputType.BUTTON);
	PageElement paymentSuccessMessage = new PageElement(successMessageId,RECEIPT_PAYMENT_SUCCESS_MESSAGE);
	PageElement identificationTypeDropdown = new PageElement(identificationTypeDropdownId,PropertiesReader.readProperty("idType"),InputType.DROPDOWN);
	PageElement identificationIssuePlaceTextbox = new PageElement(identificationIssuePlaceTextboxId,PropertiesReader.readProperty("issuePlace"),InputType.TEXT_BOX);
	PageElement identificationNumberTextbox = new PageElement(identificationNumberTextboxId,PropertiesReader.readProperty("idNumber"),InputType.TEXT_BOX);
	PageElement okButton = new PageElement(okButtonId,null,InputType.BUTTON);
	PageElement idInformationBox = new PageElement(idInformationBoxId);
	PageElement idInformationBoxFrame = new PageElement(idInformationBoxFrameId);
	
	
	public void createReceipt(){
		logger.info("Inside createReceipt method in POS Receipt Page");
		browser.verifyText(posSuccessMessage);
		browser.setElement(paymentMethodCodeDropdown);
		browser.setElement(addPaymentButton);
		browser.verifyText(paymentSuccessMessage);
		browser.setElement(checkPrintReceiptCheckbox);
		//browser.setElement(selectPrinter); - Commented since printer is shown as Not A Real Printer
		String currentReceiptNumber = browser.getTextByAttribute(receiptNumber).toString();
		browser.setElement(saveAndExitButton);
		
		//TODO: This is not working yet due to inability to switch to a frame
		/*
		browser.switchToFrame(idInformationBoxFrame);
		browser.setElement(identificationTypeDropdown);
		browser.setElement(identificationIssuePlaceTextbox);
		browser.setElement(identificationNumberTextbox);
		browser.setElement(okButton);
	
		String receiptSuccessMessage = "The receipt "+ currentReceiptNumber +" has been committed successfully. ";
		PageElement currentReceiptSuccessMessage = new PageElement(successMessageId,receiptSuccessMessage);
		
		String printSuccessMessage = "Document Receipt was printed to printer "+ PropertiesReader.readProperty("printer") +".";
		PageElement currentPrintSuccessMessage = new PageElement(printerMessageId,printSuccessMessage);
		
		browser.verifyText(currentReceiptSuccessMessage);
		browser.verifyText(currentPrintSuccessMessage);
		*/
		
	}
		
		

}

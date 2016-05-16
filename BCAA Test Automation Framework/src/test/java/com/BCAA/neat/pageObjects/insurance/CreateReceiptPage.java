package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * This class is for Create Receipts page
 * @author Optimus
 */

public class CreateReceiptPage {
	Logger logger = Logger.getLogger(CreateReceiptPage.class);
	Browser browser = new Browser();

	By createNewReceiptButtonId = By.id("btnCreateReceiptCreateNewReceiptId");

	PageElement createNewReceiptButton = new PageElement(createNewReceiptButtonId, null, InputType.BUTTON);
	
	
	public void selectCreateReceipt(){
		logger.info("Inside selectCreateReceipt method in Create Receipt page class");
		browser.setElement(createNewReceiptButton);
		
	}
		
		

}

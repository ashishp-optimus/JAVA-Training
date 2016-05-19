package com.BCAA.neat.pageObjects.epp;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.pageObjects.insurance.EditQuotesOrPolicyPage;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is for EPP page
 * @author Optimus
 */

public class OpenPaymentPlanPage {
	Logger logger = Logger.getLogger(OpenPaymentPlanPage.class);
	Browser browser = new Browser();
	
	

	By planTypeDropdownId = By.id("eppTypeDropdown");
	By recalculateButtonId = By.xpath("//*[@id='PayplanTabPanel']/form/table/tbody/tr[2]/td/fieldset/div/input[1]");
	By amountColumnId = By.id("ScheduleItem_1_5");
	By paymentMethodTabId = By.id("PaymentPlanMethodTab_lnk");
	By accountHolderTextboxId = By.id("psAccountHolder");
	By transitNumberTextboxId = By.id("psTransitNumber");
	By bankNumberTextboxId = By.id("psBankNumber");
	By bankAccountNumberTextboxId = By.id("psBankAccountNumber");
	By applyButtonId = By.id("applyButton");
	By okButtonXpath = By.xpath("//*[@id='editPayPlan']/div[1]/input[1]");
	By emailRadioButtonId = By.id("printRadio2");
	By alternateEmailRadioId = By.id("emailAddressStringRadio");
	By emailAddressTextboxId = By.id("emailAddressString");
	By emailPermissionCheckboxId = By.id("emailPermission");
	By okPrintButtonId = By.id("yui-gen0-button");
	By printBoxId= By.id("dialog1");
	
	
	PageElement planTypeDropdown = new PageElement(planTypeDropdownId, PropertiesReader.readProperty("planType"), InputType.DROPDOWN);
	PageElement recalculateButton = new PageElement(recalculateButtonId,null,InputType.BUTTON);
	PageElement amountColumn = new PageElement(amountColumnId);
	PageElement paymentPlanMethodTab = new PageElement(paymentMethodTabId,null,InputType.BUTTON);
	PageElement accountHolderTextbox = new PageElement(accountHolderTextboxId,PropertiesReader.readProperty("accountHolder"), InputType.TEXT_BOX);
	PageElement transitNumberTextbox = new PageElement(transitNumberTextboxId,PropertiesReader.readProperty("transitNumber"), InputType.TEXT_BOX);
	PageElement bankNumberTextbox = new PageElement(bankNumberTextboxId,PropertiesReader.readProperty("bankNumber"), InputType.TEXT_BOX);
	PageElement bankAccountNumberTextbox = new PageElement(bankAccountNumberTextboxId,PropertiesReader.readProperty("accNumber"), InputType.TEXT_BOX);
	PageElement applyButton = new PageElement(applyButtonId,null,InputType.BUTTON);
	PageElement okButton = new PageElement(okButtonXpath,null,InputType.BUTTON);
	PageElement emailRadioButton = new PageElement(emailRadioButtonId,null,InputType.RADIOBUTTON);
	PageElement alternateEmailRadio = new PageElement(alternateEmailRadioId,null,InputType.RADIOBUTTON);
	PageElement emailAddressTextbox = new PageElement(emailAddressTextboxId,PropertiesReader.readProperty("email"), InputType.TEXT_BOX);
	PageElement emailPermissionCheckbox = new PageElement(emailPermissionCheckboxId,null,InputType.DROPDOWN);
	PageElement okPrintButton = new PageElement(okPrintButtonId,null,InputType.BUTTON);
	PageElement printBox = new PageElement(printBoxId);
	
	
	
	public void openPaymentPlan(){
		logger.info("Inside openPaymentPlan method in Open Payment Plan page class");
		browser.setElement(planTypeDropdown);
		browser.setElement(recalculateButton);
		browser.verifyTextIsNotNull(amountColumn);
		browser.setElement(paymentPlanMethodTab);
		browser.setElement(accountHolderTextbox);
		browser.setElement(transitNumberTextbox);
		browser.setElement(bankNumberTextbox);
		browser.setElement(bankAccountNumberTextbox);
		browser.setElement(applyButton);
		browser.setElement(okButton);
		browser.waitForVisibility(printBox);
		browser.setElement(emailRadioButton);
		browser.setElement(alternateEmailRadio);
		browser.setElement(emailAddressTextbox);
		browser.setElement(emailPermissionCheckbox);
		browser.setElement(okPrintButton);
		
		EditQuotesOrPolicyPage editQuotesOrPolicyPage = new EditQuotesOrPolicyPage();
		editQuotesOrPolicyPage.verifyPolicyOpenSuccessMessage();
	}
	

		

}


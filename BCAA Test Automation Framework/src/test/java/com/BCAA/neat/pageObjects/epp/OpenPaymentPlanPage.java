package com.BCAA.neat.pageObjects.epp;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.CheckBox;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.RadioButton;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.pageObjects.insurance.EditQuotesOrPolicyPage;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is for EPP page
 * 
 * @author Optimus
 */

public class OpenPaymentPlanPage {
	Logger logger = Logger.getLogger(OpenPaymentPlanPage.class);
	Browser browser = new Browser();

	private By planTypeDropdownId = By.id("eppTypeDropdown");
	private By recalculateButtonId = By
			.xpath("//*[@id='PayplanTabPanel']/form/table/tbody/tr[2]/td/fieldset/div/input[1]");
	private By amountColumnId = By.id("ScheduleItem_1_5");
	private By paymentMethodTabId = By.id("PaymentPlanMethodTab_lnk");
	private By accountHolderTextboxId = By.id("psAccountHolder");
	private By transitNumberTextboxId = By.id("psTransitNumber");
	private By bankNumberTextboxId = By.id("psBankNumber");
	private By bankAccountNumberTextboxId = By.id("psBankAccountNumber");
	private By applyButtonId = By.id("applyButton");
	private By okButtonXpath = By.xpath("//*[@id='editPayPlan']/div[1]/input[1]");
	private By emailRadioButtonId = By.id("printRadio2");
	private By alternateEmailRadioId = By.id("emailAddressStringRadio");
	private By emailAddressTextboxId = By.id("emailAddressString");
	private By emailPermissionCheckboxId = By.id("emailPermission");
	private By okPrintButtonId = By.id("yui-gen0-button");
	private By printBoxId = By.id("dialog1");

	Button recalculateButton = new Button(recalculateButtonId);
	Button okPrintButton = new Button(okPrintButtonId);
	Button paymentPlanMethodTab = new Button(paymentMethodTabId);
	Button applyButton = new Button(applyButtonId);
	Button okButton = new Button(okButtonXpath);

	CheckBox emailPermissionCheckbox = new CheckBox(emailPermissionCheckboxId);

	DropDown planTypeDropdown = new DropDown(planTypeDropdownId, PropertiesReader.readProperty("planType"));

	PageElement amountColumn = new PageElement(amountColumnId);
	PageElement printBox = new PageElement(printBoxId);

	RadioButton emailRadioButton = new RadioButton(emailRadioButtonId);
	RadioButton alternateEmailRadio = new RadioButton(alternateEmailRadioId);

	TextBox accountHolderTextbox = new TextBox(accountHolderTextboxId, PropertiesReader.readProperty("accountHolder"));
	TextBox transitNumberTextbox = new TextBox(transitNumberTextboxId, PropertiesReader.readProperty("transitNumber"));
	TextBox bankNumberTextbox = new TextBox(bankNumberTextboxId, PropertiesReader.readProperty("bankNumber"));
	TextBox bankAccountNumberTextbox = new TextBox(bankAccountNumberTextboxId,
			PropertiesReader.readProperty("accNumber"));
	TextBox emailAddressTextbox = new TextBox(emailAddressTextboxId, PropertiesReader.readProperty("email"));

	/**
	 * To open a payment plan
	 */
	public void openPaymentPlan() {
		logger.info("Inside openPaymentPlan method in Open Payment Plan page class");
		planTypeDropdown.selectValue();
		recalculateButton.click();
		browser.verifyTextIsNotNull(amountColumn);
		paymentPlanMethodTab.click();
		accountHolderTextbox.enterTextInField();
		transitNumberTextbox.enterTextInField();
		bankNumberTextbox.enterTextInField();
		bankAccountNumberTextbox.enterTextInField();
		applyButton.click();
		okButton.click();
		browser.waitForVisibility(printBox);
		emailRadioButton.selectRadioButton();
		alternateEmailRadio.selectRadioButton();
		emailAddressTextbox.enterTextInField();
		emailPermissionCheckbox.selectCheckbox();
		okPrintButton.click();

		EditQuotesOrPolicyPage editQuotesOrPolicyPage = new EditQuotesOrPolicyPage();
		editQuotesOrPolicyPage.verifyPolicyOpenSuccessMessage();
	}

}

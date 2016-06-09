package com.BCAA.neat.pageObjects.epp;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.CheckBox;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.RadioButton;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.DataBaseConnection;

/**
 * This class is for EPP page
 * 
 * @author Optimus
 */

public class OpenPaymentPlanPage {
	Logger logger;
	Browser browser;

	DataBaseConnection databaseConnection = new DataBaseConnection();;
	private Map<String, String> openPaymentPlanPage = databaseConnection.getDatabase()
			.getPageCollectionsAsMap("OPENPAYMENTPLANPAGE");

	public OpenPaymentPlanPage() {
		logger = Logger.getLogger(OpenPaymentPlanPage.class);
		browser = new Browser();
	}

	private static final String PAYMENT_PLAN = "The new payment plan is successfully opened.";
	private static final String BANK_NUMBER_KEY = "banknumber";
	private static final String TRANSIT_NUMBER_KEY = "transitnumber";
	private static final String ACCOUNT_HOLDER_KEY = "accountholder";
	private static final String PLAN_TYPE_KEY = "plantype";
	private static final String ACCOUNT_NUMBER_KEY = "accnumber";
	private static final String EMAIL_KEY = "email";

	private static final String OPEN_PAYMENT_PLAN = "Inside openPaymentPlan method in OpenPaymentPlanPage class";

	private By planTypeDropdownId = By.id("eppTypeDropdown");
	private By recalculateButtonXpath = By
			.xpath("//*[@id='PayplanTabPanel']/form/table/tbody/tr[2]/td/fieldset/div/input[1]");
	private By amountColumnId = By.id("ScheduleItem_1_5");
	private By paymentMethodTabId = By.id("PaymentPlanMethodTab_lnk");
	private By accountHolderTextboxId = By.id("psAccountHolder");
	private By transitNumberTextboxId = By.id("psTransitNumber");
	private By bankNumberTextboxId = By.id("psBankNumber");
	private By bankAccountNumberTextboxId = By.id("psBankAccountNumber");
	private By applyButtonId = By.id("applyButton");
	private By okButtonXpath = By.xpath(".//*[@id='editPayPlan']/div[1]/input[1]");
	private By emailRadioButtonId = By.id("printRadio2");
	private By alternateEmailRadioId = By.id("emailAddressStringRadio");
	private By emailAddressTextboxId = By.id("emailAddressString");
	private By emailPermissionCheckboxId = By.id("emailPermission");
	private By okPrintButtonId = By.id("yui-gen0-button");
	private By printBoxId = By.id("dialog1");
	private By verifyPaymentPlanId = By.id("msgbox");

	private Button recalculateButton = new Button(recalculateButtonXpath);
	private Button okPrintButton = new Button(okPrintButtonId);
	private Button paymentPlanMethodTab = new Button(paymentMethodTabId);
	private Button applyButton = new Button(applyButtonId);
	private Button okButton = new Button(okButtonXpath);

	private CheckBox emailPermissionCheckbox = new CheckBox(emailPermissionCheckboxId);

	private DropDown planTypeDropdown = new DropDown(planTypeDropdownId, openPaymentPlanPage.get(PLAN_TYPE_KEY));

	private PageElement amountColumn = new PageElement(amountColumnId);
	private PageElement printBox = new PageElement(printBoxId);

	private RadioButton emailRadioButton = new RadioButton(emailRadioButtonId);
	private RadioButton alternateEmailRadio = new RadioButton(alternateEmailRadioId);

	private TextBox accountHolderTextbox = new TextBox(accountHolderTextboxId,
			openPaymentPlanPage.get(ACCOUNT_HOLDER_KEY));
	private TextBox transitNumberTextbox = new TextBox(transitNumberTextboxId,
			openPaymentPlanPage.get(TRANSIT_NUMBER_KEY));
	private TextBox bankNumberTextbox = new TextBox(bankNumberTextboxId, openPaymentPlanPage.get(BANK_NUMBER_KEY));
	private TextBox bankAccountNumberTextbox = new TextBox(bankAccountNumberTextboxId,
			openPaymentPlanPage.get(ACCOUNT_NUMBER_KEY));
	private TextBox emailAddressTextbox = new TextBox(emailAddressTextboxId, openPaymentPlanPage.get(EMAIL_KEY));
	private TextBox verifyPaymentPlan = new TextBox(verifyPaymentPlanId, PAYMENT_PLAN);

	/**
	 * To open a payment plan
	 */
	public void openPaymentPlan() {
		logger.info(OPEN_PAYMENT_PLAN);

		planTypeDropdown.selectValue();
		recalculateButton.click();
		browser.verifyTextIsNotNull(amountColumn);
		paymentPlanMethodTab.click();
		accountHolderTextbox.enterTextInField();
		transitNumberTextbox.enterTextInField();
		bankNumberTextbox.enterTextInField();
		bankAccountNumberTextbox.enterTextInField();

		applyButton.clickWhenElementIsClickable();

		okButton.clickWhenElementIsClickable();

		browser.waitForVisibilityOfElement(printBox);
		emailRadioButton.selectRadioButton();
		alternateEmailRadio.selectRadioButton();
		emailAddressTextbox.enterTextInField();
		emailPermissionCheckbox.selectCheckbox();
		okPrintButton.click();
		verifyPaymentPlan.verifyText();
	}
}

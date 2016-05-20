package com.BCAA.neat.pageObjects.insurance;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.PropertiesReader;

public class SelectInsurancePlanPage {
	Logger logger = Logger.getLogger(SelectInsurancePlanPage.class);
	Browser browser = new Browser();

	private final static String PRODUCT_TYPE = "Homeowner";
	private final static String PLAN_TYPE = "Home Insurance";
	private final static String DRAFT_SUCCESS_MESSAGE = "Draft Quote has been successfully created.";
	private final static String VALUE = "value";
	private final static String INSURANCE_PLAN_HEADER = "Select Insurance Plan";
	private final static String EDIT_QUOTE_HEADER = "Edit Quote/Policy";
	private final static String ACTIVE_POLICY_NUM = "G7141442";

	private By categoryDropdownId = By.id("productCategoryCode");
	private By expiryDateId = By.id("expiryDate");
	private By okButtonId = By.id("btnSelectInsurancePlanOkId");
	private By planTypeXpath = By.xpath("//*[@id='selectInsurancePlan']/table/tbody/tr[2]/td[6]/select/option[12]");
	private By typeXpath = By.xpath(".//*[@id='productTypeCode']/option[3]");
	private By calenderButtonId = By.id("showeffectiveDate");
	private By calenderXpath = By.xpath("//td[contains(@class,'today selectable')]");
	private By confirmationMessageBoxId = By.id("msgbox");
	private By SelectInsurancePlanHeader = By.xpath("//div[@id='selectInsurancePlan']/h2");
	private By OkBtnId = By.id("btnSelectInsurancePlanOkId");
	private By policyDetailHeader = By.xpath("//div[@id='policy_detail']/h2");

	Button okButton = new Button(okButtonId);
	Button calenderButton = new Button(calenderButtonId);
	Button currentDateInCalender = new Button(calenderXpath);
	Button clickOkBtn = new Button(OkBtnId);

	DropDown categoryDropdown = new DropDown(categoryDropdownId, PropertiesReader.readProperty("selectInsurancePlan"));

	PageElement planType = new PageElement(planTypeXpath, PLAN_TYPE);
	PageElement type = new PageElement(typeXpath, PRODUCT_TYPE);
	PageElement successMessageBox = new PageElement(confirmationMessageBoxId, DRAFT_SUCCESS_MESSAGE);
	PageElement messageBox = new PageElement(confirmationMessageBoxId, DRAFT_SUCCESS_MESSAGE);
	PageElement sucessMessageBox = new PageElement(confirmationMessageBoxId, DRAFT_SUCCESS_MESSAGE);
	PageElement verifyInsurancePlanHeader = new PageElement(SelectInsurancePlanHeader, INSURANCE_PLAN_HEADER);
	PageElement verifyEditQuoteHeader = new PageElement(policyDetailHeader, EDIT_QUOTE_HEADER);
	PageElement actualExpiryDate;

	/**
	 * To verify the auto-populated expiry date when filling in the effective
	 * date for a policy
	 * 
	 */

	public String verifyExpiryDate() {
		logger.info("Inside verifyExpiryDate method in SelectInsurancePlanPage Class");
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());
		Format f = new SimpleDateFormat("yyyy/MM/dd");
		date.add(Calendar.YEAR, 1);
		String laterDate;
		// To handle expiry date in case of leap year
		if (date.getActualMaximum(Calendar.DAY_OF_YEAR) > 365) {
			date.add(Calendar.DATE, 1);
			laterDate = f.format(date.getTime()).toString();
		} else {
			laterDate = f.format(date.getTime()).toString();
		}
		return laterDate;
	}

	/**
	 * 
	 * To select an Insurance Plan and create a draft quote
	 */

	public void selectInsurancePlan() {
		logger.info("Inside selectInsurancePlan method in SelectInsurancePlanPage Class");

		categoryDropdown.selectValue();

		browser.verifyText(type);
		browser.verifyText(planType);

		calenderButton.click();
		currentDateInCalender.click();
		// To retrieve actual expiry date
		String retrievedExpiryDate = verifyExpiryDate();
		// creates a new object for PageElement class to verify expiry date
		actualExpiryDate = new PageElement(expiryDateId, retrievedExpiryDate, VALUE);
		browser.verifyTextByAttributeValue(actualExpiryDate);

		okButton.click();

		browser.verifyText(successMessageBox);
	}

	/*
	 * public void selectEndorsePolicy() { FindQuotesOrPolicyPage
	 * findQuotesOrPolicyObj = new FindQuotesOrPolicyPage();
	 * findQuotesOrPolicyObj.searchQuotePolicywithQuoteNumber(ACTIVE_POLICY_NUM)
	 * ; browser.getText(verifyInsurancePlanHeader);
	 * browser.setElement(clickOkBtn); browser.getText(verifyEditQuoteHeader); }
	 */

}

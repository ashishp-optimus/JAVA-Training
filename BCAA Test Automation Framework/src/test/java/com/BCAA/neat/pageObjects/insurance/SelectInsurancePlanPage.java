package com.BCAA.neat.pageObjects.insurance;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;

public class SelectInsurancePlanPage {
	Logger logger = Logger.getLogger(SelectInsurancePlanPage.class);
	Browser browser = new Browser();

	private final String PRODUCT_TYPE = "Homeowner";
	private final String PLAN_TYPE = "Home Insurance";
	private final String DRAFT_SUCCESS_MESSAGE = "Draft Quote has been successfully created.";
	private final String VALUE = "value";
	private final String INSURANCE_PLAN_HEADER = "Select Insurance Plan";
	private final String EDIT_QUOTE_HEADER = "Edit Quote/Policy";
	private final String ACTIVE_POLICY_NUM = "G7141442";
	

	By categoryDropdownId = By.id("productCategoryCode");
	By expiryDateId = By.id("expiryDate");
	By okButtonId = By.id("btnSelectInsurancePlanOkId");
	By planTypeXpath = By.xpath("//*[@id='selectInsurancePlan']/table/tbody/tr[2]/td[6]/select/option[12]");
	By typeXpath = By.xpath(".//*[@id='productTypeCode']/option[3]");
	By calenderButtonId = By.id("showeffectiveDate");
	By calenderXpath = By.xpath("//td[contains(@class,'today selectable')]");
	By confirmationMessageBoxId = By.id("msgbox");
	By SelectInsurancePlanHeader = By.xpath("//div[@id='selectInsurancePlan']/h2");
	By OkBtnId = By.id("btnSelectInsurancePlanOkId");
	By policyDetailHeader = By.xpath("//div[@id='policy_detail']/h2");

	PageElement categoryDropdown = new PageElement(categoryDropdownId,
			PropertiesReader.readProperty("selectInsurancePlan"), InputType.DROPDOWN);
	PageElement okButton = new PageElement(okButtonId, null, InputType.BUTTON);
	PageElement planType = new PageElement(planTypeXpath, PLAN_TYPE);
	PageElement type = new PageElement(typeXpath, PRODUCT_TYPE);
	PageElement calenderButton = new PageElement(calenderButtonId, null, InputType.BUTTON);
	PageElement currentDateInCalender = new PageElement(calenderXpath, null, InputType.BUTTON);
	PageElement successMessageBox = new PageElement(confirmationMessageBoxId, DRAFT_SUCCESS_MESSAGE);
	PageElement messageBox = new PageElement(confirmationMessageBoxId, DRAFT_SUCCESS_MESSAGE);
	PageElement sucessMessageBox = new PageElement(confirmationMessageBoxId, DRAFT_SUCCESS_MESSAGE);
	PageElement verifyInsurancePlanHeader = new PageElement(SelectInsurancePlanHeader, INSURANCE_PLAN_HEADER);
	PageElement clickOkBtn = new PageElement(OkBtnId, null, InputType.BUTTON);
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
		browser.setElement(categoryDropdown);
		browser.verifyText(type);
		browser.verifyText(planType);
		browser.setElement(calenderButton);
		browser.setElement(currentDateInCalender);
		// To retrieve actual expiry date
		String retrievedExpiryDate = verifyExpiryDate();
		// creates a new object for PageElement class to verify expiry date
		actualExpiryDate = new PageElement(expiryDateId, retrievedExpiryDate, VALUE);
		browser.verifyTextByAttributeValue(actualExpiryDate);
		browser.setElement(okButton);
		browser.verifyText(successMessageBox);
	}
	
	public void selectEndorsePolicy() {
		FindQuotesOrPolicyPage findQuotesOrPolicyObj = new FindQuotesOrPolicyPage();
		findQuotesOrPolicyObj.searchQuotePolicywithQuoteNumber(ACTIVE_POLICY_NUM);
		browser.getText(verifyInsurancePlanHeader);
		browser.setElement(clickOkBtn);
		browser.getText(verifyEditQuoteHeader);
	}

}

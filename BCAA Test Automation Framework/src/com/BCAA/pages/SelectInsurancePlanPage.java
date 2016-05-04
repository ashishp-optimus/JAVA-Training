package com.BCAA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BCAA.executor.BrowserFactory;
import com.BCAA.utils.InputType;

public class SelectInsurancePlanPage {
	private WebDriver driver;

	BrowserFactory browserFactory = new BrowserFactory();
	private final String PRODUCT_CATEGORY = "Habitational";
	private final String PRODUCT_TYPE = "Homeowner";
	private final String PLAN_TYPE = "Home Insurance";

	/**
	 * 
	 * @param locDriver
	 */

	public SelectInsurancePlanPage(WebDriver locDriver) {
		this.driver = locDriver;
	}

	By category = By.id("productCategoryCode");
	By associateNumber = By.name("associateNumber");
	By effectiveDate = By.id("effectiveDate");
	By expiryDate = By.id("expiryDate");
	By ok = By.id("btnSelectInsurancePlanOkId");
	By plan = By.name("productId");
	By type = By.id("productTypeCode");
	By calenderButton = By.id("showeffectiveDate");
	By calender = By.xpath("//td[contains(@class,'today selectable')]");

	/**
	 * 
	 * To select an Insurance Plan on TNEAT and create a draft quote
	 */

	public void selectInsurancePlan() {
		driver = browserFactory.setElement(driver, category, PRODUCT_CATEGORY, InputType.DROPDOWN.getValue());
		driver = browserFactory.getText(driver, type, PRODUCT_TYPE);
		driver = browserFactory.getText(driver, plan, PLAN_TYPE);
		driver = browserFactory.setElement(driver, calenderButton, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, calender, null, InputType.BUTTON.getValue());

		// TODO: Date verification is still to be implemented

		driver = browserFactory.setElement(driver, ok, null, InputType.BUTTON.getValue());
		
		//TODO: Success message verification to be implemented once Edit Quote/Policy page is created 
	}

}

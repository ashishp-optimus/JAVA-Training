package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.Table;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;

/**
 * This class is for Options tab page
 * 
 * @author Optimus
 */

public class OptionsTabPage {
	Logger logger;
	Browser browser;

	public OptionsTabPage() {
		logger = Logger.getLogger(OptionsTabPage.class);
		browser = new Browser();
	}

	private final String ASSERT_FAIL_MESSAGE = "FAILED due to null value in Premiums";
	private final String R13_BUILDING_BY_LAW = "R13 - Building By-Law Rider";
	private final String DISCOUNT = "Added option Discount - Safehome";
	private final String REMOVE_DISCOUNT = "Removed option Discount";
	private final String VALUE = "1,000,000";
	private final String C6_ADVANTAGE_HOME_INSURANCE="C6 - Advantage Home Insurance";

	private By verifyOptionsBtnId = By.id("btnOptionsTabVerifyOptionsId");
	private By addEditDeleteOptionsBtnXpath = By
			.xpath("//*[@id='OptionsTabPanel']/div[1]/span[2]/input");
	private By policyRecordBtnXpath = By
			.xpath("//div[@id='OptionsTabPanel']/div/table/tbody/tr");
	private By productOptionActive = By
			.xpath("//tr[contains(@id,'productOptionActive')]/following-sibling::tr/child::td[5]");
	private By showAllBtnXpath = By
			.xpath("//*[@id='OptionsTabPanel']/div[1]/span[6]/input");
	private By annualPremium = By
			.xpath("//tr[contains(@id,'productOptionActive')]/following-sibling::tr/child::td[6]");
	private By authorizationsBtnXpath = By
			.xpath("//input[@value='Authorizations']");
	private By messageBoxId = By.id("msgbox");

	private Button verifyOptionsButon = new Button(verifyOptionsBtnId);
	private Button addEditDeleteOptions = new Button(addEditDeleteOptionsBtnXpath);
	private Button showAllBtn = new Button(showAllBtnXpath);
	private Button authorizationsBtn = new Button(authorizationsBtnXpath);
	private Button selectPolicyRecord = new Button(policyRecordBtnXpath);
	
	private Table policyRecord = new Table(policyRecordBtnXpath);
	private Table buildingByLawOptionBtn = new Table(policyRecordBtnXpath,
			R13_BUILDING_BY_LAW);
	private Table liabilityIncreaseLimit = new Table(
			policyRecordBtnXpath,VALUE);

	private TextBox discount = new TextBox(messageBoxId, DISCOUNT);
	private TextBox removeDiscount = new TextBox(messageBoxId, REMOVE_DISCOUNT);

	private TextBox activePolicyOptions = new TextBox(productOptionActive);
	private Table condoAdvantageHomeInsurance=new Table(policyRecordBtnXpath, C6_ADVANTAGE_HOME_INSURANCE);
	
	private final static String VERIFY_OPTIONS = "Inside verifyOptions method in OptionsTabPage Class";
	private final static String VERIFY_PREMIUMS = "Inside verifyPremiums method in OptionsTabPage Class";
	private final static String SHOW_ALL_BUTTON = "Clicking the Show All button in OptionsTabPage Class";
	private final static String CLICKING_ADD_EDIT_DELETE = "Clicking Add/Edit/Delete Policy Options Button in OptionsTabPage Class";
	private final static String SELECT_FIRT_ASSET = "Selecting first assset in OptionsTabPage Class";
	private final static String SELECT_OPTION = "Selecting Option in OptionsTabPage Class";
	private final static String SELECT_CONDO_ADVANTAGE = "Selecting Condo Advantage Home Insurance plan in OptionTabPage";
	private final static String LIABILITY_ADDITION = "Verify addition of Liability-Increase Limit Option";
	private final static String CLICK_AUTHORIZATION = "Clicking authorizations button";
	private final static String VERIFY_DISCOUNT = "Inside verifyDiscount method in OptionsTabPage Class";
	private final static String VERIFY_REMOVED_DISCOUNT = "Inside verifyDiscount method in OptionsTabPage Class";


	/**
	 * To verify options for a policy
	 * 
	 */

	public void selectAPolicyAndClickVerifyOptions() {
		logger.info(VERIFY_OPTIONS);

		verifyOptionsButon.clickAndWaitForProcessingBoxToDisappear();
		browser.waitTillElementIsClickable(selectPolicyRecord);
		policyRecord.selectFirstRow();
	}

	/**
	 * To verify the premium amount in the Premium column
	 */
	public void verifyPremiums() {
		logger.info(VERIFY_PREMIUMS);

		activePolicyOptions.waitForInvisibilityOfElement();

		if ((Browser.driver.findElement(productOptionActive) != null)
				&& (Browser.driver.findElement(annualPremium) != null)) {
			logger.info("There is no null value in Premium");
		} else {
			logger.fatal("There is null value in Premiums");
			Assert.fail(ASSERT_FAIL_MESSAGE);
		}

	}
	
	/**
	 * To reload the page internally, since the code was unable to click on any other tab
	 */

	public void clickShowAllBtn() {
		logger.info(SHOW_ALL_BUTTON);

		showAllBtn.click();
	}

	public void clickAddEditDeleteOptionsButton() {
		logger.info(CLICKING_ADD_EDIT_DELETE);

		addEditDeleteOptions.click();
	}

	/**
	 * 
	 * To Select First Asset on Option Page
	 * 
	 * @param option
	 *            Locator of the First option
	 */

	public void selectingFirstAsset() {
		logger.info(SELECT_FIRT_ASSET);

		browser.waitTillElementIsClickable(policyRecord);

		policyRecord.selectFirstRow();
	}

	/**
	 * To Select a Option
	 */
	public void selectingOptionOnOptionTab() {
		logger.info(SELECT_OPTION);

		browser.waitTillElementIsClickable(buildingByLawOptionBtn);
		buildingByLawOptionBtn.selectRowByUniqueText();
	}

	/**
	 * To Select Condo Advantage Home Insurance
	 */
	public void selectCondoAdvantageHomeInsurance()
	{
		logger.info(SELECT_CONDO_ADVANTAGE);
		browser.waitTillElementIsClickable(condoAdvantageHomeInsurance);
		condoAdvantageHomeInsurance.selectRowByUniqueText();
	}
	/**
	 * To verify Addition of Liability IncreaseLimit Option
	 */
	public void verifyAdditionOption() {
		logger.info(LIABILITY_ADDITION);

		liabilityIncreaseLimit.verifyTextIsPresent();
	}

	/**
	 * 
	 * To select the Authorizations button
	 */
	public void clickAuthorizationsBtn() {
		logger.info(CLICK_AUTHORIZATION);

		authorizationsBtn.clickWhenElementIsClickable();
	}

	/**
	 * To verify That Discount is Applied
	 */
	public void verifyDiscount() {
		logger.info(VERIFY_DISCOUNT);

		browser.waitForVisibilityOfElement(discount);
		discount.verifyContainsText();
	}

	/**
	 * To verify That Discount is Removed
	 */
	public void verifyRemoveDiscount() {
		logger.info(VERIFY_REMOVED_DISCOUNT);

		browser.waitForVisibilityOfElement(removeDiscount);
		removeDiscount.verifyContainsText();

	}

}

package com.BCAA.neat.pageObjects.insurance;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.SetCalendar;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;

/**
 * This class is for Select Insurance Plan page
 * 
 * @author Optimus
 */

public class SelectInsurancePlanPage {
	Logger logger;
	Browser browser;

	DataBaseConnection database = new DataBaseConnection();;
	private Map<String, String> selectInsurancePlanPage = database.getDatabase()
			.getPageCollectionsAsMap("SELECTINSURANCEPLANPAGE");

	public SelectInsurancePlanPage() {
		logger = Logger.getLogger(SelectInsurancePlanPage.class);
		browser = new Browser();
	}

	private final static String PRODUCT_TYPE_KEY = "producttype";
	private final static String PRODUCT_PLAN_KEY = "productplam";
	private final static String PRODUCT_CATEGORY_KEY = "productcategory";
	private final static String INSURANCE_PLAN_HEADER_KEY = "insuranceplanheader";
	private final static String COPY_QUOTE_SUCESS_MESSAGE_KEY = "copyquotesuccessmessage";

	private final static String ENDORSEMENT_DATE_LESS_THEN_EFFECTIVE_DATE = "Endorsement Effective Date should be later or equal to Effective Date.";
	private final static String ENDORSEMENT_DATE_AFTER_EXPIRY_DATE = "Expiry Date should be later or equal to Endorsement Effective Date.";
	private final static String VALUE = "value";

	private final static String SELECT_INSURANCE_PLAN = "Inside selectInsurancePlan method in SelectInsurancePlanPage Class";
	private final static String CLICK_OK_BTN = "clickOkBtn under SelectInsurancePlanPage Class";
	private final static String VERIFY_COPY_SUCESS_MESSAGE = "verifyCopySuccessMsg under SelectInsurancePlanPage Class";
	private final static String VERIFY_SELECT_INSURANCE_PLAN_MESSAGE = "verifySelectInsurancePlanHeader under SelectInsurancePlanPage Class";
	private final static String SET_BEFORE_AND_AFTER_CURRENT_DATE = "setBeforeAndAfterCurrentDate under SelectInsurancePlanPage Class";
	private final static String SET_AFTER_EXPIRY_DATE = "setAfterExpiryDate under SelectInsurancePlanPage Class";
	private final static String VERIFY_ERROR_AFTER_EXPIRY_DATE_MESSAGE = "verifyErrorAfterExpiryDate under SelectInsurancePlanPage Class";
	private final static String VERIFY_ERROR_BEFORE_EXPIRY_DATE_MESSAGE = "verifyErrorBeforeEffectiveDate under SelectInsurancePlanPage Class";

	private By categoryDropdownId = By.id("productCategoryCode");
	private By expiryDateId = By.id("expiryDate");
	private By okButtonId = By.id("btnSelectInsurancePlanOkId");
	private By planTypeXpath = By.xpath("//*[@id='selectInsurancePlan']/table/tbody/tr[2]/td[6]/select/option[12]");
	private By typeXpath = By.xpath(".//*[@id='productTypeCode']/option[3]");
	private By effectiveDateId = By.id("effectiveDate");
	private By endorsementEffectiveDate = By.id("endorsementEffectiveDate");
	private By errorMsg = By.xpath("//div[@id='errbox']/ul");
	private By selectInsurancePlanHeader = By.xpath("//div[@id='selectInsurancePlan']/h2");
	private By OkBtnId = By.id("btnSelectInsurancePlanOkId");
	private By msbSucessBoxID = By.id("msgbox");

	private Button okButton = new Button(okButtonId);
	private Button clickOkBtn = new Button(OkBtnId);

	private DropDown categoryDropdown = new DropDown(categoryDropdownId,
			selectInsurancePlanPage.get(PRODUCT_CATEGORY_KEY));

	private TextBox actualExpiryDate;

	private SetCalendar effectiveDate = new SetCalendar(effectiveDateId);
	private SetCalendar endorsementDate = new SetCalendar(endorsementEffectiveDate);

	private TextBox productPlan = new TextBox(planTypeXpath, selectInsurancePlanPage.get(PRODUCT_PLAN_KEY));
	private TextBox productType = new TextBox(typeXpath, selectInsurancePlanPage.get(PRODUCT_TYPE_KEY));

	private TextBox verifyInsurancePlanHeader = new TextBox(selectInsurancePlanHeader,
			selectInsurancePlanPage.get(INSURANCE_PLAN_HEADER_KEY));
	private TextBox copySuccessMsgBox = new TextBox(msbSucessBoxID,
			selectInsurancePlanPage.get(COPY_QUOTE_SUCESS_MESSAGE_KEY));
	private TextBox dateLessThenEffectiveDate = new TextBox(errorMsg, ENDORSEMENT_DATE_LESS_THEN_EFFECTIVE_DATE);
	private TextBox dateAfterExpiryDate = new TextBox(errorMsg, ENDORSEMENT_DATE_AFTER_EXPIRY_DATE);

	/**
	 * To verify the auto-populated expiry date when filling in the effective
	 * date for a policy
	 * 
	 */
	public void selectInsurancePlan() {
		logger.info(SELECT_INSURANCE_PLAN);

		// To retrieve actual expiry date
		String retrievedExpiryDate = effectiveDate.verifyExpiryDate();

		effectiveDate.calendar();

		categoryDropdown.selectValue();

		productType.verifyText();
		productPlan.verifyText();
		actualExpiryDate = new TextBox(expiryDateId, retrievedExpiryDate, VALUE);
		actualExpiryDate.verifyTextByAttributeValue();

		okButton.click();
	}

	public void clickOkBtn() {
		logger.info(CLICK_OK_BTN);
		clickOkBtn.click();
	}

	public void verifyCopySuccessMsg() {
		logger.info(VERIFY_COPY_SUCESS_MESSAGE);

		copySuccessMsgBox.verifyText();
	}

	public void verifySelectInsurancePlanHeader() {
		logger.info(VERIFY_SELECT_INSURANCE_PLAN_MESSAGE);

		verifyInsurancePlanHeader.verifyText();
	}

	public void setBeforeAndAfterCurrentDate(int numberOfDayBeforeCurrentDate) {
		logger.info(SET_BEFORE_AND_AFTER_CURRENT_DATE);
		endorsementDate.beforeAndAfterCurrentDate(numberOfDayBeforeCurrentDate);
	}

	public void setAfterExpiryDate(int numberOfDayAfterExpirytDate) {
		logger.info(SET_AFTER_EXPIRY_DATE);
		endorsementDate.afterExpiryDate(numberOfDayAfterExpirytDate);
	}

	public void verifyErrorAfterExpiryDate() {
		logger.info(VERIFY_ERROR_AFTER_EXPIRY_DATE_MESSAGE);
		dateAfterExpiryDate.verifyText();
	}

	public void verifyErrorBeforeEffectiveDate() {
		logger.info(VERIFY_ERROR_BEFORE_EXPIRY_DATE_MESSAGE);
		dateLessThenEffectiveDate.verifyText();
	}

}

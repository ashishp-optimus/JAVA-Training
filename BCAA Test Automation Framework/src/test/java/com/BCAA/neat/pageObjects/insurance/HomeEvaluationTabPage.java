package com.BCAA.neat.pageObjects.insurance;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;

/**
 * This class is for Home Evaluation tab page
 * 
 * @author Optimus
 */
public class HomeEvaluationTabPage {
	Logger logger;
	Browser browser;

	DataBaseConnection dataBaseConnection = new DataBaseConnection();
	private Map<String, String> homeEvaluationTabPage = dataBaseConnection.getDatabase()
			.getPageCollectionsAsMap("HOMEEVALUATIONTABPAGE");

	public HomeEvaluationTabPage() {
		logger = Logger.getLogger(HomeEvaluationTabPage.class);
		browser = new Browser();
	}

	private final static String STOREY_NUMBER_KEY = "storeynumber";
	private final static String LIVING_AREA_KEY = "livingarea";
	private final static String MSB_SUCCESS_MESSAGE_KEY = "msbsuccessmessage";
	private final static String ASSET_SUCCESS_MESSAGE_KEY = "assetsavedsuccessmessage";
	private final static String MBSTYLES_KEY = "mbstyles";
	private final static String YEAR_BUILT_KEY = "yearbuilt";
	private final static String NO_PROPERTY_MESSAGE_KEY = "cannotfindpropertymessage";
	private final static String RCT_VERIFIED_STATUS_KEY = "rctdataverifiedstatus";
	private final static String CONSTRUCTION_KEY = "selectconstruction";

	private final static String ADD_HOME_EVALUATION = "Inside addHomeEvaluation method in HomeEvaluationTabPage Class";
	private final static String ADD_CONDO_EVALUATION = "Inside addCondoEvaluation method in HomeEvaluationTabPage Class";
	private final static String ADD_TENANT_EVALUATION = "Inside addTenantEvaluation method in HomeEvaluationTabPage Class";

	private By yearBuiltTextboxId = By.id("yearBuiltHomeEval");
	private By styleDropdownId = By.id("msbStyle");
	private By numberOfStoreysDropdownId = By.id("msbNumberOfStoreys");
	private By findPropertyBtnId = By.id("findPropertyButton");
	private By noPropertyErrorMessageXpath = By.xpath("//*[@id='errorMsgBox']/span/ul/li");
	private By finishedLivingAreaTextboxId = By.id("msbFinishedLivingArea");
	private By populateBtnId = By.id("populateButton");
	private By constructionDropdownId = By.id("msbConstruction");
	private By calculateBuildingValueBtnId = By.id("btnHomeEvaluationTabCalculateBuildingValueId");
	private By alertRctDataStatusBtnId = By.id("yui-gen8-button");
	private By verifiedDataStatusXpath = By.xpath("//*[@id='msbReviewdWithUser']/option[2]");
	private By saveBtnXpath = By.xpath(".//*[@id='btnHomeEvaluationTabSaveId']");
	private By okButtonHomeXpath = By.xpath(".//*[@id='btnAddHomeOkId']");
	private By msbSuccessMsgBoxXpath = By.xpath("//*[@id='msgbox']");
	private By deleteBtnId = By.id("btnAssetsTabDeleteId");

	private Button findPropertyBtn = new Button(findPropertyBtnId);
	private Button populateBtnSelect = new Button(populateBtnId);
	private Button calculateBuildingValueBtn = new Button(calculateBuildingValueBtnId);
	private Button alertRCTDataStatusBtnSelect = new Button(alertRctDataStatusBtnId);
	private Button saveBtnSelect = new Button(saveBtnXpath);
	private Button okBtnHomeSelect = new Button(okButtonHomeXpath);
	private Button deleteBtn = new Button(deleteBtnId);

	private DropDown styleDropdown = new DropDown(styleDropdownId, homeEvaluationTabPage.get(MBSTYLES_KEY));
	private DropDown numberOfStoreysDropdown = new DropDown(numberOfStoreysDropdownId,
			homeEvaluationTabPage.get(STOREY_NUMBER_KEY));
	private DropDown constructionDropdown = new DropDown(constructionDropdownId,
			homeEvaluationTabPage.get(CONSTRUCTION_KEY));

	private TextBox noPropertyErrorMessage = new TextBox(noPropertyErrorMessageXpath,
			homeEvaluationTabPage.get(NO_PROPERTY_MESSAGE_KEY));
	private TextBox msbSuccessMsgBox = new TextBox(msbSuccessMsgBoxXpath,
			homeEvaluationTabPage.get(MSB_SUCCESS_MESSAGE_KEY));
	private TextBox verifiedDataStatus = new TextBox(verifiedDataStatusXpath,
			homeEvaluationTabPage.get(RCT_VERIFIED_STATUS_KEY));
	private TextBox assetSuccessMsgBox = new TextBox(msbSuccessMsgBoxXpath, homeEvaluationTabPage.get(ASSET_SUCCESS_MESSAGE_KEY));
	private TextBox yearBuiltTextbox = new TextBox(yearBuiltTextboxId, homeEvaluationTabPage.get(YEAR_BUILT_KEY));
	private TextBox finishedTextbox = new TextBox(finishedLivingAreaTextboxId,
			homeEvaluationTabPage.get(LIVING_AREA_KEY));

	/**
	 * Add a new Home evaluation asset
	 * 
	 */
	public void addHomeEvaluation() {
		logger.info(ADD_HOME_EVALUATION);

		findPropertyBtn.click();

		noPropertyErrorMessage.verifyText();

		yearBuiltTextbox.enterTextInField();

		styleDropdown.selectValue();
		numberOfStoreysDropdown.selectValue();

		finishedTextbox.enterTextInField();

		populateBtnSelect.clickWhenElementIsClickable();

		msbSuccessMsgBox.verifyText();

		constructionDropdown.selectValue();

		calculateBuildingValueBtn.clickWhenElementIsClickable();

		alertRCTDataStatusBtnSelect.clickWhenElementIsClickable();

		verifiedDataStatus.verifyText();

		saveBtnSelect.clickWhenElementIsClickable();
		browser.acceptAlertButtonIfPresent();

		assetSuccessMsgBox.verifyText();

		okBtnHomeSelect.clickWhenElementIsClickable();
		browser.acceptAlertButtonIfPresent();

		assetSuccessMsgBox.verifyText();

		deleteBtn.clickWhenElementIsClickable();
	}

	/**
	 * Add a new Condo evaluation asset
	 * 
	 */
	public void addCondoEvaluation() {
		logger.info(ADD_CONDO_EVALUATION);

		yearBuiltTextbox.enterTextInField();

		saveBtnSelect.clickWhenElementIsClickable();

		assetSuccessMsgBox.verifyText();

		okBtnHomeSelect.clickWhenElementIsClickable();

		assetSuccessMsgBox.verifyText();

		deleteBtn.clickWhenElementIsClickable();
	}

	/**
	 * Add a new Tenant evaluation asset
	 * 
	 */
	public void addTenantEvaluation() {
		logger.info(ADD_TENANT_EVALUATION);

		addCondoEvaluation();
	}

}

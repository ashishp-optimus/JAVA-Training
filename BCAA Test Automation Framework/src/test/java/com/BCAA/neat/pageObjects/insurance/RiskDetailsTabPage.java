package com.BCAA.neat.pageObjects.insurance;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.CheckBox;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is for Risk details tab page
 * 
 * @author Optimus
 */
public class RiskDetailsTabPage {
	Logger logger;
	Browser browser;

	DataBaseConnection dataBaseConnection = new DataBaseConnection();
	private Map<String, String> riskDetailsTabPage = dataBaseConnection.getDatabase()
			.getPageCollectionsAsMap("RISKDETAILSTABPAGE");

	public RiskDetailsTabPage() {
		logger = Logger.getLogger(RiskDetailsTabPage.class);
		browser = new Browser();
	}

	private final static String PRINCIPAL = "Principal";
	private final static String EMPTY = "";
	private final static String petBreed = "Pit Bull or any 'bull' breed";
	private final static String NO_RENTAL = "No Rental Units";
	private final static String MSG_BOX = "Policy Home Asset was saved successfully.";
	private final static String ATTRIBUTE_TYPE_VALUE = "value";
	private final static String PRIMARY_HEATING = "None";
	private final static String AUXILIARY_HEATING = "None";
	private final static String CONSTRUCTION = "Concrete";
	private final static String FIREHALL_OTHER_OPTION = "Over 8km by Road";
	private final static String FIRE_PROTECTION = "Fire protection grading override removed";
	private final static String ADD_RISK_DETAILS_WITHOUT_LOCATION = "Inside addRiskDetailsWithoutLocation method in RiskDetailsTabPage Class";
	private final static String WITH_PET_BINDING = "Inside addRiskDetailsWithPetBinding method in RiskDetailsTabPage Class";
	private final static String SELECT_HEATING = "Inside selectHeating method in RiskDetailsTabPage Class";
	private final static String FIREHALL_DISTANCE = "Inside selectfirehallDistanceLookupCodeDropdown method in RiskDetailsTabPage Class";
	private final static String CONDO_ASSETS = "Inside addRiskDetailsForCondoAssets method in RiskDetailsTabPage Class";
	private final static String TENANTS_ASSETS = "Inside addRiskDetailsForTenantAssets method in RiskDetailsTabPage Class";
	private final static String FIRE_PROTECTION_MESSAGE = "Inside verifyFireProtectionMessage method in RiskDetailsTabPage Class";
	private final static String REMOVE_FIRE_PROTECTION = "Inside clickRemoveFireProtectionButton method in  in RiskDetailsTabPage Class";
	private final static String ADD_RISK_DETAILS = "Inside addRiskDetails method in RiskDetailsTabPage Class";

	private By dayCareInHouseDropdownId = By.id("drpdwnRiskDetailsTabIsDaycareInHouseId");
	private By addHomeLocationCheckBoxId = By.id("chkbxAddHomeLocation1Id");
	private By businessActivityOrLocDropdownId = By.id("drpdwnRiskDetailsTabIsBusinessInLocationId");
	private By riskTypeDropdownId = By.id("drpdwnRiskDetailsTabRiskTypeId");
	private By principalResidenceDropdownId = By.id("drpdwnRiskDetailsTabIsMemberLiveInResidenceId");
	private By hydrantDropdownId = By.id("hydrantDistanceLookupCode");
	private By firehallDropdownId = By.id("firehallDistanceLookupCode");
	private By electricalSystemDropdownId = By.id("drpdwnRiskDetailsTabElectricalSystemId");
	private By plumbingSystemDropdownId = By.id("drpdwnRiskDetailsTabPlumbingSystemId");
	private By petFlagDropdownId = By.id("petFlagField");
	private By petTypeDropdownId = By.id("petTypeLookupCodeField");
	private By numberOfFamiliesDropdownId = By.id("drpdwnRiskDetailsTabNumberOfFamiliesId");
	private By numberOfAdultsDropdownId = By.id("drpdwnRiskDetailsTabNumberOfAdultsId");
	private By numberOfChildrenDropdownId = By.id("drpdwnRiskDetailsTabNumberOfChildrenId");
	private By numberOfRoomersDropdownId = By.id("drpdwnRiskDetailsTabNumberOfRoomersId");
	private By rentalUnitsDropdownId = By.id("drpdwnRiskDetailsTabNumberOfRentalUnitsId");
	private By commercialOccupancyDropdownId = By.id("drpdwnRiskDetailsTabIsThereCommercialOccupancyId");
	private By dwellingTypeDropdownId = By.id("drpdwnRiskDetailsTabDwellingTypeId");
	private By alarmDropdownId = By.id("alarmLookupCode");
	private By saveButtonId = By.id("btnRiskDetailsTabSaveId");
	private By msgboxId = By.id("msgbox");
	private By fireProtectedTextboxId = By.id("fireProtectionLookupCode_id");
	private By primaryHeatingDropDownXpath = By.xpath("//*[@id='riskDetailsTabPanel']/table/tbody/tr[8]/td[2]/select");
	private By auxiliaryHeatingDropDownXpath = By
			.xpath("//*[@id='riskDetailsTabPanel']/table/tbody/tr[8]/td[4]/select");
	private By firehallDistanceLookupCodeDropdownId = By.id("firehallDistanceLookupCode");
	private By firehallDistanceLookupCodeBtnXpath = By.xpath("//input[@value='Remove Fire Protection Override']");
	private By primaryHeatingXpath = By
			.xpath("//td[@id='primaryHeatingLookupCodeLbl']/following-sibling::td[1]/child::select");
	private By auxiliaryHeatingXpath = By
			.xpath("//td[@id='auxiliaryHeatingLookupCodeLbl']/following-sibling::td[1]/child::select");
	private By constructionXpath = By
			.xpath("//td[@id='constructionLookupCodeLbl']/following-sibling::td[1]/child::select");

	private Button saveButton = new Button(saveButtonId);
	private Button firehallDistanceLookupCodeBtn = new Button(firehallDistanceLookupCodeBtnXpath);

	private CheckBox addHomeLocationCheckBox = new CheckBox(addHomeLocationCheckBoxId);

	private DropDown selectDaycareDropdown = new DropDown(dayCareInHouseDropdownId,
			riskDetailsTabPage.get("isdaycareinhouse"));
	private DropDown selectBusinessActivityDropdown = new DropDown(businessActivityOrLocDropdownId,
			riskDetailsTabPage.get("isbusinessatlocation"));
	private DropDown selectRiskTypeDropdown = new DropDown(riskTypeDropdownId, PRINCIPAL);

	private DropDown selectPrincipalResidenceDropdown = new DropDown(principalResidenceDropdownId,
			riskDetailsTabPage.get("isprincipleresidence"));
	private DropDown selectElectricalSystemDropdown = new DropDown(electricalSystemDropdownId,
			riskDetailsTabPage.get("electricalsystem"));
	private DropDown selectTabPlumbingSystemDropdown = new DropDown(plumbingSystemDropdownId,
			riskDetailsTabPage.get("plubmingsystem"));
	private DropDown selectPetFlagFieldDropdown = new DropDown(petFlagDropdownId,
			riskDetailsTabPage.get("isprincipleresidence"));
	private DropDown selectPetTypeDropdown = new DropDown(petTypeDropdownId, petBreed);
	private DropDown selectNumberOfFamiliesDropdown = new DropDown(numberOfFamiliesDropdownId,
			riskDetailsTabPage.get("numberoffamilies"));
	private DropDown selectNumberOfAdultsDropdown = new DropDown(numberOfAdultsDropdownId,
			riskDetailsTabPage.get("howmanyadults"));
	private DropDown selectNumberOfChildrenDropdown = new DropDown(numberOfChildrenDropdownId,
			riskDetailsTabPage.get("howmanychildren"));
	private DropDown selectNumberOfRoomersDropdown = new DropDown(numberOfRoomersDropdownId,
			riskDetailsTabPage.get("howmanyroomers"));
	private DropDown selectRentalUnitsDropdown = new DropDown(rentalUnitsDropdownId, NO_RENTAL);
	private DropDown selectCommercialOccupancyDropdown = new DropDown(commercialOccupancyDropdownId,
			riskDetailsTabPage.get("iscommercialoccupancy"));
	private DropDown selectDwellingTypeDropdown = new DropDown(dwellingTypeDropdownId,
			riskDetailsTabPage.get("dwellingtype"));
	private DropDown selectAlarmDropdown = new DropDown(alarmDropdownId, riskDetailsTabPage.get("alarm"));
	private DropDown changePetFlagFieldDropdown = new DropDown(petFlagDropdownId, riskDetailsTabPage.get("haveapet"));
	private DropDown selectHydrantDropdown = new DropDown(hydrantDropdownId, riskDetailsTabPage.get("hydrant"));
	private DropDown selectFirehallDropdown = new DropDown(firehallDropdownId, riskDetailsTabPage.get("firehall"));
	private DropDown selectPrimaryHeating = new DropDown(primaryHeatingXpath, PRIMARY_HEATING);
	private DropDown selectAuxiliaryHeating = new DropDown(auxiliaryHeatingXpath, AUXILIARY_HEATING);
	private DropDown selectConstruction = new DropDown(constructionXpath, CONSTRUCTION);
	private DropDown primaryHeatingDropDown = new DropDown(primaryHeatingDropDownXpath,
			PropertiesReader.readProperty("primaryHeating"));
	private DropDown auxiliaryHeatingDropDown = new DropDown(auxiliaryHeatingDropDownXpath,
			PropertiesReader.readProperty("auxHeating"));

	private DropDown firehallDistanceLookupCodeDropdown = new DropDown(firehallDistanceLookupCodeDropdownId,
			FIREHALL_OTHER_OPTION);
	private DropDown verifyHydrantEmpty = new DropDown(hydrantDropdownId, EMPTY);
	private DropDown verifyFirehallEmpty = new DropDown(firehallDropdownId, EMPTY);
	private DropDown verifySelectedHydrantOption = new DropDown(hydrantDropdownId, riskDetailsTabPage.get("hydrant"));
	private DropDown verifySelectedFirehallOption = new DropDown(firehallDropdownId,
			riskDetailsTabPage.get("firehall"));
	private DropDown verifyPetType = new DropDown(petTypeDropdownId);

	private TextBox verifyPolicyHomeText = new TextBox(msgboxId, MSG_BOX);
	private TextBox FireProtectionText = new TextBox(msgboxId, FIRE_PROTECTION);
	private TextBox verifyAttributeValueFireProtected = new TextBox(fireProtectedTextboxId,
			riskDetailsTabPage.get("fireprotection"), ATTRIBUTE_TYPE_VALUE);

	/**
	 * To fill all the required fields of Risk Details Tab TA- 3930
	 * 
	 */
	public void addRiskDetails() {
		logger.info(ADD_RISK_DETAILS);

		selectDaycareDropdown.selectValue();
		selectBusinessActivityDropdown.selectValue();
		selectRiskTypeDropdown.selectValue();
		selectPrincipalResidenceDropdown.selectValue();

		verifyHydrantEmpty.verifyFirstSelectedOption();
		verifyFirehallEmpty.verifyFirstSelectedOption();

		selectElectricalSystemDropdown.selectValue();
		selectTabPlumbingSystemDropdown.selectValue();
		selectPetFlagFieldDropdown.selectValue();
		selectPetTypeDropdown.selectValue();
		selectNumberOfFamiliesDropdown.selectValue();
		selectNumberOfAdultsDropdown.selectValue();
		selectNumberOfChildrenDropdown.selectValue();
		selectNumberOfRoomersDropdown.selectValue();
		selectRentalUnitsDropdown.selectValue();
		selectCommercialOccupancyDropdown.selectValue();
		selectDwellingTypeDropdown.selectValue();
		selectAlarmDropdown.selectValue();

		saveButton.clickAndWaitForProcessingBoxToDisappear();
		// Added sleep and clicking save button after this to remove the error
		// Please select hydrant and firehall
		try {
			Thread.sleep(10000);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

		saveButton.clickAndWaitForProcessingBoxToDisappear();
		saveButton.click();

		verifyPolicyHomeText.verifyText();
		verifySelectedHydrantOption.verifyFirstSelectedOption();
		verifySelectedFirehallOption.verifyFirstSelectedOption();
		verifyAttributeValueFireProtected.verifyTextByAttributeValue();

		changePetFlagFieldDropdown.selectValue();

		verifyPetType.verifyElementDisabled();

		// Added sleep since an unhandled application error message is displayed
		try {
			Thread.sleep(5000);
		} catch (InterruptedException exception) {
			logger.warn(exception);
		}
		saveButton.clickAndWaitForProcessingBoxToDisappear();

		verifyPolicyHomeText.verifyText();

	}

	/**
	 * To fill all the required fields of Risk Details Tab and Selecting Pet
	 * Dropdown as Yes TA- 3930
	 * 
	 */
	public void addRiskDetailsWithPetBinding() {

		logger.info(WITH_PET_BINDING);

		selectDaycareDropdown.selectValue();
		selectBusinessActivityDropdown.selectValue();
		selectRiskTypeDropdown.selectValue();
		selectPrincipalResidenceDropdown.selectValue();
		selectElectricalSystemDropdown.selectValue();
		selectTabPlumbingSystemDropdown.selectValue();
		selectPetFlagFieldDropdown.selectValue();
		selectPetTypeDropdown.selectValue();
		selectNumberOfFamiliesDropdown.selectValue();
		selectNumberOfAdultsDropdown.selectValue();
		selectNumberOfChildrenDropdown.selectValue();
		selectNumberOfRoomersDropdown.selectValue();
		selectRentalUnitsDropdown.selectValue();
		selectCommercialOccupancyDropdown.selectValue();
		selectDwellingTypeDropdown.selectValue();
		selectAlarmDropdown.selectValue();
		saveButton.clickAndWaitForProcessingBoxToDisappear();
		verifyPolicyHomeText.verifyText();
	}

	public void selectPrimaryHeating() {
		logger.info(SELECT_HEATING);

		browser.waitForVisibilityOfElement(primaryHeatingDropDown);
		selectConstruction.selectValue();
		primaryHeatingDropDown.selectValue();
		auxiliaryHeatingDropDown.selectValue();
	}

	/**
	 * To Select firehall Distance Lookup Code Dropdown
	 */
	public void selectfirehallDistanceLookupCodeDropdown() {
		logger.info(FIREHALL_DISTANCE);

		browser.waitForVisibilityOfElement(firehallDistanceLookupCodeDropdown);
		firehallDistanceLookupCodeDropdown.selectValue();
		saveButton.clickAndWaitForProcessingBoxToDisappear();
	}

	/**
	 * To fill all the required fields of a Condo asset TA- 3983
	 * 
	 */
	public void addRiskDetailsForCondoAssets() {
		logger.info(CONDO_ASSETS);

		selectDaycareDropdown.selectValue();
		selectBusinessActivityDropdown.selectValue();
		selectRiskTypeDropdown.selectValue();
		selectPrincipalResidenceDropdown.selectValue();
		selectHydrantDropdown.selectValue();
		selectFirehallDropdown.selectValue();
		selectElectricalSystemDropdown.selectValue();
		selectTabPlumbingSystemDropdown.selectValue();
		selectPetFlagFieldDropdown.selectValue();
		selectPetTypeDropdown.selectValue();
		selectNumberOfFamiliesDropdown.selectValue();
		selectNumberOfAdultsDropdown.selectValue();
		selectNumberOfChildrenDropdown.selectValue();
		selectNumberOfRoomersDropdown.selectValue();
		selectRentalUnitsDropdown.selectValue();
		selectCommercialOccupancyDropdown.selectValue();
		selectDwellingTypeDropdown.selectValue();
		selectAlarmDropdown.selectValue();

		saveButton.clickAndWaitForProcessingBoxToDisappear();

		selectConstruction.selectValue();
		selectPrimaryHeating.selectValue();
		selectAuxiliaryHeating.selectValue();

		saveButton.clickAndWaitForProcessingBoxToDisappear();

		verifyPolicyHomeText.verifyText();
	}

	/**
	 * To fill all the required fields of a Tenant asset TA- 3983
	 * 
	 */
	public void addRiskDetailsForTenantAssets() {
		logger.info(TENANTS_ASSETS);

		addRiskDetailsForCondoAssets();

	}

	/**
	 * To verify the Message
	 */
	public void verifyFireProtectionMessage() {
		logger.info(FIRE_PROTECTION_MESSAGE);

		FireProtectionText.verifyContainsText();
	}

	public void clickRemoveFireProtectionButton() {
		logger.info(REMOVE_FIRE_PROTECTION);

		browser.waitForVisibilityOfElement(firehallDistanceLookupCodeBtn);
		firehallDistanceLookupCodeBtn.clickAndWaitForProcessingBoxToDisappear();
	}

	/**
	 * To fill all the required fields for Second Assets and clicking Location
	 * 
	 */

	public void addRiskDetailsWithoutLocation() {
		logger.info(ADD_RISK_DETAILS_WITHOUT_LOCATION);

		selectDaycareDropdown.selectValue();
		addHomeLocationCheckBox.deSelectCheckbox();
		selectBusinessActivityDropdown.selectValue();
		selectRiskTypeDropdown.selectValue();
		selectPrincipalResidenceDropdown.selectValue();
		selectElectricalSystemDropdown.selectValue();
		selectTabPlumbingSystemDropdown.selectValue();
		changePetFlagFieldDropdown.selectValue();
		selectNumberOfFamiliesDropdown.selectValue();
		selectNumberOfAdultsDropdown.selectValue();
		selectNumberOfChildrenDropdown.selectValue();
		selectNumberOfRoomersDropdown.selectValue();
		selectRentalUnitsDropdown.selectValue();
		selectCommercialOccupancyDropdown.selectValue();
		selectDwellingTypeDropdown.selectValue();
		selectAlarmDropdown.selectValue();

		saveButton.clickAndAcceptAlertBtn();
		browser.waitForProcessingRequestBoxToDisappear();
		// Added sleep and clicking save button after this to remove the error
		// Please select hydrant and firehall
		try {
			Thread.sleep(10000);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
		saveButton.clickAndAcceptAlertBtn();
		browser.waitForProcessingRequestBoxToDisappear();

	}

}

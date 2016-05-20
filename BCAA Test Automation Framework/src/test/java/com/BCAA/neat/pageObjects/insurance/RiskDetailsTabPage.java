package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This Class fills all the required fields in RiskDetails Tab and verify the
 * required required fields which need to be verified
 * 
 * @author Optimus
 *
 */
public class RiskDetailsTabPage {
	Logger logger = Logger.getLogger(RiskDetailsTabPage.class);

	private final static String NO = "No";
	private final static String PRINCIPAL = "Principal";
	private final static String YES = "Yes";
	private final static String EMPTY = "";
	private final static String AMP_GREATER_200 = "200 amp or greater";
	private final static String COPPER = "Copper";
	private final static String petBreed = "Pit Bull or any 'bull' breed";
	private final static String value1 = "1";
	private final static String value0 = "0";
	private final static String NO_RENTAL = "No Rental Units";
	private final static String SINGLE_FAMILY = "Single family";
	private final static String NONE = "None";
	private final static String RISK_DETAIL = "Risk Details";
	private final static String MSG_BOX = "Policy Home Asset was saved successfully.";
	private final static String hydrantOption = "Within 300m by Road";
	private final static String firehallOption = "Within 8km by Road";
	private final static String protectedText = "Protected";
	private final static String ATTRIBUTE_TYPE_VALUE = "value";

	private By dayCareInHouseDropdownId = By.id("drpdwnRiskDetailsTabIsDaycareInHouseId");
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
	private By riskDetailTabOpenXpath = By.xpath("//li[@class='current']/a[@id='riskDetailsTab_lnk']");
	private By msgboxId = By.id("msgbox");
	private By fireProtectedTextboxId = By.id("fireProtectionLookupCode_id");
	private By quotePolicyheaderId = By.id("miniQuoteAndPolicyHeader");
	private By processingRequestBoxId = By.id("request_processing_layer_content");

	Button saveButton = new Button(saveButtonId);

	DropDown selectDaycareDropdown = new DropDown(dayCareInHouseDropdownId, NO);
	DropDown selectBusinessActivityDropdown = new DropDown(businessActivityOrLocDropdownId, NO);
	DropDown selectRiskTypeDropdown = new DropDown(riskTypeDropdownId, PRINCIPAL);
	DropDown selectPrincipalResidenceDropdown = new DropDown(principalResidenceDropdownId, YES);
	DropDown selectElectricalSystemDropdown = new DropDown(electricalSystemDropdownId, AMP_GREATER_200);
	DropDown selectTabPlumbingSystemDropdown = new DropDown(plumbingSystemDropdownId, COPPER);
	DropDown selectPetFlagFieldDropdown = new DropDown(petFlagDropdownId, YES);
	DropDown selectPetTypeDropdown = new DropDown(petTypeDropdownId, petBreed);
	DropDown selectNumberOfFamiliesDropdown = new DropDown(numberOfFamiliesDropdownId, value1);
	DropDown selectNumberOfAdultsDropdown = new DropDown(numberOfAdultsDropdownId, value1);
	DropDown selectNumberOfChildrenDropdown = new DropDown(numberOfChildrenDropdownId, value0);
	DropDown selectNumberOfRoomersDropdown = new DropDown(numberOfRoomersDropdownId, value0);
	DropDown selectRentalUnitsDropdown = new DropDown(rentalUnitsDropdownId, NO_RENTAL);
	DropDown selectCommercialOccupancyDropdown = new DropDown(commercialOccupancyDropdownId, NO);
	DropDown selectDwellingTypeDropdown = new DropDown(dwellingTypeDropdownId, SINGLE_FAMILY);
	DropDown selectAlarmDropdown = new DropDown(alarmDropdownId, NONE);
	DropDown changePetFlagFieldDropdown = new DropDown(petFlagDropdownId, NO);

	PageElement verifyRiskDetailTab = new PageElement(riskDetailTabOpenXpath, RISK_DETAIL);
	PageElement verifyHydrantEmpty = new PageElement(hydrantDropdownId, EMPTY);
	PageElement verifyFirehallEmpty = new PageElement(firehallDropdownId, EMPTY);
	PageElement verifyPolicyHomeText = new PageElement(msgboxId, MSG_BOX);
	PageElement verifySelectedHydrantOption = new PageElement(hydrantDropdownId, hydrantOption);
	PageElement verifySelectedFirehallOption = new PageElement(firehallDropdownId, firehallOption);
	PageElement verifyAttributeValueFireProtected = new PageElement(fireProtectedTextboxId, protectedText,
			ATTRIBUTE_TYPE_VALUE);
	PageElement verifyPetType = new PageElement(petTypeDropdownId);
	PageElement waitTillMsgVisible = new PageElement(msgboxId);
	PageElement waitTillSelectSaveButtonVisible = new PageElement(saveButtonId, null, InputType.BUTTON);
	PageElement processingRequest = new PageElement(processingRequestBoxId);

	/**
	 * To fill all the required fields of Risk Details Tab
	 * TA- 3930
	 * 
	 */
	public void addRiskDetails() {
		logger.info("Inside addRiskDetails method in RiskDetailsTabPage Class");

		Browser browser = new Browser();

		browser.verifyText(verifyRiskDetailTab);

		selectDaycareDropdown.selectValue();
		selectBusinessActivityDropdown.selectValue();
		selectRiskTypeDropdown.selectValue();
		selectPrincipalResidenceDropdown.selectValue();

		browser.verifyFirstSelectedOption(verifyHydrantEmpty);
		browser.verifyFirstSelectedOption(verifyFirehallEmpty);

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

		browser.waitForInvisibilityOfElement(processingRequest);

		saveButton.click();

		browser.verifyText(verifyPolicyHomeText);
		browser.verifyFirstSelectedOption(verifySelectedHydrantOption);
		browser.verifyFirstSelectedOption(verifySelectedFirehallOption);
		browser.verifyTextByAttributeValue(verifyAttributeValueFireProtected);

		changePetFlagFieldDropdown.selectValue();

		browser.verifyElementDisabled(verifyPetType);

		// Added sleep since an unhandled application error message is displayed
		try {
			Thread.sleep(Integer.parseInt(PropertiesReader.readProperty("sleep")));
		} catch (InterruptedException exception) {
			logger.warn(exception);
		}
		saveButton.click();

		browser.waitForInvisibilityOfText(processingRequest);
		browser.waitForVisibility(waitTillMsgVisible);

		browser.verifyText(verifyPolicyHomeText);

	}

}

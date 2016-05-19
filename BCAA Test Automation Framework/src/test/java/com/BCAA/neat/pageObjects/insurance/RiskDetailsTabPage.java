package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.DropDown;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

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

	PageElement verifyRiskDetailTab = new PageElement(riskDetailTabOpenXpath, RISK_DETAIL);
	PageElement selectDaycareDropdown = new PageElement(dayCareInHouseDropdownId, NO, InputType.DROPDOWN);
	PageElement selectBusinessActivityDropdown = new PageElement(businessActivityOrLocDropdownId, NO,
			InputType.DROPDOWN);
	PageElement selectRiskTypeDropdown = new PageElement(riskTypeDropdownId, PRINCIPAL, InputType.DROPDOWN);
	PageElement selectPrincipalResidenceDropdown = new PageElement(principalResidenceDropdownId, YES,
			InputType.DROPDOWN);
	PageElement verifyHydrantEmpty = new PageElement(hydrantDropdownId, EMPTY);
	PageElement verifyFirehallEmpty = new PageElement(firehallDropdownId, EMPTY);
	PageElement selectElectricalSystemDropdown = new PageElement(electricalSystemDropdownId, AMP_GREATER_200,
			InputType.DROPDOWN);
	PageElement selectTabPlumbingSystemDropdown = new PageElement(plumbingSystemDropdownId, COPPER, InputType.DROPDOWN);
	PageElement selectPetFlagFieldDropdown = new PageElement(petFlagDropdownId, YES, InputType.DROPDOWN);
	PageElement selectPetTypeDropdown = new PageElement(petTypeDropdownId, petBreed, InputType.DROPDOWN);
	PageElement selectNumberOfFamiliesDropdown = new PageElement(numberOfFamiliesDropdownId, value1,
			InputType.DROPDOWN);
	PageElement selectNumberOfAdultsDropdown = new PageElement(numberOfAdultsDropdownId, value1, InputType.DROPDOWN);
	PageElement selectNumberOfChildrenDropdown = new PageElement(numberOfChildrenDropdownId, value0,
			InputType.DROPDOWN);
	PageElement selectNumberOfRoomersDropdown = new PageElement(numberOfRoomersDropdownId, value0, InputType.DROPDOWN);
	PageElement selectRentalUnitsDropdown = new PageElement(rentalUnitsDropdownId, NO_RENTAL, InputType.DROPDOWN);
	PageElement selectCommercialOccupancyDropdown = new PageElement(commercialOccupancyDropdownId, NO,
			InputType.DROPDOWN);
	PageElement selectDwellingTypeDropdown = new PageElement(dwellingTypeDropdownId, SINGLE_FAMILY, InputType.DROPDOWN);
	PageElement selectAlarmDropdown = new PageElement(alarmDropdownId, NONE, InputType.DROPDOWN);
	PageElement saveButton = new PageElement(saveButtonId, null, InputType.BUTTON);
	PageElement verifyPolicyHomeText = new PageElement(msgboxId, MSG_BOX);
	PageElement verifySelectedHydrantOption = new PageElement(hydrantDropdownId, hydrantOption);
	PageElement verifySelectedFirehallOption = new PageElement(firehallDropdownId, firehallOption);
	PageElement verifyAttributeValueFireProtected = new PageElement(fireProtectedTextboxId, protectedText,
			ATTRIBUTE_TYPE_VALUE);
	PageElement changePetFlagFieldDropdown = new PageElement(petFlagDropdownId, NO, InputType.DROPDOWN);
	PageElement verifyPetType = new PageElement(petTypeDropdownId);
	PageElement waitTillMsgVisible = new PageElement(msgboxId);
	PageElement waitTillSelectSaveButtonVisible = new PageElement(saveButtonId, null, InputType.BUTTON);
	PageElement processingRequest = new PageElement(processingRequestBoxId, null);

	/**
	 * To fill all the required fields of Risk Details Tab
	 *
	 * 
	 */
	public void addRiskDetails() {
		logger.info("Inside addRiskDetails method in RiskDetailsTabPage Class");

		Browser browser = new Browser();
		Button button = new Button();
		DropDown dropDown = new DropDown();

		browser.verifyText(verifyRiskDetailTab);

		dropDown.selectValue(selectDaycareDropdown);
		dropDown.selectValue(selectBusinessActivityDropdown);
		dropDown.selectValue(selectRiskTypeDropdown);
		dropDown.selectValue(selectPrincipalResidenceDropdown);

		browser.verifyFirstSelectedOption(verifyHydrantEmpty);
		browser.verifyFirstSelectedOption(verifyFirehallEmpty);

		dropDown.selectValue(selectElectricalSystemDropdown);
		dropDown.selectValue(selectTabPlumbingSystemDropdown);
		dropDown.selectValue(selectPetFlagFieldDropdown);
		dropDown.selectValue(selectPetTypeDropdown);
		dropDown.selectValue(selectNumberOfFamiliesDropdown);
		dropDown.selectValue(selectNumberOfAdultsDropdown);
		dropDown.selectValue(selectNumberOfChildrenDropdown);
		dropDown.selectValue(selectNumberOfRoomersDropdown);
		dropDown.selectValue(selectRentalUnitsDropdown);
		dropDown.selectValue(selectCommercialOccupancyDropdown);
		dropDown.selectValue(selectDwellingTypeDropdown);
		dropDown.selectValue(selectAlarmDropdown);

		browser.waitForInvisibility(processingRequest);

		button.click(saveButton);

		browser.verifyText(verifyPolicyHomeText);
		browser.verifyFirstSelectedOption(verifySelectedHydrantOption);
		browser.verifyFirstSelectedOption(verifySelectedFirehallOption);
		browser.verifyTextByAttributeValue(verifyAttributeValueFireProtected);

		dropDown.selectValue(changePetFlagFieldDropdown);

		browser.verifyElementDisabled(verifyPetType);

		// Added sleep since an unhandled application error message is displayed
		try {
			Thread.sleep(3000);
		} catch (InterruptedException exception) {
			logger.info(exception);
		}
		button.click(saveButton);

		browser.waitForInvisibility(processingRequest);
		browser.waitForVisibility(waitTillMsgVisible);

		browser.verifyText(verifyPolicyHomeText);

	}

}

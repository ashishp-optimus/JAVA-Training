package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * 
 * @author Optimus
 *
 */
public class RiskDetailsTabPage {
	Logger logger = Logger.getLogger(RiskDetailsTabPage.class);
	Browser browser = new Browser();

	private final String NO = "No";
	private final String PRINCIPAL = "Principal";
	private final String YES = "Yes";
	private final String EMPTY = "";
	private final String AMP_GREATER_200 = "200 amp or greater";
	private final String COPPER = "Copper";
	private final String petBreed = "Pit Bull or any 'bull' breed";
	private final String value1 = "1";
	private final String value0 = "0";
	private final String NO_RENTAL = "No Rental Units";
	private final String SINGLE_FAMILY = "Single family";
	private final String NONE = "None";
	private final String RISK_DETAIL = "Risk Details";
	private final String MSG_BOX = "Policy Home Asset was saved successfully.";
	private final String hydrantOption = "Within 300m by Road";
	private final String firehallOption = "Within 8km by Road";
	private final String protectedText = "Protected";
	private final String ATTRIBUTE_TYPE_VALUE = "value";

	By dropDownDayCareInHouse = By.id("drpdwnRiskDetailsTabIsDaycareInHouseId");
	By dropDownBusinessActivityOrLoc = By.id("drpdwnRiskDetailsTabIsBusinessInLocationId");
	By riskType = By.id("drpdwnRiskDetailsTabRiskTypeId");
	By principalResidence = By.id("drpdwnRiskDetailsTabIsMemberLiveInResidenceId");
	By hydrant = By.id("hydrantDistanceLookupCode");
	By firehall = By.id("firehallDistanceLookupCode");
	By electricalSystem = By.id("drpdwnRiskDetailsTabElectricalSystemId");
	By tabPlumbingSystem = By.id("drpdwnRiskDetailsTabPlumbingSystemId");
	By petFlagField = By.id("petFlagField");
	By petType = By.id("petTypeLookupCodeField");
	By numberOfFamilies = By.id("drpdwnRiskDetailsTabNumberOfFamiliesId");
	By numberOfAdults = By.id("drpdwnRiskDetailsTabNumberOfAdultsId");
	By numberOfChildren = By.id("drpdwnRiskDetailsTabNumberOfChildrenId");
	By numberOfRoomers = By.id("drpdwnRiskDetailsTabNumberOfRoomersId");
	By rentalUnits = By.id("drpdwnRiskDetailsTabNumberOfRentalUnitsId");
	By commercialOccupancy = By.id("drpdwnRiskDetailsTabIsThereCommercialOccupancyId");
	By dwellingType = By.id("drpdwnRiskDetailsTabDwellingTypeId");
	By alarm = By.id("alarmLookupCode");
	By saveButton = By.id("btnRiskDetailsTabSaveId");
	By riskDetailTabOpen = By.xpath("//li[@class='current']/a[@id='riskDetailsTab_lnk']");
	By msgbox = By.id("msgbox");
	By fireProtected = By.id("fireProtectionLookupCode_id");
	By quotePolicyheader = By.id("miniQuoteAndPolicyHeader");
	By processingRequestBoxId = By.id("request_processing_layer_content");

	PageElement verifyRiskDetailTab = new PageElement(riskDetailTabOpen, RISK_DETAIL);
	PageElement dropdownSelectDaycare = new PageElement(dropDownDayCareInHouse, NO, InputType.DROPDOWN);
	PageElement dropdownSelectBusinessActivity = new PageElement(dropDownBusinessActivityOrLoc, NO, InputType.DROPDOWN);
	PageElement dropdownSelectRiskType = new PageElement(riskType, PRINCIPAL, InputType.DROPDOWN);
	PageElement dropdownSelectPrincipalResidence = new PageElement(principalResidence, YES, InputType.DROPDOWN);
	PageElement verifyHydrantEmpty = new PageElement(hydrant, EMPTY);
	PageElement verifyFirehallEmpty = new PageElement(firehall, EMPTY);
	PageElement dropdownSelectElectricalSystem = new PageElement(electricalSystem, AMP_GREATER_200, InputType.DROPDOWN);
	PageElement dropdownSelectTabPlumbingSystem = new PageElement(tabPlumbingSystem, COPPER, InputType.DROPDOWN);
	PageElement dropdownSelectPetFlagField = new PageElement(petFlagField, YES, InputType.DROPDOWN);
	PageElement dropdownSelectPetType = new PageElement(petType, petBreed, InputType.DROPDOWN);
	PageElement dropdownSelectNumberOfFamilies = new PageElement(numberOfFamilies, value1, InputType.DROPDOWN);
	PageElement dropdownSelectNumberOfAdults = new PageElement(numberOfAdults, value1, InputType.DROPDOWN);
	PageElement dropdownSelectNumberOfChildren = new PageElement(numberOfChildren, value0, InputType.DROPDOWN);
	PageElement dropdownSelectNumberOfRoomers = new PageElement(numberOfRoomers, value0, InputType.DROPDOWN);
	PageElement dropdownSelectRentalUnits = new PageElement(rentalUnits, NO_RENTAL, InputType.DROPDOWN);
	PageElement dropdownSelectCommercialOccupancy = new PageElement(commercialOccupancy, NO, InputType.DROPDOWN);
	PageElement dropdownSelectDwellingType = new PageElement(dwellingType, SINGLE_FAMILY, InputType.DROPDOWN);
	PageElement dropdownSelectAlarm = new PageElement(alarm, NONE, InputType.DROPDOWN);
	PageElement selectSaveButton = new PageElement(saveButton, null, InputType.BUTTON);
	PageElement verifyPolicyHomeText = new PageElement(msgbox, MSG_BOX);
	PageElement verifySelectedHydrantOption = new PageElement(hydrant, hydrantOption);
	PageElement verifySelectedFirehallOption = new PageElement(firehall, firehallOption);
	PageElement verifyAttributeValueFireProtected = new PageElement(fireProtected, protectedText, ATTRIBUTE_TYPE_VALUE);
	PageElement dropdownChangePetFlagField = new PageElement(petFlagField, NO, InputType.DROPDOWN);
	PageElement verifyPetType = new PageElement(petType);
	PageElement waitTillMsgVisible = new PageElement(msgbox);
	PageElement waitTillSelectSaveButtonVisible = new PageElement(saveButton, null, InputType.BUTTON);
	PageElement processingRequest = new PageElement(processingRequestBoxId,null);

	/**
	 * To fill all the required fields of Risk Details Tab for Home
	 *
	 * 
	 */
	public void addRiskDetails() {
		logger.info("Inside addRiskDetails method in RiskDetailsTabPage Class");
		browser.verifyText(verifyRiskDetailTab);
		browser.setElement(dropdownSelectDaycare);
		browser.setElement(dropdownSelectBusinessActivity);
		browser.setElement(dropdownSelectRiskType);
		browser.setElement(dropdownSelectPrincipalResidence);
		browser.verifyFirstSelectedOption(verifyHydrantEmpty);
		browser.verifyFirstSelectedOption(verifyFirehallEmpty);
		browser.setElement(dropdownSelectElectricalSystem);
		browser.setElement(dropdownSelectTabPlumbingSystem);
		browser.setElement(dropdownSelectPetFlagField);
		browser.setElement(dropdownSelectPetType);
		browser.setElement(dropdownSelectNumberOfFamilies);
		browser.setElement(dropdownSelectNumberOfAdults);
		browser.setElement(dropdownSelectNumberOfChildren);
		browser.setElement(dropdownSelectNumberOfRoomers);
		browser.setElement(dropdownSelectRentalUnits);
		browser.setElement(dropdownSelectCommercialOccupancy);
		browser.setElement(dropdownSelectDwellingType);
		browser.setElement(dropdownSelectAlarm);
		browser.waitForInvisibility(processingRequest);
		browser.setElement(selectSaveButton);
		browser.verifyText(verifyPolicyHomeText);
		browser.verifyFirstSelectedOption(verifySelectedHydrantOption);
		browser.verifyFirstSelectedOption(verifySelectedFirehallOption);
		browser.verifyTextByAttributeValue(verifyAttributeValueFireProtected);
		browser.setElement(dropdownChangePetFlagField);
		browser.verifyElementDisabled(verifyPetType);
		
		// Added sleep since an unhandled application error message is displayed
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser.setElement(selectSaveButton);
		browser.waitForInvisibility(processingRequest);
		browser.waitForVisibility(waitTillMsgVisible);
		browser.verifyText(verifyPolicyHomeText);

	}

}

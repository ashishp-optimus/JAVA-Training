package com.BCAA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BCAA.executor.BrowserFactory;
import com.BCAA.utils.InputType;
import com.BCAA.utils.PropertiesReader;

/**
 * 
 * @author Optimus
 *
 */
public class RiskDetails {

	private WebDriver driver;
	BrowserFactory browserFactory = new BrowserFactory();

	private final String NO = "No";
	private final String PRINCIPAL = "Principal";
	private final String YES = "Yes";
	private final String EMPTY = " ";
	private final String AMP_GREATER_200 = "200 amp or greater";
	private final String COPPER = "Copper";
	private final String petBreed= "Pit Bull or any 'bull' breed";
	private final String value1= "1";
	private final String value0= "0";
	private final String NO_RENTAL= "No Rental Units";
	private final String SINGLE_FAMILY = "Single family";
	private final String NONE = "None";

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
	By RentalUnits = By.id("drpdwnRiskDetailsTabNumberOfRentalUnitsId");
	By commercialOccupancy = By.id("drpdwnRiskDetailsTabIsThereCommercialOccupancyId");
	By dwellingType = By.id("drpdwnRiskDetailsTabDwellingTypeId");
	By alarm = By.id("alarmLookupCode");
	By saveButton = By.id("btnRiskDetailsTabSaveId");

	/**
	 * 
	 * @param locDriver
	 *            Getting WebDriver driver reference
	 */
	public RiskDetails(WebDriver locDriver) {
		this.driver = locDriver;
	}

	public WebDriver addRiskDetails() {
		driver = browserFactory.setElement(driver, dropDownDayCareInHouse, NO, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, dropDownBusinessActivityOrLoc, NO, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, riskType, PRINCIPAL, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, principalResidence, YES, InputType.DROPDOWN.getValue());
		driver = browserFactory.getText(driver, hydrant, EMPTY);
		driver = browserFactory.getText(driver, firehall, EMPTY);
		driver = browserFactory.setElement(driver, electricalSystem, AMP_GREATER_200, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, tabPlumbingSystem, COPPER, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, petFlagField, YES, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, petType, petBreed, InputType.DROPDOWN.getValue());		
		driver = browserFactory.setElement(driver, numberOfFamilies, value1, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, numberOfAdults, value1, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, numberOfChildren, value0, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, numberOfRoomers, value0, InputType.DROPDOWN.getValue());		
		driver = browserFactory.setElement(driver, RentalUnits, NO_RENTAL, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, commercialOccupancy, NO, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, dwellingType, SINGLE_FAMILY, InputType.DROPDOWN.getValue());		
		driver = browserFactory.setElement(driver, alarm, NONE, InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, saveButton, null, InputType.BUTTON.getValue());
		//TODO : verify
		driver = browserFactory.setElement(driver, saveButton, null, InputType.BUTTON.getValue());
		
		return driver;

	}

}

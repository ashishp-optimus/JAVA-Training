package com.BCAA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BCAA.executor.BrowserFactory;
import com.BCAA.utils.InputType;
import com.BCAA.utils.PropertiesReader;

public class HomeEvaluation {

	private WebDriver driver;
	private final String MB_STYLES = "1.5";
	private final String STOREY_NUMBER = "1.5";
	BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * 
	 * @param locDriver
	 */
	public HomeEvaluation(WebDriver locDriver) {
		this.driver = locDriver;
	}

	By homeEvaluationTab = By.id("homeEvaluationTab");
	By yearBuilt = By.id("yearBuiltHomeEval");
	By style = By.id("msbStyle");
	By numberOfStoreys = By.id("msbNumberOfStoreys");
	By findProperty = By.id("findPropertyButton");
	By finishedLivingArea = By.id("msbFinishedLivingArea");
	By populate = By.id("populateButton");
	By construction = By.id("msbConstruction");
	By calculateBuildingValue = By.id("btnHomeEvaluationTabCalculateBuildingValueId");
	By alertRCTDataStatus = By.id("yui-gen8-button");
	By saveButton = By.id("btnHomeEvaluationTabSaveId");
	By okButtonhome = By.id("btnAddHomeOkId");

	/**
	 * Navigate to home evaluation tab
	 */
	public void homeEvaluationTab() {
		driver = browserFactory.setElement(driver, homeEvaluationTab, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, yearBuilt, PropertiesReader.readProperty("yearbuilt"),
				InputType.TEXT_BOX.getValue());
		driver = browserFactory.setElement(driver, style, "MB_STYLES", InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, numberOfStoreys, "STOREY_NUMBER", InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, findProperty, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, finishedLivingArea,
				PropertiesReader.readProperty("finishedlivingarea"), InputType.TEXT_BOX.getValue());
		driver = browserFactory.setElement(driver, populate, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, construction, "concrete", InputType.DROPDOWN.getValue());
		driver = browserFactory.setElement(driver, calculateBuildingValue, null, InputType.BUTTON.getValue());
		driver = browserFactory.acceptAlertButton(driver, alertRCTDataStatus);
		driver = browserFactory.setElement(driver, saveButton, null, InputType.BUTTON.getValue());

	}
}

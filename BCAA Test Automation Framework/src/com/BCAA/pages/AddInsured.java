package com.BCAA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BCAA.executor.BrowserFactory;
import com.BCAA.utils.InputType;

public class AddInsured {

	private WebDriver driver;

	BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * @param locDriver
	 */
	public AddInsured(WebDriver locDriver) {
		this.driver = locDriver;
	}
	
	//To find the element locator from the web pages
	By selectPolicy =By.id("policyInsured_1_2");
	By retrieveClientMember = By.id("btnInsuredsTabRetrieveClientOrMemberId");
	By checkboxRetrieveClientMember = By.id("chkbxRetrieveClientOrMemberMember1Id");
	By btnRetreiveClientMember = By.id("btnRetrieveClientOrMemberOKId");
    
	/**
	 * Navigate to Retrieve Client/Member 
	 */
	public void addInsuredMember() {
		
		driver = browserFactory.setElement(driver, selectPolicy, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, retrieveClientMember, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, checkboxRetrieveClientMember, null, InputType.BUTTON.getValue());
		driver = browserFactory.setElement(driver, btnRetreiveClientMember, null, InputType.BUTTON.getValue());
	}
}
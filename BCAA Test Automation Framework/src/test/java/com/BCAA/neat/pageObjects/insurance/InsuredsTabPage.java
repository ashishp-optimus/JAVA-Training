package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;

public class InsuredsTabPage {
	Logger logger = Logger.getLogger(InsuredsTabPage.class);

	private By selectUserToEditId = By.id("policyInsured_1_2");
	private By insuredTabId = By.id("InsuredsTab_lnk");
	private By editBtnId = By.id("btnInsuredsTabEditId");
	private By retrieveClientMemberBtnId = By.id("btnInsuredsTabRetrieveClientOrMemberId");
	
	Button editBtn = new Button(editBtnId);
	Button selectUserToEdit = new Button(selectUserToEditId);
	Button insuredTab = new Button(insuredTabId);
	Button retrieveClientMemberBtn = new Button(retrieveClientMemberBtnId);


	/**
	 * To select edit Insured tab
	 */
	public void selectEditInsuredTab()
	{
		logger.info("Inside select edit insured tab method in InsuredsTabPage Class");
		selectUserToEdit.click();
		editBtn.click();
	}
	/**
	 * To select Add Insured Tab 
	 */
	public void selectAddInsuredTab()
	{
		logger.info("Inside select add insured tab method in InsuredsTabPage Class");
		selectUserToEdit.click();
		retrieveClientMemberBtn.click();
	}
}

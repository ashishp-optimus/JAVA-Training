package com.BCAA.neat.pageObjects.insurance;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.Table;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;

/**
 * This class is for Insureds tab page
 * 
 * @author Optimus
 */

public class InsuredsTabPage {
	Logger logger;
	Browser browser;

	DataBaseConnection dataBaseConnection = new DataBaseConnection();
	private Map<String, String> insuredsTabPage = dataBaseConnection.getDatabase()
			.getPageCollectionsAsMap("INSUREDSTABPAGE");

	public InsuredsTabPage() {
		logger = Logger.getLogger(InsuredsTabPage.class);
		browser = new Browser();
	}

	private final static String INSURED_MEMBER_KEY = "insuredmember";
	private final static String ADDITIONAL_INSURED_MEMBER_KEY = "additionalinsuredmember";

	private By selectUserToEditXpath = By.xpath("//div[@id='InsuredsTabPanel']/div/table/tbody/tr");
	private By editBtnId = By.id("btnInsuredsTabEditId");
	private By retrieveClientMemberBtnId = By.id("btnInsuredsTabRetrieveClientOrMemberId");
	private By selectPolicyInsuredId = By.id("policyInsured_2_1");
	private By deleteBtnId = By.id("btnInsuredsTabDeleteId");
	private By errorMsgBoxId = By.id("errorMsgBox");

	private Button editBtn = new Button(editBtnId);
	private Button retrieveClientMemberBtn = new Button(retrieveClientMemberBtnId);
	private Button deleteBtn = new Button(deleteBtnId);

	private TextBox errorMsgBox = new TextBox(errorMsgBoxId);

	private TextBox insuredMember = new TextBox(selectUserToEditXpath, insuredsTabPage.get(INSURED_MEMBER_KEY));
	private TextBox addtionalInsuredMember = new TextBox(selectPolicyInsuredId,
			insuredsTabPage.get(ADDITIONAL_INSURED_MEMBER_KEY));

	private Table selectInsuredToEdit = new Table(selectUserToEditXpath);
	private Table selectNewInsuredToEdit = new Table(selectUserToEditXpath, insuredsTabPage.get(INSURED_MEMBER_KEY));
	private Table selectDeleteInsured = new Table(selectUserToEditXpath,
			insuredsTabPage.get(ADDITIONAL_INSURED_MEMBER_KEY));

	/**
	 * To select edit Insured tab
	 */
	public void selectEditInsuredBtn() {
		logger.info("Inside select edit insured tab method in InsuredsTabPage Class");

		selectInsuredToEdit.selectFirstRow();
		editBtn.click();
	}

	/**
	 * To select Add Insured Tab
	 */
	public void selectAddInsuredTab() {
		logger.info("Inside select add insured tab method in InsuredsTabPage Class");

		selectInsuredToEdit.selectFirstRow();
		retrieveClientMemberBtn.click();
	}

	/**
	 * To verify edit Insured policy member number
	 */
	public void verifyEditInsured() {
		logger.info("verifyEditInsured method in InsuredsTabPage Class");

		insuredMember.verifyPolicyMember();

	}

	/**
	 * To verify additional insured policy member number
	 */
	public void verifyAddInsured() {
		logger.info("verifyAddInsured method in InsuredsTabPage Class");

		addtionalInsuredMember.verifyPolicyMember();

	}

	/**
	 * To Set Additional Insured As Primary Holder
	 */
	public void selectEditAdditionalInsured() {
		logger.info("Inside select add insured tab method in InsuredsTabPage Class");

		selectNewInsuredToEdit.selectRowByPartialText();
		editBtn.click();
	}

	public void selectDeleteBtn() {
		logger.info("Select Delete button under InsuredsTabPage Class");

		deleteBtn.click();
		errorMsgBox.waitUntilMsgBoxIsDisplayed();
	}

	/**
	 * To delete an insured policy member
	 */
	public void deleteInsuredBtn() {
		logger.info("Select Delete Insured button under InsuredsTabPage Class");

		deleteBtn.click();

		selectDeleteInsured.selectRowByPartialText();

		deleteBtn.clickAndAcceptAlertBtn();
		deleteBtn.click();

	}

	/**
	 * To Edit an insured policy member
	 */
	public void selectEditButton() {
		logger.info("Inside select edit button InsuredsTabPage Class");

		editBtn.click();
	}

}

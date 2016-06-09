package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.CheckBox;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;

/**
 * This class is for Add Insured page
 * 
 * @author Optimus
 */

public class AddInsuredPage {

	Logger logger;
	Browser browser;

	public AddInsuredPage() {
		logger = Logger.getLogger(AddInsuredPage.class);
		browser = new Browser();
	}

	private final static String RETREIVE_CLIENT_MEMBER = "Retrieve Client/Member";
	private final static String ADD_INSURED_MESSAGE = "Inside addInsured method in InsuredsTabPage Class";

	private By retrieveClientMemberCheckboxId = By.id("chkbxRetrieveClientOrMemberMember1Id");
	private By retreiveClientMemberOkButtonId = By.id("btnRetrieveClientOrMemberOKId");
	private By retreiveClientMemberPageTextXpath = By.xpath("//*[@id='findPolicyMember']/h2/span");

	private Button retreiveClientMemberOkBtn = new Button(retreiveClientMemberOkButtonId);

	private CheckBox checkRetrieveClientMember = new CheckBox(retrieveClientMemberCheckboxId);

	private TextBox retreiveClientMemberPageText = new TextBox(retreiveClientMemberPageTextXpath, RETREIVE_CLIENT_MEMBER);

	/**
	 * To add a new insured user under a policy
	 */
	public void addInsured() {
		logger.info(ADD_INSURED_MESSAGE);

		retreiveClientMemberPageText.verifyText();

		checkRetrieveClientMember.selectCheckbox();

		retreiveClientMemberOkBtn.clickAndWaitForProcessingBoxToDisappear();
	
	}

}

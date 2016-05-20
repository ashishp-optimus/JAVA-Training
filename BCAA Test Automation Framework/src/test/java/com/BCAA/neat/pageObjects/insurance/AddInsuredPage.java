package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.CheckBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

public class AddInsuredPage {

	Logger logger = Logger.getLogger(AddInsuredPage.class);

	private final static String INSURED_MEMBER_LIST = "Peterson Best, Ervian Shoei Western";
	private final static String RETREIVE_CLIENTMEMBER = "Retrieve Client/Member";

	private By selectUserToEditId = By.id("policyInsured_1_2");

	private By retrieveClientMemberCheckboxId = By.id("chkbxRetrieveClientOrMemberMember1Id");
	private By retreiveClientMemberOkButtonId = By.id("btnRetrieveClientOrMemberOKId");
	private By retreiveClientMemberPageTextXpath = By.xpath("//*[@id='findPolicyMember']/h2/span");

	Button selectUserToEdit = new Button(selectUserToEditId);
	Button retreiveClientMemberOk = new Button(retreiveClientMemberOkButtonId);

	CheckBox checkRetrieveClientMember = new CheckBox(retrieveClientMemberCheckboxId);
	PageElement retreiveClientMemberPageText = new PageElement(retreiveClientMemberPageTextXpath,
			RETREIVE_CLIENTMEMBER);
	PageElement insuredMember = new PageElement(selectUserToEditId, INSURED_MEMBER_LIST);

	/**
	 * To add a new insured user under a policy
	 */
	public void addInsured() {
		logger.info("Inside addInsured method in InsuredsTabPage Class");
		Browser browser = new Browser();
		browser.verifyText(retreiveClientMemberPageText);
		checkRetrieveClientMember.selectCheckbox();
		retreiveClientMemberOk.click();
		browser.verifyText(insuredMember);
	}

}

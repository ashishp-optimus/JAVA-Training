package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

/**
 * 
 * @author Optimus
 *
 */
public class RemarksTabPage {
	Logger logger = Logger.getLogger(RemarksTabPage.class);
	Browser browser = new Browser();

	private final static String DECLARATION_PAGE_Remarks = "Testing Declaration page remarks";
	private final static String POLICY_REMARKS_TEXT = "Policy Remark has been updated successfully.";

	
	private By areaRemarksTextboxId = By.id("txtareaRemarksTabRemarksId");
	private By saveBtnId = By.id("btnRemarksTabSaveId");
	private By msgboxId = By.id("msgbox");

	
	Button saveBtn = new Button(saveBtnId);

	PageElement verifyPolicyRemarksText = new PageElement(msgboxId, POLICY_REMARKS_TEXT);

	TextBox txtAreaRemarksTextbox = new TextBox(areaRemarksTextboxId, DECLARATION_PAGE_Remarks);

	/**
	 * To add remarks to a policy
	 *
	 */
	public void addRemarks() {
		logger.info("Inside addRemarks method in RemarksTabPage Class");

		txtAreaRemarksTextbox.enterTextInField();

		saveBtn.click();

		browser.verifyText(verifyPolicyRemarksText);

	}

}

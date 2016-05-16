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
public class RemarksTabPage {
	Logger logger = Logger.getLogger(RemarksTabPage.class);
	Browser browserFactory = new Browser();

	private final String DECLARATION_PAGE_Remarks = "Testing Declaration page remarks";
	private final String POLICY_REMARKS_TEXT = "Policy Remark has been updated successfully.";

	By remarksTab = By.id("RemarksTab");
	By txtAreaRemarks = By.id("txtareaRemarksTabRemarksId");
	By saveBtn = By.id("btnRemarksTabSaveId");
	By msgbox = By.id("msgbox");

	PageElement clickRemarksTab = new PageElement(remarksTab, null, InputType.BUTTON);
	PageElement enterTextIntxtAreaRemarks = new PageElement(txtAreaRemarks, DECLARATION_PAGE_Remarks,
			InputType.TEXT_BOX);
	PageElement clickSaveBtn = new PageElement(saveBtn, null, InputType.BUTTON);
	PageElement verifyPolicyRemarksText = new PageElement(msgbox, POLICY_REMARKS_TEXT);

	public void clickOnRemarksTab() {
		logger.info("Inside clickOnRemarksTab method in RemarksTabPage Class");
		browserFactory.setElement(clickRemarksTab);
	}

	/**
	 * To add remarks to a policy
	 *
	 */
	public void addRemarks() {
		logger.info("Inside addRemarks method in RemarksTabPage Class");
		browserFactory.setElement(enterTextIntxtAreaRemarks);
		browserFactory.setElement(clickSaveBtn);
		browserFactory.verifyText(verifyPolicyRemarksText);

	}

}

package com.BCAA.neat.pageObjects.insurance;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;

/**
 * This class is for Remarks Tab page
 * 
 * @author Optimus
 */
public class RemarksTabPage {
	Logger logger;
	Browser browser;
	
	DataBaseConnection dataBaseConnection = new DataBaseConnection();
	private Map<String, String> remarksTabPage = dataBaseConnection
			.getDatabase().getPageCollectionsAsMap("REMARKSTABPAGE");

	public RemarksTabPage() {
		logger = Logger.getLogger(RemarksTabPage.class);
		browser = new Browser();
	}

	private final static String DECLARATION_PAGE_REMARKS = "declarationpageremarks";
	private final static String POLICY_REMARKS_KEY = "remarksupdatedsuccessmsg";
	private final static String ADD_REMARKS="Inside addRemarks method in RemarksTabPage Class";

	private By areaRemarksTextboxId = By.id("txtareaRemarksTabRemarksId");
	private By saveBtnId = By.id("btnRemarksTabSaveId");
	private By msgboxId = By.id("msgbox");

	private Button saveBtn = new Button(saveBtnId);

	private TextBox verifyPolicyRemarksText = new TextBox(msgboxId,remarksTabPage.get(POLICY_REMARKS_KEY));
	private TextBox remarksText = new TextBox(areaRemarksTextboxId, remarksTabPage.get(DECLARATION_PAGE_REMARKS));

	/**
	 * To add remarks to a policy
	 *
	 */
	public void addRemarks() {
		logger.info(ADD_REMARKS);

		remarksText.enterTextInField();

		saveBtn.clickAndWaitForProcessingBoxToDisappear();

		verifyPolicyRemarksText.verifyText();
	}

}

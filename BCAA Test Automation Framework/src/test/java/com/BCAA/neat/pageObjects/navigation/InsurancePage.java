package com.BCAA.neat.pageObjects.navigation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

/**
 * This class is for Insurance tab page
 * 
 * @author Optimus
 */
public class InsurancePage {

	Logger logger;
	Browser browser;

	public InsurancePage() {
		logger = Logger.getLogger(HomePage.class);
		browser = new Browser();
	}

	private By quotesAndPolicies = By.linkText("Quotes and Policies");
	private final static String USER_NEATAM = "neatadm";
	private final static String NAVIGATE_TO_QUOTE_AND_POLICY = "Navigating to Quotes and Policies tab";
	private final static String LOGIN_AS_SOMEONE_WITH_BINDING = "Log in as someone with a binding stop authorization level of 5 ";
	private final static String VERIFY_OVERRIDE = "To verify that Override user is Signed out";
	private final static String VERIFY_OVERRIDE_SIGNED = "To verify that Override user is Signed In ";
	private final static String VERIFY_OVERRIDE_SIGNEDOUT = "Log in as someone with a binding stop authorization level of 5 ";

	private By userNameTextboxId = By.id("overrideUserId");
	private By tb_iframeContentId = By.id("TB_iframeContent");
	private By passwordTextboxId = By.id("overrideUserPassword");
	private By overrideSignInPopupBtnId = By.id("overrideLoginPopupLink");
	private By overrideUserSigninBtnId = By.id("overrideUserSigninBttn");
	private By overrideLogoutPopupLinkBtnId = By.id("overrideLogoutPopupLink");
	
	private Button selectQuotesAndPolicies = new Button(quotesAndPolicies);
	private Button overrideSignOutLinkBtn = new Button(
			overrideLogoutPopupLinkBtnId);
	private Button overrideSignOutPopupBtn = new Button(overrideSignInPopupBtnId);
	private Button overrideUserSigninBtn = new Button(overrideUserSigninBtnId);
	private Button overrideSignInLink = new Button(
			overrideLogoutPopupLinkBtnId);	
	
	private PageElement tb_iframeContent = new PageElement(tb_iframeContentId);

	private TextBox userNameTextbox = new TextBox(userNameTextboxId, USER_NEATAM);
	private TextBox passwordTextbox = new TextBox(passwordTextboxId, USER_NEATAM);
	private TextBox userName = new TextBox(userNameTextboxId);
	

	/**
	 * Navigating to Quotes and Policies tab
	 */

	public void goToQuotesAndPoliciesTab() {
		logger.info(NAVIGATE_TO_QUOTE_AND_POLICY);

		selectQuotesAndPolicies.click();
	}

	/**
	 * Log in as someone with a binding stop authorization level of 5
	 */
	public void overrideSignIn() {
		logger.info(LOGIN_AS_SOMEONE_WITH_BINDING);

		overrideSignOutPopupBtn.waitForVisibilityAndClick();
		browser.waitForVisibilityOfElement(tb_iframeContent);
		browser.switchToFrame(tb_iframeContent);
		userName.waitForVisibilityOfElement();
		userNameTextbox.enterTextInField();
		passwordTextbox.enterTextInField();
		overrideUserSigninBtn.click();
		browser.switchToDefaultFrame();		
	}

	/*
	 * 
	 * To verify that Override user is Signed out
	 */
	public void verifyOverrideUserSignOut() {
		logger.info(VERIFY_OVERRIDE);

		browser.waitForVisibilityOfElement(overrideSignOutPopupBtn);
		browser.verifyElementIsDisplayed(overrideSignOutPopupBtn);
	}

	/*
	 * 
	 * To verify that Override user is Signed In
	 */
	public void verifyOverrideUserSignIn() {
		logger.info(VERIFY_OVERRIDE_SIGNED);

		browser.waitForVisibilityOfElement(overrideSignOutPopupBtn);
		browser.verifyElementIsDisplayed(overrideSignInLink);
	}
	
	/**
	 * Log in as someone with a binding stop authorization level of 5
	 */
	public void overrideSignOut() {
		logger.info(VERIFY_OVERRIDE_SIGNEDOUT);

		overrideSignOutLinkBtn.waitForVisibilityAndClick();		
	}
	
	


}

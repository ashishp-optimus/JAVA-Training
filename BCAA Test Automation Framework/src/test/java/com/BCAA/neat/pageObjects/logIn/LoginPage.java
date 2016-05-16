package com.BCAA.neat.pageObjects.logIn;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is used for login
 *
 * @author Optimus
 */
public class LoginPage {
	Logger logger = Logger.getLogger(LoginPage.class);
	Browser browser = new Browser();

	By userNameFieldId = By.id("userNameField");
	By passwordFieldId = By.id("passwordField");
	By signInButtonId = By.id("btnSignInId");
	By logOutButtonId = By.id("btnSignOutId");

	PageElement userName = new PageElement(userNameFieldId, PropertiesReader.readProperty("userId"),
			InputType.TEXT_BOX);
	PageElement password = new PageElement(passwordFieldId, PropertiesReader.readProperty("password"),
			InputType.TEXT_BOX);
	PageElement logInButton = new PageElement(signInButtonId, null, InputType.BUTTON);
	PageElement logOutButton = new PageElement(logOutButtonId, null, InputType.BUTTON);

	/**
	 * This method is for sign into NEAT application
	 */
	public void signIn() {
		logger.info("Inside signIn method in LoginPage class");
		
		browser.setElement(userName);
		browser.setElement(password);
		browser.setElement(logInButton);
	}
	
	public void signOut(){
		logger.info("Inside signOut method in LoginPage class");
		
		browser.setElement(logOutButton);
	}
}

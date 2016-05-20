package com.BCAA.neat.pageObjects.logIn;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This class is used for login
 *
 * @author Optimus
 */
public class LoginPage {
	Logger logger = Logger.getLogger(LoginPage.class);
	Browser browser = new Browser();

	By userNameTextboxId = By.id("userNameField");
	By passwordTextboxId = By.id("passwordField");
	By signInButtonId = By.id("btnSignInId");
	By logOutButtonId = By.id("btnSignOutId");

	TextBox userNameTextbox = new TextBox(userNameTextboxId, PropertiesReader.readProperty("userId"));
	TextBox passwordTextbox = new TextBox(passwordTextboxId, PropertiesReader.readProperty("password"));

	Button logInButton = new Button(signInButtonId);
	Button logOutButton = new Button(logOutButtonId);

	/**
	 * This method is for sign into NEAT application
	 */
	public void signIn() {
		logger.info("Inside signIn method in LoginPage class");
		userNameTextbox.enterTextInField();
		passwordTextbox.enterTextInField();
		logInButton.click();
	}

	/**
	 * This method sign
	 */
	public void signOut() {
		logger.info("Inside signOut method in LoginPage class");

		logOutButton.click();
	}
}

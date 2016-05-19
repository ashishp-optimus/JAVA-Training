package com.BCAA.neat.pageObjects.logIn;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
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

	By userNameTextboxId = By.id("userNameField");
	By passwordTextboxId = By.id("passwordField");
	By signInButtonId = By.id("btnSignInId");
	By logOutButtonId = By.id("btnSignOutId");

	PageElement userNameTextbox = new PageElement(userNameTextboxId, PropertiesReader.readProperty("userId"),
			InputType.TEXT_BOX);
	PageElement passwordTextbox = new PageElement(passwordTextboxId, PropertiesReader.readProperty("password"),
			InputType.TEXT_BOX);
	PageElement logInButton = new PageElement(signInButtonId, null, InputType.BUTTON);
	PageElement logOutButton = new PageElement(logOutButtonId, null, InputType.BUTTON);

	/**
	 * This method is for sign into NEAT application
	 */
	public void signIn() {
		logger.info("Inside signIn method in LoginPage class");
		
		Button button = new Button();
		TextBox textBox = new TextBox();
		
		textBox.enterTextInField(userNameTextbox);
		textBox.enterTextInField(passwordTextbox);
		
		button.click(logInButton);
	
	}
	
	/**
	 * This method sign
	 */
	public void signOut(){
		logger.info("Inside signOut method in LoginPage class");
		
		Button button = new Button();
		
		button.click(logOutButton);
	}
}

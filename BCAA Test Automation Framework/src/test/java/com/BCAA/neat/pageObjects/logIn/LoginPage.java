package com.BCAA.neat.pageObjects.logIn;

import java.util.Map;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.utils.DataBaseConnection;

/**
 * This class is for Login page
 *
 * @author Optimus
 */
public class LoginPage {
	Logger logger;

	DataBaseConnection dataBaseConnection = new DataBaseConnection();
	private Map<String, String> defaultData = dataBaseConnection.getDatabase().getPageCollectionsAsMap("LOGINPAGE");
	
	public LoginPage() {
		logger = Logger.getLogger(LoginPage.class);
	}
	
	private By userNameTextboxId = By.id("userNameField");
	private By passwordTextboxId = By.id("passwordField");
	private By signInButtonId = By.id("btnSignInId");
	private By logOutButtonId = By.id("btnSignOutId");

	TextBox userNameTextbox = new TextBox(userNameTextboxId, defaultData.get("userid"));
	TextBox passwordTextbox = new TextBox(passwordTextboxId, defaultData.get("password"));	

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
}

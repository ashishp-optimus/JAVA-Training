package com.BCAA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BCAA.executor.BrowserFactory;
import com.BCAA.utils.InputType;
import com.BCAA.utils.PropertiesReader;

/**
 * This class is used for login
 * 
 * @author Optimus
 *
 */
public class LoginPage {

	private WebDriver driver;
	BrowserFactory browserFactory = new BrowserFactory();

	By userId = By.id("userNameField");
	By password = By.id("passwordField");
	By login = By.id("btnSignInId");

	/**
	 * 
	 * @param locDriver
	 *            Getting WebDriver driver reference
	 */
	public LoginPage(WebDriver locDriver) {
		this.driver = locDriver;
	}

	/**
	 * This method is for sign in to NEAT application
	 */
	public WebDriver signIn() {
		driver = browserFactory.setElement(driver, userId, PropertiesReader.readProperty("userId"),
				InputType.TEXT_BOX.getValue());
		driver = browserFactory.setElement(driver, password, PropertiesReader.readProperty("password"),
				InputType.TEXT_BOX.getValue());
		driver = browserFactory.setElement(driver, login, null, InputType.BUTTON.getValue());
		
		return driver;
	}
}

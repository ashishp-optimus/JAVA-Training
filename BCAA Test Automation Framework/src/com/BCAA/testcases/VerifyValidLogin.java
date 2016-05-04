package com.BCAA.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BCAA.executor.BrowserFactory;
import com.BCAA.pages.HomePage;
import com.BCAA.pages.InsurancePage;
import com.BCAA.pages.LoginPage;
import com.BCAA.pages.QuotesAndPoliciesPage;
import com.BCAA.pages.SelectInsurancePlanPage;

/**
 * 
 * This class verify the login page
 * 
 * @author Optimus
 */
public class VerifyValidLogin {

	private WebDriver driver;
	private BrowserFactory browserFactory;

	LoginPage loginPage;
	HomePage homePage = new HomePage(driver);
	InsurancePage insurancePage = new InsurancePage(driver);
	QuotesAndPoliciesPage quotesPage = new QuotesAndPoliciesPage(driver);
	SelectInsurancePlanPage selectInsurancePlan = new SelectInsurancePlanPage(driver);

	/**
	 * BeforeTest execute before each Test and it will open the browser and
	 * navigate to the given URL
	 */
	@BeforeMethod
	public void openBrowser() {
		browserFactory = new BrowserFactory();
		driver = browserFactory.startBrowser();
		browserFactory.navigateTo();
	}

	/**
	 * Test method to test valid user
	 */

	@Test
	public void checkValidUser() {
		loginPage = new LoginPage(driver);
		driver = loginPage.signIn();
		HomePage homePage = new HomePage(driver);
		driver = homePage.VerifyLogin();
	}

	/**
	 * Test method to create a new draft quote
	 * @throws InterruptedException 
	 */

	@Test
	public void createDraftQuote() {
		checkValidUser();
		homePage.selectInsurance();
		insurancePage.quotesAndPoliciesTab();
		quotesPage.createQuote();
		selectInsurancePlan.selectInsurancePlan();
	}

	/**
	 * AfterTest Execute after each Test and it close the browser
	 */
	@AfterMethod
	public void closeBrowser() {
		browserFactory.closeBrowser(driver);
	}
}

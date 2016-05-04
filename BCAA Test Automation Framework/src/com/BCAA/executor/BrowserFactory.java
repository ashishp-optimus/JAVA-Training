package com.BCAA.executor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BCAA.utils.InputType;
import com.BCAA.utils.PropertiesReader;

/**
 * 
 * @author Optimus
 *
 */
public class BrowserFactory extends PageElement {

	private WebDriver driver;
	private final String FIREFOX = "Firefox";
	private final String BROWSER_TYPE = "browserType";
	private final String CHROME = "chrome";
	private final String INTERNET_EXPLORER = "IE";

	public void setLocator(By locator) {
		this.locator = locator;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Opens a particular browser based on the data in config.properties
	 * 
	 * @return WebDriver driver reference
	 */
	public WebDriver startBrowser() {

		try {
			if (PropertiesReader.readProperty(BROWSER_TYPE).equalsIgnoreCase(FIREFOX)) {
				driver = new FirefoxDriver();
			} else if (PropertiesReader.readProperty(BROWSER_TYPE).equalsIgnoreCase(CHROME)) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Support Library\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (PropertiesReader.readProperty(BROWSER_TYPE).equalsIgnoreCase(INTERNET_EXPLORER)) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\Support Library\\IEDriverServer.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				driver = new InternetExplorerDriver(capabilities);
			}
		} catch (Exception exception) {
			// TODO: To create a custom class for handling exceptions
			exception.printStackTrace();
		}

		return driver;

	}

	/**
	 * Navigating to the particular URL based on the data in config.properties
	 */
	public void navigateTo() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			driver.get(PropertiesReader.readProperty("testsiteBaseURL"));
		} catch (Exception exception) {
			// TODO To create a custom class for handling exceptions
			exception.printStackTrace();
		}
	}

	/**
	 * 
	 * @param driver
	 *            Getting WebDriver reference
	 * @param locator
	 *            Contains locator name and its value
	 * @param text
	 *            Contains String value to be used as data
	 * @param type
	 *            Contains type of WebElement
	 * @return returning driver instance
	 */
	public WebDriver setElement(WebDriver driver, By locator, String text, String type) {

		this.driver = driver;
		this.setLocator(locator);
		this.setType(type);

		InputType inputType = InputType.getKey(type);

		// Method to handle intraction with WebElements
		switch (inputType) {
		case TEXT_BOX:
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
			break;
		case BUTTON:
			driver.findElement(locator).click();
			break;
		case DROPDOWN:
			new Select(driver.findElement(locator)).selectByVisibleText(text);
			break;
		case CHECK_CHECKBOX:
			if (!driver.findElement(locator).isSelected()) {
				driver.findElement(locator).click();
			}
			break;
		case UNCHECK_CHECKBOX:
			if (!driver.findElement(locator).isSelected()) {
				driver.findElement(locator).click();
			}
			break;
		case RADIOBUTTON:
			driver.findElement(locator).click();
			break;
		default:
			// TODO: To create a custom class for handling exceptions
		}

		return driver;
	}

	public WebDriver getText(WebDriver driver, By locator, String Expected) {
		try {
			String Actual = driver.findElement(locator).getText();
			if (Actual.equalsIgnoreCase(Expected)) {
				System.out.println("Redirection is successful. Text retrieved is " + Actual);
			}
		} catch (Exception exception) {
			// TODO: To create a custom class for handling exceptions
			exception.printStackTrace();
		}
		return driver;
	}

	public WebDriver acceptAlertButton(WebDriver driver, By locator) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return driver;
	}

	/**
	 * 
	 * @param driver
	 *            Getting WebDriver reference
	 * @param locator
	 *            Contains locator name and its value
	 */
	public WebDriver selectModule(WebDriver driver, By locator) {
		this.driver = driver;
		driver.findElement(locator).click();

		return driver;
	}

	public void waitForVisibility(WebDriver driver, By home) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(home));
		} catch (Exception exception) {
			// TODO need to be implemented
			exception.printStackTrace();
		}

	}

	/**
	 * Closing Browser
	 * 
	 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

}

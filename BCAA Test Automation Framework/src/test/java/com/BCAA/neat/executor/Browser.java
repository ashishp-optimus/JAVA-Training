package com.BCAA.neat.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.BCAA.neat.utils.PropertiesReader;

/**
 * 
 * @author Optimus
 *
 */
public class Browser {
	Logger logger = Logger.getLogger(Browser.class);

	public static WebDriver driver;
	private final String FIREFOX = "Firefox";
	private final String BROWSER_TYPE = "browserType";
	private final String CHROME = "chrome";
	private final String INTERNET_EXPLORER = "IE";

	/**
	 * Opens a particular browser based on the data in config.properties
	 * 
	 * @return WebDriver driver reference
	 */
	public void startBrowser() {

		try {
			if (PropertiesReader.readProperty(BROWSER_TYPE).equalsIgnoreCase(FIREFOX)) {
				driver = new FirefoxDriver();
				logger.info("Starting Firefox Browser");
			} else if (PropertiesReader.readProperty(BROWSER_TYPE).equalsIgnoreCase(CHROME)) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Support Library\\chromedriver.exe");
				driver = new ChromeDriver();
				logger.info("Starting Chrome Browser");
			} else if (PropertiesReader.readProperty(BROWSER_TYPE).equalsIgnoreCase(INTERNET_EXPLORER)) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\Support Library\\IEDriverServer.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability("ie.ensureCleanSession", true);
				driver = new InternetExplorerDriver(capabilities);
				logger.info("Starting Internet Explorer Browser");
			} else {
				logger.info("Please enter the valid browser name");
				Assert.fail();
			}
		} catch (Exception exception) {
			logger.warn(exception);
		}

	}

	/**
	 * Navigating to the particular URL based on the data in config.properties
	 */
	public void navigateTo() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			// TODO:: use a variable for url
			driver.get(PropertiesReader.readProperty("testsiteBaseURL"));
			logger.info("Opening URL: " + PropertiesReader.readProperty("testsiteBaseURL"));
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
		}
	}

	/**
	 * 
	 * @param pageElement
	 *            contains locator and input value
	 */
	public void setElement(PageElement pageElement) {
		try {
			switch (pageElement.getElementType()) {
			case TEXT_BOX:
				driver.findElement(pageElement.getLocatorType()).click();
				driver.findElement(pageElement.getLocatorType()).clear();
				driver.findElement(pageElement.getLocatorType()).sendKeys(pageElement.getInValue());
				logger.info("Entering text into TextBox: " + pageElement.getInValue());
				break;
			case BUTTON:
				driver.findElement(pageElement.getLocatorType()).click();
				logger.info("Clicking on button");
				break;
			case DROPDOWN:
				logger.info("Selecting DropDown Value: " + pageElement.getInValue());
				new Select(driver.findElement(pageElement.getLocatorType()))
						.selectByVisibleText(pageElement.getInValue());

				break;
			case CHECK_CHECKBOX:
				if (!driver.findElement(pageElement.getLocatorType()).isSelected()) {
					driver.findElement(pageElement.getLocatorType()).click();
					logger.info("Checking the CheckBox");
				}
				logger.info("CheckBox is already checked");
				break;
			case UNCHECK_CHECKBOX:
				if (driver.findElement(pageElement.getLocatorType()).isSelected()) {
					driver.findElement(pageElement.getLocatorType()).click();
					logger.info("UnChecking the CheckBox");
				}
				logger.info("CheckBox is already unchecked");
				break;
			case RADIOBUTTON:
				driver.findElement(pageElement.getLocatorType()).click();
				logger.info("Clicking on Radio button");
				break;
			default:
				logger.info("Please input valid element type: " + pageElement.getElementType());
			}
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
		}

	}

	/**
	 * @param pageElement
	 *            Contains locator, input value. Sets it to the output value and
	 *            then retrieve the outValue
	 */

	public void verifyText(PageElement pageElement) {
		try {
			String actual = driver.findElement(pageElement.getLocatorType()).getText().trim();
			pageElement.setOutValue(actual);
			logger.info("actual value is: " + pageElement.getOutValue());
			logger.info("expected value is: " + pageElement.getInValue().trim());
			Assert.assertEquals(pageElement.getOutValue(), pageElement.getInValue().trim());
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}
	}

	/**
	 * 
	 * @param pageElementObj
	 */
	// TODO :: change the argument name.
	public void waitForVisibility(PageElement pageElementObj) {
		try {
			WebDriverWait waitFor = new WebDriverWait(driver, Integer.parseInt(PropertiesReader.readProperty("wait")));
			waitFor.until(ExpectedConditions.visibilityOfElementLocated(pageElementObj.getLocatorType()));
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}

	}

	public void waitForInvisibility(PageElement pageElementObj) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(PropertiesReader.readProperty("wait")));
			wait.until(ExpectedConditions.invisibilityOfElementWithText(pageElementObj.getLocatorType(),
					pageElementObj.getInValue()));
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}

	}

	public void switchToFrame(PageElement pageElementObj) {
		try {
			String frame = driver.findElement(pageElementObj.getLocatorType()).toString();
			driver.switchTo().frame(frame);
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
		}

	}

	public void waitUntilTextIsPresent(PageElement pageElementObj) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(PropertiesReader.readProperty("wait")));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(pageElementObj.getLocatorType(),
					pageElementObj.getInValue()));

		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}

	}

	public void acceptAlertButton() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}
	}

	/**
	 * @param pageElementObj
	 *            Contains locator
	 * @return PageElement object with the output value of the retrieved text
	 */

	public PageElement getText(PageElement pageElementObj) {
		String retrievedText;
		try {
			retrievedText = driver.findElement(pageElementObj.getLocatorType()).getText().toString().trim();
			pageElementObj.setOutValue(retrievedText);
			logger.info("Retrieved value is: " + pageElementObj.getOutValue());

		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}
		return pageElementObj;
	}

	/**
	 * To get text of an element by desired attribute (value, href, name, etc)
	 * 
	 * @param pageElementObj
	 *            Contains locator
	 * @return PageElement object with the output value of the retrieved text
	 */
	public PageElement getTextByAttribute(PageElement pageElementObj) {
		try {
			String retrievedText = driver.findElement(pageElementObj.getLocatorType())
					.getAttribute(pageElementObj.getInValue());
			pageElementObj.setOutValue(retrievedText.trim());
			logger.info(pageElementObj.getOutValue());

		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}
		return pageElementObj;
	}

	/**
	 * To wait till an element is visible
	 * 
	 * @param pageElementObj
	 *            Page element to be verified
	 * 
	 */

	public void waitTillElementIsClickable(PageElement pageElementObj) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(PropertiesReader.readProperty("wait")));
			wait.until(ExpectedConditions.elementToBeClickable(pageElementObj.getLocatorType()));
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}
	}

	/**
	 * 
	 * @param pageElementObj
	 *            Contains locator and expected value as inValue
	 */
	public void verifyFirstSelectedOption(PageElement pageElementObj) {
		try {

			String actual = new Select(driver.findElement(pageElementObj.getLocatorType())).getFirstSelectedOption()
					.getText();
			pageElementObj.setOutValue(actual.trim());

			logger.info("Expected is: " + pageElementObj.getInValue().trim());
			logger.info("Actual is: " + pageElementObj.getOutValue());

			Assert.assertEquals(pageElementObj.getOutValue(), pageElementObj.getInValue().trim());
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}
	}

	/**
	 * 
	 * @param pageElementObj
	 *            contains locator, AttributeValue(HTML attribute
	 *            value,name,href etc) and inValue
	 */
	public void verifyTextByAttributeValue(PageElement pageElementObj) {
		try {
			String actual = driver.findElement(pageElementObj.getLocatorType())
					.getAttribute(pageElementObj.getAttributeType());
			pageElementObj.setOutValue(actual.trim());
			logger.info("Expected is: " + pageElementObj.getInValue().trim());
			logger.info("Actual is: " + pageElementObj.getOutValue());
			Assert.assertEquals(pageElementObj.getOutValue(), pageElementObj.getInValue().trim());
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}

	}

	/**
	 * To retrieve the Quote/Policy number from a draft policy
	 * 
	 * @return actualQuoteNumber[0] Quote Number
	 */

	public PageElement retreiveQuote(PageElement pageElementObj) {
		String[] retreivequote = null;
		try {
			pageElementObj.setOutValue(driver.findElement(pageElementObj.getLocatorType()).getText());
			retreivequote = pageElementObj.getOutValue().split(" ");
			logger.info("Actual quote number is: " + retreivequote[0]);
			pageElementObj.setOutValue(retreivequote[0].trim());
		} catch (Exception exception) {
			logger.warn(exception);

		}
		return pageElementObj;
	}

	/**
	 * To verify an element is disabled
	 * 
	 * @param pageElementObj
	 *            Page element to be verified
	 */

	public void verifyElementDisabled(PageElement pageElementObj) {
		try {
			logger.info("Verify if the element is Disable");
			Assert.assertEquals(false, driver.findElement(pageElementObj.getLocatorType()).isEnabled());
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}
	}

	/**
	 * To verify premium is not null under Premium column
	 * 
	 * @param pageElementObj
	 *            Page element to be verified
	 */

	public void verifyPremium(PageElement pageElementObj) {
		logger.info("Inside removePolicyWithNoPremium method in OptionsTabPage Class");
		List<WebElement> Element = new ArrayList<WebElement>();
		try {

			Element = driver.findElements(pageElementObj.getLocatorType());
			for (int counter = 0; counter < Element.size(); counter++) {

				String text = Element.get(counter).getText();
				logger.info("text is: " + text);
				Assert.assertNotEquals(text, pageElementObj.getInValue());
			}

		} catch (Exception exception) {
			logger.info(exception);
			Assert.fail();
		}

	}

	/**
	 * 
	 * @param pageElementObj
	 */
	public void verifyTextIsNotNull(PageElement pageElementObj) {
		logger.info("Verifying text is not null");
		String retrievedText = driver.findElement(pageElementObj.getLocatorType()).getText().toString();
		try {
			Assert.assertNotNull(retrievedText);
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}
	}

	/**
	 * 
	 * @param pageElementObj
	 * @return
	 */
	public PageElement verifyAttributeValueNotNull(PageElement pageElementObj) {
		try {

			String retrievedText = driver.findElement(pageElementObj.getLocatorType())
					.getAttribute(pageElementObj.getInValue());
			logger.info("Retrieved value: " + retrievedText);

			Assert.assertNotNull(retrievedText);
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();

		}
		return pageElementObj;
	}

	public void closeBrowser() {
		driver.quit();
	}

}

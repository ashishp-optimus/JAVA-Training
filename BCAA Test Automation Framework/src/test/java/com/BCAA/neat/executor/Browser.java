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
			//TODO:: use a variable for url
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
	 * contains locator and input value
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
				new Select(driver.findElement(pageElement.getLocatorType())).selectByVisibleText(pageElement.getInValue());
				logger.info("Selecting DropDown Value: " + pageElement.getInValue());
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
	//TODO:: remove print stack trace if already logged
			exception.printStackTrace();
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
			exception.printStackTrace();
		}
	}
    
	/**
	 * 
	 * @param object
	 */
	//TODO :: change the argument name.
	public void waitForVisibility(PageElement object) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(object.getLocatorType()));
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
			exception.printStackTrace();
		}

	}

	public void waitForInvisibility(PageElement object) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementWithText(object.getLocatorType(), object.getInValue()));
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
			exception.printStackTrace();
		}

	}
	
	public void switchToFrame(PageElement object) {
		try {
			String frame = driver.findElement(object.getLocatorType()).toString();
			driver.switchTo().frame(frame);
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
			exception.printStackTrace();
		}

	}
	
	public void waitUntilTextIsPresent(PageElement object) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(object.getLocatorType(), object.getInValue()));
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
			exception.printStackTrace();
		}

	}

	public void acceptAlertButton() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
			exception.printStackTrace();
		}
	}

	/**
	 * @param object
	 *            Contains locator
	 * @return PageElement object with the output value of the retrieved text
	 */

	public PageElement getText(PageElement object) {
		String retrievedText;
		try {
			retrievedText = driver.findElement(object.getLocatorType()).getText().toString().trim();
			object.setOutValue(retrievedText);
			logger.info("Retrieved value is: " + object.getOutValue());

		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
			exception.printStackTrace();
		}
		return object;
	}

	/**
	 * To get text of an element by desired attribute (value, href, name, etc)
	 * 
	 * @param object
	 *            Contains locator
	 * @return PageElement object with the output value of the retrieved text
	 */
	public PageElement getTextByAttribute(PageElement object) {
		try {
			String retrievedText = 
					driver.findElement(object.getLocatorType()).getAttribute(object.getInValue());
			object.setOutValue(retrievedText.trim());
			logger.info(object.getOutValue());
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
			exception.printStackTrace();
		}
		return object;
	}

	/**
	 * To wait till an element is visible
	 * 
	 * @param object
	 *            Page element to be verified
	 * 
	 */

	public void waitTillElementIsClickable(PageElement object) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(object.getLocatorType()));
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
			exception.printStackTrace();
		}
	}

	/**
	 * 
	 * @param object
	 *            Contains locator and expected value as inValue
	 */
	public void verifyFirstSelectedOption(PageElement object) {
		try {
			String actual = 
					new Select(driver.findElement(object.getLocatorType())).getFirstSelectedOption().getText();
			object.setOutValue(actual.trim());
			
			logger.info("Expected is: " + object.getInValue().trim());
			logger.info("Actual is: " + object.getOutValue());
			
			Assert.assertEquals(object.getOutValue(), object.getInValue().trim());
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
			exception.printStackTrace();
		}
	}

	/**
	 * 
	 * @param object
	 *            contains locator, AttributeValue(HTML attribute
	 *            value,name,href etc) and inValue
	 */
	public void verifyTextByAttributeValue(PageElement object) {
		try {
			String actual = driver.findElement(object.getLocatorType()).getAttribute(object.getAttributeType());
			object.setOutValue(actual.trim());
			logger.info("Expected is: " + object.getInValue().trim());
			logger.info("Actual is: " + object.getOutValue());
			Assert.assertEquals(object.getOutValue(), object.getInValue().trim());
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
			exception.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param pageElementObj
	 * 
	 */
	
	public String retreiveQuote(PageElement pageElementObj)
	{
		String[] Retreivequote = null;
		pageElementObj.setOutValue(driver.findElement(pageElementObj.getLocatorType()).getText());
		Retreivequote = pageElementObj.getOutValue().split(" ");
		logger.info("Actual quote number is: " + Retreivequote[0]);
		return Retreivequote[0];
	}

	/**
	 * To verify an element is disabled
	 * 
	 * @param object
	 *            Page element to be verified
	 */

	public void verifyElementDisabled(PageElement object) {
		try {
			logger.info("Verify if the element is Disable");
			Assert.assertEquals(false, driver.findElement(object.getLocatorType()).isEnabled());
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail();
			exception.printStackTrace();
		}
	}
	
	/**
	 * To verify premium is not null under Premium column
	 * 
	 * @param option
	 *            Page element to be verified
	 */

	
	public void verifyPremium(PageElement option) {
		logger.info("Inside removePolicyWithNoPremium method in OptionsTabPage Class");
		List <WebElement> Element = new ArrayList<WebElement>();
		try {
			Element =  driver.findElements(option.getLocatorType());
			for(int counter=0;counter<Element.size();counter++){
				String text = Element.get(counter).getText();
				logger.info("text is: "+text);
				Assert.assertNotEquals(text, option.getInValue());
			}
			
		}catch (Exception exception) {
			logger.info(exception);
			Assert.fail();
		}
		
	}

	public void closeBrowser() {
		driver.quit();
	}
	
	

}

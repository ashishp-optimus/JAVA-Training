package com.BCAA.neat.executor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.utils.PropertiesReader;

/**
 * This is the class to initialize the browser and to define common
 * verification/assertion methods
 * 
 * @author Optimus
 *
 */
public class Browser {
	static Logger logger = Logger.getLogger(Browser.class);

	public static WebDriver driver;
	private final String FIREFOX = "Firefox";
	private final String BROWSER_TYPE = "browserType";
	private final String CHROME = "Chrome";
	private final String INTERNET_EXPLORER = "IE";
	private final String STARTING_FIREFOX = "Starting Firefox browser";
	private final String STARTING_CHROME = "Starting Chrome browser";
	private final String STARTING_INTERNET_EXPLORER = "Starting Internet Explorer browser";
	private final String INVALID_BROWSER_NAME = "Please enter a valid browser name. Currently only Firefox, Chrome and IE are supported";
	private final String ASSERT_FAIL_MESSAGE = "FAILED due to: ";
	private final String OPENING_URL = "Opening URL: ";
	private final String URL_VALUE = "URL";
	private final String ENTERING_TEXT = "Entering text into TextBox: ";
	private final String CLICKING_BUTTON = "Clicking on button";
	private final String SELECTING_DROPOWN_VALUE = "Selecting DropDown Value: ";
	private final String CHECK_CHECKBOX = "Checking the CheckBox";
	private final String CHECK_BOX_ALREADY_CHECKED = "CheckBox is already checked";
	private final String UNCHECK_CHECKBOX = "Unchecking the CheckBox";
	private final String CHECKBOX_ALREADY_UNCHECKED = "CheckBox is already unchecked";
	private final String CLICKING_RADIO_BUTTON = "Clicking on Radio button";
	private final String INVALID_INPUT_TYPE = "Please input valid element type: ";
	private final String ACTUAL_VALUE = "Actual value is: ";
	private final String EXPECTED_VALUE = "Expected value is: ";
	private final String VERIFY_LOCATOR_MESSAGE = "Verify the locator is present";
	private final String WAIT_PROPERTY = "wait";
	private final String PROCESSING_BOX = "request_processing_layer_content";
	private final String SWITCHING_WINDOW = "Switching to other window and closing it";
	private final String RETRIEVED_VALUE = "Retrieved value is: ";
	private final String ELEMENT_IS_DISABLED = "Verify if the element is disabled";
	private final String VERIFY_PREMIUMS = "Verifying premium values on Options tab page";
	private final String PREMIUM_VALUE = "Premium value is: ";
	private final String VERIFY_TEXT_IS_NOT_NULL = "Verifying text is not null";
	private final String VERIFY_TEXT = "Verifying the text";
	private final String WAIT_FOR_VISIBLITY = "Waiting for element to be visible";
	private final String WAIT_FOR_TEXT_INVISIBLITY = "Waiting for text to be invisible";
	private final String WAIT_FOR_PROCCESSING_BOX_TO_DISAPPEAR = "Waiting for request processing box to disappear";
	private final String WAIT_FOR_TEXT = "Waiting until particular text is present";
	private final String WAIT_TILL_CLICKABLE = "Waiting for an element to be clickable";
	private final String SWITCH_FRAME = "Switching to a frame within the page";
	private final String ACCEPT_ALERT = "Accepting windows alert box";
	private final String GET_TEXT = "Getting text from a particular field";
	private final String TEXT_BY_ATTRIBUTE = "Getting text by a particular attribute";
	private final String VERIFY_SELECTED_OPTION = "Verifying the first selected option of a dropdown";
	private final String VERIFY_TEXT_BY_ATTRIBUTE = "Verifying text by a particular attribute";
	private final String VERIFY_ATTRIBUTE_VALUE_NOT_NULL = "Verify the value retrieved by attribute is not null";
	private final String RETRIEVE_QUOTE = "Retrieving quote value";
	private final String CLOSE_BROWSER = "Closing the browser";
	private final String WAIT_FOR_INVISIBLITY = "Waiting for element to be invisible";
	private final String CAPTURE_SCREENSHOT = "Capturing screenshot for method: ";
	private final String ALERT_MESSAGE = "Alert is not present";
	
	private WebDriverWait wait;

	/**
	 * Opens a particular browser based on the data in config.properties
	 * 
	 * @return WebDriver driver reference
	 */
	public void startBrowser() {

		try {
			if (PropertiesReader.readProperty(BROWSER_TYPE).equalsIgnoreCase(
					FIREFOX)) {
				// created firefox instance
				driver = new FirefoxDriver();
				logger.info(STARTING_FIREFOX);
			} else if (PropertiesReader.readProperty(BROWSER_TYPE)
					.equalsIgnoreCase(CHROME)) {
				// created chrome instance
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")
								+ "\\Support Library\\chromedriver.exe");
				driver = new ChromeDriver();
				logger.info(STARTING_CHROME);
			} else if (PropertiesReader.readProperty(BROWSER_TYPE)
					.equalsIgnoreCase(INTERNET_EXPLORER)) {
				// created Internet Explorer instance
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir")
								+ "\\Support Library\\IEDriverServer.exe");
				DesiredCapabilities capabilities = DesiredCapabilities
						.internetExplorer();
				capabilities.setCapability("ie.ensureCleanSession", true);
				driver = new InternetExplorerDriver(capabilities);
				logger.info(STARTING_INTERNET_EXPLORER);
			} else {
				logger.warn(INVALID_BROWSER_NAME);
				Assert.fail(INVALID_BROWSER_NAME);
			}
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * Navigating to the particular URL based on the data in config.properties
	 */
	public void navigateTo() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try {
			logger.info(OPENING_URL + PropertiesReader.readProperty(URL_VALUE));
			driver.get(PropertiesReader.readProperty(URL_VALUE));
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
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
				logger.info(ENTERING_TEXT + pageElement.getInValue());
				wait = new WebDriverWait(driver,
						Integer.parseInt(PropertiesReader
								.readProperty(WAIT_PROPERTY)));
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(pageElement.getLocatorType()));
				driver.findElement(pageElement.getLocatorType()).click();
				driver.findElement(pageElement.getLocatorType()).clear();
				driver.findElement(pageElement.getLocatorType()).sendKeys(
						pageElement.getInValue());
				break;
			case BUTTON:
				logger.info(CLICKING_BUTTON);
				wait = new WebDriverWait(driver,
						Integer.parseInt(PropertiesReader
								.readProperty(WAIT_PROPERTY)));
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(pageElement.getLocatorType()));
				wait.until(ExpectedConditions.elementToBeClickable(pageElement
						.getLocatorType()));
				driver.findElement(pageElement.getLocatorType()).click();
				break;
			case DROPDOWN:
				logger.info(SELECTING_DROPOWN_VALUE + pageElement.getInValue());
				wait = new WebDriverWait(driver,
						Integer.parseInt(PropertiesReader
								.readProperty(WAIT_PROPERTY)));
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(pageElement.getLocatorType()));
				wait.until(ExpectedConditions.elementToBeClickable(pageElement
						.getLocatorType()));
				new Select(driver.findElement(pageElement.getLocatorType()))
						.selectByVisibleText(pageElement.getInValue());
				break;
			case CHECK_CHECKBOX:
				if (!driver.findElement(pageElement.getLocatorType())
						.isSelected()) {
					logger.info(CHECK_CHECKBOX);
					driver.findElement(pageElement.getLocatorType()).click();
				}
				logger.info(CHECK_BOX_ALREADY_CHECKED);
				break;

			case UNCHECK_CHECKBOX:
				if (driver.findElement((pageElement.getLocatorType()))
						.getAttribute("checked").equals("true")) {
					logger.info(UNCHECK_CHECKBOX);
					driver.findElement(pageElement.getLocatorType()).click();
				}
				logger.info(CHECKBOX_ALREADY_UNCHECKED);
				break;
			case RADIOBUTTON:
				logger.info(CLICKING_RADIO_BUTTON);
				driver.findElement(pageElement.getLocatorType()).click();
				break;
			default:
				logger.info(INVALID_INPUT_TYPE + pageElement.getElementType());
			}
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * @param pageElement
	 *            Contains locator, input value. Sets it to the output value and
	 *            then retrieve the outValue
	 */
	public void verifyText(PageElement pageElement) {
		try {
			logger.info(VERIFY_TEXT);
			String actual = driver.findElement(pageElement.getLocatorType())
					.getText().trim();
			pageElement.setOutValue(actual);
			logger.info(ACTUAL_VALUE + pageElement.getOutValue());
			logger.info(EXPECTED_VALUE + pageElement.getInValue());
			Assert.assertEquals(pageElement.getOutValue(),
					pageElement.getInValue());
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * 
	 * @param pageElement
	 *            contains locator
	 */
	public void verifyLocator(PageElement pageElement) {
		try {
			logger.info(VERIFY_LOCATOR_MESSAGE);
			Assert.assertEquals(true,
					driver.findElement(pageElement.getLocatorType())
							.isDisplayed());
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * 
	 * @param pageElementObj
	 *            contains locator
	 */
	public void waitForVisibilityOfElement(PageElement pageElementObj) {
		try {
			logger.info(WAIT_FOR_VISIBLITY);
			WebDriverWait wait = new WebDriverWait(driver,
					Integer.parseInt(PropertiesReader
							.readProperty(WAIT_PROPERTY)));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(pageElementObj.getLocatorType()));
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * 
	 * @param pageElementObj
	 *            contains locator
	 */
	public void waitForInvisibilityOfText(PageElement pageElementObj) {
		try {
			logger.info(WAIT_FOR_TEXT_INVISIBLITY);
			WebDriverWait wait = new WebDriverWait(driver,
					Integer.parseInt(PropertiesReader
							.readProperty(WAIT_PROPERTY)));
			wait.until(ExpectedConditions.invisibilityOfElementWithText(
					pageElementObj.getLocatorType(),
					pageElementObj.getInValue()));
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	public void waitForProcessingRequestBoxToDisappear() {
		try {
			logger.info(WAIT_FOR_PROCCESSING_BOX_TO_DISAPPEAR);
			WebDriverWait wait = new WebDriverWait(driver,
					Integer.parseInt(PropertiesReader
							.readProperty(WAIT_PROPERTY)));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.id(PROCESSING_BOX)));
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * 
	 * @param pageElementObj
	 *            contains locator
	 */
	public void waitForInvisibilityOfElement(PageElement pageElementObj) {
		try {
			logger.info(WAIT_FOR_INVISIBLITY);
			WebDriverWait wait = new WebDriverWait(driver,
					Integer.parseInt(PropertiesReader
							.readProperty(WAIT_PROPERTY)));
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(pageElementObj
							.getLocatorType()));
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * 
	 * @param pageElementObj
	 *            contains locator
	 */
	public void waitUntilTextIsPresent(PageElement pageElementObj) {
		try {
			logger.info(WAIT_FOR_TEXT);
			WebDriverWait wait = new WebDriverWait(driver,
					Integer.parseInt(PropertiesReader
							.readProperty(WAIT_PROPERTY)));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(
					pageElementObj.getLocatorType(),
					pageElementObj.getInValue()));

		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
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
			logger.info(WAIT_TILL_CLICKABLE);
			WebDriverWait wait = new WebDriverWait(driver,
					Integer.parseInt(PropertiesReader
							.readProperty(WAIT_PROPERTY)));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(pageElementObj.getLocatorType()));
			wait.until(ExpectedConditions.elementToBeClickable(pageElementObj
					.getLocatorType()));
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * 
	 * @param pageElementObj
	 *            contains locator
	 */
	public void switchToFrame(PageElement pageElementObj) {
		try {
			logger.info(SWITCH_FRAME);
			WebElement iframe = driver.findElement(pageElementObj
					.getLocatorType());
			driver.switchTo().frame(iframe);
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * This method accepts the alert
	 */
	public void acceptAlertButtonIfPresent() {
		try {
			logger.info(ACCEPT_ALERT);
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(PropertiesReader
					.readProperty(WAIT_PROPERTY)));
			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {

				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
		} catch (TimeoutException exception) {
			logger.info(ALERT_MESSAGE);

		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());

		}
	}

	public void switchToWindow(String parentHandle) {
		logger.info(SWITCHING_WINDOW);

		try {
			Thread.sleep(10000L);
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}

		Set<String> handle = driver.getWindowHandles();

		if (handle.contains(parentHandle)) {
			handle.remove(parentHandle);
		}
		for (String winHandle : handle) {
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(parentHandle);
		driver.switchTo().defaultContent();
	}

	/**
	 * @param pageElementObj
	 *            Contains locator
	 * @return PageElement object with the output value of the retrieved text
	 */

	public PageElement getText(PageElement pageElementObj) {
		String retrievedText;
		try {
			logger.info(GET_TEXT);
			retrievedText = driver.findElement(pageElementObj.getLocatorType())
					.getText().trim();
			pageElementObj.setOutValue(retrievedText);
			logger.info(RETRIEVED_VALUE + pageElementObj.getOutValue());

		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());

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
			logger.info(TEXT_BY_ATTRIBUTE);
			String retrievedText = driver
					.findElement(pageElementObj.getLocatorType())
					.getAttribute(pageElementObj.getInValue()).trim();
			pageElementObj.setOutValue(retrievedText);
			logger.info(pageElementObj.getOutValue());

		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(ASSERT_FAIL_MESSAGE + exception.getMessage(), exception);
		}
		return pageElementObj;
	}

	/**
	 * 
	 * @param pageElementObj
	 *            Contains locator and expected value as inValue
	 */
	public void verifyFirstSelectedOption(PageElement pageElementObj) {
		try {
			logger.info(VERIFY_SELECTED_OPTION);
			String actual = new Select(driver.findElement(pageElementObj
					.getLocatorType())).getFirstSelectedOption().getText()
					.trim();
			pageElementObj.setOutValue(actual);

			logger.info(EXPECTED_VALUE + pageElementObj.getInValue());
			logger.info(ACTUAL_VALUE + pageElementObj.getOutValue());

			Assert.assertEquals(pageElementObj.getOutValue(),
					pageElementObj.getInValue());
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
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
			logger.info(VERIFY_TEXT_BY_ATTRIBUTE);
			String actual = driver.findElement(pageElementObj.getLocatorType())
					.getAttribute(pageElementObj.getAttributeType()).trim();
			pageElementObj.setOutValue(actual);
			logger.info(EXPECTED_VALUE + pageElementObj.getInValue());
			logger.info(ACTUAL_VALUE + pageElementObj.getOutValue());
			Assert.assertEquals(pageElementObj.getOutValue(),
					pageElementObj.getInValue());
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * To verify an element is disabled
	 * 
	 * @param pageElementObj
	 *            Page element to be verified
	 */

	public void verifyElementDisabled(PageElement pageElementObj) {
		try {
			logger.info(ELEMENT_IS_DISABLED);
			Assert.assertEquals(false,
					driver.findElement(pageElementObj.getLocatorType())
							.isEnabled());
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * To verify premium is not null under Premium column
	 * 
	 * @param pageElementObj
	 *            Page element to be verified
	 */

	public void verifyPremium(PageElement pageElementObj) {
		logger.info(VERIFY_PREMIUMS);
		List<WebElement> element = new ArrayList<WebElement>();
		try {

			element = driver.findElements(pageElementObj.getLocatorType());
			for (int counter = 0; counter < element.size(); counter++) {

				String premiumText = element.get(counter).getText().trim();
				logger.info(PREMIUM_VALUE + premiumText);
				Assert.assertNotEquals(premiumText, pageElementObj.getInValue());
			}

		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * 
	 * @param pageElementObj
	 */
	public void verifyTextIsNotNull(PageElement pageElementObj) {
		logger.info(VERIFY_TEXT_IS_NOT_NULL);
		String retrievedText = driver
				.findElement(pageElementObj.getLocatorType()).getText().trim();
		try {
			logger.info(RETRIEVED_VALUE + retrievedText);
			Assert.assertNotNull(retrievedText);
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * 
	 * @param pageElementObj
	 * @return
	 */
	public PageElement verifyAttributeValueNotNull(PageElement pageElementObj) {
		try {
			logger.info(VERIFY_ATTRIBUTE_VALUE_NOT_NULL);
			String retrievedText = driver
					.findElement(pageElementObj.getLocatorType())
					.getAttribute(pageElementObj.getInValue()).trim();
			logger.info(RETRIEVED_VALUE + retrievedText);
			Assert.assertNotNull(retrievedText);
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
		return pageElementObj;
	}

	/**
	 * To retrieve the Quote/Policy number from a draft policy
	 * 
	 * @return actualQuoteNumber[0] Quote Number
	 */

	public TextBox retreiveQuote(TextBox quoteNo) {
		String[] retreivequote = null;
		try {
			logger.info(RETRIEVE_QUOTE);
			quoteNo.setOutValue(driver.findElement(quoteNo.getLocatorType())
					.getText());
			retreivequote = quoteNo.getOutValue().split(" ");
			logger.info(ACTUAL_VALUE + retreivequote[0]);
			quoteNo.setOutValue(retreivequote[0].trim());
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
		return quoteNo;
	}

	/**
	 * To verify policy member number
	 * 
	 * @param pageElementObj
	 * @return
	 */
	public void verifyPolicyMember(PageElement pageElementObj) {
		String[] policyMember = null;
		try {
			logger.info("Verify Policy Member");
			pageElementObj.setOutValue(driver.findElement(
					pageElementObj.getLocatorType()).getText());
			policyMember = pageElementObj.getOutValue().split("-");
			logger.info(EXPECTED_VALUE + pageElementObj.getInValue());
			logger.info(ACTUAL_VALUE + policyMember[1]);
			pageElementObj.setOutValue(policyMember[1].trim());
			Assert.assertEquals(pageElementObj.getOutValue(),
					pageElementObj.getInValue());
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * To retrieve first/last name from the full name
	 * 
	 * @param firstLastName
	 * @param name
	 *            firstName or lastName
	 * @return pageElementObj containing firstName or lastName
	 */

	public TextBox retrieveFromFullName(TextBox firstLastName, String name) {
		String[] fullName = null;
		try {
			firstLastName.setOutValue(driver.findElement(
					firstLastName.getLocatorType()).getText());
			fullName = firstLastName.getOutValue().split(",");

			if (name.equalsIgnoreCase("firstName")) {
				firstLastName.setOutValue(fullName[1].trim());
				logger.info("First name is: " + fullName[1]);
			} else if (name.equalsIgnoreCase("lastName")) {
				firstLastName.setOutValue(fullName[0].trim());
				logger.info("Last name is: " + fullName[0]);
			} else {
				Assert.fail("Please enter valid name type - firstName or lastName");
			}

		} catch (Exception exception) {
			logger.warn(exception);
		}
		return firstLastName;
	}

	/**
	 * To retrieve associate/member number from complete member number
	 * 
	 * @param memberAssociateNumber
	 * @param name
	 *            memberNumber or associateNumber
	 * @return pageElementObj containing memberNumber or associateNumber
	 */

	public TextBox retrieveMemberAndAssociateNumber(
			TextBox memberAssociateNumber, String numberType) {
		String[] membershipNumber = null;
		try {
			memberAssociateNumber.setOutValue(driver.findElement(
					memberAssociateNumber.getLocatorType()).getText());
			membershipNumber = memberAssociateNumber.getOutValue().split("-");

			if (numberType.equalsIgnoreCase("memberNumber")) {
				logger.info("Policy member number is: " + membershipNumber[0]);
				memberAssociateNumber.setOutValue(membershipNumber[0].trim());
			} else if (numberType.equalsIgnoreCase("associateNumber")) {
				logger.info("Policy associate number is: "
						+ membershipNumber[1]);

				memberAssociateNumber.setOutValue(membershipNumber[1].trim());
			} else {
				Assert.fail("Please enter valid number type - memberNumber or associateNumber");
			}

		} catch (Exception exception) {
			logger.warn(exception);
		}
		return memberAssociateNumber;
	}

	/**
	 * @param pageElement
	 *            Contains locator, input value. Sets it to the output value and
	 *            then retrieve the outValue
	 */
	public void verifyContainsText(PageElement pageElement) {
		try {
			String actual = driver.findElement(pageElement.getLocatorType())
					.getText().trim();
			pageElement.setOutValue(actual);
			logger.info("actual value is: " + pageElement.getOutValue());
			logger.info("expected value is: " + pageElement.getInValue());
			Assert.assertTrue(pageElement.getOutValue().contains(
					pageElement.getInValue()));
		} catch (Exception exception) {
			logger.warn(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * This method is used for taking a screenshot within a method. Not to be
	 * confused with captureScreenshotOnFailure() under TestListener class
	 */

	public void captureScreenshot() {
		logger.info("Capture the Screen shot");
		File scrFile;
		try {
			String methodName = Thread.currentThread().getStackTrace()[2]
					.getMethodName();
			String GENERIC_SCREENSHOTPATH = System.getProperty("user.dir")
					+ "\\Generic_Screenshot\\";

			System.out.println(CAPTURE_SCREENSHOT + methodName);

			scrFile = new File(GENERIC_SCREENSHOTPATH);

			scrFile = ((TakesScreenshot) Browser.driver)
					.getScreenshotAs(OutputType.FILE);
			GENERIC_SCREENSHOTPATH = GENERIC_SCREENSHOTPATH
					+ methodName
					+ "_"
					+ new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss")
							.format(Calendar.getInstance().getTime()) + ".png";
			FileUtils.copyFile(scrFile, new File(GENERIC_SCREENSHOTPATH));

		} catch (Exception exception) {
			logger.warn(exception);
		}
	}

	/**
	 * To verify an element is Displayed
	 * 
	 * @param pageElementObj
	 *            Page element to be verified
	 */

	public void verifyElementIsDisplayed(PageElement pageElementObj) {
		try {

			logger.info(WAIT_FOR_VISIBLITY);
			Assert.assertEquals(true,
					driver.findElement(pageElementObj.getLocatorType())
							.isDisplayed());
		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());
		}
	}

	/**
	 * Switch to Default Window Frame
	 */

	public void switchToDefaultFrame() {

		try {
			logger.info(GET_TEXT);

			driver.switchTo().defaultContent();

		} catch (Exception exception) {
			logger.fatal(exception);
			Assert.fail(exception.getMessage());

		}

	}

	public void closeBrowser() {
		logger.info(CLOSE_BROWSER);

		driver.quit();
	}

}

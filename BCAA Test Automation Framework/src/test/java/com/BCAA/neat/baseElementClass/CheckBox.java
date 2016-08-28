package com.BCAA.neat.baseElementClass;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * This class is used defining behaviour of element type CheckBox
 *
 * @author Optimus
 */

public class CheckBox extends PageElement {

	private final static String VERIFY_CHECKED = "Verification failed checkbox is not checked";
	private final static String VERIFY_UNCHECKED = "Verification failed checkbox is checked";

	public CheckBox(By locatorType) {
		super(locatorType);
	}

	public void selectCheckbox() {
		PageElement selectCheckbox = new PageElement(this.getLocatorType(), InputType.CHECK_CHECKBOX);
		browser.setElement(selectCheckbox);
	}

	public void deSelectCheckbox() {
		PageElement deSelectCheckbox = new PageElement(this.getLocatorType(), InputType.UNCHECK_CHECKBOX);
		browser.setElement(deSelectCheckbox);
	}

	/**
	 * 
	 * @param checkBoxObj
	 *            contains the locator
	 */
	public void verifyCheckBoxIsChecked() {
		if (!Browser.driver.findElement(this.getLocatorType()).isSelected()) {
			Assert.fail(VERIFY_CHECKED);
		}
	}

	/**
	 * 
	 * @param checkBoxObj
	 *            contains the locator
	 */
	public void verifyCheckBoxIsUnChecked() {
		if (Browser.driver.findElement(this.getLocatorType()).isSelected()) {
			Assert.fail(VERIFY_UNCHECKED);
		}
	}
	
	public void verifyCheckbox(){
		browser.verifyLocator(this);
	}

}

package com.BCAA.neat.baseElementClass;

import org.openqa.selenium.By;

import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * This class is used defining behaviour of element type CheckBox
 *
 * @author Optimus
 */


public class CheckBox extends PageElement {

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

}

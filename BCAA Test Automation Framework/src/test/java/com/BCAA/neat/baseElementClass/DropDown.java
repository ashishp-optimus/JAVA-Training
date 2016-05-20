package com.BCAA.neat.baseElementClass;

import org.openqa.selenium.By;

import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * This class is used defining behaviour of element type DropDown
 *
 * @author Optimus
 */

public class DropDown extends PageElement {

	public DropDown(By locatorType, String inValue) {
		super(locatorType, inValue, InputType.DROPDOWN);

	}

	public void selectValue() {
		browser.setElement(this);
	}
}

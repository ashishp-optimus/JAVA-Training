package com.BCAA.neat.baseElementClass;

import org.openqa.selenium.By;

import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * This class is used defining behaviour of element type Textbox
 *
 * @author Optimus
 */

public class TextBox extends PageElement {

	public TextBox(By locatorType, String inValue) {
		super(locatorType, inValue, InputType.TEXT_BOX);

	}

	public void enterTextInField() {
		browser.setElement(this);
	}
}

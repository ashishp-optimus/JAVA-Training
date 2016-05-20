package com.BCAA.neat.baseElementClass;

import org.openqa.selenium.By;

import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;



/**
 * This class is used defining behaviour of element type Button
 *
 * @author Optimus
 */

public class Button extends PageElement {

	public Button(By locatorType) {
		super(locatorType, InputType.BUTTON);

	}

	public void click() {
		browser.setElement(this);
	}
}

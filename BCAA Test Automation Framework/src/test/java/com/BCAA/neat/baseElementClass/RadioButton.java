package com.BCAA.neat.baseElementClass;

import org.openqa.selenium.By;

import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * This class is used defining behaviour of element type Radio button
 *
 * @author Optimus
 */

public class RadioButton extends PageElement {

	public RadioButton(By locatorType) {
		super(locatorType, InputType.RADIOBUTTON);

	}

	public void selectRadioButton() {
		browser.setElement(this);
	}
}

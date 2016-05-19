package com.BCAA.neat.baseElementClass;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

/**
 * This class is used defining behaviour of element type Radio button
 *
 * @author Optimus
 */


public class RadioButton {
		
	public void selectRadioButton(PageElement pageElementobj){
		Browser browser = new Browser();
		browser.setElement(pageElementobj);
	}
}

package com.BCAA.neat.baseElementClass;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

/**
 * This class is used defining behaviour of element type Textbox
 *
 * @author Optimus
 */

public class TextBox {
		
	public void enterTextInField(PageElement pageElementobj){
		Browser browser = new Browser();
		browser.setElement(pageElementobj);
	}
}

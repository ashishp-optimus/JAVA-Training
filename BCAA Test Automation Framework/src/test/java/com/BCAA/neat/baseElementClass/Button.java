package com.BCAA.neat.baseElementClass;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

/**
 * This class is used defining behaviour of element type Button
 *
 * @author Optimus
 */


public class Button {

	public void click(PageElement pageElementobj){

		Browser browser = new Browser();
		browser.setElement(pageElementobj);
	}
}

package com.BCAA.neat.baseElementClass;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

/**
 * This class is used defining behaviour of element type DropDown
 *
 * @author Optimus
 */

public class DropDown {
			
	public void selectValue(PageElement pageElementobj){
		Browser browser = new Browser();
		browser.setElement(pageElementobj);
	}
}

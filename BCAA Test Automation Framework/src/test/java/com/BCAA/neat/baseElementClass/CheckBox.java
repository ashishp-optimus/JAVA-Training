package com.BCAA.neat.baseElementClass;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

/**
 * This class is used defining behaviour of element type CheckBox
 *
 * @author Optimus
 */


public class CheckBox {

	public void selectCheckbox(PageElement pageElementobj){
		Browser browser = new Browser();
		browser.setElement(pageElementobj);
	}
	
	public void deSelectCheckbox(PageElement pageElementobj){
		Browser browser = new Browser();
		browser.setElement(pageElementobj);
	}
	
}

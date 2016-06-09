package com.BCAA.neat.baseElementClass;

import org.openqa.selenium.By;

import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * This class is used defining behaviour of element type Button.
 * It also contains the different methods for click and wait over elements.
 * @author Optimus
 */

public class Button extends PageElement {

	public Button(By locatorType) {
		super(locatorType, InputType.BUTTON);
	}

	public void click() {
		browser.setElement(this);		
	}
	
	public void clickAndWaitForProcessingBoxToDisappear() {
		browser.setElement(this);
		browser.waitForProcessingRequestBoxToDisappear();
	}
	
	public void clickAndWaitForInvisibilityOf(PageElement pageElementObj){
		browser.setElement(this);
		browser.waitForInvisibilityOfElement(pageElementObj);
	}
	
	public void clickAndWaitForVisibilityOf(PageElement pageElementObj){
		browser.setElement(this);
		browser.waitForVisibilityOfElement(pageElementObj);
	}
	
	public void clickWhenElementIsClickable(){
		browser.waitTillElementIsClickable(this);
		browser.setElement(this);
	}
	
	public void clickAndAcceptAlertBtn(){
		browser.setElement(this);
		browser.acceptAlertButtonIfPresent();
		
	}
	
	public void waitForVisibilityAndClick(){
		browser.waitForVisibilityOfElement(this);
		browser.setElement(this);		
	}
	
}

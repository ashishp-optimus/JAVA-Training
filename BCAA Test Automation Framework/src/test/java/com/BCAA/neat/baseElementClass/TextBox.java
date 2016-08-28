package com.BCAA.neat.baseElementClass;

import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
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
	
	public TextBox(By locatorType, String inValue, String attributeType) {
		super(locatorType, inValue, attributeType);
	}
	
	public TextBox(String inValue){
		super(inValue);
	}
	
	public TextBox(By locatorType){
		super(locatorType);
	}
	
	
	public void enterTextInField() {
		browser.setElement(this);
	}

	/**
	 * Verifying the Text of Page element
	 */
	public void verifyText() {
		browser.verifyText(this);
	}

	/**
	 * To get text of an element by desired attribute (value, href, name, etc)
	 */
	public TextBox getTextByAttribute() {
		TextBox textBoxObj =  (TextBox) browser.getTextByAttribute(this);
		return textBoxObj;
	}
	
	/**
	 * Verifying the Text of Page element
	 */
	public void verifyContainsText() {
		browser.verifyContainsText(this);
	}
	
	/**
	 * Verifying the wait For Invisibility Of Text
	 */
	public void waitForInvisibilityOfText() {
		browser.waitForInvisibilityOfText(this);
	}
	
	/**
	 * Verifying the wait For Invisibility Of Text
	 */
	public void waitUntilTextIsPresent() {
		browser.waitUntilTextIsPresent(this);
	}
	
	/**
	 * Verifying the selected option 
	 */
	public void verifyFirstSelectedOption() {
		browser.verifyFirstSelectedOption(this);
	}
	
	/**
	 * Verifying the selected option 
	 */
	public void verifyPolicyMember() {
		browser.verifyPolicyMember(this);
	}
	
	/**
	 * Verifying the attribute
	 */
	public void verifyTextByAttributeValue() {
		browser.verifyTextByAttributeValue(this);
	}
	
	public void waitUntilMsgBoxIsDisplayed(){
		browser.waitForVisibilityOfElement(this);
	}
	
	public void waitForInvisibilityOfElement(){
		browser.waitForInvisibilityOfElement(this);
	}
	
	public void verifyLocator(){
		browser.verifyLocator(this);
	}
	
	public void waitForVisibilityOfElement(){
		browser.waitForVisibilityOfElement(this);
	}
	
	public void clearTextBox(){
		Browser.driver.findElement(this.getLocatorType()).clear();
	}

}

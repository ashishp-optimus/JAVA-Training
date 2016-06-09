package com.BCAA.neat.executor;

import org.openqa.selenium.By;

import com.BCAA.neat.utils.InputType;

/**
 * This is the class to define the behaviour of the Element class objects
 * 
 * @author Optimus
 */
public class PageElement {

	protected By locator;
	protected String inValue;
	private String outValue;
	protected String attributeType;
	private InputType elementType;
	protected Browser browser = new Browser();

	public PageElement(By locatorType, String inValue, InputType elementType) {
		this.locator = locatorType;
		if (inValue != null) {
			this.inValue = inValue.trim();
		}

		this.elementType = elementType;
	}

	public PageElement(By locatorType, InputType elementType) {
		this.locator = locatorType;
		this.elementType = elementType;
	}

	public PageElement(By locatorType, String inValue, String attributeType) {
		this.locator = locatorType;
		if (inValue != null) {
			this.inValue = inValue.trim();
		}
		this.attributeType = attributeType;
	}

	public PageElement(By locatorType, String inValue) {
		this.locator = locatorType;
		if (inValue != null) {
			this.inValue = inValue.trim();
		}
	}

	public PageElement(By locatorType) {
		this.locator = locatorType;
	}

	public PageElement(String inValue) {
		this.inValue = inValue;
	}

	public By getLocatorType() {
		return this.locator;
	}

	public String getInValue() {
		return this.inValue;
	}

	public InputType getElementType() {
		return this.elementType;
	}

	public String getOutValue() {
		return this.outValue;
	}

	public String getAttributeType() {
		return this.attributeType;
	}
	
	public void setInValue(String value) {
		this.inValue = value.trim();
	}

	public void setOutValue(String value) {
		this.outValue = value.trim();
	}
	
	public void setAttributeType(String value) {
		this.attributeType = value;
	}
}

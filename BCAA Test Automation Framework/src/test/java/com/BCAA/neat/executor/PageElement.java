package com.BCAA.neat.executor;

import org.openqa.selenium.By;

import com.BCAA.neat.utils.InputType;

/**
 * @author Optimus
 */
public class PageElement {

	private By locator;
	private String inValue;
	private String outValue;
	private String attributeType;
	private InputType elementType;
	protected Browser browser = new Browser();

	public PageElement(By locatorType, String inValue, InputType elementType) {
		this.locator = locatorType;
		this.inValue = inValue;
		this.elementType = elementType;
	}

	public PageElement(By locatorType, InputType elementType) {
		this.locator = locatorType;
		this.elementType = elementType;
	}

	public PageElement(By locatorType, String inValue, String attributeType) {
		this.locator = locatorType;
		this.inValue = inValue;
		this.attributeType = attributeType;
	}

	public PageElement(By locatorType, String inValue) {
		this.locator = locatorType;
		this.inValue = inValue;
	}

	public PageElement(By locatorType) {
		this.locator = locatorType;
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

	public void setOutValue(String value) {
		this.outValue = value;
	}
}

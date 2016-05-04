package com.BCAA.executor;

import org.openqa.selenium.By;

/**
 * 
 * @author Optimus
 *
 */
public abstract class PageElement {

	public By locator = null;
	public String type = null;

	public abstract void setLocator(By locator);

	public abstract void setType(String type);

}

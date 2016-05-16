package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

public class PreviewDeclarationPages {
	Logger logger = Logger.getLogger(PreviewDeclarationPages.class);
	Browser browser = new Browser();
	

	By preview_Tab=By.id("btnEditiPolicyPreviewId");
	By quoteSucessMsgBox=By.id("msgbox");
	
	PageElement preview=new PageElement(preview_Tab, null, InputType.BUTTON);
//	PageElement printTheQuoteDeclaration=new PageElement(printTheQuoteDeclarationButton, null, InputType.BUTTON);
	
	public void preview()
	{
		logger.info("Inside preview method in Preview Declaration Pages Class");
		browser.setElement(preview);
		// TODO : NOT IMPLEMENTED YET
	}
	
	
}

package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.executor.Browser;

public class PreviewDeclarationPages {
	Logger logger = Logger.getLogger(PreviewDeclarationPages.class);
	Browser browser = new Browser();

	private By previewTabId = By.id("btnEditiPolicyPreviewId");
	private By quoteSucessMsgBoxId = By.id("msgbox");

	Button preview = new Button(previewTabId);

	// PageElement printTheQuoteDeclaration=new
	// PageElement(printTheQuoteDeclarationButton, null, InputType.BUTTON);

	public void preview() {
		logger.info("Inside preview method in Preview Declaration Pages Class");

		preview.click();

		// TODO : NOT IMPLEMENTED YET
	}

}

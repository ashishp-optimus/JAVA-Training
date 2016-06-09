package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.executor.Browser;

/**
 * This class is for Preview Declaration page
 * 
 * @author Optimus
 */

public class PreviewDeclarationPages {
	Logger logger;
	Browser browser;

	public PreviewDeclarationPages() {
		logger = Logger.getLogger(PreviewDeclarationPages.class);
		browser = new Browser();
	}

	private final static String VERIFY_PDF_THROUGH_PREVIEW_BTN="Inside preview method in Preview Declaration Pages Class";
	private By previewBtnId = By.id("btnEditiPolicyPreviewId");

	private Button previewBtn = new Button(previewBtnId);

	/**
	 * To switch and close the browser window containing the PDF preview
	 */
	public void verifyPdfThroughPreviewBtn() {
		logger.info(VERIFY_PDF_THROUGH_PREVIEW_BTN);

		String parentHandle = Browser.driver.getWindowHandle();
		previewBtn.click();

		browser.switchToWindow(parentHandle);
	}

}

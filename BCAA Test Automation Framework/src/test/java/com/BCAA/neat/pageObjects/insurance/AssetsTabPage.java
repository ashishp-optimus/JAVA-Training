package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;

/**
 * This class is for Assets tab page
 * 
 * @author Optimus
 */

public class AssetsTabPage {

	Logger logger;
	Browser browser;

	public AssetsTabPage() {
		logger = Logger.getLogger(AssetsTabPage.class);
		browser = new Browser();
	}

	private final static String EDIT_HOME = "Edit Home";

	private By assetsTabId = By.id("AssetTab_lnk");
	private By addAssetBtnId = By.id("btnAssetsTabAddId");
	private By selectHomeBtnId = By.id("policyAsset_1_1");
	private By homePolicyAssetId = By.id("policyAsset_2_2");
	private By editAssetsTabId = By.id("btnAssetsTabEditId");
	private By verifyEditHomeId = By.xpath(".//*[@id='home_asset_detail']/h2/span");

	private Button addAssetBtn = new Button(addAssetBtnId);
	private Button selectHomeBtn = new Button(selectHomeBtnId);
	private Button homePolicyAsset = new Button(homePolicyAssetId);
	private Button editAssetsTab = new Button(editAssetsTabId);
	private Button assetsTab = new Button(assetsTabId);

	private TextBox verifyEditHome = new TextBox(verifyEditHomeId, EDIT_HOME);

	/**
	 * To add Asset tab
	 */
	public void selectAddAsset() {
		logger.info("Inside select add asset tab method in InsuredsTabPage Class");

		selectHomeBtn.click();
		addAssetBtn.click();
	}

	/**
	 * Edit an existing home asset
	 */
	public void selectEditHomeAssetTab() {
		logger.info("Inside edit Asset method in AssetsTabPage Class");
		browser.waitTillElementIsClickable(homePolicyAsset);
		homePolicyAsset.click();
		editAssetsTab.click();

		verifyEditHome.verifyText();
	}
	/**
	 * Clicks on the edit button, just to reload the page internally
	 */
	public void clickOnEditButton() {
		logger.info("Inside clickOnEditButton method in AssetsTabPage Class");
		
		editAssetsTab.click();
	}
}
package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

public class AssetsTabPage {

	Logger logger = Logger.getLogger(AssetsTabPage.class);

	private By assetsTabId = By.id("AssetTab_lnk");
	Button assetsTab = new Button(assetsTabId);


	private By addAssetBtnId = By.id("btnAssetsTabAddId");
	private By selectHomeBtnId = By.id("policyAsset_1_1");
	private By homePolicyAssetId = By.id("policyAsset_2_2");
	private By editAssetsTabId = By.id("btnAssetsTabEditId");
	private By verifyEditHomeId = By.xpath(".//*[@id='home_asset_detail']/h2/span");
	private final static String EDIT_HOME = "Edit Home";

	Button addAssetBtn = new Button(addAssetBtnId);
	Button selectHomeBtn = new Button(selectHomeBtnId);
	Button homePolicyAsset = new Button(homePolicyAssetId);
	Button editAssetsTab = new Button(editAssetsTabId);
	PageElement verifyEditHome = new PageElement(verifyEditHomeId, EDIT_HOME);
	

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
	public void selectEditAssetTab() {
		logger.info("Inside edit Asset method in AssetsTabPage Class");
		Browser browser = new Browser();
		homePolicyAsset.click();
		editAssetsTab.click();
		browser.verifyText(verifyEditHome);
	}
}
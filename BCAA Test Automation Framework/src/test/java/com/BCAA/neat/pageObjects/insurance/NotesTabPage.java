package com.BCAA.neat.pageObjects.insurance;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.utils.DataBaseConnection;

/**
 * This class is for Notes tab page
 * 
 * @author Optimus
 */
public class NotesTabPage {
	Logger logger;
	Browser browser;

	DataBaseConnection dataBaseConnection = new DataBaseConnection();
	private Map<String, String> notesTabPage = dataBaseConnection.getDatabase().getPageCollectionsAsMap("NOTESTABPAGE");

	public NotesTabPage() {
		logger = Logger.getLogger(NotesTabPage.class);
		browser = new Browser();
	}

	private final static String POLICY_NOTE_TEXT_KEY = "policynotesuccessmessage";
	private final static String SELECT_VIEW_BTN = "Selecting View button in NotesTabPage Class";
	private final static String SELECT_EDIT_BTN = "Selecting Edit button in NotesTabPage Class";
	private final static String SELECT_ADD_BTN = "Selecting Add button in NotesTabPage Class";
	private final static String VERIFY_MESSAGE = "Inside verifyMessageAfterAddingNote method in NotesTabPage Class";

	private By addBtnId = By.id("btnNotesTabAddId");
	private By msgboxId = By.id("msgbox");
	private By editBtnId = By.id("btnNotesTabEditId");
	private By firstNoteBtnId = By.id("note_1");
	private By viewBtnId = By.id("btnNotesTabViewId");

	private Button addBtn = new Button(addBtnId);
	private Button editBtn = new Button(editBtnId);
	private Button firstNoteBtn = new Button(firstNoteBtnId);
	private Button viewBtn = new Button(viewBtnId);

	private TextBox verifyPolicyNoteText = new TextBox(msgboxId, notesTabPage.get(POLICY_NOTE_TEXT_KEY));

	public void selectViewNoteBtn() {
		logger.info(SELECT_VIEW_BTN);

		firstNoteBtn.click();
		viewBtn.click();
	}

	public void selectEditBtn() {
		logger.info(SELECT_EDIT_BTN);

		editBtn.click(); // to reload the page internally, since it was unable
							// to click on any other tab
	}

	public void selectAddBtn() {
		logger.info(SELECT_ADD_BTN);

		addBtn.click();
	}

	/**
	 * To verify message on adding a note successfully
	 */

	public void verifyMessageAfterAddingNote() {
		logger.info(VERIFY_MESSAGE);

		verifyPolicyNoteText.verifyText();
	}

}

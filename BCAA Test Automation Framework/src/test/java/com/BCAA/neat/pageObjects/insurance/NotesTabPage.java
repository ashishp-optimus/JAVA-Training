package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.baseElementClass.Button;
import com.BCAA.neat.baseElementClass.TextBox;
import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;

/**
 * 
 * @author Optimus
 *
 */
public class NotesTabPage {
	Logger logger = Logger.getLogger(NotesTabPage.class);
	Browser browser = new Browser();

	private final static String ADD_NOTE = "Add Note";
	private final static String SUBJECT = "Testing";
	private final static String NOTE_FIELD_TEXT = "Testing on note field";
	private final static String POLICY_NOTE_TEXT = "Policy Note has been added successfully.";
	private final static String EDIT_QUOATE_POLICY_HEADER = "Edit Quote/Policy";
	private By addBtnId = By.id("btnNotesTabAddId");
	private By subjectTextboxId = By.id("txtbxAddNoteSubjectId");
	private By noteFieldTextboxId = By.id("txtareaAddNoteNoteId");
	private By okBtnId = By.id("btnAddNoteOkId");
	private By addNoteHeaderXpath = By.xpath("//form/div[@id='policy_note']/h2");
	private By msgboxId = By.id("msgbox");
	private By editQuotePolicyHeaderXpath = By
			.xpath("//*[@id='insurancePolicyDetailForm']/div[@id='policy_detail']/h2");
	private By editBtnId = By.id("btnNotesTabEditId");
	private By firstNoteBtnId = By.id("note_1");
	private By viewBtnId = By.id("btnNotesTabViewId");

	Button addBtn = new Button(addBtnId);
	Button okBtn = new Button(okBtnId);
	Button editBtn = new Button(editBtnId);
	Button firstNoteBtn = new Button(firstNoteBtnId);
	Button viewBtn = new Button(viewBtnId);

	PageElement verifyAddNoteHeader = new PageElement(addNoteHeaderXpath, ADD_NOTE);
	PageElement verifyEditQuoatePolicyHeader = new PageElement(editQuotePolicyHeaderXpath, EDIT_QUOATE_POLICY_HEADER);
	PageElement verifyPolicyNoteText = new PageElement(msgboxId, POLICY_NOTE_TEXT);

	TextBox subjectTextbox = new TextBox(subjectTextboxId, SUBJECT);
	TextBox noteFieldTextbox = new TextBox(noteFieldTextboxId, NOTE_FIELD_TEXT);


	/**
	 * To add a new note to a policy
	 * 
	 */
	public void addNotes() {
		logger.info("Inside addNotes method in NotesTabPage Class");

		addBtn.click();

		browser.verifyText(verifyAddNoteHeader);

		subjectTextbox.enterTextInField();
		noteFieldTextbox.enterTextInField();

		okBtn.click();

		browser.verifyText(verifyEditQuoatePolicyHeader);
		browser.verifyText(verifyPolicyNoteText);

		editBtn.click(); // to reload the page internally, since it was unable to click on any other tab

	}

	/**
	 * 
	 */
	public void ViewNote() {
		logger.info("Inside ViewNote method in NotesTabPage Class");

		firstNoteBtn.click();
		viewBtn.click();

	}
}

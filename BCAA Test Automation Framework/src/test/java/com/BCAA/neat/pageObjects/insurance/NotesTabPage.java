package com.BCAA.neat.pageObjects.insurance;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.BCAA.neat.executor.Browser;
import com.BCAA.neat.executor.PageElement;
import com.BCAA.neat.utils.InputType;

/**
 * 
 * @author Optimus
 *
 */
public class NotesTabPage {
	Logger logger = Logger.getLogger(NotesTabPage.class);
	Browser browser = new Browser();

	private final String ADD_NOTE = "Add Note";
	private final String SUBJECT = "Testing";
	private final String NOTE_FIELD_TEXT = "Testing on note field";
	private final String POLICY_NOTE_TEXT = "Policy Note has been added successfully.";
	private final String EDIT_QUOATE_POLICY_HEADER = "Edit Quote/Policy";

	By noteTab = By.id("NotesTab");
	By addBtn = By.id("btnNotesTabAddId");
	By subjectTextbox = By.id("txtbxAddNoteSubjectId");
	By noteField = By.id("txtareaAddNoteNoteId");
	By okBtn = By.id("btnAddNoteOkId");
	By addNoteHeader = By.xpath("//form/div[@id='policy_note']/h2");
	By msgbox = By.id("msgbox");
	By editQuotePolicyHeader = By.xpath("//*[@id='insurancePolicyDetailForm']/div[@id='policy_detail']/h2");
	By editButtonId = By.id("btnNotesTabEditId");
	By firstNote = By.id("note_1");
	By viewBtn = By.id("btnNotesTabViewId");

	PageElement clickNoteTab = new PageElement(noteTab, null, InputType.BUTTON);
	PageElement clickAddBtn = new PageElement(addBtn, null, InputType.BUTTON);
	PageElement verifyAddNoteHeader = new PageElement(addNoteHeader, ADD_NOTE);
	PageElement writeInSubjectTextbox = new PageElement(subjectTextbox, SUBJECT, InputType.TEXT_BOX);
	PageElement writeInNoteField = new PageElement(noteField, NOTE_FIELD_TEXT, InputType.TEXT_BOX);
	PageElement clickOkBtn = new PageElement(okBtn, null, InputType.BUTTON);
	PageElement verifyEditQuoatePolicyHeader = new PageElement(editQuotePolicyHeader, EDIT_QUOATE_POLICY_HEADER);
	PageElement verifyPolicyNoteText = new PageElement(msgbox, POLICY_NOTE_TEXT);
	PageElement editButton = new PageElement(editButtonId, null, InputType.BUTTON);
	PageElement clickFirstNote = new PageElement(firstNote, null, InputType.BUTTON);
	PageElement clickViewBtn = new PageElement(viewBtn, null, InputType.BUTTON);

	/**
	 * clicking on add note tab
	 */
	public void clickOnNoteTab() {
		logger.info("Inside clickOnNoteTab method in NotesTabPage Class");
		browser.setElement(clickNoteTab);
	}

	/**
	 * To add a new note to a policy
	 * 
	 */
	public void addNotes() {
		logger.info("Inside addNotes method in NotesTabPage Class");
		browser.setElement(clickAddBtn);
		browser.verifyText(verifyAddNoteHeader);
		browser.setElement(writeInSubjectTextbox);
		browser.setElement(writeInNoteField);
		browser.setElement(clickOkBtn);
		browser.verifyText(verifyEditQuoatePolicyHeader);
		browser.verifyText(verifyPolicyNoteText);
		browser.setElement(editButton);

	}

	/**
	 * 
	 */
	public void ViewNote() {
		logger.info("Inside ViewNote method in NotesTabPage Class");
		browser.setElement(clickFirstNote);
		browser.setElement(clickViewBtn);
		
		
	}
}

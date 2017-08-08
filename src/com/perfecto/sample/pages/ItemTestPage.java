package com.perfecto.sample.pages;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.thoughtworks.selenium.webdriven.commands.GetXpathCount;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class ItemTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "txt.itemname.fieldservices")
	private QAFWebElement txtItemnameFieldservices;
	@FindBy(locator = "txt.servicesname.fieldservices")
	private QAFWebElement txtServicesnameFieldservices;
	@FindBy(locator = "txt.address.fieldservices")
	private QAFWebElement txtAddressFieldservices;
	@FindBy(locator = "txt.addphoto.fieldservices")
	private QAFWebElement txtAddphotoFieldservices;
	@FindBy(locator = "txt.notes.fieldservices")
	private QAFWebElement txtNotesFieldservices;
	@FindBy(locator = "input.note.fieldservices")
	private QAFWebElement inputNoteFieldservices;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getTxtItemnameFieldservices() {
		return txtItemnameFieldservices;
	}

	public QAFWebElement getTxtServicesnameFieldservices() {
		return txtServicesnameFieldservices;
	}

	public QAFWebElement getTxtAddressFieldservices() {
		return txtAddressFieldservices;
	}

	public QAFWebElement getTxtAddphotoFieldservices() {
		return txtAddphotoFieldservices;
	}

	public QAFWebElement getTxtNotesFieldservices() {
		return txtNotesFieldservices;
	}

	public QAFWebElement getInputNoteFieldservices() {
		return inputNoteFieldservices;
	}

	public void verifyitemdetailPage() {

		getTxtAddressFieldservices().verifyPresent();
		getTxtAddphotoFieldservices().verifyPresent();
		getTxtServicesnameFieldservices().verifyPresent();
		((AppiumDriver) driver.getUnderLayingDriver()).hideKeyboard();
		getTxtItemnameFieldservices().verifyPresent();
		

	}

	public void addNote(String note) {

		getTxtNotesFieldservices().sendKeys(note);
		getInputNoteFieldservices().click();

	}

}

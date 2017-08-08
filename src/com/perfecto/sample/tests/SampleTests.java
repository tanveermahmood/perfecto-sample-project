package com.perfecto.sample.tests;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.perfecto.sample.components.HeaderBar;
import com.perfecto.sample.pages.HomescrTestPage;
import com.perfecto.sample.pages.ItemTestPage;
import com.perfecto.sample.pages.LoginscrTestPage;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;

public class SampleTests {

	@Test
	public void validLoginTest() {
		new WebDriverTestBase().getDriver();
		LoginscrTestPage loginPage = new LoginscrTestPage();
		loginPage.doLogin(getBundle().getString("login.user.email"), getBundle().getString("login.user.password"));
		HeaderBar hbar = new HeaderBar();
		hbar.getBtnLogoutHeader().verifyPresent();
	}

	@Test
	public void verifyTaskDetailPage() {
		LoginscrTestPage loginPage = new LoginscrTestPage();
		loginPage.doLogin(getBundle().getString("login.user.email"), getBundle().getString("login.user.password"));
		HomescrTestPage homePage = new HomescrTestPage();
		homePage.waitForPageToLoad();
		String openedItem = homePage.openItemByIndex(1);
		ItemTestPage itemTestPage = new ItemTestPage();
		itemTestPage.verifyitemdetailPage();
		itemTestPage.addNote("Assignment done");

	}

	@Test
	public void userInteraction() {
		LoginscrTestPage loginPage = new LoginscrTestPage();
		loginPage.doLogin(getBundle().getString("login.user.email"), getBundle().getString("login.user.password"));
		HomescrTestPage homePage = new HomescrTestPage();
		homePage.waitForPageToLoad();
		homePage.zoomOnMap();
		QAFTestBase.pause(5000);
		homePage.pinchMap();
		QAFTestBase.pause(5000);
		homePage.swipeOnMap();
		QAFTestBase.pause(5000);

	}

}

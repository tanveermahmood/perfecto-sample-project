package com.perfecto.sample.pages;

import java.util.List;
import com.qmetry.qaf.automation.ui.*;
import com.perfecto.sample.components.TaskItem;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

import io.appium.java_client.AppiumDriver;

public class HomescrTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "FieldService.Map")
	private QAFWebElement map;

	@FindBy(locator = "FieldService.itemlist")
	private List<TaskItem> fieldServiceItemlist;

	public List<TaskItem> getFieldServiceItemlist() {
		return fieldServiceItemlist;
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

	public QAFWebElement getMap() {
		return map;
	}

	@Override
	public void waitForPageToLoad() {
		map.waitForPresent();
		fieldServiceItemlist.get(0).waitForPresent();
		super.waitForPageToLoad();
	}

	public String openItemByIndex(int index) {
		String openedItemName = getFieldServiceItemlist().get(index).getFieldServiceItemname().getText();
		getFieldServiceItemlist().get(index).getFieldServiceItemname().click();
		return openedItemName;
	}

	public void openItemByName(String name) {
		for (TaskItem item : getFieldServiceItemlist()) {
			if (item.equals(name)) {
				item.getFieldServiceItemname().click();
				return;
			}
		}
		Reporter.log("Item not found", MessageTypes.Fail);
		
	}
	
	
	public void zoomOnMap(){
		((AppiumDriver)driver.getUnderLayingDriver()).zoom(getMap());;
		
	
	}
	public void swipeOnMap(){
	
		((AppiumDriver)driver.getUnderLayingDriver()).swipe(250, 250, 450,250, 3);
	
}
	
	public void pinchMap(){
		
		((AppiumDriver)driver.getUnderLayingDriver()).pinch(getMap());
	
	
	}
}
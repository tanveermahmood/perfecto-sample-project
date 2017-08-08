package com.perfecto.sample.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class TaskItem extends QAFWebComponent {

	public TaskItem(String locator) {
		super(locator);
	}

	@FindBy(locator = "FieldService.itemname")
	private QAFWebElement fieldServiceItemname;
	@FindBy(locator = "FieldService.servicename")
	private QAFWebElement fieldServiceServicename;
	@FindBy(locator = "FieldService.distances")
	private QAFWebElement fieldServiceDistances;

	public QAFWebElement getFieldServiceItemname() {
		return fieldServiceItemname;
	}

	public QAFWebElement getFieldServiceServicename() {
		return fieldServiceServicename;
	}

	public QAFWebElement getFieldServiceDistances() {
		return fieldServiceDistances;
	}

	@Override
	public boolean equals(Object obj) {
		if (null != obj && obj instanceof String) {
			return fieldServiceItemname.getText().equalsIgnoreCase((String) obj);
		}
		return super.equals(obj);
	}

}
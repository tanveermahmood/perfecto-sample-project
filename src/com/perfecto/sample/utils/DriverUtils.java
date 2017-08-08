package com.perfecto.sample.utils;

import org.openqa.selenium.interactions.internal.TouchAction;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverUtils {

	public static AppiumDriver getAppiumDriver() {
		return (AppiumDriver) getDriver().getUnderLayingDriver();
	}

	public static TouchAction getTouchAction() {
		return new TouchAction(getAppiumDriver());
	}

	public static IOSDriver getIOSDriver() {
		return (IOSDriver) getAppiumDriver();
	}

	public static AndroidDriver getAndroidDriver() {
		return (AndroidDriver) getAppiumDriver();
	}

	public static QAFExtendedWebDriver getDriver() {
		return new WebDriverTestBase().getDriver();
	}

	public static boolean isRunningOnIOS() {
		return (null != getDriver().getCapabilities().getCapability("platformName"))
				&& getDriver().getCapabilities().getCapability("platformName").toString().toLowerCase().contains("ios");
	}

	public static boolean isRunningOnAndroid() {
		return (null != getDriver().getCapabilities().getCapability("platformName")) && getDriver().getCapabilities()
				.getCapability("platformName").toString().toLowerCase().contains("android");

	}

}

package com.perfecto.sample.steps;

import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

import static com.qmetry.qaf.automation.step.CommonStep.*;

import org.hamcrest.Matchers;

import com.perfecto.sample.components.HeaderBar;
import com.perfecto.sample.utils.PerfectoUtilities;

public class LoginSteps {

	@QAFTestStep(description = "I open application")
	public void launchApp() {
		PerfectoUtilities.openApplication("Field Service");
		System.out.println(PerfectoUtilities.screenText());
		Validator.verifyThat("text should match: ", PerfectoUtilities.screenText().contains("BODAKDEV"),
				Matchers.equalTo(true));
		Reporter.log("This will fail", MessageTypes.Fail);
		Reporter.log("This will pass", MessageTypes.Pass);

		Reporter.log("This is jst an infos", MessageTypes.Info);
		Reporter.logWithScreenShot("this will capture screenshot");

		// new WebDriverTestBase().getDriver();
	}

	@QAFTestStep(description = "I login with {username} and {password}")
	public void doLogin(String username, String password) {
		HeaderBar hbar = new HeaderBar();
		hbar.doLogout();
		// clear("input.email.login");
		sendKeys(username, "input.email.login");
		// clear("input.password.login");
		sendKeys(password, "input.password.login");
		click("btn.signin.login");
	}

}

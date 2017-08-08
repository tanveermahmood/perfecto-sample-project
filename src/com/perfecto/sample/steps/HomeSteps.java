package com.perfecto.sample.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import static com.qmetry.qaf.automation.step.CommonStep.*;

public class HomeSteps {

	@QAFTestStep(description = "I should see user home screen")
	public void verifyHomePage() {
		verifyPresent("FieldService.Map");
		verifyPresent("FieldService.itemlist");
	}

}

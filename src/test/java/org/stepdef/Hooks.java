package org.stepdef;

import java.io.IOException;

import org.baseclass.UtitlityClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class Hooks extends UtitlityClass {

	@Before
	public void beforeScenario() {
		browserLaunch("chrome");
		loadUrl("https://adactinhotelapp.com/");
		windowMaxmize();
		deleteCookies();
		implicitWait(10);
	}

	@After
	public void afterScenario(Scenario scenario) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] bs = screenshot.getScreenshotAs(OutputType.BYTES);

		Status status = scenario.getStatus();

		switch (status) {
		case FAILED:
			scenario.attach(bs, "image/png", scenario.getName());
			break;

		default:
			break;
		}

		quitBrowser();

	}

}

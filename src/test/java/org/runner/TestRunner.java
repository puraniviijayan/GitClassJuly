package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.stepdef.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", snippets = SnippetType.CAMELCASE, glue = "org.stepdef", dryRun = false, stepNotifications = false, plugin = {
		"pretty", "html:target\\Report\\Cucumber-report.html", "junit:target\\Report\\Cucumber-report.xml",
		"json:target\\Report\\Cucumber-report.json", "rerun:src\\test\\resources\\Failed.txt" }, publish = true)
public class TestRunner {

	@AfterClass
	public static void afterClass() {
		Reporting.generateReport(
				"C:\\Users\\DELL\\eclipse-workspace\\CucumberProjectJan17" + "\\target\\Report\\Cucumber-report.json");
	}

}

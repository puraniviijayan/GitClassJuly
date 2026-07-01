package org.stepdef;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateReport(String jsonFile) {

		File jsonFilePath = new File("C:\\Users\\DELL\\eclipse-workspace\\CucumberProjectJan17\\target\\Report");

		Configuration conf = new Configuration(jsonFilePath, "Adactin Hotel Application");
		conf.addClassifications("Platform Name", "Windows");
		conf.addClassifications("Build No", "GT001");
		conf.addClassifications("Environment", "QA");
		conf.addClassifications("Browser Name", "Chrome");

		List<String> json = new ArrayList<>();
		json.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(json, conf);
		builder.generateReports();

	}

}

package org.stepdef;

import java.io.IOException;
import java.util.List;
//import java.util.Map;

import org.baseclass.UtitlityClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.LoginPage;
import org.pom.SearchHotelPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends UtitlityClass {

	@Given("User is on adactin login page")
	public void userIsOnAdactinLoginPage() {

	}

	@When("User enters valid username and password")
	public void userEntersValidUsernameAndPassword() throws IOException {
		LoginPage login = new LoginPage();
		type(login.getTxtUserName(), excelRead("login", 1, 0));
		type(login.getTxtPassword(), excelRead("login", 1, 1));
	}

	@When("Clicks on login button")
	public void clicksOnLoginButton() {
		LoginPage login = new LoginPage();
		btnClick(login.getBtnLogin());
	}

	@Then("User is navigates to Search hotel page")
	public void userIsNavigatesToSearchHotelPage() {
		Assert.assertTrue("Verify Search Hotel title", pageTitle().contains("Search Hotel"));
	}

	@When("User enters Invalid username and password")
	public void userEntersInvalidUsernameAndPassword() throws IOException {
		LoginPage login = new LoginPage();
		type(login.getTxtUserName(), excelRead("login", 2, 0));
		type(login.getTxtPassword(), excelRead("login", 2, 1));
	}

	@Then("Invalid login error message is display")
	public void invalidLoginErrorMessageIsDisplay() {
		LoginPage login = new LoginPage();
		Assert.assertTrue("Verify invalid login error message",
				getTextEle(login.getErrorMsg()).contains("invalid login"));
	}

	@When("User enters valid username as {string} and invalid password as {string}")
	public void userEntersValidUsernameAsAndInvalidPasswordAs(String s1, String s2) {
		LoginPage login = new LoginPage();
		type(login.getTxtUserName(), s1);
		type(login.getTxtPassword(), s2);
	}

	@When("User enters location and noOfRooms and checkInDate and checkOutDate and adultsPerRoom and Clicks on Search button")
	public void userEntersLocationAndNoOfRoomsAndCheckInDateAndCheckOutDateAndAdultsPerRoomAndClicksOnSearchButton(
			io.cucumber.datatable.DataTable dataTable) {
//		// 2d with header
//		List<Map<String, String>> asMaps = dataTable.asMaps();
//		Map<String, String> asMap = asMaps.get(2);
//		SearchHotelPage searchHotel = new SearchHotelPage();
//		drpSelectByVisibleText(searchHotel.getDrpLocation(), asMap.get("location"));
//		drpSelectByVisibleText(searchHotel.getDrpNoOfRooms(), asMap.get("noOfRooms"));
//		clearTextbox(searchHotel.getTextCheckInDate());
//		type(searchHotel.getTextCheckInDate(), asMap.get("checkInDate"));
//		clearTextbox(searchHotel.getTextCheckOutDate());
//		type(searchHotel.getTextCheckOutDate(), asMap.get("checkOutDate"));
//		drpSelectByVisibleText(searchHotel.getDrpAdultsPerRoom(), asMap.get("adultsPerRoom"));
//		btnClick(searchHotel.getBtnSubmit());
	}

}

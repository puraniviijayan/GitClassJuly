package org.pom;

import org.baseclass.UtitlityClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends UtitlityClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement drpLocation;

	@FindBy(id = "room_nos")
	private WebElement drpNoOfRooms;

	@FindBy(id = "datepick_in")
	private WebElement textCheckInDate;

	@FindBy(id = "datepick_out")
	private WebElement textCheckOutDate;

	@FindBy(id = "adult_room")
	private WebElement drpAdultsPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSubmit;

	public WebElement getDrpLocation() {
		return drpLocation;
	}

	public WebElement getDrpNoOfRooms() {
		return drpNoOfRooms;
	}

	public WebElement getTextCheckInDate() {
		return textCheckInDate;
	}

	public WebElement getTextCheckOutDate() {
		return textCheckOutDate;
	}

	public WebElement getDrpAdultsPerRoom() {
		return drpAdultsPerRoom;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

}

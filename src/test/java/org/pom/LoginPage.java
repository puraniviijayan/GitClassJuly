package org.pom;

import org.baseclass.UtitlityClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

//pojo class -> Encapsulation
public class LoginPage extends UtitlityClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBys({ @FindBy(id = "username"), @FindBy(xpath = "//input[@name='username']") })
	private WebElement txtUserName;

	@CacheLookup
	@FindAll({ @FindBy(name = "password"), @FindBy(id = "passWord") })
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement btnLogin;

	@FindBy(xpath = "//b[contains(text(),'Invalid Login details')]")
	private WebElement errorMsg;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}

}

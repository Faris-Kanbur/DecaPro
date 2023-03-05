package com.decapro.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Action;

public class LoginPage {

	WebDriver ldriver;
	Action action = new Action();

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[@class='base']")
	@CacheLookup
	WebElement loginPageTitle;

	@FindBy(xpath = "//div[@id='email-error']")
	@CacheLookup
	WebElement loginPageRequiredErrorMail;

	@FindBy(xpath = "//div[@id='pass-error']")
	@CacheLookup
	WebElement loginPageRequiredErrorPass;

	@FindBy(xpath = "//div[@data-ui-id='message-error']")
	@CacheLookup
	WebElement errorMessage;

	@FindBy(xpath = "(//strong[@id='block-customer-login-heading'])[1]")
	@CacheLookup
	WebElement registeredCustomerText;

	@FindBy(xpath = "//div[@class='field note']")
	@CacheLookup
	WebElement haveAccount;

	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement txtUserMail;

	@FindBy(id = "pass")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name = "send")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "//a[@class='action remind']")
	@CacheLookup
	WebElement fotgetyourpass;

	@FindBy(xpath = "//fieldset[@class='fieldset login']")
	@CacheLookup
	WebElement RequireFields;

	@FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
	@CacheLookup
	WebElement MyAccount;

	
	
	public boolean getLoginPageError() {
		return action.isDisplayed(ldriver, errorMessage);

	}

	public void setUserMail(String userMail) {
		action.type(txtUserMail, userMail);
	}

	public void setPassword(String pwd) {
		action.type(txtPassword, pwd);
	}

	public void clickSubmit() {
		btnLogin.click();
	}

	public boolean validateloginPageTitle() {
		return action.isDisplayed(ldriver, loginPageTitle);

	}

	public boolean getMyAccountText() {
		return action.isDisplayed(ldriver, MyAccount);

	}

	public boolean getRequiredPassText() {
		return action.isDisplayed(ldriver, loginPageRequiredErrorPass);

	}

	public boolean getRequiredMailText() {
		return action.isDisplayed(ldriver, loginPageRequiredErrorMail);

	}

	public String getRegisteredCustomerText() {

		String MyregisteredCustomerText = registeredCustomerText.getText();
		return MyregisteredCustomerText;
	}

	public String haveAccountText() {

		String HaveAccountText = haveAccount.getText();
		return HaveAccountText;
	}
	


}

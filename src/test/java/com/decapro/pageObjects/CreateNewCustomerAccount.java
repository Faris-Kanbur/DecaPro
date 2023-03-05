package com.decapro.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Action;

public class CreateNewCustomerAccount {

	WebDriver ldriver;
	Action action = new Action();

	public CreateNewCustomerAccount(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//strong[contains(text(),'Registered Customers')]")
	@CacheLookup
	WebElement personelInfo;

	@FindBy(xpath = "//input[@id='firstname']")
	@CacheLookup
	WebElement firstName;

	@FindBy(xpath = "//input[@id='lastname']")
	@CacheLookup
	WebElement lastName;

	@FindBy(xpath = "//input[@id='email_address']")
	@CacheLookup
	WebElement email;

	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//input[@id='password-confirmation']")
	@CacheLookup
	WebElement confirmationPassword;

	@FindBy(xpath = "//button[@title='Create an Account']")
	@CacheLookup
	WebElement createAcountBtn;

	@FindBy(xpath = "//div[contains(text(),'Thank you for registering with Fake Online Clothin')]")
	@CacheLookup
	WebElement thanksFakeOnlineText;

	@FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
	@CacheLookup
	WebElement MyAccount;

	@FindBy(xpath = "//div[contains(@id,'error')]")
	@CacheLookup
	List<WebElement> requiredError;
	
	
	@FindBy(xpath = "//div[@class='page messages']")
	@CacheLookup
	WebElement alreadyHaveAccount;
	

	public String getpersonelInfo() {

		String personelInfoText = personelInfo.getText();
		return personelInfoText;
	}

	public boolean getRequiredErrorCount() {
		boolean flag = false;
		int RequiredErrorCount = requiredError.size();
		
		if (RequiredErrorCount <= 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public void setFirstName(String firstname) {
		firstName.sendKeys(firstname);

	}

	public void setLastName(String lastname) {
		lastName.sendKeys(lastname);

	}

	public void setEmail(String mail) {
		email.sendKeys(mail);

	}

	public void setPassword(String pass) {
		password.sendKeys(pass);

	}

	public void setConfirmPassword(String pass) {
		confirmationPassword.sendKeys(pass);

	}

	public void clickCreateAcountBtn() {
		action.scrollByVisibilityOfElement(ldriver, createAcountBtn);
		action.click(ldriver, createAcountBtn);

	}

	public boolean getMyAccountText() {
		return action.isDisplayed(ldriver, MyAccount);

	}

	public boolean getFakeOnlineText() {
		return action.isDisplayed(ldriver, thanksFakeOnlineText);

	}
	
	public String getAlreadyHaveAccount() {
		String haveAccountAlready = alreadyHaveAccount.getText();
		return haveAccountAlready;
	}

}

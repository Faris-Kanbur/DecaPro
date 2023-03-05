package com.decapro.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
    }
	
	
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	@CacheLookup
	WebElement signIn;
	
	@FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
	@CacheLookup
	WebElement createAccount;
	
	
	
	public LoginPage clickSignIn()
	{
		signIn.click();
		return new LoginPage(ldriver);
	}	
	
	public CreateNewCustomerAccount clickCreateAcount()
	{
		createAccount.click();
		return new CreateNewCustomerAccount(ldriver);
	}	
	
}

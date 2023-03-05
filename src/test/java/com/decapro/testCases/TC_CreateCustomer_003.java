package com.decapro.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.decapro.pageObjects.CreateNewCustomerAccount;
import com.decapro.pageObjects.HomePage;

public class TC_CreateCustomer_003 extends BaseClass {
	

	HomePage homepage;
	CreateNewCustomerAccount createNewCustomer;

	@Test
	public void createNewCustomer() throws InterruptedException, IOException {
		
		logger.info("HomePage is opend");
		homepage=new HomePage(driver);
		logger.info("Create an AccountButton is cliked");
		createNewCustomer=homepage.clickCreateAcount();
		
		Thread.sleep(3000);
		
		createNewCustomer.setFirstName(firstName);
		logger.info("Entered username");
		
		
		createNewCustomer.setLastName(lastName);
		logger.info("Entered LastName");
		
		
		createNewCustomer.setEmail(usermail);
		logger.info("Entered Email");
		
		
		createNewCustomer.setPassword(password);
		logger.info("Entered Password");
		
		createNewCustomer.setConfirmPassword(password);
		logger.info("Entered Password");
		
		
		createNewCustomer.clickCreateAcountBtn();
		logger.info("Click the create button");
		
		Boolean RequiredErrorCount = createNewCustomer.getRequiredErrorCount();
		Assert.assertTrue(RequiredErrorCount);
		logger.info("No require text field");
		
		Thread.sleep(3000);
		String AlreadyhaveAccount = createNewCustomer.getAlreadyHaveAccount();
		AssertJUnit.assertFalse(AlreadyhaveAccount.contains("There is already an account with this email address."));
		logger.info("No text : 'AlreadyhaveAccount' ");
		

		Boolean textFakeOnline = createNewCustomer.getFakeOnlineText();
		Assert.assertTrue(textFakeOnline);
		logger.info("Check : Thank you for registering with Fake Online Clothin");
		
		// check if there is a loginPageTitle "My Account"
		Boolean myAccountText = createNewCustomer.getMyAccountText();
		
		if (myAccountText) {
			AssertJUnit.assertTrue(true);
			logger.info("Create customer test passed");
		} else {
			captureScreen(driver, "loginTest");
			AssertJUnit.assertTrue(false);
			logger.info("Create customer test failed");
		}
	}
}

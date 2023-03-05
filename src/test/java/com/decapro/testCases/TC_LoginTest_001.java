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
import java.io.IOException;

import org.testng.Assert;

import com.decapro.pageObjects.HomePage;
import com.decapro.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	HomePage homepage;
	LoginPage loginpage;

	@Test
	public void loginTest() throws IOException, InterruptedException {

		logger.info("HomePage is opened");
		homepage = new HomePage(driver);
		logger.info("click the SignInbutton");
		loginpage = homepage.clickSignIn();

		Thread.sleep(3000);
		logger.info("LoginPage is opened");

		loginpage.setUserMail(usermail);
		logger.info("Entered username");

		loginpage.setPassword(password);
		logger.info("Entered password");

		loginpage.clickSubmit();

		// check if there is a loginError because of wrong pass or mail
		Boolean textLoginError = loginpage.getLoginPageError();
		Assert.assertFalse(textLoginError);

		// check if there is a "This is a required pass filed"
		Boolean requiredTextPass = loginpage.getRequiredPassText();
		Assert.assertFalse(requiredTextPass);
		
		// check if there is a "This is a required mail filed"
		Boolean requiredTextMail = loginpage.getRequiredPassText();
		Assert.assertFalse(requiredTextMail);

		// check if there is a loginPageTitle "Customer Login"
		Boolean text = loginpage.validateloginPageTitle();
		Assert.assertTrue(text);

		// check if there is a loginPageTitle "My Account"
		Boolean myAccountText = loginpage.getMyAccountText();

		if (myAccountText) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

	}

}
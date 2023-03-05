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

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.decapro.pageObjects.HomePage;
import com.decapro.pageObjects.LoginPage;
import com.decapro.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass
{
	HomePage homepage;
	LoginPage loginpage;

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		logger.info("HomePage is opened");
		homepage=new HomePage(driver);
		logger.info("click the SignInbutton");
		loginpage=homepage.clickSignIn();
		
		Thread.sleep(3000);
		logger.info("LoginPage is opened");
		
		loginpage.setUserMail(usermail);
		logger.info("user name provided");
		
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
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/decapro/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}
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

import com.decapro.pageObjects.HomePage;


public class TC_HomePage_000 extends BaseClass{
	
	@Test
	public void homeTest() throws IOException 
	{

		logger.info("URL is opened");
		
		
		if(driver.getTitle().equals("Home Page Magento eCommerce"))
		{
			AssertJUnit.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"hometest");
			AssertJUnit.assertTrue(false);
			logger.info("Login test failed");
		}
		
		HomePage hm=new HomePage(driver);
		hm.clickSignIn();
  }
}

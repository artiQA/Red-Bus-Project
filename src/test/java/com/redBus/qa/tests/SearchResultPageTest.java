package com.redBus.qa.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.redBus.qa.pages.HomePage;
import com.redBus.qa.pages.SearchResultPage;
import com.redBus.qa.testBase.TestBase;
import com.redBus.qa.utility.TestUtils;

public class SearchResultPageTest extends TestBase{
	HomePage home;
	SearchResultPage search;
	TestUtils util;
	
	SearchResultPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		home = new HomePage();
		search = new SearchResultPage();
		util= new TestUtils();
		home.clickonSearch(prop.getProperty("source"), prop.getProperty("destination"));
		
	}
	
	@Test(priority=0)
	public void validateLogo() throws IOException {
		home.validateRedBusLogo();
		Boolean result= home.validateRedBusLogo();
		assertTrue(result);
		
	}
	
	@Test(priority=1)
	public void searchResultTest() throws IOException {
		search.clickOnViewSeat();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		
		if(ITestResult.FAILURE==result.getStatus()||ITestResult.SKIP==result.getStatus())
		{
			String screenshotPath=util.takeScreenshot(driver, result.getName());
			result.setAttribute("screenshotPath", screenshotPath);
		}
		driver.quit();
	}

}

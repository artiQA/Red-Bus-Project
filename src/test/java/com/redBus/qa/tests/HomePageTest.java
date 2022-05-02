package com.redBus.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.redBus.qa.pages.HomePage;
import com.redBus.qa.testBase.TestBase;
import com.redBus.qa.utility.TestUtils;
import com.sun.tools.sjavac.Log;

public class HomePageTest extends TestBase{
	HomePage home;
	TestUtils util;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		log.info("WebBrowser Initialized");
		initialization();
		home = new HomePage();
		util=new TestUtils();
	}
	
	@Test(priority=0)
	public void homePageTitleTest() {
		log.info("TC 01: Validating Home Page title");
		String title = home.validateHomePageTitle();
		Assert.assertEquals(title, prop.getProperty("HomePageTitle"));
	}
	
	@Test(priority=1)
	public void validateRedBusLogoTest() throws IOException {
		log.info("TC 02: Validating RebBus Logo");
		Boolean result= home.validateRedBusLogo();
		assertTrue(result);
	}
	
	@Test(priority=2)
	public void verifyFromfieldPresence() throws IOException {
		log.info("TC 03: Validating From Field presence");
		Boolean result= home.validateFromField();
		assertTrue(result);
		
	}
	
	@Test(priority=3)
	public void verifyTofieldPresence() throws IOException {
		log.info("TC 04: Validating To Field presence");
		Boolean result= home.validateToField();
		assertTrue(result);
	}
	
	@Test(priority=4)
	public void verifyDatefieldPresence() throws IOException {
		log.info("TC 05: Validating Date Field Field presence");
		Boolean result= home.validateDateFieldPresence();
		assertTrue(result);
	}
	
	
	@Test(priority=5)
	public void searchTest() throws InterruptedException, IOException {
		log.info("TC 06: Clicking on Search from Mumbai to Goa");
		home.clickonSearch(prop.getProperty("source"), prop.getProperty("destination"));

	}
	
		
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		
		if(ITestResult.FAILURE==result.getStatus()||ITestResult.SKIP==result.getStatus()) {
			String screenshotPath=util.takeScreenshot(driver, result.getName());
			result.setAttribute("screenshotPath", screenshotPath);
			}
		
		driver.quit();
	}
	
	
	

}

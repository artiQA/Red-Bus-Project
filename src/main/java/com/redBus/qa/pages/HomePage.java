package com.redBus.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.redBus.qa.testBase.TestBase;
import com.redBus.qa.utility.TestUtils;
import com.relevantcodes.extentreports.model.Log;

public class HomePage extends TestBase {
	TestUtils util;
	
	
	//Initialisation
	public HomePage() {
		PageFactory.initElements(driver, this);
		util=new TestUtils();
	}
	
	
	//Validate page Title
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	//Validate Bus logo
	public Boolean validateRedBusLogo() throws IOException {
		return driver.findElement(util.getbjectLocator("home.redBusLogo")).isDisplayed();
	
	}
	
	//Validate Source field
	public Boolean validateFromField() throws IOException {
		return driver.findElement(util.getbjectLocator("home.fromField")).isDisplayed();		
	}
	
	//Validate Destination field
	public Boolean validateToField() throws IOException {
		return driver.findElement(util.getbjectLocator("home.toField")).isDisplayed();
		
	}
	
	//Validate Date Field
	public boolean validateDateFieldPresence() throws IOException {
		return driver.findElement(util.getbjectLocator("home.dateField")).isDisplayed();
	}
	
	// Tap on Search Buses
	public SearchResultPage clickonSearch(String src, String dest) throws IOException {
		writeText(util.getbjectLocator("home.fromField"),src);
		click(util.getbjectLocator("home.firstElement"));
		writeText(util.getbjectLocator("home.toField"),dest);
		click(util.getbjectLocator("home.firstElement"));
		click(util.getbjectLocator("home.dateField"));
		click(util.getbjectLocator("home.currentDay"));
		click(util.getbjectLocator("home.searchCTA"));

		return new SearchResultPage();
	}

}

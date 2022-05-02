package com.redBus.qa.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.redBus.qa.testBase.TestBase;
import com.redBus.qa.utility.TestUtils;

public class SearchResultPage extends TestBase{
	WebDriverWait wait;
	TestUtils util=new TestUtils();
	
	public String validateSearchResultPageTitle() {
		log.info("TC 07: Validating From Field presence");
		return driver.getTitle();
	}
	
	public void clickOnViewSeat() throws IOException {
		log.info("TC 08: Verify First ticket clicking on View ticket");
		if(driver.findElement(util.getbjectLocator("search.busItems")).isDisplayed()) {
		click(util.getbjectLocator("search.viewSeats"));
		}
		else
		{
			System.out.println("Buses are not present");
		}
	}

}

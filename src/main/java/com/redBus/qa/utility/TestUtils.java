package com.redBus.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.redBus.qa.testBase.TestBase;

public class TestUtils extends TestBase{
	public Properties prop;
	
	public TestUtils(){
		super();
	}
	
	public String takeScreenshot(WebDriver driver, String filename) {
		String dateName= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot scr = (TakesScreenshot)driver;
		File src= scr.getScreenshotAs(OutputType.FILE);
		File dest = new File(workingDir+"/Screenshots/"+filename+dateName+".png");
		String errpath=dest.getAbsolutePath();
		log.info(errpath);
		//log.info(errpath);
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errpath;
	}
	

	public By getbjectLocator(String locatorName) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/redBus/qa/config/object.properties");
		prop = new Properties();
		prop.load(fis);
		String locatorProperty = prop.getProperty(locatorName);
		String locatorType = locatorProperty.split(":")[0];
		String locatorValue = locatorProperty.split(":")[1];


		By locator = null;
		switch(locatorType)
		{
		case "Id":
			locator = By.id(locatorValue);
			break;
		case "Name":
			locator = By.name(locatorValue);
			break;
		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "LinkText":
			locator = By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator = By.tagName(locatorValue);
			break;
		case "Xpath":
			locator = By.xpath(locatorValue);
			break;
		}
		return locator;
	}
}



package com.redBus.qa.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	static public WebDriver driver;
	static public Properties prop;
	public static String workingDir;
	public Logger log;
	public WebDriverWait wait;
	
	public TestBase() {
		prop = new Properties();
		log=Logger.getLogger(TestBase.class);

		
		try {
			workingDir= System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/redBus/qa/config/config.properties");
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));

	}
	
	//Click Method
    public void click (By elementBy) {
       // waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }
   
    public void waitVisibility(By elementBy) {
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

	//Write Text
    public void writeText (By elementBy, String text) {
        //waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

}

package com.crm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.constants.ConstantsQA;

public class TestBase {
public static Properties prop;
public static WebDriver driver;
public TestBase(){
		
		try {
			FileInputStream fis = new FileInputStream(new File("G:\\Selenium GIT Code\\SunnyDemoRepository\\src\\main\\java\\Test.property"));
			
			prop = new Properties();
			
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initbrowser(){
		String browser = prop.getProperty("browser");
		System.out.println("Browser Selected is " + " " + browser);
		
		if(ConstantsQA.CHROME_BROWSER.equals(browser)){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Sunny\\Desktop\\Selenium Webdriver jars\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(ConstantsQA.FIREFOX_BROWSER.equals(browser)){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Sunny\\Desktop\\Selenium Webdriver jars\\chromedriver\\chromedriver.exe");
			driver = new FirefoxDriver();

		}else{
			System.setProperty("webdriver.ie.driver","C:\\Users\\Sunny\\Desktop\\Selenium Webdriver jars\\InternetExplorerDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

	}
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(ConstantsQA.IMPLICITWAIT_TIME, TimeUnit.SECONDS);
	      driver.manage().deleteAllCookies();
	      driver.get(prop.getProperty("url"));
	}
}

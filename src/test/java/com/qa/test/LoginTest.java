package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.qa.LoginPage.HomePage;
import com.qa.LoginPage.LoginPage;
import com.qa.constants.ConstantsQA;

public class LoginTest extends TestBase{
	public LoginPage loginPage;
	public HomePage homePage;
public LoginTest(){
	super();
}
	@BeforeMethod
	public void intialisation(){
		initbrowser();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority = 0)
	public void crmLogoTest(){
	boolean actualflag = loginPage.freeCrmLogoValidation();
		Assert.assertTrue(actualflag);
	}
	
	@Test(priority = 1)
	public void validateLoginPageTitleTest(){
		String actualTitle = loginPage.validateLoginPageTitle();
        Assert.assertEquals(actualTitle, ConstantsQA.expectedLogin_Title);
        
	}
	@Test(priority = 2)
	public void loginTest() throws InterruptedException{
		homePage = loginPage.loginsuccessful(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}

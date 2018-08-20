package com.qa.LoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath = "//input[@name ='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name ='password']")
    WebElement password;
	
	@FindBy(xpath = "//input[@value ='Login']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//img[@alt ='free crm logo']")
	WebElement crmLogo;
	
	public LoginPage(){
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle(){
		String actualTitle = driver.getTitle();
		return actualTitle;
	}
	
	public boolean freeCrmLogoValidation(){
		boolean flag = crmLogo.isDisplayed();
		return flag;
	}
	
	public HomePage loginsuccessful(String userName,String passWord) throws InterruptedException{
		username.sendKeys(userName);
		password.sendKeys(passWord);
		Thread.sleep(5000);
		loginbutton.click();
		
		return new HomePage();
		
	}
	
}

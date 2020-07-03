package com.sa.happytrip.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class AdminLoginModel {
	
	public AdminLoginModel(WebDriver driver) {	
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(how = How.ID, using = "username")
	WebElement userName;

	@FindBy(how = How.ID, using = "password")
	WebElement password;
	
	@FindBy(how = How.ID, using = "signInButton")
	WebElement signIn;

	public void sendUsername(String UserName) {
		userName.click();
		userName.clear();
		userName.sendKeys(UserName);
	}

	public void sendPassword(String Password) {
		password.click();
		password.clear();
		password.sendKeys(Password);
	}

	public void SignIN() {
		signIn.click();
	}

	public void assertResult() {
		String actual = "Add";
		String expected = signIn.getText();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
	}
}

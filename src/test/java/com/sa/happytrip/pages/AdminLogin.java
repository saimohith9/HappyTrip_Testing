package com.sa.happytrip.pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sa.happytrip.base.BaseClass;
import com.sa.happytrip.base.DataProvider;
import com.sa.happytrip.util.AdminLoginModel;



public class AdminLogin extends BaseClass {

	@Test(dataProvider = "adminLogin",dataProviderClass = DataProvider.class)
	public void login(String userName,String password) {
	//create page class for home page/login page too
		logs = reports.startTest("login");
			driver.findElement(By.linkText("Log in as admin")).click();
			AdminLoginModel admin = new AdminLoginModel(driver);

			admin.sendUsername("admin@mindtree.com");

			admin.sendPassword("admin");

			admin.SignIN();
			
			admin.assertResult();
			logs.log(LogStatus.PASS, "Login is passed");
	}
}

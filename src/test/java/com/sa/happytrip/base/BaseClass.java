package com.sa.happytrip.base;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sa.happytrip.util.AdminLoginModel;

public abstract class BaseClass {

	protected static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest logs;
	String filePath = "./";
	
	@BeforeTest
	public void startReport() {
	reports = new ExtentReports(filePath +"\\reports\\HappyTripReport.html",true);
	reports.loadConfig(new File(filePath +"\\report-config.xml"));
	}
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://43.254.161.195:8085/happytripcrclean1");
		driver.manage().window().maximize();
			}
	
	@BeforeMethod
	public void login(){
	logs = reports.startTest("login");
		driver.findElement(By.linkText("Log in as admin")).click();
		AdminLoginModel admin = new AdminLoginModel(driver);
		admin.sendUsername("admin@mindtree.com");
		admin.sendPassword("admin");
		admin.SignIN();	
		admin.assertResult();
		logs.log(LogStatus.PASS, "Login is passed");
	}
	@AfterClass
	public static void tearDown() {
		driver.close();
	}
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			logs.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logs.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP) {
			logs.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		reports.endTest(logs);
			}
	
	@AfterTest
	public void endReport() {
		reports.flush();
		reports.close();
	}
}

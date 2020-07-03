package com.sa.happytrip.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class testListener extends BaseClass implements ITestListener{
	
	String filePath = "D:\\work space\\testing\\happytripproject\\screenshots";
	
	public void onTestFailure(ITestResult result) {
		String methodName=result.getName().toString();
		takeScreenShot(methodName, driver);
	}

	private void takeScreenShot(String methodName, WebDriver driver) {
		System.out.println("ScreenShot function called");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println("Screenshot taken");
		//The below method will save the screen shot in d drive with test method name
		try {
		Files.copy(scrFile, new File(filePath+methodName+".png"));
		System.out.println("***Placed screen shot in "+filePath+" ***");
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
}


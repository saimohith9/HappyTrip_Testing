package com.sa.happytrip.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightPageModel {
	
	public FlightPageModel(WebDriver driver) {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(how = How.PARTIAL_LINK_TEXT,partialLinkText = "Schedule Flight")
	public WebElement flightLink;
	
	@FindBy(how = How.ID,id = "flight")
	WebElement selectFlight;
	
	@FindBy(how = How.ID,id = "route")
	WebElement selectRoute;
	
	@FindBy(how = How.ID,id = "distance")
	WebElement distance;
	
	@FindBy(how= How.ID,id = "departureDate")
	WebElement depDate;
	
	@FindBy(how= How.ID,id = "departureTime")
	WebElement depTime;
	
	@FindBy(how= How.ID,id = "arrivalDate")
	WebElement arrDate;
	
	@FindBy(how=How.ID,id = "arrivalTime")
	WebElement arrTime;
	
	@FindBy(how = How.ID,id = "classBusiness")
	WebElement costBusiness;
	
	@FindBy(how=How.ID,id = "classEconomy")
	WebElement costEco;
	
	@FindBy(how = How.ID,id = "signInButton")
	WebElement add;
	
	
	@FindBy(how = How.XPATH,xpath = "//*[@id=\"ContentFrame\"]/div[1]/div/h1")
	WebElement assertFlight;
	
	@FindBy(how = How.XPATH,xpath = "//*[@id=\"ContentFrame\"]/div[1]/div/h1")
	WebElement assertSuccess;
	
	@FindBy(how = How.ID,id = "distance_required")
	public WebElement distanceCheck;
	
	@FindBy(how = How.ID,id = "time_difference")
	public WebElement timeCheck;

	@FindBy(how = How.ID,id = "economy_cost_required")
	public WebElement economyCost;
	
	@FindBy(how = How.ID,id = "business_cost_required")
	public WebElement businessCost;
	public void selectFlight(String flight) {
		Select drpFlight = new Select(selectFlight); 
		drpFlight.selectByVisibleText(flight);
	}
	public void selectFlight(int flight) {
		Select drpFlight = new Select(selectFlight); 
		drpFlight.selectByIndex(flight);
	}
	
	public void selectRoute(String route) {
		Select drpRoute = new Select(selectRoute);
		drpRoute.selectByVisibleText(route);
	}
	
	public void selectRoute(int route) {
		Select drpRoute = new Select(selectRoute);
		drpRoute.selectByIndex(route);
	}
	
	public void distanceValue(String value) {
		distance.click();
		distance.clear();
		distance.sendKeys(value);
	}
	
	public void departureDate(String date) {
		List<WebElement> coloums = depDate.findElements(By.className("ui-datepicker-trigger"));
		for(WebElement dates: coloums) {
			if(dates.getText().equals(date)) {
				dates.findElement(By.linkText(date)).click();
				break;
			}
		}
	}	
	public void departureTime(String value) {
		Select drpTime = new Select(depTime);
		drpTime.selectByVisibleText(value);
	}
	
	public void departureTime(int value) {
		Select drpTime = new Select(depTime);
		drpTime.selectByIndex(value);
	}
	
	public void arrivalDate(String date) {
		List<WebElement> coloums = arrDate.findElements(By.className("ui-datepicker-trigger"));
		for(WebElement dates: coloums) {
			if(dates.getText().equals(date)) {
				dates.findElement(By.linkText(date)).click();
				break;
			}
		}
	}
	
	public void arrivalTime(String value) {
		Select drpTime = new Select(arrTime);
		drpTime.selectByVisibleText(value);
	}
	
	public void arrivalTime(int value) {
		Select drpTime = new Select(arrTime);
		drpTime.selectByIndex(value);
	}
	
	public void clickAdd() {
		add.click();
	}
	
	public void businessCost(String cost) {
		costBusiness.click();
		costBusiness.clear();
		costBusiness.sendKeys(cost);
	}
	
	public void economyCost(String cost){
		costEco.click();
		costEco.clear();
		costEco.sendKeys(cost);
	}
	public void assertResult() {
		String actual = "Schedule a flight";
		String expected =  assertFlight.getText();
		Assert.assertEquals(actual, expected);
	}
	
	public void assertSuccess() {
		String actual = "Schedule added successfuly";
		String expected = assertSuccess.getText();
		Assert.assertEquals(actual, expected);
	}
}

package com.sa.happytrip.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sa.happytrip.base.BaseClass;
import com.sa.happytrip.base.DataProvider;
import com.sa.happytrip.util.FlightPageModel;


public class FlightPage extends BaseClass {
	
	@Test
	public void invalidFieldsVerify() {
		FlightPageModel flight = new FlightPageModel(driver);
		flight.flightLink.click();
		flight.clickAdd();
		flight.assertResult();
	}
	
	@Test(dataProvider = "validFields",dataProviderClass = DataProvider.class)
	public void validFieldsVerify(String flightName,int route,String distance,String depdate,String depTime,
			String arrDate,String arrTime,String businessCost,String ecoCost) {
		logs = reports.startTest("validFields");
		FlightPageModel flight = new FlightPageModel(driver);
		flight.flightLink.click();
		flight.selectFlight(flightName);
		flight.selectRoute(route);
		flight.distanceValue(distance);
		flight.departureDate(depdate);
		flight.departureTime(depTime);
		flight.arrivalDate(arrDate);
		flight.arrivalTime(arrTime);
		flight.businessCost(businessCost);
		flight.economyCost(ecoCost);
		flight.clickAdd();
		flight.assertSuccess();
		logs.log(LogStatus.PASS, "Valid Fields is passed");
	}
	
	
	@Test(dataProvider = "Distance",dataProviderClass = DataProvider.class)
	public void distanceValidation(String distance) {
		logs = reports.startTest("distance Validation");
		FlightPageModel flight = new FlightPageModel(driver);
		flight.flightLink.click();
		flight.distanceValue(distance);
		flight.clickAdd();
		String actual = "Distance should be greater than 0";
		String expected = flight.distanceCheck.getText();
		Assert.assertEquals(actual, expected);
		logs.log(LogStatus.PASS, "Distance Validation is passed");
	}
	
	@Test(dataProvider = "depDates",dataProviderClass = DataProvider.class)
	public void datesCheck(String depDate,String arrDate) {
		logs = reports.startTest("Dates Check");	
		FlightPageModel flight = new FlightPageModel(driver);
		flight.flightLink.click();
		flight.departureDate(depDate);
		flight.arrivalDate(arrDate);
		flight.clickAdd();
		String actual = "Arrival date should be after the departure";
		String expected = flight.timeCheck.getText();
		Assert.assertEquals(actual, expected);
		logs.log(LogStatus.PASS, "Dates Check is passed");
	}
	
	@Test(dataProvider = "times",dataProviderClass = DataProvider.class)
	public void timeCheck(int depTime,int arrTime) {
		logs = reports.startTest("Times Check");	
		FlightPageModel flight = new FlightPageModel(driver);
		flight.flightLink.click();
		flight.arrivalTime(arrTime);
		flight.departureTime(depTime);
		flight.clickAdd();
		String actual = "Arrival time should be after the departure";
		String expected = flight.timeCheck.getText();
		Assert.assertEquals(actual, expected);
		logs.log(LogStatus.PASS, "Times Check is passed");
	}
	
	@Test(dataProvider = "Cost",dataProviderClass = DataProvider.class)
	public void costCheck(String businessCost,String economyCost) {
		logs = reports.startTest("Cost Check");		
		FlightPageModel flight = new FlightPageModel(driver);
		flight.flightLink.click();
		flight.businessCost(businessCost);
		flight.economyCost(economyCost);
		flight.clickAdd();
		String businessActual = "Please provide a valid cost for the Business seats";
		String economyActual = "Please provide a valid cost for the Economy seats";
		String businessExpected = flight.businessCost.getText();
		String economyExpected = flight.economyCost.getText();
		Assert.assertEquals(businessActual, businessExpected);
		Assert.assertEquals(economyActual, economyExpected);
		logs.log(LogStatus.PASS, "Cost Check is passed");
	}
	
	@Test(dataProvider = "arrdeptimes",dataProviderClass = DataProvider.class)
	public void DepArrTimesCheck(String flightName,int route,String distance,String depdate,String depTime,
			String arrDate,String arrTime,String businessCost,String ecoCost) {
		logs = reports.startTest("Dep Arr Times Check");
		FlightPageModel flight = new FlightPageModel(driver);
		flight.flightLink.click();
		flight.selectFlight(flightName);
		flight.selectRoute(route);
		flight.distanceValue(distance);
		flight.departureDate(depdate);
		flight.departureTime(depTime);
		flight.arrivalDate(arrDate);
		flight.arrivalTime(arrTime);
		flight.businessCost(businessCost);
		flight.economyCost(ecoCost);
		flight.clickAdd();
		flight.assertSuccess();
		logs.log(LogStatus.PASS, "Dep Arr Times check is passed");
	}
}

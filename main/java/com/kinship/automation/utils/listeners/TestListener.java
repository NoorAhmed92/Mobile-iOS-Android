package com.kinship.automation.utils.listeners;

import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.utils.drivers.DriverManager;
import io.qameta.allure.Attachment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	//Attachment for allure
	@Attachment(value="Page screenshot", type="image/png")
	public byte[] saveScreenshotPng(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value="{0}", type="text/plain")
	public static String saveTextLog(String message) {
		return message;
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		WebDriver driver = DriverManager.getDriver();
		String sTestName =  result.getMethod().getMethodName() + " ("+ FrameworkConfigFactory.getConfig().platform().toString() + ")";
		if(FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android") || FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase(("iOS")) ) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\"" + sTestName + "\" }}");
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = DriverManager.getDriver();
		if(driver instanceof WebDriver) {
			saveScreenshotPng(driver);
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

   
}

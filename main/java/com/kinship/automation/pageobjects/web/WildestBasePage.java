package com.kinship.automation.pageobjects.web;

import com.kinship.automation.utils.commonutils.TestDriver;
import com.kinship.automation.utils.commonutils.TestDriver.ScrollDirection;
import io.qameta.allure.Step;

public class WildestBasePage {

	protected TestDriver driver;

	public WildestBasePage(){
	        
	    }
	 
	public WildestBasePage(TestDriver driver){
        this.driver=driver;
    }

    @Step("Navigating to home url")
	public HomePage navigateToHomePage(String url) {
		driver.navigateTo(url);
		return new HomePage(driver);
	}
	
	public void scroll(ScrollDirection direction) {
		driver.scroll(direction);
	}
	
	public void scroll(ScrollDirection direction, double distance) {
		driver.scroll(direction, distance);
	}
	
	public void scrollPageUpOrDown(ScrollDirection direction) {
		driver.scrollPageUPOrDown(direction, 5, 300);
	}

	public void scrollPageUpOrDown(TestDriver.ScrollDirection direction, int scrollTimes, int ScrollBy){
		driver.scrollPageUPOrDown(direction, 1, 800);
	}
}

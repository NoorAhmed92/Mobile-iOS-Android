package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import org.openqa.selenium.By;

public class SafePlacesPage extends WhistleBasePage {
    private By addPlace= ByT.locator(By.id("Add a Place"),By.id("places_list_add_place"));
    private By addressField= ByT.locator(By.xpath("//*[@value='Address']"),By.id("place_setup_address_field"));
    private By listOfMatchingAddress= ByT.locator(By.id("New York, NY"),By.xpath("//*[@text='New York']"));
    private By enterLocationManually= ByT.locator(By.xpath("//*[@id=concat('I', \"'\", 'll enter it manually')]"),By.id(""));

    public SafePlacesPage(TestDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public boolean clickOnAddPlace(){
        driver.clickLocator(addPlace);
        return true;
    }
    public String enterAddress(String placeName){
        driver.clickLocator(addressField);
        driver.type(addressField, placeName);
        return placeName;
    }
    public boolean isListOfMatchingAddressDisplayed(){
        driver.pauseExecutionFor(10);
        driver.isElementPresent(listOfMatchingAddress);
        return true;
    }
    public void clickOnEnterManualLocationOption(){
        driver.pauseExecutionFor(2);
        driver.clickLocator(enterLocationManually);
    }
}

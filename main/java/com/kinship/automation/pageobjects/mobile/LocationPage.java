package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LocationPage extends WhistleBasePage {

    TestDriver driver;

    private By mapTab=ByT.locator(By.xpath("//XCUIElementTypeStaticText[@name='Location']//following::XCUIElementTypeOther[4]"),By.xpath("//*[@class='android.widget.RelativeLayout' and ./*[@class='android.widget.ImageView']]"));
    private By petPinHead=ByT.locator(By.id("battery-charging-button"),By.id("status_banner_bg"));
    private By mapTypeIcon=ByT.locator(By.id("location - map type button"),By.id("location_screen_show_map_types_btn"));
    private By findMyPetCTA=ByT.locator(By.id("Find My Pet"),By.id("location_history_current_panel_tracking_btn"));
    private By locationTabEmptyHeader=ByT.locator(By.id("Location not available"),By.id("location_tab_empty_state_header"));
    private By stopCTA=ByT.locator(By.id("Stop"),By.id("tracking_button"));
    private By start=ByT.locator(By.id("Start"),By.id("md_buttonDefaultNegative"));
    private By cancel=ByT.locator(By.id("Cancel"),By.id("md_buttonDefaultPositive"));
    private By startCTA=ByT.locator(By.xpath("//XCUIElementTypeButton[@name='Keep tracking']"),By.id("md_buttonDefaultNegative"));
    private By cancelCTA=ByT.locator(By.xpath("//XCUIElementTypeButton[@name='Yes, cancel']"),By.id("md_buttonDefaultPositive"));

    public LocationPage(TestDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isPetPinLeadDisplayed() {
        return driver.isElementPresent(petPinHead);
    }

    public boolean isMapTypeIconDisplayed() {
        return driver.isElementPresent(mapTypeIcon);
    }

    public boolean isMapIconDisplayed() {
        return driver.isElementPresent(mapTab);
    }

    public boolean isFindMyPetDisplayed() {
        driver.pauseExecutionFor(4);
        return driver.isElementPresent(findMyPetCTA);
    }

    public boolean isFindMyPetEnabled() {
        return driver.isElementEnabled(findMyPetCTA);
    }

    @Step("Click Find My Pet CTA")
    public void clickFindMyPet()  {
        driver.clickLocator(findMyPetCTA);
    }

    @Step("Click Stop CTA")
    public void clickStopCTA()  {
        driver.clickLocator(stopCTA);
    }

    public boolean isStartCTADisplayed() {
        driver.pauseExecutionFor(2);
        return driver.isElementPresent(startCTA) || driver.isElementPresent(start);
    }

    public boolean isCancelCTADisplayed() {
        driver.pauseExecutionFor(2);
        return driver.isElementPresent(cancelCTA) || driver.isElementPresent(cancel);
    }

    public void clickCancelCTA() {
        driver.clickLocator(cancelCTA);
    }
    public String getLocationTabEmptyHeaderText() {
        driver.isElementPresent(locationTabEmptyHeader);
        return driver.getText(locationTabEmptyHeader,"Get Location Tab Header Text").trim();
    }
}
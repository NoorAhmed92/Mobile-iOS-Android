package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ActivityPage extends WhistleBasePage {

    public TestDriver driver;

    private By shareActivity  = ByT.locator(By.id("share activity"), By.id("activity_details_share_button"));
    private By activeMinutesInActivity = ByT.locator(By.xpath("//XCUIElementTypeButton[@name='share activity']//following-sibling::XCUIElementTypeStaticText[9]"));
    private By minutesActive  = ByT.locator(By.id("activity_details_minutes_active"));
    private By activityGoalDivisor  = ByT.locator(By.id("activity_details_goal_divisor"));
    public ActivityPage(TestDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isShareActivityDisplayed() {
        return driver.isElementPresent(shareActivity);
    }

    /**
     * @return string text value for Active minutes/Activity goal divisor in Android and iOS
     * from Activity screen
     */
    @Step("Get Active minutes from Activity screen\"")
    public String getActiveMinutesFromActivity() {
        String activeMins = "";
        driver.pauseExecutionFor(3);
        if(isAndroidBS()){
            activeMins = driver.findElement(minutesActive).getText().trim()+driver.findElement(activityGoalDivisor).getText().trim();
        }else
        {
            activeMins = driver.getText(activeMinutesInActivity,"Get Active minutes from Activity screen").trim();
        }
        return activeMins;
    }
}



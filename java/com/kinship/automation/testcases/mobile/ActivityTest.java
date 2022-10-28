package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.pageobjects.mobile.HomePageWhistle;
import com.kinship.automation.pageobjects.mobile.SignInPage;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Jyoti Basera
 * created on 2022/08/02
 */
@Listeners(TestListener.class)
public class ActivityTest extends MobileBaseTest {

    @TestRails(id = "1016340")
    @Description("Data on the card and activity detail page should show the same results for the day")
    @Test(priority = 0, groups = {"P1"})
    @Feature("Activity")
    public void testActiveMinutesDataOnHomeAndActivity() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageW04Device();
            homePageWhistle.handleNotificationBanner();
        }

        String sActiveMinutesHome = homePageWhistle.getActiveMinutesFromHome();
        whistleBasePage.write2Log4jAllureStep("Get Active minutes from Home dashboard screen: "+sActiveMinutesHome);

        whistleBasePage.write2Log4jAllureStep("Click on Activity widget on dashboard");
        activityPage = homePageWhistle.clickActivityWidget();

        String sActiveMinutesActivity = activityPage.getActiveMinutesFromActivity();
        whistleBasePage.write2Log4jAllureStep("Get Active minutes from Activity screen: " +sActiveMinutesActivity);

        whistleBasePage.write2Log4jAllureStep("Validate if Active Minutes data on Home dashboard:" +sActiveMinutesHome+" equals to Active Minutes data on Activity screen:"+sActiveMinutesActivity);
        Assert.assertEquals(sActiveMinutesHome, sActiveMinutesActivity);
    }
}

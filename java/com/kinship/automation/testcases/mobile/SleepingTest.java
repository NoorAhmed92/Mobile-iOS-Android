package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.pageobjects.mobile.HomePageWhistle;
import com.kinship.automation.pageobjects.mobile.SignInPage;
import com.kinship.automation.pageobjects.mobile.SleepingPage;
import com.kinship.automation.utils.testrail.TestRails;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.kinship.automation.utils.commonutils.TestDriver.ScrollDirection.UP;

public class SleepingTest extends MobileBaseTest {

    /**
     * @author Noor Ahmed
     * created on 2022/08/01
     */
    @TestRails(id = "1016436")
    @Description("Validate Sleeping page")
    @Test(priority = 0, groups = {"P1"})
    @Feature("Validate Sleeping page")

    public void testSleepingPage() {

        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        SleepingPage sleepingPage = new SleepingPage(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        testDriver.swipe(UP);
        homePageWhistle.clickOnSleeping();
        whistleBasePage.write2Log4jAllureStep("Verify Sleeping page is displayed");
        Assert.assertTrue(sleepingPage.isSleepingHeaderDisplayed(), "Verify Sleeping page is not displayed");
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("iOS")) {
            whistleBasePage.write2Log4jAllureStep("Verify Top Card is displayed on Sleeping page");
            Assert.assertTrue(sleepingPage.isTopCardDisplayedOnSleepingPage(), "Top Card is not displayed on sleeping page");
        }
        whistleBasePage.write2Log4jAllureStep("Verify Graph section is displayed on sleeping page");
        Assert.assertTrue(sleepingPage.isGraphSectionDisplayedOnSleepingPage(), "Graph section is not displayed on sleeping page");
    }
}

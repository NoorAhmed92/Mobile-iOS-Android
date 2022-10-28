package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.pageobjects.mobile.HealthPage;
import com.kinship.automation.pageobjects.mobile.HomePageWhistle;
import com.kinship.automation.pageobjects.mobile.SignInPage;
import com.kinship.automation.utils.testrail.TestRails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.kinship.automation.utils.commonutils.TestDriver.ScrollDirection.UP;

public class ScratchingModalTest extends MobileBaseTest {
    /**
     * Created by Jameel Mohammed on 1st August, 2022
     **/
    @TestRails(id = "1016390")
    @Description("Validating Full screen modal for Scratching")
    @Test(priority = 0, groups = {"P1"})
    @Feature("Modal")
    public void testModalFullScreenStatuses() {
        SignInPage signInPage = new SignInPage(testDriver);
        HealthPage healthPage = new HealthPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {
            whistleBasePage.write2Log4jAllureStep("Scrolling up to Drinking");
            testDriver.scrollToText((AppiumDriver<MobileElement>) driver, "Drinking");
        } else {
            whistleBasePage.write2Log4jAllureStep("Scrolling up to Drinking");
            testDriver.swipe(UP);
        }
        whistleBasePage.write2Log4jAllureStep("Clicking on Scratching detail option");
        homePageWhistle.clickScratchingDetailInHomeScreen();

        whistleBasePage.write2Log4jAllureStep("Verifying Scratching statuses title is displayed");
        Assert.assertTrue(healthPage.isScratchingStatusesTitleDisplayed(), "Scratching statuses title is not displayed");

        whistleBasePage.write2Log4jAllureStep("Validating Scratching statuses");
        Assert.assertTrue(healthPage.isScratchingStatusesDisplayed(), "Scratching statuses are not displayed");

        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {
            whistleBasePage.write2Log4jAllureStep("Scrolling up to Chat with a Vet");
            testDriver.scrollToText((AppiumDriver<MobileElement>) driver, "Chat with a Vet");
        } else {
            whistleBasePage.write2Log4jAllureStep("Scrolling up to Chat with a Vet");
            testDriver.swipe(UP);
        }
        whistleBasePage.write2Log4jAllureStep("Validating Learn about scratching option is displayed");
        Assert.assertTrue(healthPage.isLearnAboutScratchingDisplayed(), "Learn about Scratching option is not displayed");
        whistleBasePage.write2Log4jAllureStep("Validating Chat with a Vet option is displayed");
        Assert.assertTrue(homePageWhistle.isChatWithVetOptionDisplayed(), "Chat with a Vet option is not displayed");
    }
}
package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.pageobjects.mobile.*;
import com.kinship.automation.utils.listeners.Retry;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import com.kinship.automation.constants.WhistleConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static com.kinship.automation.utils.commonutils.TestDriver.ScrollDirection.UP;

/**
 * Created by Jyoti Basera on 7 Feb, 2022
 **/

@Listeners(TestListener.class)
public class HealthChatTest extends MobileBaseTest {

    List<String> healthOption = new ArrayList<String>();

    @TestRails(id = "1016379")
    @Description("Verify Chat with Vet Link")
    @Test(priority = 0, groups = {"P0"}, retryAnalyzer = Retry.class)
    @Feature("ChatWithVetLink")
    public void testChatWithVetOpt() {
        LandingPage landingPage = new LandingPage(testDriver);
        HealthPage healthPage = new HealthPage(testDriver);

        healthOption.add("Scratching");
        healthOption.add("Licking");
        healthOption.add("Eating");
        healthOption.add("Drinking");

        if (!landingPage.isSignInBtnDisplayed()) {
            log.info("user is already logged in");
        } else {
            log.info("Clicked on Sign in Button");
            signInPage = landingPage.clickSignInLnk();

            log.info("Enter Email Address / User ID " + WhistleConstants.EMAIL_MOBILE);
            signInPage.enterEmail(WhistleConstants.EMAIL_MOBILE);

            log.info("Enter Password " + WhistleConstants.PASSWORD);
            signInPage.enterPassword(WhistleConstants.PASSWORD);

            log.info("Click on Login button");
            homePageWhistle = signInPage.clickLoginBtn();

            log.info("Verifying for Family Trip screen");
            homePageWhistle.handleNotificationBanner();
        }

        for(int i=0; i<healthOption.size();i++){
            testDriver.swipe(UP);
            healthPage.verifyLearnAndChat(healthOption.get(i));
        }
    }
    /**
     * @author Noor Ahmed
     * created on 2022/08/03
     */
    @TestRails(id = "1016437")
    @Description("Validate Month toggle")
    @Test(priority = 1, groups = {"P1"})
    @Feature("Validate Month toggle")

    public void testMonthToggle() {

        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        LickingPage lickingPage = new LickingPage(testDriver);
        HealthPage healthPage = new HealthPage(testDriver);
        healthOption.add("Scratching");
        healthOption.add("Licking");
        healthOption.add("Drinking");
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        for(int i=0; i<healthOption.size();i++) {
            testDriver.swipe(UP);
            homePageWhistle.clickOnHealthOptions(healthOption.get(i));
            whistleBasePage.write2Log4jAllureStep("Click on Month toggle");
            if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {
                lickingPage.clickOnMonth();
            } else {
                lickingPage.clickOnMonthToggle();
            }
            whistleBasePage.write2Log4jAllureStep("Verify Top card is displayed for " + healthOption.get(i));
            Assert.assertTrue(lickingPage.isDateViewDisplayed(), "Verify Top card is not displayed for " +  healthOption.get(i));
            whistleBasePage.write2Log4jAllureStep("Verify Graph updates from Week view to Month view for "+ healthOption.get(i));
            if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {
                Assert.assertTrue(lickingPage.isGraphSectionDisplayed(), "Graph section is not displayed for "+ healthOption.get(i));
            } else {
                Assert.assertTrue(lickingPage.verifyGraphViewForMonth(), "Graph view is not updated to month view for "+ healthOption.get(i));
            }
            healthPage.backToHomeScreen();
        }
    }

    /**
     * @author Noor Ahmed
     * created on 2022/08/08
     */
    @TestRails(id = "1016438")
    @Description("Validate Week toggle")
    @Test(priority = 1, groups = {"P1"})
    @Feature("Validate Week toggle")

    public void testWeekToggle() {

        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        LickingPage lickingPage = new LickingPage(testDriver);
        HealthPage healthPage = new HealthPage(testDriver);
        healthOption.add("Scratching");
        healthOption.add("Licking");
        healthOption.add("Drinking");
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        for(int i=0; i<healthOption.size();i++) {
            testDriver.swipe(UP);
            homePageWhistle.clickOnHealthOptions(healthOption.get(i));
            whistleBasePage.write2Log4jAllureStep("Verify Top card is displayed for" + healthOption.get(i));
            Assert.assertTrue(lickingPage.isDateViewDisplayed(), "Verify Top card is not displayed for" + healthOption.get(i));
            whistleBasePage.write2Log4jAllureStep("Verify Graph updates from Month view to Week view for" + healthOption.get(i));
            if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {
                Assert.assertTrue(lickingPage.isGraphSectionDisplayed(), "Graph section is not displayed for" + healthOption.get(i));
            } else {
                Assert.assertTrue(lickingPage.verifyGraphViewForWeek(), "Graph view is not updated to Week view for" + healthOption.get(i));
            }
            healthPage.backToHomeScreen();
        }
    }
}

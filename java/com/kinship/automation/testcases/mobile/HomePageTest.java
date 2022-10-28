package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.pageobjects.mobile.EatingPage;
import com.kinship.automation.pageobjects.mobile.HomePageWhistle;
import com.kinship.automation.pageobjects.mobile.SignInPage;
import com.kinship.automation.utils.testrail.TestRails;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.kinship.automation.utils.commonutils.TestDriver.ScrollDirection.UP;

public class HomePageTest  extends MobileBaseTest {

/**
* Created by Noor Shaik on 22 June, 2022
**/
    @TestRails(id = "1016328")
    @Description("Validate Health card on Dashboard")
    @Test(priority = 0, groups = {"P0"})
    @Feature("Validate Health card on Dashboard")

    public void testHealthCardDashboard() {

        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        log.info("Scroll the Screen");
        testDriver.swipe(UP);

        whistleBasePage.write2Log4jAllureStep("Verifying Health Dashboard is Displayed");
        Assert.assertTrue(homePageWhistle.isCheckHealthDashboardDisplayed(), "Health Dashboard is not displayed");
        testDriver.swipe(UP);

        whistleBasePage.write2Log4jAllureStep("Verifying Scratching tab is Displayed");
        Assert.assertTrue(homePageWhistle.isCheckScratchingTextDisplayed(), "Scratching tab is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Licking tab is Displayed");
        Assert.assertTrue(homePageWhistle.isCheckLickingTextDisplayed(), "Licking tab is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Sleeping tab is Displayed");
        Assert.assertTrue(homePageWhistle.isCheckSleepingTextDisplayed(), "Sleeping tab is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Eating tab is Displayed");
        Assert.assertTrue(homePageWhistle.isCheckEatingTextDisplayed(), "Eating tab is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Drinking tab is Displayed");
        Assert.assertTrue(homePageWhistle.isCheckDrinkingTextDisplayed(), "Drinking tab is not displayed");
    }

/**
* Created by Noor Shaik on 23 June, 2022
**/
    @TestRails(id = "1016381")
    @Description("Navigation - AM2/W04 Dogs ")
    @Test(priority = 1, groups = {"P0"})
    @Feature("Navigation - AM2/W04 Dogs ")

    public void testNavigationBar() {

        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageMultiPet();
            homePageWhistle.handleNotificationBanner();
        }

        whistleBasePage.write2Log4jAllureStep("Verifying Home tab is Displayed");
        Assert.assertTrue(homePageWhistle.isCheckHomeIconDisplayed(), "Home tab is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Activity tab is Displayed");
        Assert.assertTrue(homePageWhistle.ischeckActivityIconDisplayed(), "Activity tab is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Location tab is Displayed");
        Assert.assertTrue(homePageWhistle.isCheckLocationIconDisplayed(), "Location tab is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Pet tab is Displayed");
        Assert.assertTrue(homePageWhistle.ischeckPetIconDisplayed(), "Pet tab is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Human tab is Displayed");
        Assert.assertTrue(homePageWhistle.ischeckHumanIconDisplayed(), "Human tab is not displayed");
    }

/**
* Created by Noor Shaik on 4 July, 2022
**/
    @TestRails(id = "1016366")
    @Description("Data sync happens for all of the widgets upon successful log in and lands on the Home tab")
    @Test(priority = 2, groups = {"P0"})
    @Feature("Data sync happens for all of the widgets upon successful log in and lands on the Home tab ")

    public void testDataSyncOnHomePage() {

        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }

        whistleBasePage.write2Log4jAllureStep("Verifying Wellness section on homepage is Displayed");
        Assert.assertTrue(homePageWhistle.verifyWellnessSection(), "Wellness section is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Activity timestamp Today is Displayed");
        Assert.assertTrue(homePageWhistle.isTodayTextisplayed(), "Activity timestamp Today is not displayed");
        testDriver.swipe(UP);

        whistleBasePage.write2Log4jAllureStep("Verifying Health Section is Displayed");
        Assert.assertTrue(homePageWhistle.verifyHealthSection(), "Health Section is not displayed");
    }

/**
* Created by Noor Shaik on 5 July, 2022
**/
    @TestRails(id = "1016310")
    @Description("Eating Tab")
    @Test(priority = 3, groups = {"P0"})
    @Feature("Eating Tab")

    public void testEatingTabNavigation() {

        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        EatingPage eatingPage = new EatingPage(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        testDriver.swipe(UP);
        whistleBasePage.write2Log4jAllureStep("Verifying Eating tab on homepage is clicked");
        testDriver.swipe(UP);
        Assert.assertTrue(homePageWhistle.clickOnEatingTab(), "Eating tab is not clicked");

        whistleBasePage.write2Log4jAllureStep("After clicking on eating tab then Verify the navigation to eating screen is displayed");
        Assert.assertTrue(eatingPage.isEatingHeaderDisplayed(), "the navigation to eating screen is not displayed");
    }

/**
* Created by Murali Jaladurgam on 14 July, 2022
**/
    @TestRails(id = "1016367")
    @Description("All the pets on the account are visible or available to select")
    @Test(priority = 4, groups = {"P1"})
    @Feature("All the pets on the account are visible or available to select")

    public void testMultiPetsNameVisibleVerification() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageMultiPet();
            homePageWhistle.handleNotificationBanner();
        }

        whistleBasePage.write2Log4jAllureStep("Verify the Home tab display for AM2 device ");

        whistleBasePage.write2Log4jAllureStep("Verifying the First Pet profile Pic or Alphabet is Displayed ");
        Assert.assertTrue(homePageWhistle.isFirstPetProfilePicOrAlphabetDisplayed(), "Pet profile  Pic or Alphabet is not Displayed ");

        whistleBasePage.write2Log4jAllureStep("Verifying First Pet profile is selected");
        Assert.assertTrue(homePageWhistle.isFirstPetProfileSelected(), "First Pet profile is not selected");

        whistleBasePage.write2Log4jAllureStep("Verifying second pet profile is not selected and it is in right side ");
        Assert.assertFalse(homePageWhistle.isSecondPetProfileSelected(), "Second pet profile is selected and it is in right side ");

        whistleBasePage.write2Log4jAllureStep("Click on Second Pet Image");
        homePageWhistle.clickSecondPetImage();
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")) {
            if (homePageWhistle.isW05EnableBLEBannerPresent()) {
                whistleBasePage.write2Log4jAllureStep("Click on enable button");
                homePageWhistle.clickEnableButton();
            }
        }

        whistleBasePage.write2Log4jAllureStep("Verifying the Second Pet profile Pic or Alphabet is Displayed ");
        Assert.assertTrue(homePageWhistle.isSecondPetProfilePicOrAlphabetDisplayed(), "Second Pet profile  Pic or Alphabet is not Displayed ");

        whistleBasePage.write2Log4jAllureStep("Verifying Second Pet profile is selected");
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios"))
            Assert.assertTrue(homePageWhistle.isFirstPetProfileSelected(), "Second Pet profile is not selected");
        else
            Assert.assertTrue(homePageWhistle.isSecondPetProfileSelected(), "Second Pet profile is not selected");

        whistleBasePage.write2Log4jAllureStep("Verifying First Pet profile is not selected ");
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios"))
            Assert.assertFalse(homePageWhistle.isSecondPetProfileSelected(), "First Pet profile is selected");
        else
            Assert.assertFalse(homePageWhistle.isFirstPetProfileSelected(), "First Pet profile is selected");
    }

/**
* Created by Murali Jaladurgam on 19 July, 2022
**/
    @TestRails(id = "994068")
    @Description("Valid User Landed on Home Screen ")
    @Test(priority = 5, groups = {"P1"})
    @Feature("Valid User (AM2/w04) Landed on Home Screen ")

    public void testValidUserHomeScreen() {

        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageMultiPet();
            homePageWhistle.handleNotificationBanner();
        }

        whistleBasePage.write2Log4jAllureStep("Verifying Home tab is Displayed for AM2 user");
        Assert.assertTrue(homePageWhistle.isCheckHomeIconDisplayed(), "Home tab is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying AM2 User logged in ");
        Assert.assertEquals(homePageWhistle.getCurrentUser(),"AM2","AM2 user not logged in ");
     }

/**
* Created by Noor Shaik on 20 July, 2022
**/
    @TestRails(id = "1016346")
    @Description("Validate the header and pet selector for the Home/Wifi(Home)icon for a GPS device")
    @Test(priority = 6, groups = {"P1"})
    @Feature("Validate the header and pet selector for the Home/Wifi(Home)icon for a GPS device")

    public void testTinyHomeIcon() {

        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }

        whistleBasePage.write2Log4jAllureStep("Verifying Tiny Home Icon");
        Assert.assertTrue(homePageWhistle.isTinyHomeIconDisplayed(), "Tiny Home Icon is not displayed");
    }

/**
* Created by Noor Shaik on 25 July, 2022
**/
    @TestRails(id = "1016345")
    @Description("Validate the Pet picker With No custom picture - Pet identifier")
    @Test(priority = 6, groups = {"P1"})
    @Feature("Validate the Pet picker With No custom picture - Pet identifier")

    public void testGenericPicture() {

        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageMultiPet();
            homePageWhistle.handleNotificationBanner();
        }

        whistleBasePage.write2Log4jAllureStep("Verifying If the pet does not have an avatar Validate a generic picture");
        Assert.assertTrue(homePageWhistle.isSecondPetProfilePicOrAlphabetDisplayed(), "Generic picture is not displayed");
    }
}



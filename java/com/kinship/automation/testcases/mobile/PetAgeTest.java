package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.constants.WhistleConstants;
import com.kinship.automation.pageobjects.mobile.HomePageWhistle;
import com.kinship.automation.pageobjects.mobile.LandingPage;
import com.kinship.automation.utils.testrail.TestRails;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetAgeTest extends MobileBaseTest {

/**
* Created by Jyoti Basera on 02 June, 2022
**/
    @TestRails(id = "1008548")
    @Description("Age - Valid")
    @Test(priority = 0, groups = {"P2"})
    @Feature("Age - Valid")
    public void testPetValidAge() {
        LandingPage landingPage = new LandingPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);

        if (!landingPage.isSignInBtnDisplayed()) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            whistleBasePage.write2Log4jAllureStep("Clicked on Sign in Button");
            signInPage = landingPage.clickSignInLnk();

            whistleBasePage.write2Log4jAllureStep("Enter Email Address / User ID " + FrameworkConfigFactory.getConfig().emailMobile());
            signInPage.enterEmail(FrameworkConfigFactory.getConfig().emailMobile());

            whistleBasePage.write2Log4jAllureStep("Enter Password " + FrameworkConfigFactory.getConfig().passwordMobile());
            signInPage.enterPassword(FrameworkConfigFactory.getConfig().passwordMobile());

            whistleBasePage.write2Log4jAllureStep("Click on Login button");
            homePageWhistle = signInPage.clickLoginBtn();

            whistleBasePage.write2Log4jAllureStep("Verify Family Notification Screen");
            homePageWhistle.handleNotificationBanner();
        }

        whistleBasePage.write2Log4jAllureStep("Click on Pet");
        viewPetProfilePage = homePageWhistle.clickPetMenuOptn();

        whistleBasePage.write2Log4jAllureStep("Click on Pet Edit Icon");
        petEditProfilePage = viewPetProfilePage.selectEditIcon();

        whistleBasePage.write2Log4jAllureStep("Select Pet's Age in Edit Pet Profile");
        petEditProfilePage.clickOnAge();

        whistleBasePage.write2Log4jAllureStep("Select Pet's age in years");
        petEditProfilePage.enterYear(WhistleConstants.UPDATE_AGE);

        whistleBasePage.write2Log4jAllureStep("Select Pet's age in months");
        petEditProfilePage.enterMonths(WhistleConstants.UPDATE_AGE);
        petEditProfilePage.clickPetAgeYear();

        whistleBasePage.write2Log4jAllureStep("Click on save button");
        if ((FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android"))) {
            petEditProfilePage.clickOnSaveButton();
        } else {
            petEditProfilePage.clickOnAge();
        }

        whistleBasePage.write2Log4jAllureStep("Get the age value");
        String getUpdatedAge =petEditProfilePage.getUpdatedAge();

        whistleBasePage.write2Log4jAllureStep("Verify age has been updated ");
       Assert.assertEquals(getUpdatedAge, petEditProfilePage.getExpectedAge());
    }

/**
* Created by Jyoti Basera on 02 June, 2022
**/
    @TestRails(id = "1008549")
    @Description("Age - 0 years, 0 months")
    @Test(priority = 1, groups = {"P1"})
    @Feature("Age - Zero")
    public void testPetAgeZero() {
        if ((FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android"))) {
        LandingPage landingPage = new LandingPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);

        if (!landingPage.isSignInBtnDisplayed()) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            whistleBasePage.write2Log4jAllureStep("Clicked on Sign in Button");
            signInPage = landingPage.clickSignInLnk();

            whistleBasePage.write2Log4jAllureStep("Enter Email Address / User ID " + FrameworkConfigFactory.getConfig().emailMobile());
            signInPage.enterEmail(FrameworkConfigFactory.getConfig().emailMobile());

            whistleBasePage.write2Log4jAllureStep("Enter Password " + FrameworkConfigFactory.getConfig().passwordMobile());
            signInPage.enterPassword(FrameworkConfigFactory.getConfig().passwordMobile());

            whistleBasePage.write2Log4jAllureStep("Click on Login button");
            homePageWhistle = signInPage.clickLoginBtn();

            whistleBasePage.write2Log4jAllureStep("Verify Family Notification Screen");
            homePageWhistle.handleNotificationBanner();
        }

        whistleBasePage.write2Log4jAllureStep("Click on Pet");
        viewPetProfilePage = homePageWhistle.clickPetMenuOptn();

        whistleBasePage.write2Log4jAllureStep("Click on Pet Edit Icon");
        petEditProfilePage = viewPetProfilePage.selectEditIcon();

        whistleBasePage.write2Log4jAllureStep("Select Pet's Age in Edit Pet Profile");
        petEditProfilePage.clickOnAge();

        whistleBasePage.write2Log4jAllureStep("Select Pet's age in years");
        petEditProfilePage.enterYear(WhistleConstants.UPDATE_AGE_ZERO);

        whistleBasePage.write2Log4jAllureStep("Select Pet's age in months");
        petEditProfilePage.enterMonths(WhistleConstants.UPDATE_AGE_ZERO);
        petEditProfilePage.clickPetAgeYear();

        whistleBasePage.write2Log4jAllureStep("Verify save Button is disabled for zero age");
        Assert.assertFalse(petEditProfilePage.isSaveButtonEnabled(), "Save Button is enabled");
    } else
            whistleBasePage.write2Log4jAllureStep("This test is not in scope for iOS Automation as Age in months can't be selected to zero");
    }
}

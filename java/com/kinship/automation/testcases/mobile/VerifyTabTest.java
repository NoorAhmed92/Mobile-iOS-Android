package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.constants.WhistleConstants;
import com.kinship.automation.pageobjects.mobile.*;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.kinship.automation.utils.commonutils.TestDriver.ScrollDirection.UP;

/**
 * Created by Murali Jaladurgam on 17 Feb, 2022
 * */

@Listeners(TestListener.class)
public class VerifyTabTest extends MobileBaseTest {

/**
* Created by Murali Jaladurgam on 17 Feb, 2022
**/
    @TestRails(id = "1008240")
    @Description("Navigation - W04/AM2 Dogs")
    @Test(priority = 0, groups = {"BAT", "P0"})
    @Feature("Navigation")
    public void testDisplayHomeScreenAfterLogin() {
        SignInPage signInPage = new SignInPage(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            log.info("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        log.info("Verifying if Location Icon is displayed");
        signInPage.assertTab("Location");

        log.info("Verifying if Activity Icon is displayed");
        signInPage.assertTab("Activity");

        log.info("Verifying if Pet Icon is displayed ");
        signInPage.assertTab("Pet");

        log.info("Verifying if Human icon is displayed");
        signInPage.assertTab("Human");
    }

/**
* Created by Achal Kumar Jain on 06 June, 2022
**/
    @TestRails(id = "1009993")
    @Description("Single pet with AM2S/AM2 device ")
    @Test(priority = 1, groups = {"P0"})
    @Feature("Single pet with AM2S/AM2 device")
    public void testVerifyTabsAccountAM2() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        HumanStuffPage humanStuffPage = new HumanStuffPage(testDriver);
        AccountInformationPage accountInformationPage = new AccountInformationPage(testDriver);
        LandingPage landingPage = new LandingPage(testDriver);

        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            log.info("user is already logged in");
            log.info("Click on Human Tab");
            if ((FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android"))) {
                humanStuffPage.clickHumanIcon();
            } else {
                humanStuffPage.clickHumanIcon();
            }
            log.info("Scroll up to Account Information");
            if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {
                testDriver.scrollToText((AppiumDriver<MobileElement>) driver, "Account Information");
            } else {
                testDriver.swipe(UP);
            }
            log.info("Click on Account Information Option");
            if (signInPage.isAndroidBS()) {
                accountInformationPage = humanStuffPage.clickAccountInformation();
                log.info("Click on Logout Option");
                testDriver.scrollToText((AppiumDriver<MobileElement>) driver, "Log Out");
                accountInformationPage.clickLogout();
                accountInformationPage.clickLogoutPopUpBtn();
                log.info("Logged out successfully");
            } else {
                log.info("Click on Account Information");
                whistleBasePage = accountInformationPage.clickOnAccountInfo();
                log.info("Click on Logout Option");
                accountInformationPage.clickLogout();
                log.info("Logged out successfully");
            }
        } else {
            whistleBasePage.write2Log4jAllureStep("Clicked on Sign in Button");
        }
        whistleBasePage.write2Log4jAllureStep("Clicked on Sign in Button");
        signInPage = landingPage.clickSignInLnk();
        whistleBasePage.write2Log4jAllureStep("Enter Email Address / User ID " + FrameworkConfigFactory.getConfig().emailMobileAM2());
        signInPage.enterEmail(FrameworkConfigFactory.getConfig().emailMobileAM2());

        whistleBasePage.write2Log4jAllureStep("Enter Password " + FrameworkConfigFactory.getConfig().passwordMobileAM2());
        signInPage.enterPassword(FrameworkConfigFactory.getConfig().passwordMobileAM2());

        whistleBasePage.write2Log4jAllureStep("Click on Login button");
        homePageWhistle = signInPage.clickLoginBtn();

        whistleBasePage.write2Log4jAllureStep("Verify Family Notification Screen");
        homePageWhistle.handleNotificationBanner();

        log.info("Verifying if Location Icon is displayed");
        signInPage.assertTab("Location");

        log.info("Verifying if Activity Icon is displayed");
        signInPage.assertTab("Activity");

        log.info("Verifying if Pet Icon is displayed ");
        signInPage.assertTab("Pet");

        log.info("Verifying if Human icon is displayed");
        signInPage.assertTab("Human");
    }

/**
* Created by Achal Kumar Jain on 08 June, 2022
**/
    @TestRails(id = "1009991")
    @Description("Single pet with W04 device ")
    @Test(priority = 2, groups = {"P0"})
    @Feature("Single pet with W04 device")
    public void testVerifyTabsAccountW04() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        HumanStuffPage humanStuffPage = new HumanStuffPage(testDriver);
        AccountInformationPage accountInformationPage = new AccountInformationPage(testDriver);
        LandingPage landingPage = new LandingPage(testDriver);

        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            log.info("user is already logged in");
            log.info("Click on Human Tab");
            if ((FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android"))) {
                humanStuffPage.clickHumanIcon();
            } else {
                humanStuffPage.clickHumanIcon();
            }
            log.info("Scroll up to Account Information");
            if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {
                testDriver.scrollToText((AppiumDriver<MobileElement>) driver, "Account Information");
            } else {
                testDriver.swipe(UP);
            }
            log.info("Click on Account Information Option");
            if (signInPage.isAndroidBS()) {
                accountInformationPage = humanStuffPage.clickAccountInformation();
                testDriver.scrollToText((AppiumDriver<MobileElement>) driver, "Log Out");
                log.info("Click on Logout Option");
                accountInformationPage.clickLogout();
                accountInformationPage.clickLogoutPopUpBtn();
                log.info("Logged out successfully");
            } else {
                log.info("Click on Account Information");
                whistleBasePage = accountInformationPage.clickOnAccountInfo();
                log.info("Click on Logout Option");
                accountInformationPage.clickLogout();
                log.info("Logged out successfully");
            }
        } else {
            whistleBasePage.write2Log4jAllureStep("Clicked on Sign in Button");
        }
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

        log.info("Verifying if Location Icon is displayed");
        signInPage.assertTab("Location");

        log.info("Verifying if Activity Icon is displayed");
        signInPage.assertTab("Activity");

        log.info("Verifying if Pet Icon is displayed ");
        signInPage.assertTab("Pet");

        log.info("Verifying if Human icon is displayed");
        signInPage.assertTab("Human");
    }

/**
* Created by Jyoti Basera on 11 July, 2022
**/
    @TestRails(id = "1009994")
    @Description("Hybrid Account-Multiple Pet/Devices")
    @Test(priority = 3, groups = {"P0"})
    @Feature("Verify Tabs in Hybrid Account")
    public void testTabDisplayOrderForHybridAccount() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageMultiPet();
            homePageWhistle.handleNotificationBanner();
        }
        whistleBasePage.write2Log4jAllureStep("Verify the tab display for AM2 device ");
        whistleBasePage.write2Log4jAllureStep("Verifying if Home Icon is displayed");
        signInPage.assertTab("Home");
        whistleBasePage.write2Log4jAllureStep("Verifying if Activity Icon is displayed");
        signInPage.assertTab("Activity");
        whistleBasePage.write2Log4jAllureStep("Verifying if Location Icon is displayed");
        signInPage.assertTab("Location");
        whistleBasePage.write2Log4jAllureStep("Verifying if Pet Icon is displayed ");
        signInPage.assertTab("Pet");
        whistleBasePage.write2Log4jAllureStep("Verifying if Human icon is displayed");
        signInPage.assertTab("Human");
        whistleBasePage.write2Log4jAllureStep("Verify tab order");
        Assert.assertEquals(homePageWhistle.validateTabOrder(), WhistleConstants.ALL_TAB_NAMES);

        whistleBasePage.write2Log4jAllureStep("Click on Second Pet Image");
        homePageWhistle.clickSecondPetImage();
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")) {
            if (homePageWhistle.isW05EnableBLEBannerPresent()) {
                whistleBasePage.write2Log4jAllureStep("Click on enable button");
                homePageWhistle.clickEnableButton();
            }
        }
        whistleBasePage.write2Log4jAllureStep("Verify the tab display for W04 device ");
        whistleBasePage.write2Log4jAllureStep("Verifying if Home Icon is displayed");
        signInPage.assertTab("Home");
        whistleBasePage.write2Log4jAllureStep("Verifying if Activity Icon is displayed");
        signInPage.assertTab("Activity");
        whistleBasePage.write2Log4jAllureStep("Verifying if Location Icon is displayed");
        signInPage.assertTab("Location");
        whistleBasePage.write2Log4jAllureStep("Verifying if Pet Icon is displayed ");
        signInPage.assertTab("Pet");
        whistleBasePage.write2Log4jAllureStep("Verifying if Human icon is displayed");
        signInPage.assertTab("Human");
        whistleBasePage.write2Log4jAllureStep("Verify tab order");
        Assert.assertEquals(homePageWhistle.validateTabOrder(), WhistleConstants.ALL_TAB_NAMES);
    }

/**
* Created by Murali Jaladurgam on 12 July, 2022
**/
    @TestRails(id = "1016383")
    @Description("Navigation - Hybrid")
    @Test(priority = 4, groups = {"P0"})
    @Feature("Navigation - Hybrid")
    public void testNavigationHybrid() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageMultiPet();
            homePageWhistle.handleNotificationBanner();
        }

        whistleBasePage.write2Log4jAllureStep("Verify the Home tab display for AM2 device ");
        whistleBasePage.write2Log4jAllureStep("Get pet name before Pet updates ");
        String sOriginalPetName = homePageWhistle.getPetValueFromHeader();

        /* Need to implement code for validating Health and Wellness cards if the Pet is used as dog */

        whistleBasePage.write2Log4jAllureStep("Validating the Wellness Score card in Home Page");
        Assert.assertTrue(homePageWhistle.isWellnessScoreTextDisplayed(),"Wellness Score card in Home Page is not Displayed");
        whistleBasePage.write2Log4jAllureStep("Scroll up to Health");
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {
            testDriver.scrollToText((AppiumDriver<MobileElement>) driver, "Health");
        }
        else
            testDriver.swipe(UP);
        whistleBasePage.write2Log4jAllureStep("Validating the Health card in Home Page");
        Assert.assertTrue(homePageWhistle.isCheckHealthDashboardDisplayed(),"Health card in Home Page is not Displayed");

        whistleBasePage.write2Log4jAllureStep("click on Activity menu");
        activityPage = homePageWhistle.clickActivityIcon();
        whistleBasePage.write2Log4jAllureStep("Verifying Share Activity is displayed");
        Assert.assertTrue(activityPage.isShareActivityDisplayed(), "Share Activity is not displayed");

        whistleBasePage.write2Log4jAllureStep("click on pet menu");
        viewPetProfilePage = homePageWhistle.clickPetMenuOptn();
        whistleBasePage.write2Log4jAllureStep("Verifying default tab selection ");
        Assert.assertTrue(viewPetProfilePage.isDefaultTabSelected(), "Default tab  Pet & Device is not selected");

        whistleBasePage.write2Log4jAllureStep("Click on Human Tab");
        if ((FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")))
            signInPage.clickTab("Human");
        humanStuffPage = signInPage.clickHumanTab();
        whistleBasePage.write2Log4jAllureStep("Verifying Human Stuff Title is Displaying");
        Assert.assertTrue(humanStuffPage.isHumanStuffTitlePresent(), "Human Stuff Title is not Displayed");

        whistleBasePage.write2Log4jAllureStep("Click Location icon for AM2 device");
        locationPage = homePageWhistle.clickLocationIcon();
        whistleBasePage.write2Log4jAllureStep("Verify Feature not Compatible text message for AM2 device Location");
        if (locationPage.isAndroidBS()) {
            Assert.assertEquals(locationPage.getLocationTabEmptyHeaderText(), WhistleConstants.LOCATION_TAB_EMPTY_HEADER);
        } else {
            Assert.assertEquals(locationPage.getLocationTabEmptyHeaderText(), WhistleConstants.LOCATION_TAB_EMPTY_HEADER_IOS);
        }

        whistleBasePage.write2Log4jAllureStep("Click on Pet Picker dropdown");
        homePageWhistle.clickPetPickerDropdownone();
        whistleBasePage.write2Log4jAllureStep("Click on next Pet from the dropdown");
        homePageWhistle.clickNextPetFromDropdown();

        whistleBasePage.write2Log4jAllureStep("Get pet name after new Pet is selected from Pet Picker");
        String sUpdatedPetName = homePageWhistle.getPetValueFromHeader();
        log.info("sOriginalPetName:" +sOriginalPetName+" and sUpdatedPetName:"+sUpdatedPetName);

        whistleBasePage.write2Log4jAllureStep("Verify pet name data changes ");
        if(!sOriginalPetName.equalsIgnoreCase(sUpdatedPetName)) {
            whistleBasePage.write2Log4jAllureStep("Pet name data is changed with pet changes in Home dashboard");
        }

        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")) {
            if (homePageWhistle.isW05EnableBLEBannerPresent()) {
                whistleBasePage.write2Log4jAllureStep("Click on enable button");
                homePageWhistle.clickEnableButton();
            }
        }

        whistleBasePage.write2Log4jAllureStep("Verifying the Map is Displayed");
        Assert.assertTrue(locationPage.isMapIconDisplayed(),"Map is not displayed");
    }

/**
* Created by Jyoti Basera on 25 July, 2022
**/
    @TestRails(id = "1016363")
    @Description("Navigation Bar for health( AM2 or AM6 )devices")
    @Test(priority = 5, groups = {"P1"})
    @Feature("Navigation")
    public void testNavigationBarForSingleAM2Account() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageAM2();
            homePageWhistle.handleNotificationBanner();
        }
        whistleBasePage.write2Log4jAllureStep("Verify the tab display for AM2 device ");
        whistleBasePage.write2Log4jAllureStep("Verifying if Home Icon is displayed");
        signInPage.assertTab("Home");
        whistleBasePage.write2Log4jAllureStep("Verifying if Activity Icon is displayed");
        signInPage.assertTab("Activity");
        whistleBasePage.write2Log4jAllureStep("Verifying if Location Icon is not displayed for AM2 device");
        Assert.assertFalse(homePageWhistle.isCheckLocationIconDisplayed(),"Location Icon is displayed");
        whistleBasePage.write2Log4jAllureStep("Verifying if Pet Icon is displayed ");
        signInPage.assertTab("Pet");
        whistleBasePage.write2Log4jAllureStep("Verifying if Human icon is displayed");
        signInPage.assertTab("Human");
        whistleBasePage.write2Log4jAllureStep("Verify tab order");
        Assert.assertEquals(homePageWhistle.validateTabOrderForAM2(), WhistleConstants.AM2_TAB_NAMES);
    }
}

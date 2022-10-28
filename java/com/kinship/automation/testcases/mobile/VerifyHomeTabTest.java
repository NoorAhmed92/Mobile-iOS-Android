package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.constants.WhistleConstants;
import com.kinship.automation.pageobjects.mobile.*;
import com.kinship.automation.pageobjects.mobile.HomePageWhistle;
import com.kinship.automation.pageobjects.mobile.SignInPage;
import com.kinship.automation.utils.testrail.TestRails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.kinship.automation.utils.commonutils.TestDriver.ScrollDirection.DOWN;
import static com.kinship.automation.utils.commonutils.TestDriver.ScrollDirection.UP;

public class VerifyHomeTabTest extends MobileBaseTest {

    /**
     * Created by Murali Jaladurgam on 16 June, 2022
     **/
    @TestRails(id = "1016361")
    @Description("User lands on the Home tab upon login")
    @Test(priority = 1, groups = {"P0"})
    @Feature("User lands on the Home tab upon login")

    public void testHomeTabVerify() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        whistleBasePage.write2Log4jAllureStep("Verifying user is navigated to Home Tab");
        Assert.assertNotNull(homePageWhistle, "user not is navigated to Home Tab");
    }

/**
* Created by Murali Jaladurgam on 16 June, 2022
**/
    @TestRails(id = "1016325")
    @Description("Map widget leading user to the location tab")
    @Test(priority = 2, groups = {"P0"})
    @Feature("Map widget leading user to the location tab")

    public void testUserNavigatedToLocationTab() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        testDriver.swipe(UP);

        whistleBasePage.write2Log4jAllureStep("Selecting the Map");
        locationPage = homePageWhistle.clickOnMapTab();

        whistleBasePage.write2Log4jAllureStep("Verifying user is navigated to Location Tab");
        Assert.assertNotNull(locationPage, "user is not navigated to Location Tab");
    }

/**
* Created by Jyoti Basera on 17 June, 2022
**/
    @TestRails(id = "1016322")
    @Description("HomePage - Map")
    @Test(priority = 0, groups = {"P0"})
    @Feature("HomePage-Map")
    public void testDisplayMapOnHomeScreen() {
        SignInPage signInPage = new SignInPage(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            log.info("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        testDriver.swipe(UP);
        whistleBasePage.write2Log4jAllureStep("Verify if Map is displayed in the dashboard");
        Assert.assertTrue(homePageWhistle.isMapDisplayed(), "Map is not displayed");
    }

/**
* Created by Jameel Ahmed on 17 June, 2022
**/
    @TestRails(id = "1016362")
    @Description("Validating Tab order")
    @Test(priority = 3, groups = {"P0"})
    @Feature("Navigation Bar for the GPS W04 devices")
    public void testTabOrderForW04() {
        LandingPage landingPage = new LandingPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        PetEditProfilePage petEditprofilepage = new PetEditProfilePage(testDriver);

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

        whistleBasePage.write2Log4jAllureStep("Click on Activity tab");
        homePageWhistle.clickActivityIcon();

        whistleBasePage.write2Log4jAllureStep("Click on Location tab");
        homePageWhistle.clickLocationIcon();

        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")) {
            if (homePageWhistle.isW05EnableBLEBannerPresent()) {
                whistleBasePage.write2Log4jAllureStep("Click on enable button");
                homePageWhistle.clickEnableButton();
            }
        }
        whistleBasePage.write2Log4jAllureStep("Click on Pet tab");
        homePageWhistle.clickPetMenuOptn();

        whistleBasePage.write2Log4jAllureStep("Click on Human tab");
        homePageWhistle.clickHumanIcon();

        whistleBasePage.write2Log4jAllureStep("Click on Home tab");
        homePageWhistle.clickHomeTab();

        whistleBasePage.write2Log4jAllureStep("Verify tab order");
        Assert.assertEquals(homePageWhistle.validateTabOrder(), WhistleConstants.ALL_TAB_NAMES);
    }

/**
* Created by Jameel Ahmed on 17 June, 2022
**/
    @TestRails(id = "1016362")
    @Description("Validating Tab order")
    @Test(priority = 4, groups = {"P0"})
    @Feature("Navigation Bar for the GPS W05 devices")
    public void testTabOrderForW05() {
        SignInPage signInPage = new SignInPage(testDriver);
        HumanStuffPage humanStuffPage = new HumanStuffPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        AccountInformationPage accountInformationPage = new AccountInformationPage(testDriver);
        LandingPage landingPage = new LandingPage(testDriver);
        PetEditProfilePage petEditprofilepage = new PetEditProfilePage(testDriver);

        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            log.info("user is already logged in");
            log.info("Click on Human Tab");
            homePageWhistle.clickOnHumanIcon();
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
        }
        whistleBasePage.write2Log4jAllureStep("Clicked on Sign in Button");
        signInPage = landingPage.clickSignInLnk();

        whistleBasePage.write2Log4jAllureStep("Enter Email Address / User ID " + FrameworkConfigFactory.getConfig().emailMobileW05());
        signInPage.enterEmail(FrameworkConfigFactory.getConfig().emailMobileW05());

        whistleBasePage.write2Log4jAllureStep("Enter Password " + FrameworkConfigFactory.getConfig().passwordMobile());
        signInPage.enterPassword(FrameworkConfigFactory.getConfig().passwordMobile());

        whistleBasePage.write2Log4jAllureStep("Click on Login button");
        homePageWhistle = signInPage.clickLoginBtn();

        whistleBasePage.write2Log4jAllureStep("Verify Family Notification Screen");
        homePageWhistle.handleNotificationBanner();

        whistleBasePage.write2Log4jAllureStep("Click on Activity tab");
        homePageWhistle.clickActivityIcon();

        whistleBasePage.write2Log4jAllureStep("Click on Location tab");
        homePageWhistle.clickLocationIcon();

        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")) {
            if (homePageWhistle.isW05EnableBLEBannerPresent()) {
                whistleBasePage.write2Log4jAllureStep("Click on enable button");
                homePageWhistle.clickEnableButton();
            }
        }
        whistleBasePage.write2Log4jAllureStep("Click on Pet tab");
        homePageWhistle.clickPetMenuOptn();

        whistleBasePage.write2Log4jAllureStep("Click on Human tab");
        homePageWhistle.clickHumanIcon();

        whistleBasePage.write2Log4jAllureStep("Click on Home tab");
        homePageWhistle.clickHomeTab();

        whistleBasePage.write2Log4jAllureStep("Verify tab order");
        Assert.assertEquals(homePageWhistle.validateTabOrder(), WhistleConstants.ALL_TAB_NAMES);
    }

/**
* Created by Jameel Ahmed on 20 June, 2022
**/
    @TestRails(id = "1016320")
    @Description("Clicking on Wellness widget takes user to Wellness Detail")
    @Test(priority = 5, groups = {"P0"})
    @Feature("Clicking on Wellness widget takes user to Wellness Detail")
    public void testWellnessScoreNavigation() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        HumanStuffPage humanStuffPage = new HumanStuffPage(testDriver);
        AccountInformationPage accountInformationPage = new AccountInformationPage(testDriver);
        LandingPage landingPage = new LandingPage(testDriver);

        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            log.info("user is already logged in");
            log.info("Click on Human Tab");
            homePageWhistle.clickOnHumanIcon();
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
            whistleBasePage.write2Log4jAllureStep("User is on Sign in page");
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

        whistleBasePage.write2Log4jAllureStep("Click on Wellness Score option");
        homePageWhistle.clickWellnessScore();

        whistleBasePage.write2Log4jAllureStep("Validate Wellness score board is displayed");
        Assert.assertTrue(homePageWhistle.verifyWellnessScoreBoardIsDisplayed(), "Wellness score board is not displayed");
    }

/**
* Created by Achal Kumar Jain on 22 June, 2022
**/
    @TestRails(id = "1016336")
    @Description("Validate Activity widget on home tab")
    @Test(priority = 6, groups = {"P0"})
    @Feature("Activity")
    public void testActivityWidget() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("User is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        whistleBasePage.write2Log4jAllureStep("Verifying if Home Icon is displayed");
        signInPage.assertTab("Home");

        whistleBasePage.write2Log4jAllureStep("Verifying Activity Label is displayed");
        homePageWhistle.isActivityLabelDisplayed();
        whistleBasePage.write2Log4jAllureStep("Verifying if Progress circle is displayed");
        homePageWhistle.isProgressCircleDisplayed();
        whistleBasePage.write2Log4jAllureStep("Verifying if Hours Label is displayed");
        homePageWhistle.isHoursLabelDisplayed();
        whistleBasePage.write2Log4jAllureStep("Verifying if Minuts Label is displayed");
        homePageWhistle.isMinutsLabelDisplayed();
        whistleBasePage.write2Log4jAllureStep("Verifying if calori Label is displayed");
        homePageWhistle.isCaloriLabelDisplayed();
        whistleBasePage.write2Log4jAllureStep("Verifying if Today Text is displayed");
        homePageWhistle.isTodayTextisplayed();
        whistleBasePage.write2Log4jAllureStep("Verifying if Graph area is displayed");
        homePageWhistle.isGraphAreaDisplayed();
    }

/**
* Created by Achal Kumar Jain on 24 June, 2022
**/
    @TestRails(id = "1016337")
    @Description("Validate clicking on Activity widget navigate on activity tab")
    @Test(priority = 7, groups = {"P0"})
    @Feature("Activity")
    public void testClickActivityWidget() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("User is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        whistleBasePage.write2Log4jAllureStep("Verifying if Home Icon is displayed");
        signInPage.assertTab("Home");

        whistleBasePage.write2Log4jAllureStep("Verifying Activity Label is displayed");
        Assert.assertTrue(homePageWhistle.isActivityLabelDisplayed(), "activity label is Present in Activity screen");

        whistleBasePage.write2Log4jAllureStep("Click on Activity Label");
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {
            homePageWhistle.clickTodayText();
        } else {
            homePageWhistle.clickActivityLabel();
        }
        whistleBasePage.write2Log4jAllureStep("User lands on Activity screen");

        whistleBasePage.write2Log4jAllureStep("Verify share icon is Present in Activity screen");
        Assert.assertTrue(homePageWhistle.isShareIconDisplayed(), "share icon is Present in Activity screen");

        whistleBasePage.write2Log4jAllureStep("Verify calorie icon is Present in Activity screen");
        Assert.assertTrue(homePageWhistle.isCaloriesIconDisplayed(), "calorie icon is Present in Activity screen");

        whistleBasePage.write2Log4jAllureStep("Verify distance icon is Present in Activity screen");
        Assert.assertTrue(homePageWhistle.isDistanceIconDisplayed(), "distance icon is Present in Activity screen");

        whistleBasePage.write2Log4jAllureStep("Verify rest icon is Present in Activity screen");
        Assert.assertTrue(homePageWhistle.isRestIconDisplayed(), "rest icon is Present in Activity screen");
    }

/**
* Created by Jameel Mohammed on 20 June, 2022
**/
    @TestRails(id = "1016320")
    @Description("Validating Wellness information is displayed in the home screen")
    @Test(priority = 8, groups = {"P0"})
    @Feature("Validate Wellness Widget card on Hometab/Dashboard")
    public void testWellnessScore() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        HumanStuffPage humanStuffPage = new HumanStuffPage(testDriver);
        AccountInformationPage accountInformationPage = new AccountInformationPage(testDriver);
        LandingPage landingPage = new LandingPage(testDriver);

        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            log.info("user is already logged in");
            log.info("Click on Human Tab");
            homePageWhistle.clickOnHumanIcon();
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
            whistleBasePage.write2Log4jAllureStep("User is on Sign in page");
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

        whistleBasePage.write2Log4jAllureStep("Validate Wellness information is displayed");
        Assert.assertTrue(homePageWhistle.isWellnessScoreDisplayed(), "Wellness information is not displayed");
    }

/**
* Created by Jameel Mohammed on 14 July, 2022
**/
    @TestRails(id = "1016365")
    @Description("Validating Home screen scroll up and down")
    @Test(priority = 9, groups = {"P1"})
    @Feature("Home Page scroll up and down")
    public void testHomeScreenScrollUpDown() {
        SignInPage signInPage = new SignInPage(testDriver);
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
            Assert.assertTrue(homePageWhistle.isCheckDrinkingTextDisplayed(), "Drinking text is not displayed");
            whistleBasePage.write2Log4jAllureStep("Scrolling up to Wellness Score");
            testDriver.scrollToText((AppiumDriver<MobileElement>) driver, "Wellness Score");
            Assert.assertTrue(homePageWhistle.isWellnessScoreDisplayed(), "Wellness Score text is not displayed");
        } else {
            whistleBasePage.write2Log4jAllureStep("Scrolling down up to Drinking");
            testDriver.swipe(UP);
            Assert.assertTrue(homePageWhistle.isCheckDrinkingTextDisplayed(), "Drinking text is not displayed");
            whistleBasePage.write2Log4jAllureStep("Scrolling up to Wellness Score");
            testDriver.swipe(DOWN);
            Assert.assertTrue(homePageWhistle.isWellnessScoreDisplayed(), "Wellness Score text is not displayed");
        }
    }

/**
* Created by Jameel Mohammed on 18 July, 2022
**/
    @TestRails(id = "1016321")
    @Description("Validating Well details information is displayed in the Wellness score screen")
    @Test(priority = 10, groups = {"P1"})
    @Feature("Validate Well-details card")
    public void testWellDetailsCard() {
        LandingPage landingPage = new LandingPage(testDriver);
        SignInPage signInPage = new SignInPage(testDriver);
        WhistleBasePage whistleBasePage = new WhistleBasePage(testDriver);
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
        whistleBasePage.write2Log4jAllureStep("Click on Wellness Score option");
        homePageWhistle.clickWellnessScore();

        whistleBasePage.write2Log4jAllureStep("Validate Wellness score with Navigate back CTA is displayed");
        Assert.assertTrue(homePageWhistle.isWellnessScoreTitleAndBackCTADisplayed(), "Wellness score/back CTA is not displayed");

        whistleBasePage.write2Log4jAllureStep("Validate Wellness information Gathering data is displayed");
        Assert.assertTrue(homePageWhistle.isWellnessScoreGatheringDataDisplayed(), "Wellness information Gathering data is not displayed");

        whistleBasePage.write2Log4jAllureStep("Validate Wellness score description is displayed");
        Assert.assertTrue(homePageWhistle.isWellnessScoreDescriptionDisplayed(), "Wellness score description is not displayed");

        whistleBasePage.write2Log4jAllureStep("Validate Wellness score measurement bar is displayed");
        Assert.assertTrue(homePageWhistle.iswellnessScoreMeasurementBarDisplayed(), "Wellness score measurement bar is not displayed");

        whistleBasePage.write2Log4jAllureStep("Validate Wellness score's screen Week/Month is displayed");
        Assert.assertTrue(homePageWhistle.iswellnessScoreWeekMonthGraphDisplayed(), "Wellness score's screen Week/Month is not displayed");

        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {
            whistleBasePage.write2Log4jAllureStep("Scrolling up to Chat with a Vet");
            testDriver.scrollToText((AppiumDriver<MobileElement>) driver, "Chat with a Vet");
        }else{
            testDriver.swipe(UP);
        }
        whistleBasePage.write2Log4jAllureStep("Validate Wellness score statuses are displayed");
        Assert.assertTrue(homePageWhistle.iswellnessStatusesDisplayed(), "Wellness score statuses are not displayed");

        whistleBasePage.write2Log4jAllureStep("Validate Learn more option is displayed");
        Assert.assertTrue(homePageWhistle.isLearnMoreOptionDisplayed(), "Wellness score Learn more option is not displayed");

        whistleBasePage.write2Log4jAllureStep("Validate Chat with Vet option is displayed");
        Assert.assertTrue(homePageWhistle.isChatWithVetOptionDisplayed(), "Wellness score Chat with Vet option is not displayed");
    }

/**
* Created by Achal Kumar Jain on 19 July, 2022
**/
    @TestRails(id = "1016338")
    @Description("Activity widget Goal Progression")
    @Test(priority =10, groups = {"P1"})
    @Feature("Home screen Activity")
    public void testActivityGoalProgression() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        whistleBasePage.write2Log4jAllureStep("Verifying if Home Icon is displayed");
        signInPage.assertTab("Home");
        whistleBasePage.write2Log4jAllureStep("Verifying Activity Label is displayed");
        Assert.assertTrue(homePageWhistle.isActivityLabelDisplayed(), "activity label is displayed");
        whistleBasePage.write2Log4jAllureStep("Verifying if Progress Bar is displayed");
        Assert.assertTrue(homePageWhistle.isProgressCircleDisplayed(), "Progress circle is displayed");
        whistleBasePage.write2Log4jAllureStep("Verifying Activity Label is displayed");
        homePageWhistle.isActivityLabelDisplayed();
        whistleBasePage.write2Log4jAllureStep("Verifying if Today Text is displayed");
        homePageWhistle.isTodayTextisplayed();
    }

/**
* Created by Achal Kumar Jain on 19 July, 2022
**/
    @TestRails(id = "1016339")
    @Description("Activity animation left to right")
    @Test(priority =11, groups = {"P1"})
    @Feature("Home screen Activity")
    public void testActivityAnimationGraph() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageMultiPet();
            homePageWhistle.handleNotificationBanner();
        }
        whistleBasePage.write2Log4jAllureStep("Verifying Activity Label is displayed");
        homePageWhistle.isActivityLabelDisplayed();
        whistleBasePage.write2Log4jAllureStep("Verifying if left hand text is displayed");
        Assert.assertTrue(homePageWhistle.isActivityLeftHandtextDisplayed(), "left hand text is not displayed");
        whistleBasePage.write2Log4jAllureStep("Verifying if RIGHT hand text is displayed");
        Assert.assertTrue(homePageWhistle.isActivityRightHandtextDisplayed(), "Right hand text is not displayed");
        whistleBasePage.write2Log4jAllureStep("Verifying if graph data is displayed from left to right");
        Assert.assertTrue(homePageWhistle.isGraphDataDisplayed(), "graph data is not displayed");
    }
}
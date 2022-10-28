package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.pageobjects.mobile.HomePageWhistle;
import com.kinship.automation.pageobjects.mobile.SignInPage;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class PetLocationTest extends MobileBaseTest {

/**
* Created by Murali Jaladurgam on 04 July, 2022
**/
    @TestRails(id = "1008008")
    @Description("PetLocationView")
    @Test(priority = 0, groups = {"P0"})
    @Feature("Pet settings view")

    public void testLocationView() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }

        whistleBasePage.write2Log4jAllureStep("Click on Location");
        locationPage=homePageWhistle.clickLocationIcon();
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")){
            if(homePageWhistle.isW05EnableBLEBannerPresent()) {
                whistleBasePage.write2Log4jAllureStep("Click on enable button");
                homePageWhistle.clickEnableButton();
            }
        }

        whistleBasePage.write2Log4jAllureStep("Verifying the Map is Displayed");
        Assert.assertTrue(locationPage.isMapIconDisplayed(),"Map is not displayed");
        if (locationPage.isAndroidBS()) {
        whistleBasePage.write2Log4jAllureStep("Verifying the Pet Pin lead is Displayed");
        Assert.assertTrue(locationPage.isPetPinLeadDisplayed(), "Pet Pin Lead is not displayed");
        }
        whistleBasePage.write2Log4jAllureStep("Verifying the Map type icon is Displayed");
        Assert.assertTrue(locationPage.isMapTypeIconDisplayed(),"Map type icon is not displayed");
    }

/**
* Created by Jyoti Basera on 04 July, 2022
**/
    @TestRails(id = "1007988")
    @Description("FindMyPet")
    @Test(priority = 1, groups = {"P0"})
    @Feature("Track Mode-Find My Pet")

    public void testFindMyPet() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageW04Device();
            homePageWhistle.handleNotificationBanner();
        }
        whistleBasePage.write2Log4jAllureStep("Click on Location");
        locationPage=homePageWhistle.clickLocationIcon();
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")){
            if(homePageWhistle.isW05EnableBLEBannerPresent()) {
                whistleBasePage.write2Log4jAllureStep("Click on enable button");
                homePageWhistle.clickEnableButton();
            }
        }
            whistleBasePage.write2Log4jAllureStep("Verifying the Track Mode- Find My Pet is Displayed");
            Assert.assertTrue(locationPage.isFindMyPetDisplayed(), "Find My Pet is not displayed");

        if(locationPage.isFindMyPetEnabled()) {
            whistleBasePage.write2Log4jAllureStep("Click Find My Pet");
            locationPage.clickFindMyPet();
            locationPage.clickStopCTA();
            whistleBasePage.write2Log4jAllureStep("Verifying the display of Start CTA");
            Assert.assertTrue(locationPage.isStartCTADisplayed(), "Start CTA is not displayed");
            whistleBasePage.write2Log4jAllureStep("Verifying the display of Cancel CTA");
            Assert.assertTrue(locationPage.isCancelCTADisplayed(), "Cancel CTA is not displayed");
            locationPage.clickCancelCTA();
        } else
            whistleBasePage.write2Log4jAllureStep("Find My Pet CTA is not enabled");
    }
}

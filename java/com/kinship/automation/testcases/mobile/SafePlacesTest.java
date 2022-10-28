package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.constants.WhistleConstants;
import com.kinship.automation.pageobjects.mobile.SafePlacesPage;
import com.kinship.automation.pageobjects.mobile.SignInPage;
import com.kinship.automation.utils.testrail.TestRails;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SafePlacesTest extends MobileBaseTest {

/**
* Created by Noor Shaik on 12 July, 2022
**/
    @TestRails(id = "1008091")
    @Description("Address - Valid")
    @Test(priority = 0, groups = {"P0"})
    @Feature("Address - Valid ")

    public void testAddressValid() {

        SignInPage signInPage = new SignInPage(testDriver);
        SafePlacesPage safePlacesPage = new SafePlacesPage(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        whistleBasePage.write2Log4jAllureStep("Click on Human Tab");
        if ((FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")))
            signInPage.clickTab("Human");
        humanStuffPage = signInPage.clickHumanTab();

        whistleBasePage.write2Log4jAllureStep("click on Safe Places");
        Assert.assertTrue(humanStuffPage.clickOnSafePlaces(), "Safe places is not clicked");

        safePlacesPage.write2Log4jAllureStep("click on Add Place icon");
        Assert.assertTrue(safePlacesPage.clickOnAddPlace(),"Add Place icon not displayed");

        if ((FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")))
        {
            safePlacesPage.clickOnEnterManualLocationOption();
            safePlacesPage.enterAddress(WhistleConstants.ADDRESS);

        }else{
            safePlacesPage.enterAddress(WhistleConstants.ADDRESS);
        }
        safePlacesPage.write2Log4jAllureStep("verify matching address list displayed");
        Assert.assertTrue(safePlacesPage.isListOfMatchingAddressDisplayed(),"list of matching address is not displayed");
    }
}

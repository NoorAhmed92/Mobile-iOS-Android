package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.pageobjects.mobile.SignInPage;
import com.kinship.automation.utils.listeners.Retry;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import com.kinship.automation.pageobjects.mobile.LandingPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.kinship.automation.config.FrameworkConfigFactory;

/**
 * Created by Hasmukh patel on 01 Mar, 2022
 **/

@Listeners(TestListener.class)
public class LandingPageVerificationTest extends MobileBaseTest {

/**
* Created by Jyoti Basera on 03 February, 2022
**/
    @TestRails(id="994168")
    @Description("Verify Landing Screen")
    @Test(groups = {"P0", "BAT"}, priority=0, retryAnalyzer = Retry.class)
    @Feature("Verifying Landing Screen")
    public void testLandingScreen() throws InterruptedException {
        LandingPage landingPage = new LandingPage(testDriver);
        log.info("Verify Get Started button is Display");
        landingPage.isGetStartedBtnDisplayed();

        log.info("Verifying Get Started button is Enable");
        landingPage.isGetStartedBtnEnable();

        log.info("Verify Sign in Text Display or Not");
        landingPage.isSignInTxtDisplayed();
    }

/**
* Created by Jameel Mohammed on 05 July, 2022
**/
    @TestRails(id="994051")
    @Description("Verifying the options displaying in the landing screen")
    @Test(priority = 1, groups = {"P1"})
    @Feature("Verify View - Home screen")
    public void testViewHomeScreen() {
        LandingPage landingPage = new LandingPage(testDriver);
        SignInPage signInPage = new SignInPage(testDriver);

        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")) {
            if (landingPage.validateBluetoothDontAllowCTA()) {
                whistleBasePage.write2Log4jAllureStep("Verify Popup Bluetooth title is present");
                Assert.assertTrue(landingPage.validateBluetoothTitle(), "Bluetooth title is not present");

                whistleBasePage.write2Log4jAllureStep("Verify Popup Bluetooth Body text is present");
                Assert.assertTrue(landingPage.validateBluetoothBodyCopy(), "Bluetooth body text is not present");

                whistleBasePage.write2Log4jAllureStep("Verify Popup Bluetooth Don't Allow CTA is present");
                Assert.assertTrue(landingPage.validateBluetoothDontAllowCTA(), "Bluetooth Don't Allow CTA is not present");

                whistleBasePage.write2Log4jAllureStep("Verify Popup Bluetooth OK CTA is present");
                Assert.assertTrue(landingPage.validateBluetoothOkCTA(), "Bluetooth OK CTA is not present");

                whistleBasePage.write2Log4jAllureStep("Click on Popup Bluetooth OK CTA");
                landingPage.clickBluetoothOkCTA();
            }
        }
        whistleBasePage.write2Log4jAllureStep("Verify Welcome to text is present");
        Assert.assertTrue(landingPage.validateWelcomeText(), "Welcome to text is not present");

        whistleBasePage.write2Log4jAllureStep("Verify Whistle Logo is present");
        Assert.assertTrue(landingPage.validateWhistleLogo(), "Whistle Logo is not present");

        whistleBasePage.write2Log4jAllureStep("Verify Dog Asset is present");
        Assert.assertTrue(landingPage.validateDogAsset(), "Dog asset is not present");

        whistleBasePage.write2Log4jAllureStep("Verify Get Started button is Displayed");
        Assert.assertTrue(landingPage.isGetStartedButtonPresent(), "Get started button is not present");

        whistleBasePage.write2Log4jAllureStep("Verify Sign in Text is present");
        landingPage.isSignInTxtDisplayed();
    }
}


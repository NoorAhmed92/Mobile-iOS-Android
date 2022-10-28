package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.pageobjects.mobile.*;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.kinship.automation.utils.commonutils.TestDriver.ScrollDirection.UP;

/**
 * @author Jyoti Basera
 * created on 2022/07/28
 */
@Listeners(TestListener.class)
public class VerifyHomeDashboardTest extends MobileBaseTest {

    @TestRails(id = "1016323")
    @Description("Account with AM2/AM6 - Map Widget/Card does not show up")
    @Test(priority = 0, groups = {"P1"})
    @Feature("Home Dashboard- Map")
    public void testMapWidgetForSingleAM2Account() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageAM2();
            homePageWhistle.handleNotificationBanner();
        }
        testDriver.swipe(UP);

        whistleBasePage.write2Log4jAllureStep("Verify the Map widget in the dashboard for AM2(non GPS) device ");
        Assert.assertFalse(homePageWhistle.isGoogleMapDisplayed(), "Map is displayed for non-GPS device");
    }

    /**
     * Created by Jyoti Basera on 01 Aug, 2022
     **/
    @TestRails(id = "1016324")
    @Description("Multipet Scenario Map Card appears only for GPS device")
    @Test(priority = 1, groups = {"P1"})
    @Feature("Home Dashboard- Map")
    public void testMapWidgetForMultiPetAccount() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePageMultiPet();
            homePageWhistle.handleNotificationBanner();
        }
        testDriver.swipe(UP);

        whistleBasePage.write2Log4jAllureStep("Verify the Map widget in the dashboard for first pet device(non-GPS) ");
        Assert.assertFalse(homePageWhistle.isGoogleMapDisplayed(), "Map is displayed for non-GPS device");

        whistleBasePage.write2Log4jAllureStep("Click on Pet Picker dropdown");
        homePageWhistle.clickPetPickerDropdown();
        whistleBasePage.write2Log4jAllureStep("Click on next Pet from the dropdown");
        homePageWhistle.clickNextPetFromDropdown();

        whistleBasePage.write2Log4jAllureStep("Verify the Map widget in the dashboard for second pet device ");
        Assert.assertTrue(homePageWhistle.isGoogleMapDisplayed(), "Map is not displayed for a GPS device on second pet");
    }
}

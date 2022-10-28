package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.constants.WhistleConstants;
import com.kinship.automation.pageobjects.mobile.HomePageWhistle;
import com.kinship.automation.pageobjects.mobile.SignInPage;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Jyoti on 09 Jun, 2022
 * */

@Listeners(TestListener.class)
public class PetFoodValidSelectionTest extends MobileBaseTest {

    @TestRails(id = "1008568")
    @Description("Pet Food - Valid One Selection")
    @Test(priority = 0, groups = {"P3"})
    @Feature("Pet Food -Valid One Selection")

    public void testPetFoodValidOneSelection() {
        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        viewPetProfilePage = homePageWhistle.clickPetMenuOptn();
        petEditProfilePage = viewPetProfilePage.selectEditIcon();

        whistleBasePage.write2Log4jAllureStep("navigating to Pet Food Page");
        petFoodPage = petEditProfilePage.clickPetFoodField();

        whistleBasePage.write2Log4jAllureStep("Deleting already selected food ");
        petFoodPage.clearFood();

        whistleBasePage.write2Log4jAllureStep("Begin typing in valid dog food");
        petFoodPage.enterFoodName(WhistleConstants.PET_FOOD);

        whistleBasePage.write2Log4jAllureStep("Select valid dog food");
        petFoodPage.clickOnSelectedFood();

        whistleBasePage.write2Log4jAllureStep("Clicking Continue' CTA button");
        petEditProfilePage =petFoodPage.clickOnContinueCTA();

        whistleBasePage.write2Log4jAllureStep("Verify user returns to  Pet Edit Profile");
        Assert.assertTrue(petEditProfilePage.isPetEditProfileDisplayed(), "Pet Edit Profile is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verify updated Pet Food is displayed");
        Assert.assertEquals(petEditProfilePage.getUpdatedPetFood(), WhistleConstants.UPDATE_PET_FOOD);
    }

/**
* Created by Murali Jaladurgam on 08 June, 2022
**/
    @TestRails(id = "1008569")
    @Description("Pet Food - Valid Two Selections")
//    @Test(priority = 1, groups = {"P3"})
    @Feature("Pet Food - Valid Two Selections")

    public void testPetFoodValidTwoSelections() {

        SignInPage signInPage = new SignInPage(testDriver);
        HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
        if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
            whistleBasePage.write2Log4jAllureStep("user is already logged in");
        } else {
            homePageWhistle = signInPage.signInToHomePage();
            homePageWhistle.handleNotificationBanner();
        }
        viewPetProfilePage = homePageWhistle.clickPetMenuOptn();
        petEditProfilePage = viewPetProfilePage.selectEditIcon();

        whistleBasePage.write2Log4jAllureStep("navigating to Pet Food Page");
        petFoodPage = petEditProfilePage.clickPetFoodField();
        petFoodPage.clearFood();

        whistleBasePage.write2Log4jAllureStep("Selecting two pet foods");
        petFoodPage.clickOnMultipleFoodItems();

        whistleBasePage.write2Log4jAllureStep("selecting Continue' CTA button");
        petFoodPercentagePage=petFoodPage.clickOnContinueButton();

        whistleBasePage.write2Log4jAllureStep("Verifying 'Back' CTA is displayed");
        Assert.assertTrue(petFoodPercentagePage.isBackCTAisDisplayed(), "'Back' CTA is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Asset is displayed");
        Assert.assertTrue(petFoodPercentagePage.isAssetDisplayed(), "Asset is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Header (question) is displayed");
        Assert.assertTrue(petFoodPercentagePage.isHeaderDisplayed(), "Header (question) is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying sub-copy is displayed");
        Assert.assertTrue(petFoodPercentagePage.isSubCopyDisplayed(), "sub-copy is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying Percentage sliders for both dog foods Defaults to 50% / 50% is displayed");
        Assert.assertTrue(petFoodPercentagePage.isFoodPercentageSlidersDisplayed(), "Percentage sliders for both dog foods Defaults to 50% / 50% is not displayed");

        whistleBasePage.write2Log4jAllureStep("Verifying 'Done' CTA in enabled state");
        Assert.assertTrue(petFoodPercentagePage.isDoneCTADisEnabled(), "'Done' CTA in disabled state");
    }
}
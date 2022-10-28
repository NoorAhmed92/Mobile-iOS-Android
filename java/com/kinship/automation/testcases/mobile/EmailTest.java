package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.pageobjects.mobile.LandingPage;
import com.kinship.automation.pageobjects.mobile.PetEditProfilePage;
import com.kinship.automation.pageobjects.mobile.SignInPage;
import com.kinship.automation.pageobjects.mobile.WhistleBasePage;
import com.kinship.automation.utils.listeners.Retry;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Jameel Ahmed
 * created on 2022/07/07
 */

@Listeners(TestListener.class)
public class EmailTest extends MobileBaseTest {

/**
* Created by Jameel Mohammed on 7 July, 2022
**/
    @TestRails(id = "994061")
    @Description("Enter valid email address format > 140 characters")
//    @Test(priority = 0, groups={ "P1" })
    @Feature("Email - Long String")
    public void testEmailLongString() {
        LandingPage landingPage = new LandingPage(testDriver);
        SignInPage signInPage = new SignInPage(testDriver);
        WhistleBasePage whistleBasePage = new WhistleBasePage(testDriver);

        whistleBasePage.write2Log4jAllureStep("Clicked on Sign in Button");
        signInPage = landingPage.clickSignInLnk();

        whistleBasePage.write2Log4jAllureStep("Enter Email value of more than 140 characters " + FrameworkConfigFactory.getConfig().emailMoreThan140Chars());
        signInPage.enterEmail(FrameworkConfigFactory.getConfig().emailMoreThan140Chars());

        whistleBasePage.write2Log4jAllureStep("Verify Email field caps at 140 characters");
        Assert.assertEquals(signInPage.getEmailTextValue().length(), 140);
    }

/**
* Created by Jameel Mohammed on 14 July, 2022
**/
    @TestRails(id = "994058")
    @Description("Validating email non existing")
    @Test(priority = 1, groups={ "P1" })
    @Feature("Email - Non Existing")
    public void testEmailNonExisting() {
        LandingPage landingPage = new LandingPage(testDriver);
        SignInPage signInPage = new SignInPage(testDriver);
        WhistleBasePage whistleBasePage = new WhistleBasePage(testDriver);
        PetEditProfilePage petEditprofilepage = new PetEditProfilePage(testDriver);

        whistleBasePage.write2Log4jAllureStep("Clicked on Sign in Button");
        signInPage = landingPage.clickSignInLnk();

        whistleBasePage.write2Log4jAllureStep("Enter non existing Email - " + FrameworkConfigFactory.getConfig().nonExistingEmail());
        signInPage.enterEmail(FrameworkConfigFactory.getConfig().nonExistingEmail());

        whistleBasePage.write2Log4jAllureStep("Enter Password " + FrameworkConfigFactory.getConfig().passwordMobile());
        signInPage.enterPassword(FrameworkConfigFactory.getConfig().passwordMobile());

        whistleBasePage.write2Log4jAllureStep("Click on Login button");
        signInPage.clickLoginBtn();

        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {

            whistleBasePage.write2Log4jAllureStep("Validating toast message");
            Assert.assertEquals(petEditprofilepage.validateToastMessage(), "Invalid email address or password");

        } else {
            whistleBasePage.write2Log4jAllureStep("Validating error message");
            Assert.assertEquals(signInPage.loginAlertOk(), "Username or password is incorrect");
        }
    }

/**
* Created by Jameel Mohammed on 14 July, 2022
**/
    @TestRails(id="994059")
    @Description("Test Email- Invalid")
	@Test(priority=2, groups={ "P1" }, retryAnalyzer = Retry.class)
    @Feature("Email - Invalid")
    public void testEmailInvalid() {
        whistleBasePage.write2Log4jAllureStep("Click on Sign In Link");
        signInPage = whistleBasePage.clickSignInLnk();
        whistleBasePage.write2Log4jAllureStep("Enter Invalid Email Address / User ID " + FrameworkConfigFactory.getConfig().invalidEmail());
        signInPage.enterEmail(FrameworkConfigFactory.getConfig().invalidEmail());
        whistleBasePage.write2Log4jAllureStep("Enter Password > 8 characters " + FrameworkConfigFactory.getConfig().invalidPasswordMobile());
        signInPage.enterPassword(FrameworkConfigFactory.getConfig().invalidPasswordMobile());
        whistleBasePage.write2Log4jAllureStep("Verifying if Log In button not displayed on entering invalid email");
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")){
            Assert.assertFalse(signInPage.isLogInBtnDisplayed());
        }else {
            signInPage.clickLoginBtn();
            Assert.assertEquals(signInPage.loginAlertOk(), "Username or password is incorrect");
        }
    }

/**
* Created by Jameel Mohammed on 14 July, 2022
**/
    @TestRails(id="994060")
    @Description("Test Email- Invalid")
    @Test(priority=3, groups={ "P1" }, retryAnalyzer = Retry.class)
    @Feature("Email - Blank")
    public void testEmailBlank() {
        whistleBasePage.write2Log4jAllureStep("Click on Sign In Link");
        signInPage = whistleBasePage.clickSignInLnk();
        whistleBasePage.write2Log4jAllureStep("Enter Blank Email Address / User ID " + FrameworkConfigFactory.getConfig().emailBlank());
        signInPage.enterEmail(FrameworkConfigFactory.getConfig().emailBlank());
        whistleBasePage.write2Log4jAllureStep("Enter Password > 8 characters " + FrameworkConfigFactory.getConfig().invalidPasswordMobile());
        signInPage.enterPassword(FrameworkConfigFactory.getConfig().invalidPasswordMobile());
        whistleBasePage.write2Log4jAllureStep("Verifying if Log In button not displayed on entering blank email");
        if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")){
            Assert.assertFalse(signInPage.isLogInBtnDisplayed());
        }else {
            Assert.assertFalse(signInPage.isLoginBtnEnabled(), "Login Btn is enabled");
        }
    }
}
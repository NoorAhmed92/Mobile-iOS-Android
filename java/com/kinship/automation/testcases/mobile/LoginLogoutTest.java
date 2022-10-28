package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.pageobjects.mobile.*;
import com.kinship.automation.utils.listeners.Retry;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import com.kinship.automation.constants.WhistleConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;
import static com.kinship.automation.utils.commonutils.TestDriver.ScrollDirection.UP;

/**
 * Modified by Jyoti Basera on 17 Feb, 2022 and added test case C994168
 * Modified by Murali Jaladurgam on 23 Feb, 2022 and added test case C993591
 */

@Listeners(TestListener.class)
public class LoginLogoutTest extends MobileBaseTest {

/**
* Created by Jyoti Basera on 03 February, 2022
**/
	@TestRails(id = "994168")
	@Description("Test Sign In screen View")
	@Test(priority = 0, groups = {"BAT", "P0"}, retryAnalyzer = Retry.class)
	@Feature("LogInLogOutTest")
	public void testSignInScreenView() {
		SignInPage signInPage = new SignInPage(testDriver);
		HomePageWhistle homePageWhistle = new HomePageWhistle(testDriver);
		HumanStuffPage humanStuffPage = new HumanStuffPage(testDriver);

		if (!testDriver.isDisplayedWait(signInPage.signInLink, 3)) {
			log.info("user is already logged in");
		} else {
			signInPage = whistleBasePage.clickSignInLnk();
			log.info("Verify UI elements on Sign In Screen");

			Assert.assertTrue(signInPage.isWelcomeTextSignInScreenDisplayed(), "Verifying if Welcome text is displayed");
			Assert.assertTrue(signInPage.isSignInPageTitleDisplayed(), "Verifying if Sign In page title is displayed");
			Assert.assertTrue(signInPage.isAppBackNavigationPresent(), "Verifying if app back navigation is present");
			Assert.assertTrue(signInPage.isEmailFieldPresent(), "Verifying if Email address text is displayed");
			Assert.assertTrue(signInPage.isPasswordFieldPresent(), "Verifying if Password field is displayed");

			log.info("Verifying if email address field is clickable");
			signInPage.verifyWaterMarkText();

			log.info("Verifying if Forgot Password CTA is displayed");
			Assert.assertTrue(signInPage.isForgotPasswordCTADisplayed(), "Verifying if Forgot Password CTA is displayed");

			log.info("Verifying if Log In button is not displayed on landing Sign In screen");
			signInPage.verifyLoginBtn();

			log.info("Enter email and password");
			signInPage.enterEmail(WhistleConstants.EMAIL_MOBILE);
			signInPage.enterPassword(WhistleConstants.PASSWORD);
			log.info("Verifying Log In button is enabled on Sign In screen after entering valid credentials");
			Assert.assertTrue(signInPage.isLogInBtnDisplayed(), "Log In button is enabled");
			homePageWhistle = signInPage.clickLoginBtn();
		}

		log.info("Verifying for Family Trip screen");
		homePageWhistle.handleNotificationBanner();

		log.info("Click on Human Tab");
		if ((FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android"))) {
			humanStuffPage = signInPage.clickHumanTab();
		} else {
			signInPage.clickTab("Human");
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
			accountInformationPage.clickLogout();
			accountInformationPage.clickLogoutPopUpBtn();
		} else {
			log.info("Scroll up to Account Information");
			testDriver.swipe(UP);
			signInPage.clickTab("Account Information");
			log.info("Click on Logout Option");
			signInPage.clickTab("Logout");
		}
		log.info("Logged out successfully");
	}

/**
* Created by Jameel Ahmed on 06 June, 2022
**/
	@TestRails(id = "994062")
	@Description("Validate incorrect password")
	@Test(priority = 2, groups = {"P1"})
	@Feature("Password - Incorrect")
	public void testPasswordIncorrect() {
		LandingPage landingPage = new LandingPage(testDriver);
		PetEditProfilePage petEditprofilepage = new PetEditProfilePage(testDriver);

		if (!landingPage.isSignInBtnDisplayed()) {
			whistleBasePage.write2Log4jAllureStep("user is already logged in");

			whistleBasePage.write2Log4jAllureStep("Click on back CTA");
			signInPage.clickBackCTA();

		} else {
			whistleBasePage.write2Log4jAllureStep("User is on Sign in screen");
		}
		whistleBasePage.write2Log4jAllureStep("Clicked on Sign in Button");
		signInPage = landingPage.clickSignInLnk();

		whistleBasePage.write2Log4jAllureStep("Enter Email Address / User ID " + FrameworkConfigFactory.getConfig().emailMobile());
		signInPage.enterEmail(FrameworkConfigFactory.getConfig().emailMobile());

		whistleBasePage.write2Log4jAllureStep("Enter Password " + FrameworkConfigFactory.getConfig().invalidPasswordMobile());
		signInPage.enterPassword(FrameworkConfigFactory.getConfig().invalidPasswordMobile());

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
* Created by Jameel Ahmed on 06 June, 2022
**/
	@TestRails(id = "994064")
	@Description("Validate password Blank")
	@Test(priority = 3, groups = {"P1"})
	@Feature("Password - Blank")
	public void testPasswordBlank() {
		LandingPage landingPage = new LandingPage(testDriver);
		PetEditProfilePage petEditprofilepage = new PetEditProfilePage(testDriver);
		SignInPage signInPage = new SignInPage(testDriver);

		if (!landingPage.isSignInBtnDisplayed()) {
			whistleBasePage.write2Log4jAllureStep("user is already logged in");

			whistleBasePage.write2Log4jAllureStep("Click on back CTA");
			signInPage.clickBackCTA();

		} else {
			whistleBasePage.write2Log4jAllureStep("User is on Sign in screen");
		}
		whistleBasePage.write2Log4jAllureStep("Clicked on Sign in Button");
		signInPage = landingPage.clickSignInLnk();

		whistleBasePage.write2Log4jAllureStep("Enter Email Address / User ID " + FrameworkConfigFactory.getConfig().emailMobile());
		signInPage.enterEmail(FrameworkConfigFactory.getConfig().emailMobile());

		whistleBasePage.write2Log4jAllureStep("Enter Password Blank" + FrameworkConfigFactory.getConfig().passwordBlank());
		signInPage.enterPassword(FrameworkConfigFactory.getConfig().passwordBlank());

		if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {

			whistleBasePage.write2Log4jAllureStep("Validating login btn is not displayed");
			Assert.assertFalse(signInPage.isLogInBtnDisplayed(), "Login Button should not be displayed");

		} else {
			whistleBasePage.write2Log4jAllureStep("Validating login Button is disabled");
			Assert.assertFalse(signInPage.isLoginBtnEnabled(), "Login Button is enabled");
		}
	}

/**
* Created by Jameel Ahmed on 10 June, 2022
**/
	@TestRails(id = "994063")
	@Description("Validate password less than eight characters")
	@Test(priority = 1, groups = {"P1"})
	@Feature("Password - Blank")
	public void testPasswordLessThanEightChars() {
		if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) {
			LandingPage landingPage = new LandingPage(testDriver);
			PetEditProfilePage petEditprofilepage = new PetEditProfilePage(testDriver);

			if (!landingPage.isSignInBtnDisplayed()) {
				whistleBasePage.write2Log4jAllureStep("user is already logged in");

				whistleBasePage.write2Log4jAllureStep("Click on back CTA");
				signInPage.clickBackCTA();

			} else {
				whistleBasePage.write2Log4jAllureStep("User is on Sign in screen");
			}
			whistleBasePage.write2Log4jAllureStep("Clicked on Sign in Button");
			signInPage = landingPage.clickSignInLnk();

			whistleBasePage.write2Log4jAllureStep("Enter Email Address / User ID " + FrameworkConfigFactory.getConfig().emailMobile());
			signInPage.enterEmail(FrameworkConfigFactory.getConfig().emailMobile());

			whistleBasePage.write2Log4jAllureStep("Enter Password " + FrameworkConfigFactory.getConfig().invalidPasswordLessThanEightChars());
			signInPage.enterPassword(FrameworkConfigFactory.getConfig().invalidPasswordLessThanEightChars());

			whistleBasePage.write2Log4jAllureStep("Validating login btn is not displayed");
			Assert.assertFalse(signInPage.isLogInBtnDisplayed(), "Login Button is displayed");
		} else
			whistleBasePage.write2Log4jAllureStep("This test is out of scope for iOS Automation");
	}
}
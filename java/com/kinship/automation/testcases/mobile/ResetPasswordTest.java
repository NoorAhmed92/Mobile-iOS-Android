package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.utils.listeners.Retry;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import com.kinship.automation.constants.WhistleConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Jyoti Basera
 * created on 2022/01/11
 */

@Listeners(TestListener.class)
public class ResetPasswordTest extends MobileBaseTest {

/**
* Created by Jyoti Basera on 11 January, 2022
**/
	@TestRails(id="994069")
	@Description("Test Reset Password View")
	@Test(priority=0, groups={ "P0" }, retryAnalyzer = Retry.class)
	@Feature("ResetPassword")
    public void testResetPasswordView() {
		signInPage = whistleBasePage.clickSignInLnk();
		resetPasswordPage = signInPage.clickForgotPasswordBtn();
		resetPasswordPage.enterEmail(WhistleConstants.EMAIL_MOBILE);
		Assert.assertTrue(resetPasswordPage.isResetPasswordBtnEnabled(), "Reset password button is not enabled");
	}

/**
* Created by Jyoti Basera on 11 January, 2022
**/
	@TestRails(id="994070")
	@Description("Test Reset Password View using valid Email.")
	@Test(priority=1, groups={ "P0" }, retryAnalyzer = Retry.class)
	@Feature("ResetPassword")
	public void testResetPasswordViewWithValidEmail() throws InterruptedException {
		signInPage = whistleBasePage.clickSignInLnk();
		resetPasswordPage = signInPage.clickForgotPasswordBtn();
		resetPasswordPage.enterEmail(WhistleConstants.EMAIL_MOBILE);
		resetPasswordPage.isResetPasswordBtnEnabled();
		resetPasswordPage.clickResetPasswordBtn();
		log.info("Verifying if Reset password toast message for valid email is displayed");
		if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")){
			Assert.assertEquals(resetPasswordPage.getToastMessage(), WhistleConstants.RESET_PASSWORD_LINK_SENT_MSG);
		}else {
			signInPage.isWelcomeTextSignInScreenDisplayed();
			Assert.assertTrue(signInPage.isWelcomeTextSignInScreenDisplayed(), "User is not landed to Welcome Sign In screen");
		}
	}

/**
* Created by Jyoti Basera on 25 January, 2022
**/
	@TestRails(id="994072")
	@Description("Test Reset Password View using Invalid Email.")
	@Test(priority=2, groups={ "P1" }, retryAnalyzer = Retry.class)
	@Feature("ResetPassword")
	public void testResetPasswordViewWithInvalidEmail() {
		signInPage = whistleBasePage.clickSignInLnk();
		resetPasswordPage = signInPage.clickForgotPasswordBtn();
		resetPasswordPage.enterEmail(WhistleConstants.INVALID_EMAIL);
		log.info("Verifying if Reset password button is not displayed on entering invalid email");
		if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")){
			Assert.assertFalse(resetPasswordPage.isResetPasswordBtnDisplayed());
		}else {
			Assert.assertFalse(resetPasswordPage.isResetPasswordBtnEnabled());
		}
	}

/**
* Created by Jyoti Basera on 21 January, 2022
**/
	@TestRails(id="994073")
	@Description("Test Reset Password View using non-existing Email.")
	@Test(priority=3, groups={ "P0" }, retryAnalyzer = Retry.class)
	@Feature("ResetPassword")
	public void testResetPasswordViewWithNonExistingEmail() throws InterruptedException {
		signInPage = whistleBasePage.clickSignInLnk();
		resetPasswordPage = signInPage.clickForgotPasswordBtn();
		resetPasswordPage.enterEmail(WhistleConstants.NON_EXISTING_EMAIL);
		resetPasswordPage.isResetPasswordBtnEnabled();
		resetPasswordPage.clickResetPasswordBtn();
		log.info("Verifying if Reset password toast message for non-existing email is displayed");
		if ( (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("android")) ){
			Assert.assertEquals(resetPasswordPage.getToastMessage(), WhistleConstants.RESET_PASSWORD_NONEXISTING_EMAIL_MSG);
		}else {
			Assert.assertTrue(resetPasswordPage.isOkBtnResetPsdErrorMsgDisplayed(),"Error message is not displayed");
			resetPasswordPage.clickOKBtn();
		}
	}
}

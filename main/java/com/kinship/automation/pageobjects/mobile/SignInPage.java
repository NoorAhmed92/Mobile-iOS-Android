package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SignInPage extends WhistleBasePage {

	TestDriver driver;

	private By welcomeText = ByT.locator(By.id("login - title label"), By.id("sign_in_screen_welcome_message"));
	private By emailAddress = ByT.locator(By.id("login - email text field"), By.id("sign_in_email_field"));
	private By passwordTextField = ByT.locator(By.id("login - password text field"), By.id("sign_in_password_field"));
	private By loginButton = ByT.locator(By.id("login - continue button"), By.id("sign_in_screen_sign_in_btn"));
	private By forgotPasswordButton = ByT.locator(By.id("Forgot password?"), By.id("sign_in_screen_forgot_password"));
	private By navigateUpBackButton = ByT.locator(By.id("ChubbyBackArrow"), By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
	private By SignInPageTitle = ByT.locator(By.xpath("//XCUIElementTypeStaticText[@name='Sign In']"), By.xpath("//android.widget.TextView[@text='Sign In']"));
	private By humanIcon = ByT.locator(By.id("Human"), By.xpath("//android.widget.FrameLayout[@content-desc=\"Human\"]"));
	private By loginAlert = ByT.locator(By.id("OK"));// for iOS only
	private By invalidEmailOrPwd = ByT.locator(By.id("login - error label"));// for iOS only
	private By eyeIcon = ByT.locator(By.id("eye"), By.id("text_input_end_icon"));

	public SignInPage(TestDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Verify if Welcome text is displayed on Sign In Screen")
	public boolean isWelcomeTextSignInScreenDisplayed() {
		driver.pauseExecutionFor(4);
		return driver.isElementPresent(welcomeText);
	}

	@Step("Verify if sign In page title is displayed")
	public boolean isSignInPageTitleDisplayed() {
		return driver.isElementPresent(SignInPageTitle);
	}

	@Step("Verify if app back navigation is present")
	public boolean isAppBackNavigationPresent() {
		return driver.isElementPresent(navigateUpBackButton);
	}

	@Step("Verify if email field is present")
	public boolean isEmailFieldPresent() {
		return driver.isElementPresent(emailAddress);
	}

	@Step("Get clickable value of email field")
	public void verifyWaterMarkText() {
		if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")) {
			String ele = driver.getElementAttributeValue(emailAddress, "value");
			log.info("Water Mark Text for iOS " + ele);
			Assert.assertEquals("Your email address", ele);
		}
	}

	@Step("Verify if password text field is present")
	public boolean isPasswordFieldPresent() {
		return driver.isElementPresent(passwordTextField);
	}

	@Step("Click on log in button")
	public HomePageWhistle clickLoginBtn() {
		driver.clickLocator(loginButton);
		driver.pauseExecutionFor(1);
		return new HomePageWhistle(driver);
	}

	@Step("Verify if Login Button is Enabled")
	public boolean isLoginBtnEnabled() {
		driver.pauseExecutionFor(2);
		return driver.isElementEnabled(loginButton);
	}

	@Step("Verify if Login Button is displayed")
	public boolean isLogInBtnDisplayed() {
		driver.pauseExecutionFor(2);
		return driver.isElementPresent(loginButton);
	}

	@Step("Enter email")
	public SignInPage enterEmail(String email) {
		driver.type(emailAddress, email);
		return this;
	}

	@Step("Enter password")
	public SignInPage enterPassword(String password) {
		driver.type(passwordTextField, password);
		return this;
	}

	@Step("Get text value of Password field")
	public String getPasswordTextValue() {
		String sPwdTxt = driver.getText(passwordTextField, "Get text value of Password field").trim();
		log.info("Password Text Value: " + sPwdTxt);
		return sPwdTxt;
	}

	@Step("Verify if Forgot Password CTA is displayed")
	public boolean isForgotPasswordCTADisplayed() {
		return driver.isElementPresent(forgotPasswordButton);
	}

	@Step("Click on Forgot Password button")
	public ResetPasswordPage clickForgotPasswordBtn() {
		driver.clickLocator(forgotPasswordButton);
		return new ResetPasswordPage(driver);
	}

	public void verifyLoginBtn() {
		driver.pauseExecutionFor(2);
		if (isAndroidBS()) {
			Assert.assertFalse(driver.isElementPresent(loginButton));
		} else {
			Assert.assertTrue(driver.isElementPresent(loginButton));
		}
	}

	@Step("Click on Human Tab")
	public HumanStuffPage clickHumanTab() {
		if (isAndroidBS())
			driver.clickLocator(humanIcon);
		return new HumanStuffPage(driver);
	}

	public HomePageWhistle signInToHomePage() {
		clickSignInLnk();
		enterEmail(FrameworkConfigFactory.getConfig().emailMobile());
		enterPassword(FrameworkConfigFactory.getConfig().passwordMobile());
		clickLoginBtn();
		return new HomePageWhistle(driver);
	}

	public HomePageWhistle signInToHomePageMultiPet() {
		clickSignInLnk();
		enterEmail(FrameworkConfigFactory.getConfig().emailMobileHybridAM2W04());
		enterPassword(FrameworkConfigFactory.getConfig().passwordMobileAM2());
		clickLoginBtn();
		return new HomePageWhistle(driver);
	}

	public HomePageWhistle signInToHomePageAM2() {
		clickSignInLnk();
		enterEmail(FrameworkConfigFactory.getConfig().emailMobileSingleAM2());
		enterPassword(FrameworkConfigFactory.getConfig().passwordMobileAM2());
		clickLoginBtn();
		return new HomePageWhistle(driver);
	}

	public HomePageWhistle signInToHomePageW04Device() {
		clickSignInLnk();
		enterEmail(FrameworkConfigFactory.getConfig().emailMobileW04());
		enterPassword(FrameworkConfigFactory.getConfig().passwordMobile());
		clickLoginBtn();
		return new HomePageWhistle(driver);
	}

	public String loginAlertOk() {
		driver.clickLocator(loginAlert);
		String ele = driver.getElementAttributeValue(invalidEmailOrPwd, "value");
		log.info("Invalid email or password error message:- " + ele);
		return ele;
	}

	public void clickBackCTA(){
		driver.clickLocator(navigateUpBackButton);
		driver.pauseExecutionFor(2);
	}

	@Step("Get text value of Email field")
	public String getEmailTextValue() {
		String sEmailTxt = driver.getText(emailAddress, "Get text value of Email field").trim();
		log.info("Email Text Value: " + sEmailTxt);
		return sEmailTxt;
	}
	public void clickEyeIcon(){
		driver.clickLocator(eyeIcon);
	}
	public String getPasswordText(){
		String getPassword= driver.getText(passwordTextField,"Password value");
		return getPassword;
	}
}
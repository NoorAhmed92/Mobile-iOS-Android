package com.kinship.automation.pageobjects.mobile;

/**
 * Created by hpatel on 01 Mar, 2022
 * Modified by jBasera on 17 Mar, 2022
 */
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import static com.kinship.automation.constants.WhistleConstants.*;

public class LandingPage extends WhistleBasePage{

	private final By getStartedBtn = ByT.locator(By.id("Get started"), By.id("welcome_screen_set_up_device_btn"));
	private final By signInButton = ByT.locator(By.xpath("//XCUIElementTypeButton[@name=\"welcome - sign in label\"]"),By.id("welcome_screen_sign_in_btn"));
	private final By BluetoothTitle = ByT.locator(By.xpath("//XCUIElementTypeStaticText[contains(@name,'“Whistle-Beta” Would Like to')]"), By.xpath(""));
	private final By BluetoothBodyCopy = ByT.locator(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Bluetooth is required for your phone to find and connect to your')]"), By.xpath(""));
	private final By BluetoothDAllowCTA = ByT.locator(By.id("Don’t Allow"), By.xpath(""));
	private final By BluetoothOkCTA = ByT.locator(By.id("OK"), By.xpath(""));
	private final By welcomeText = ByT.locator(By.id("Welcome to"), By.xpath("//android.widget.TextView[@text='Welcome to']"));
	private final By dogAsset = ByT.locator(By.xpath("//XCUIElementTypeButton/preceding-sibling::XCUIElementTypeOther[1]"), By.id("welcome_screen_dog"));
	private final By whistleLogo = ByT.locator(By.xpath("//XCUIElementTypeButton/preceding-sibling::XCUIElementTypeOther[2]"), By.id("welcome_screen_logo"));

	private final TestDriver driver;
	public LandingPage(TestDriver driver) {
		this.driver = driver;
	}

	@Step("Verifying Get Started Button is Display or not")
	public void isGetStartedBtnDisplayed() {
		Assert.assertTrue(driver.isElementEnabled(getStartedBtn));
	}

	@Step("Verifying Get Started Button is enable")
	public void isGetStartedBtnEnable() throws InterruptedException {
		Assert.assertTrue(driver.isElementEnabled(getStartedBtn));
	}

	@Step("Verifying if Sign In button is displayed")
	public boolean isSignInBtnDisplayed() {
		boolean flag = false;
		driver.pauseExecutionFor(2);
		flag = driver.isElementPresent(signInButton);
		return flag;
	}

	@Step("Have an account? Sign in Text Display")
	public void isSignInTxtDisplayed() {
		Assert.assertTrue(driver.isElementPresent(signInButton));
		String sSignTxt = driver.getText(signInButton, "signInButton");
		log.info("sSignTxt :" + sSignTxt);
		if ( (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")) || (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("bs-ios"))){
			Assert.assertEquals(sSignTxt, SIGN_IN_TEXT, "Text Doesn't match");
		}else {
			Assert.assertEquals(sSignTxt, SIGN_IN_MSG, "Text Doesn't match");
		}
	}

	@Step("Verifying Get Started Button is present in the landing screen")
	public boolean isGetStartedButtonPresent() {
		return driver.isElementPresent(getStartedBtn);
	}

	@Step("Click on sign in link")
	public SignInPage clickSignInLnk() {
		driver.pauseExecutionFor(2);
		driver.clickLocator(signInButton);
		return new SignInPage(driver);
	}

	@Step("Validate Welcome Text")
	public boolean validateWelcomeText() {
		driver.pauseExecutionFor(2);
		return driver.isElementPresent(welcomeText);
	}

	@Step("Validate Dog Asset")
	public boolean validateDogAsset() {
		driver.pauseExecutionFor(2);
		return driver.isElementPresent(dogAsset);
	}

	@Step("Validate Bluetooch title")
	public boolean validateBluetoothTitle() {
		return driver.isElementPresent(BluetoothTitle);
	}

	@Step("Validate Bluetooth Body copy")
	public boolean validateBluetoothBodyCopy() {
		return driver.isElementPresent(BluetoothBodyCopy);
	}

	@Step("Validate Bluetooth Don't Allow CTA")
	public boolean validateBluetoothDontAllowCTA() {
		return driver.isElementPresent(BluetoothDAllowCTA);
	}

	@Step("Validate Bluetooth OK CTA")
	public boolean validateBluetoothOkCTA() {
		return driver.isElementPresent(BluetoothOkCTA);
	}

	@Step("Validate Whistle Logo")
	public boolean validateWhistleLogo() {
		driver.pauseExecutionFor(2);
		return driver.isElementPresent(whistleLogo);
	}

	@Step("Click on bluetooth popup OK CTA")
	public SignInPage clickBluetoothOkCTA() {
		driver.clickLocator(BluetoothOkCTA);
		return new SignInPage(driver);
	}
}

package com.kinship.automation.testcases.mobile;

import com.kinship.automation.base.MobileBaseTest;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Jyoti Basera
 * created on 2022/03/07
 */

@Listeners(TestListener.class)
public class DeviceSetUpTest extends MobileBaseTest {

/**
* Created by Jyoti Basera on 9 March, 2022
**/
	@TestRails(id = "994077")
	@Description("Test BLE Primer Screen for Whistle Go Explorer Device")
	@Test(priority = 0, groups={ "P0" })
	@Feature("WhistleDeviceSetUp")
	public void testWhistleGoExploreDevice() throws InterruptedException {
		selectDevicePage = whistleBasePage.clickGetStartedButton();	
		whistleSetUpPage = selectDevicePage.clickOnGoExplorerDevice();
		assembleDevicePage = whistleSetUpPage.clickOnYesIHomeButton();
		boolean isEnabled = assembleDevicePage.isPairMyDeviceEnabled();
		Assert.assertEquals(isEnabled, true);
		whistleSetUpPage = assembleDevicePage.clickAppBackNavigation();
		selectDevicePage = whistleSetUpPage.clickAppBackNavigation();
		selectDevicePage.clickAppBackNavigation();
	}

/**
* Created by Jyoti Basera on 24 March, 2022
**/
	@TestRails(id = "994076")
	@Description("Test BLE Primer Screen for Whistle Switch Device")
	@Feature("WhistleDeviceSetUp")
	@Test(priority = 1, groups={ "P0" })
	public void testWhistleSwitchDevice() throws InterruptedException {
		selectDevicePage = whistleBasePage.clickGetStartedButton();	
		whistleSetUpPage = selectDevicePage.clickOnSwitchDevice();
		assembleDevicePage = whistleSetUpPage.clickOnYesIHomeButton();
		boolean isEnabled = assembleDevicePage.isPairMyDeviceEnabled();
		Assert.assertEquals(isEnabled, true);
		whistleSetUpPage = assembleDevicePage.clickAppBackNavigation();
		selectDevicePage = whistleSetUpPage.clickAppBackNavigation();
		selectDevicePage.clickAppBackNavigation();

	}
/**
* Created by Jyoti Basera on 21 March, 2022
**/
	@TestRails(id = "994080")
	@Description("Test BLE Primer Screen for Whistle Fit Device")
	@Feature("WhistleDeviceSetUp")
	@Test(priority = 2, groups={ "P0" })
	public void testWhistleFitDevice() throws InterruptedException {
		selectDevicePage = whistleBasePage.clickGetStartedButton();	
		whistleSetUpPage = selectDevicePage.clickOnFitDevice();
		assembleDevicePage = whistleSetUpPage.clickOnYesIHomeButton();
		boolean isEnabled = assembleDevicePage.isPairMyDeviceEnabled();
		Assert.assertEquals(isEnabled, true);
		whistleSetUpPage = assembleDevicePage.clickAppBackNavigation();
		selectDevicePage = whistleSetUpPage.clickAppBackNavigation();
		selectDevicePage.clickAppBackNavigation();
		selectDevicePage.clickAppBackNavigation();
	}

/**
* Created by Jyoti Basera on 21 March, 2022
**/
	@TestRails(id = "994078")
	@Description("Test BLE Primer Screen for Whistle Go Device")
	@Feature("WhistleDeviceSetUp")
	@Test(priority = 3, groups={ "P0" })
	public void testWhistleGoDevice() throws InterruptedException {
		selectDevicePage = whistleBasePage.clickGetStartedButton();
		whistleSetUpPage = selectDevicePage.clickOnGoDevice();
		assembleDevicePage = whistleSetUpPage.clickOnYesIHomeButton();
		boolean isEnabled = assembleDevicePage.isPairMyDeviceEnabled();
		Assert.assertEquals(isEnabled, true);
		whistleSetUpPage = assembleDevicePage.clickAppBackNavigation();
		selectDevicePage = whistleSetUpPage.clickAppBackNavigation();
		selectDevicePage.clickAppBackNavigation();
		selectDevicePage.clickAppBackNavigation();
	}

/**
* Created by Jyoti Basera on 5 July, 2022
**/
	@TestRails(id = "994167")
	@Description("Test Set Up Device Selection Screen")
	@Feature("WhistleDeviceSetUp")
	@Test(priority = 4, groups={ "P1" })
	public void testSetUpDeviceSelectionView() throws InterruptedException {
		selectDevicePage = whistleBasePage.clickGetStartedButton();
		whistleBasePage.write2Log4jAllureStep("Verifying Select your device page title");
		Assert.assertTrue(selectDevicePage.isSelectYourDevicePageTitleDisplayed(), "Select your device page title is not displayed");

		whistleBasePage.write2Log4jAllureStep("Verifying the header copy");
		Assert.assertTrue(selectDevicePage.isSelectYourDeviceTxtDisplayed(), "Select your device text is not displayed");

		whistleBasePage.write2Log4jAllureStep("Verifying Back [<] CTA");
		Assert.assertTrue(selectDevicePage.isAppBackNavigationDisplayed(), "Back [<] CTA is not displayed");

		whistleBasePage.write2Log4jAllureStep("Verifying Whistle Switch device CTA");
		Assert.assertTrue(selectDevicePage.isWhistleSwitchCTADisplayed(), "Whistle Switch CTA is not displayed");

		whistleBasePage.write2Log4jAllureStep("Verifying Whistle Go Explorer device CTA");
		Assert.assertTrue(selectDevicePage.isWhistleGoExplorerCTADisplayed(), "Whistle Go Explorer CTA is not displayed");

		whistleBasePage.write2Log4jAllureStep("Verifying Whistle Health device CTA");
		Assert.assertTrue(selectDevicePage.isWhistleHealthCTADisplayed(), "Whistle Health CTA is not displayed");

		whistleBasePage.write2Log4jAllureStep("Click on Other whistle Devices");
		selectDevicePage.clickOtherWhistleDevices();

		whistleBasePage.write2Log4jAllureStep("Verifying Whistle Fit device CTA");
		Assert.assertTrue(selectDevicePage.isWhistleFitCTADisplayed(), "Whistle Fit CTA is not displayed");

		whistleBasePage.write2Log4jAllureStep("Verifying Whistle GO device CTA");
		Assert.assertTrue(selectDevicePage.isWhistleGoCTADisplayed(), "Whistle Go CTA is not displayed");
	}
}

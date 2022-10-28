package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.drivers.DriverManager;
import com.kinship.automation.utils.commonutils.TestDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageWhistle  extends WhistleBasePage {

	TestDriver driver;

	private By appLogo = ByT.locator(By.id("Welcome to"), By.id("welcome_screen_logo"));
	private By permissionsRequiredPopUp = ByT.locator(By.id(""), By.id("md_titleFrame"));
	private By permissionsRequiredPopUpOkBtn = ByT.locator(By.id("OK"), By.id("md_buttonDefaultPositive"));
	private By allowLocationPopUp = ByT.locator(By.id("Allow Access"), By.id("com.android.permissioncontroller:id/grant_dialog"));
	private By allowWhileUsingApp = ByT.locator(By.id("Allow While Using App"), By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
	private By humanStuffMenuOptn = ByT.locator(By.id("Human"), By.id("main_bottom_nav_human_stuff"));
	private By petStuffMenuOptn = ByT.locator(By.xpath("//XCUIElementTypeOther[contains(@id,'Pet')]"), By.id("main_bottom_nav_pet_stuff"));
	private By petStuffMenuOptnbs = ByT.locator(By.id("Pet"), By.id("main_bottom_nav_pet_stuff"));
	private By helpMakeWhistleBetterOptn = ByT.locator(MobileBy.iOSNsPredicateString("label == \"Help Make Whistle Better\""), By.id("human_tab_list_item_make_us_better"));
	private By helpUrl = ByT.locator(By.id(""), By.id("com.sec.android.app.sbrowser:id/url_bar_text"));
	private By closeWebView = ByT.locator(By.id(""), By.id("com.sec.android.app.sbrowser:id/customtab_close"));
	private By accountInfoOptn = ByT.locator(MobileBy.iOSNsPredicateString("label == \"Account Information\""), By.id("human_tab_list_item_account_information"));
	private By logOutOptn = ByT.locator(MobileBy.iOSNsPredicateString("label == \"Logout\""), By.id("account_list_item_log_out"));
	private String family = ByT.locator("MobileBy.iOSNsPredicateString(\"label == \\\"Yer Larkin\\\"\")", "//*[@resource-id='one_line_list_item_label' and @text='%s']");
	private String removeLnk = ByT.locator("//*[@text='%s']", "//*[@resource-id='family_list_item_name' and @text='%s']//following-sibling::android.widget.TextView");
	private By confirmRemove = ByT.locator(MobileBy.xpath("//XCUIElementTypeButton[@name=\"Confirm\"]"), By.id("md_buttonDefaultPositive"));
	private By areYouSurePopUp = ByT.locator(By.id(""), By.id("md_title"));
	private By confirmLogOut = ByT.locator(By.id(""), By.id("md_buttonDefaultPositive"));
	private By backButton = ByT.locator(By.id(""), By.xpath("//*[@resource-id='blank_toolbar_activity_toolbar']//android.widget.ImageButton"));
	private By addHumans = ByT.locator(By.id(""), By.id("pet_page_family_add_humans_item"));
	private By familyTripNotificationNextBtn = ByT.locator(By.id(""), By.id("safe_breach_intro_next_button"));
	private By familyTripNotificationDoneBtn = ByT.locator(By.id("Enable"), By.id("safe_breach_intro_next_button"));
	private By dismissEnableBluetooth = ByT.locator(By.xpath("//*[@text='Don’t Allow']"), By.id("alert_banner_action_secondary"));
	private By lblConfirmationMsg = MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"Humpf!\"]/following-sibling::XCUIElementTypeStaticText");
	private By enableBluetoothBanner = ByT.locator(By.xpath("//*[@id='“Whistle-Beta” Would Like to Use Bluetooth']"), By.id("alert_banner_title"));
	private By findMyPetBtn = ByT.locator(By.id("Find My Pet"), By.xpath("//android.widget.TextView[@text='Pet']"));
	private By locationIconTabBar = ByT.locator(By.id("Location"), By.xpath("//android.widget.TextView[@text='Location']"));
	private By activityIconTabBar = ByT.locator(By.id("Activity"), By.xpath("//android.widget.TextView[@text='Activity']"));
	private By healthIconTabBar = ByT.locator(By.id("Health"), By.xpath("//android.widget.TextView[@text='Health']"));
	private By petIconTabBar = ByT.locator(By.xpath("//XCUIElementTypeOther[contains(@name,'Pet')]"), By.xpath("//android.widget.TextView[@text='Pet']"));
	private By humanIconTabBar = ByT.locator(By.xpath("//XCUIElementTypeOther[contains(@name,'Human')]"), By.xpath("//android.widget.TextView[@text='Human']"));
	private By homeIconTabBar = ByT.locator(By.xpath("//XCUIElementTypeOther[contains(@name,'Home')]"), By.xpath("//android.widget.TextView[@text='Home']"));
	private By wellnessScoreOption = ByT.locator(By.id("Wellness Score"), By.xpath("//*[@text='Wellness Score' and @class='android.view.View']"));
	private By wellnessScoreBoard = ByT.locator(By.id("Wellness Score / day"), By.id("wellness_index_day_title"));
	private By w05EnableNotificationbs = ByT.locator(By.id("ChubbyClose"),By.name(""));
	private By setupLaterbs = ByT.locator(By.id("Setup Later"),By.xpath(""));
	private By w05Notificationbs = ByT.locator(By.id("Enable"), By.xpath(""));
	private By petImage = ByT.locator(By.xpath("(//XCUIElementTypeCollectionView//XCUIElementTypeImage[1])[2]"), By.xpath("(//android.view.View[@content-desc=\"Pet Imge\"])[2]"));
	private By shortHeader = ByT.locator(By.xpath("//XCUIElementTypeOther[@name='Human']//following::XCUIElementTypeStaticText[1]"), By.id("main_pet_toolbar_fragment"));
	private By shortHeaderMultiPetAdjustHeader = ByT.locator(By.xpath("//XCUIElementTypeOther[@name='Human']//following::XCUIElementTypeOther[1]"), By.xpath("//android.view.View[@content-desc='Drop down']"));
	private By petPickerDropdown = ByT.locator(By.xpath("//XCUIElementTypeOther[@name='Human']//following::XCUIElementTypeImage[2]"), By.xpath("//android.view.View[@content-desc='Drop down']"));
	private By nextPet = ByT.locator(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[2]"), By.xpath("(//android.view.View[@content-desc=\"Pet Imge\"])[2]"));
	private By petText = ByT.locator(By.xpath("//XCUIElementTypeOther[@name='Human']//following::XCUIElementTypeStaticText[1]"), By.xpath("//android.view.View[@content-desc='Drop down']/following::android.view.View[1]"));
	private By petTextLongHeader = ByT.locator(By.xpath("//XCUIElementTypeOther[@name='Vertical scroll bar, 2 pages']//following::XCUIElementTypeStaticText[1]"), By.xpath("(//android.view.View[@content-desc=\"Pet Imge\"]//following::android.view.View[9])[1]"));
	private By mapTab=ByT.locator(By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[4]"),By.xpath("//android.view.View[@content-desc=\"Google Map\"]"));
	private By healthDashboard = ByT.locator(By.id("Health"), By.xpath("//*[@class='android.view.View' and ./*[@text='Health']]"));
	private By scratchingTab = ByT.locator(By.id("Scratching"), By.xpath("//*[@text='Scratching']"));
	private By lickingTab = ByT.locator(By.id("Licking"), By.xpath("//*[@text='Licking']"));
	private By sleepingTab = ByT.locator(By.id("Sleeping"), By.xpath("//*[@text='Sleeping']"));
	private By eatingTab = ByT.locator(By.id("Eating"), By.xpath("//*[@text='Eating']"));
	private By drinkingTab = ByT.locator(By.id("Drinking"), By.xpath("//*[@text='Drinking']"));
	private By activityLabel = ByT.locator(By.id("Activity"), By.xpath("//android.view.View[@text='Activity' and @class='android.view.View']"));
	private By caloriLabel =ByT.locator(By.xpath("(//XCUIElementTypeStaticText[@class='UIAStaticText'])[11]"), By.xpath("//android.view.View[@text='cal']"));
	private By kmLabel =ByT.locator(By.xpath("(//XCUIElementTypeStaticText[@class='UIAStaticText'])[12]"), By.xpath("//android.view.View[@text='km']"));
	private By HoursLabel = ByT.locator(By.xpath("(//XCUIElementTypeStaticText[@class='UIAStaticText'])[13]"), By.xpath("//android.view.View[@text='hrs']"));
	private By progressCircle = ByT.locator(By.xpath("//XCUIElementTypeImage[@name='gathering_data_image']//following::XCUIElementTypeOther[10]"), By.xpath("//android.view.View[@text='/']"));
	private By todayText = ByT.locator(By.id("Today"), By.xpath("//android.view.View[@text='Today']"));
	private By graphArea = ByT.locator(By.id("Line Chart. 4 datasets. DataSet, DataSet, DataSet, DataSet"), By.xpath("(//android.view.View[@class='android.view.View'])[17]"));
	private By wellnessScoreImageCard = ByT.locator(By.xpath("(//XCUIElementTypeOther/following::XCUIElementTypeStaticText)[3]"), By.xpath("//android.view.View[contains(@text,'score')]"));
	private By shareIcon = ByT.locator(By.id("share activity"), By.id("activity_details_share_button"));
	private By caloriesData = ByT.locator(By.id("Calories"), By.id("activity_details_calories_title"));
	private By distanceData = ByT.locator(By.id("Distance"), By.id("activity_details_distance_title"));
	private By restData = ByT.locator(By.id("Rest"), By.id("activity_details_rest_title"));
	private By navigateAwayMsg = ByT.locator(By.id("Are you sure you want to navigate away?"), By.xpath(""));
	private By leftHandText = ByT.locator(By.xpath("//XCUIElementTypeStaticText[@label='12am'][1]"),By.xpath("(//android.view.View[contains(@text,'12am')])[1]"));
	private By rightHandText = ByT.locator(By.xpath("//XCUIElementTypeStaticText[@label='12am'][2]"),By.xpath("(//android.view.View[contains(@text,'12am')])[2]"));
	private By graphData = ByT.locator(By.id("Line Chart. 4 datasets. DataSet, DataSet, DataSet, DataSet"),By.xpath("//android.view.View[@class='android.view.View' and ./*[@text='Activity']]"));
	private By wellnessScoreTitle = ByT.locator(By.xpath("//XCUIElementTypeNavigationBar[@id='Wellness Score']"), By.xpath("//android.widget.TextView[@text='Wellness Score']"));
	private By wellnessScoreBackCTA = ByT.locator(By.xpath("//XCUIElementTypeButton[@id='ChubbyBackArrow']"), By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
	private By wellnessScoreDescription = ByT.locator(By.xpath("//XCUIElementTypeOther/following::XCUIElementTypeStaticText[2]"), By.xpath("//android.widget.TextView/preceding-sibling::android.widget.TextView[2]"));
	private By wellnessScoreMeasurementBar = ByT.locator(By.id("Bar Chart. 1 dataset. "), By.xpath("//android.view.View/preceding-sibling::android.view.View[4]"));
	private By wellnessScoreWeekOrMonth = ByT.locator(By.xpath("//XCUIElementTypeOther[@id='health graph - week/month toggle']"), By.xpath("//android.widget.TextView[@text='Week']"));
	private By wellnessScoreMonth = ByT.locator(By.xpath(""), By.xpath("//android.widget.TextView[@text='Month']"));
	private By wellnessStatuses = ByT.locator(By.xpath(""), By.xpath("//android.widget.TextView[@id='health_graph_threshold_legend_header']"));
	private By learnMore = ByT.locator(By.id("health - graph learn more clicked"),By.xpath("//android.widget.TextView[@text='Learn about wellness levels']"));
	private By chatWithVet = ByT.locator(By.id("health - graph chat with vet clicked"), By.xpath("//android.widget.TextView[@text='Chat with a Vet']"));
	private By wellnessScoreGatheringData = ByT.locator(By.xpath("//XCUIElementTypeOther/preceding-sibling::XCUIElementTypeStaticText[1]"), By.xpath("//android.view.View/following-sibling::android.widget.TextView"));
	private By wellnessStatusesExcellent = ByT.locator(By.id("Excellent"), By.id("Excellent"));
	private By wellnessStatusesOkay = ByT.locator(By.id("Okay"), By.id("Okay"));
	private By wellnessStatusesLow = ByT.locator(By.id("Low"), By.id("Low"));
	private By firstPetProfilePicAlphabet = ByT.locator(By.xpath("(//XCUIElementTypeCollectionView//XCUIElementTypeImage[1])[1]"), By.xpath("(//android.view.View[@content-desc='Pet Imge'])[1]"));
	private By secondPetProfilePicAlphabet = ByT.locator(By.xpath("(//XCUIElementTypeCollectionView//XCUIElementTypeImage[1])[2]"), By.xpath("(//android.view.View[@content-desc='Pet Imge'])[2]"));
	private By UserName = ByT.locator(By.id("AM2"), By.xpath("//*[@text='AM2']"));
	private By tinyHomeIcon = ByT.locator(By.id("safePlaceIcon"),By.xpath("//*[@content-desc='Pet is in home']"));
	private By petPickerDropdownone = ByT.locator(By.xpath("//XCUIElementTypeOther[@name='Location']//following::XCUIElementTypeImage[2]"), By.xpath("//android.view.View[@content-desc='Drop down']"));
	private By activeMinutesHome = ByT.locator(By.xpath("//XCUIElementTypeStaticText[@name='Activity']//preceding-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText"));
	private By activityFirst = ByT.locator(By.xpath("//android.view.View[@text='Activity']//following-sibling::android.view.View[1]"));
	private By activitySecond = ByT.locator(By.xpath("//android.view.View[@text='Activity']//following-sibling::android.view.View[2]"));
	private By activityThird = ByT.locator(By.xpath("//android.view.View[@text='Activity']//following-sibling::android.view.View[3]"));
	private By activityFourth = ByT.locator(By.xpath("//android.view.View[@text='Activity']//following-sibling::android.view.View[4]"));
	public HomePageWhistle(TestDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isAppLogoDisplayed() {
		return driver.isElementPresent(appLogo);
	}

	public boolean isPermissionRequiredPopUpPresent() {
		driver.pauseExecutionFor(2);
		return driver.isElementPresent(permissionsRequiredPopUp);
	}

	@Step("Click on permission required button")
	public HomePageWhistle clickPermissionRequiredOkBtn() {
		driver.clickLocator(permissionsRequiredPopUpOkBtn);
		return this;
	}

	public boolean isAllowLocationPopUpPresent() {
		return driver.isElementPresent(allowLocationPopUp);
	}

	@Step("Click on Allow location pop up")
	public HomePageWhistle clickAllowWhileUsingApp() {
		driver.clickLocator(allowWhileUsingApp);
		return this;
	}

	@Step("Click on Human option option from footer")
	public HomePageWhistle clickHumanMenuOption() {
		driver.clickLocator(humanStuffMenuOptn);
		return this;
	}

	@Step("Click on Help make whistle better menu option")
	public HomePageWhistle clickHelpMakeWhistleBetter() {
		driver.clickLocator(helpMakeWhistleBetterOptn);
		return this;
	}

	@Step("Get the url for help make shistle better")
	public String getHelpUrl() {
		String url = "";
		if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")) {
			((AppiumDriver) DriverManager.getDriver()).activateApp("com.apple.mobilesafari");
			log.info(((AppiumDriver) DriverManager.getDriver()).queryAppState("com.apple.mobilesafari"));
			WebElement urlTextFied = ((AppiumDriver) DriverManager.getDriver()).findElement(MobileBy.iOSNsPredicateString("label == \"Address\" AND name == \"URL\" AND value == \"\u200Ewhistle.typeform.com, secure and validated connection\" AND type == \"XCUIElementTypeOther\""));
			url = urlTextFied.getText();
			log.info("URL : " +url);
			((AppiumDriver) DriverManager.getDriver()).activateApp("com.whistle.winston-ent");
		} else {
			driver.pauseExecutionFor(5);
			url = driver.getText(helpUrl, "fetching web view url");
		}
		return url;
	}

	@Step("Click on close the help window")
	public HomePageWhistle clickCloseWebView() {
		driver.clickLocator(closeWebView);
		return this;
	}

	@Step("Select account info menu option")
	public HomePageWhistle clickAccountInfoOptn() {
		driver.isElemneVisibleOnScreen(accountInfoOptn);
		driver.clickLocator(accountInfoOptn);
		return this;
	}

	@Step("Click on logout button")
	public HomePageWhistle clickLogoutBtn() {
		driver.isElemneVisibleOnScreen(logOutOptn);
		driver.clickLocator(logOutOptn);
		driver.clickLocator(confirmLogOut);
		return this;
	}

	@Step("Click on Pet option from footer")
	public ViewPetProfilePage clickPetMenuOptn() {
		driver.pauseExecutionFor(2);
		driver.clickLocator(petStuffMenuOptnbs);
		return new ViewPetProfilePage(driver);
	}

	@Step("Select the family")
	public void selectFamily(String familyName) {
		By loc = By.xpath(String.format(family, familyName));
		driver.scrollToElement(loc, addHumans, TestDriver.ScrollDirection.DOWN, 0.25, 8);
		driver.clickLocator(loc);
	}

	@Step("Click on Remove link for selected family")
	public void clickRemoveLnk(String familyName) {
		By loc = By.xpath(String.format(removeLnk, familyName));
		driver.clickLocator(loc);
	}

	public boolean isAreYouSurepoUpPresent() {
		return driver.isElementPresent(areYouSurePopUp);
	}

	@Step("Click confirm on are you sure pop up")
	public String clickConfirmRemoveBtn() {
		String text = "";
		driver.clickLocator(confirmRemove);
		if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")) {
			driver.waitForElementToBeVisible(lblConfirmationMsg);
			text = driver.getText(lblConfirmationMsg, "Fetching confirmation message");
			driver.clickLocator(MobileBy.iOSNsPredicateString("label == \"OK\" AND name == \"OK\" AND value == \"OK\""));
		} else {
			text = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		}
		return text;
	}

	@Step("Click on back button to go to previous page")
	public HomePageWhistle clickBackButton() {
		driver.clickLocator(backButton);
		return this;
	}

	@Step("Is trip notification displayed")
	public boolean isTripNotificationPopUpPresent() {
		driver.pauseExecutionFor(3);
		boolean flag = false;
		flag = driver.isElementPresent(familyTripNotificationNextBtn);
		if (flag) {
			driver.clickLocator(familyTripNotificationNextBtn);
			driver.clickLocator(familyTripNotificationDoneBtn);
		}
		return flag;
	}

	public void dismissEnableBluetoothIfPresent() {
		if (driver.isElementPresent(dismissEnableBluetooth)) {
			driver.clickLocator(dismissEnableBluetooth);
		}
	}

	@Step("Verify if enable Bluetooth Banner is displayed")
	public boolean isEnableBLEBannerPresent() {
		return driver.isElementPresent(enableBluetoothBanner);
	}

	/**
	 * Modified by Murali Jaladurgam on 21 Feb, 2022
	 */

	@Step("Verify Location Icon is Present")
	public boolean isCheckLocationIconDisplayed() {
		return driver.isElementPresent(locationIconTabBar);
	}

	@Step("Verify Location Icon is enabled")
	public boolean isLocationIconEnabled() {
		return driver.isElementEnabled(locationIconTabBar);
	}

	@Step("Verify Location Icon is enabled")
	public boolean isFindMyPetBtnDisplayed() {
		return driver.isElementEnabled(findMyPetBtn);
	}

	@Step("Verify Activity Icon is Present")
	public boolean ischeckActivityIconDisplayed() {
		return driver.isElementPresent(activityIconTabBar);
	}

	@Step("Verify Health Icon is Present")
	public boolean ischeckHealthIconDisplayed() {
		return driver.isElementPresent(healthIconTabBar);
	}

	@Step("Verify Pet Icon is Present")
	public boolean ischeckPetIconDisplayed() {
		return driver.isElementPresent(petIconTabBar);
	}

	@Step("Verify Human Icon is Present")
	public boolean ischeckHumanIconDisplayed() {
		return driver.isElementPresent(humanIconTabBar);
	}

	public boolean isfamilyTripNotificationNextPresent() {
		driver.pauseExecutionFor(2);
		return driver.isElementPresent(familyTripNotificationNextBtn);
	}

	public boolean isfamilyTripNotificationDonePresent() {
		driver.pauseExecutionFor(2);
		return driver.isElementPresent(familyTripNotificationDoneBtn);
	}

	@Step("Click on permission required button")
	public HomePageWhistle clickfamilyTripNotificationNextBtn() {
		driver.waitForElementToBeVisible(familyTripNotificationNextBtn);
		driver.clickLocator(familyTripNotificationNextBtn);
		return this;
	}

	@Step("Click on permission required button")
	public HomePageWhistle clickfamilyTripNotificationDoneBtn() {
		driver.waitForElementToBeVisible(familyTripNotificationDoneBtn);
		driver.clickLocator(familyTripNotificationDoneBtn);
		return this;
	}

	public void handleNotificationBanner() {
		if (isfamilyTripNotificationNextPresent())
			clickfamilyTripNotificationNextBtn();
		if (isfamilyTripNotificationDonePresent())
			clickfamilyTripNotificationDoneBtn();
	}

	public void handleBluetoothBanner() {
		if (isEnableBLEBannerPresent())
			dismissEnableBluetoothIfPresent();
	}

	@Step("Click on Human Icon")
	public HumanStuffPage clickHumanIcon() {
		driver.clickLocator(humanIconTabBar);
		return new HumanStuffPage(driver);
	}

	@Step("Click on Location Icon")
	public LocationPage clickLocationIcon() {
		driver.clickLocator(locationIconTabBar);
		driver.pauseExecutionFor(2);
		return new LocationPage(driver);
	}

	@Step("Click on Activity Icon")
	public ActivityPage clickActivityIcon() {
		driver.clickLocator(activityIconTabBar);
		return new ActivityPage(driver);
	}

	@Step("Validating navigation tab order")
	public String validateTabOrder(){
		driver.pauseExecutionFor(2);
		String tabNames = driver.findElement(homeIconTabBar).getText()
				+ " "+driver.findElement(activityIconTabBar).getText()
				+ " "+driver.findElement(locationIconTabBar).getText()
				+ " "+driver.findElement(petIconTabBar).getText().substring(0,3)
				+ " "+driver.findElement(humanIconTabBar).getText().substring(0,5);
		log.info(tabNames);
		return tabNames;
	}

	@Step("Validating navigation tab order")
	public String validateTabOrderForAM2(){
		driver.pauseExecutionFor(2);
		String tabNames = driver.findElement(homeIconTabBar).getText()
				+ " "+driver.findElement(activityIconTabBar).getText()
				+ " "+driver.findElement(petIconTabBar).getText().substring(0,3)
				+ " "+driver.findElement(humanIconTabBar).getText().substring(0,5);
		log.info(tabNames);
		return tabNames;
	}

	@Step("Click on Home Icon")
	public HumanStuffPage clickHomeTab() {
		driver.clickLocator(homeIconTabBar);
		return new HumanStuffPage(driver);
	}

	@Step("Click on Wellness Score option")
	public void clickWellnessScore(){
		driver.clickLocator(wellnessScoreOption);
	}

	@Step("Verify Wellness score board is displayed")
	public boolean verifyWellnessScoreBoardIsDisplayed(){
		driver.isElementPresent(wellnessScoreBoard);
		return true;
	}

	@Step("W05 BS iOS Click on Enable Button")
	public void clickEnableButton() {
		driver.clickLocator(w05EnableNotificationbs);
		driver.clickLocator(setupLaterbs);
		driver.pauseExecutionFor(2);

	}

	@Step("Click on Human Icon")
	public AccountInformationPage clickOnHumanIcon() {
		driver.pauseExecutionFor(2);
		driver.clickLocator(humanIconTabBar);
		driver.pauseExecutionFor(2);
		return new AccountInformationPage(driver);
	}

	public boolean isW05EnableBLEBannerPresent() {
		return driver.isElementPresent(w05Notificationbs);
	}

	@Step("Click on Home Icon")
	public void clickHomeIcon() {
		driver.clickLocator(homeIconTabBar);
	}

	@Step("Verify short header on page")
	public boolean verifyShortHeader() {
		driver.pauseExecutionFor(2);
		return driver.isElementPresent(shortHeader);
	}

	@Step("Verify if Second Pet Image is present")
	public boolean isMultiPetDisplayed() {
		driver.pauseExecutionFor(2);
		return(driver.isElementPresent(petImage));
	}

	@Step("Verify short header is adjusted to top of the screen")
	public boolean verifyShortHeaderMultiPetAdjustHeader() {
		driver.pauseExecutionFor(2);
		return driver.isElementPresent(shortHeaderMultiPetAdjustHeader);
	}

	@Step("Click on Second Pet Image")
	public void clickSecondPetImage() {
		driver.pauseExecutionFor(2);
		driver.clickLocator(petImage);
	}

	@Step("Click on Pet Picker Dropdown")
	public void clickPetPickerDropdown() {
		driver.pauseExecutionFor(2);
		driver.clickLocator(petPickerDropdown);
	}

	@Step("Click on next Pet from Picker Dropdown")
	public void clickNextPetFromDropdown() {
		driver.pauseExecutionFor(2);
		driver.clickLocator(nextPet);
	}

	@Step("Get Pet value from short Header")
	public String getPetValueFromHeader() {
		driver.pauseExecutionFor(2);
		return driver.getText(petText,"Get Pet name from Short Header").trim();
	}

	@Step("Get Pet value from Long Header")
	public String getPetValueFromLongHeader() {
		driver.waitForElementToBeVisible(petTextLongHeader);
		return driver.getText(petTextLongHeader,"Get Pet name from Long Header").trim();
	}

	public LocationPage clickOnMapTab() {
		driver.clickLocator(mapTab);
		return new LocationPage(driver);
	}
	public boolean isMapDisplayed() {
		return driver.isElementPresent(mapTab);
	}

	/**
	 * @return true in Android when Google Map locator is displayed
	 * and in iOS when Google map card is displayed with height 100
	 */
	public boolean isGoogleMapDisplayed() {
		if (isAndroidBS()) {
			if (driver.isElementPresent(mapTab))
				return true;
			else
				return false;
		} else {
			if (driver.findElement(mapTab).getSize().getHeight() == 100	)
				return true;
			else
				return false;
		}
	}

	public boolean isCheckHealthDashboardDisplayed() {
		return driver.isElementPresent(healthDashboard);
	}
	public boolean isCheckScratchingTextDisplayed() {
		return driver.isElementPresent(scratchingTab);
	}

	public boolean isCheckLickingTextDisplayed() {
		return driver.isElementPresent(lickingTab);
	}

	public boolean isCheckSleepingTextDisplayed() {
		return driver.isElementPresent(sleepingTab);
	}

	public boolean isCheckEatingTextDisplayed() {
		return driver.isElementPresent(eatingTab);
	}

	public boolean isCheckDrinkingTextDisplayed() {
		return driver.isElementPresent(drinkingTab);
	}

	public boolean isCheckHomeIconDisplayed() {
		return driver.isElementPresent(homeIconTabBar);
	}
	@Step("Verify Activity Label is Present in Home screen")
	public boolean isActivityLabelDisplayed() {
		driver.pauseExecutionFor(3);
		return driver.isElementPresent(activityLabel);
	}

	@Step("Verify Calori Label is Present in Home screen")
	public boolean isCaloriLabelDisplayed() {
		return driver.isElementPresent(caloriLabel);
	}

	@Step("Verify km Label is Present in Home screen")
	public boolean isMinutsLabelDisplayed() {
		return driver.isElementPresent(kmLabel);
	}

	@Step("Verify hrs Label is Present in Home screen")
	public boolean isHoursLabelDisplayed() {
		return driver.isElementPresent(HoursLabel);
	}

	@Step("Verify Progress Bar is Present in Home screen")
	public boolean isProgressCircleDisplayed() {
		driver.pauseExecutionFor(4);
		return driver.isElementPresent(progressCircle);
	}

	@Step("Verify Today text is Present in Home screen")
	public boolean isTodayTextisplayed() {
		return driver.isElementPresent(todayText);
	}

	@Step("Click on today field")
	public HumanStuffPage clickTodayText() {
		driver.pauseExecutionFor(2);
		driver.clickLocator(todayText);
		return new HumanStuffPage(driver);
	}

	@Step("Verify Graph area is Present in Home screen")
	public boolean isGraphAreaDisplayed() {
		return driver.isElementPresent(graphArea);
	}

	@Step("Click on Activity Label field")
	public HumanStuffPage clickActivityLabel() {
		driver.pauseExecutionFor(2);
		driver.clickLocator(caloriLabel);
		driver.clickLocator(activityLabel);
		return new HumanStuffPage(driver);
	}

	@Step("Verify share icon is Present in Activity screen")
	public boolean isShareIconDisplayed() {
		driver.pauseExecutionFor(3);
		return driver.isElementPresent(shareIcon);
	}

	@Step("Verify calories icon is Present in Activity screen")
	public boolean isCaloriesIconDisplayed() {
		return driver.isElementPresent(caloriesData);
	}

	@Step("Verify distance icon is Present in Activity screen")
	public boolean isDistanceIconDisplayed() {
		return driver.isElementPresent(distanceData);
	}

	@Step("Verify rest icon is Present in Activity screen")
	public boolean isRestIconDisplayed() {
		return driver.isElementPresent(restData);
	}

	@Step("Verify wellness score is displayed in the Home screen")
	public boolean isWellnessScoreDisplayed() {
		return driver.isElementPresent(wellnessScoreImageCard);
	}

	public boolean isWellnessScoreTextDisplayed(){
		driver.waitForElementToBePresent(wellnessScoreOption);
		return driver.isElementPresent(wellnessScoreOption);
	}

	public boolean verifyWellnessSection(){
		isWellnessScoreTextDisplayed();
		isWellnessScoreDisplayed();
		return true;
	}

	public boolean verifyHealthSection(){
		isCheckScratchingTextDisplayed();
		isCheckLickingTextDisplayed();
		isCheckSleepingTextDisplayed();
		isCheckEatingTextDisplayed();
		isCheckDrinkingTextDisplayed();
		return true;
	}

	public boolean clickOnEatingTab() {
		driver.clickLocator(eatingTab);
		return true;
	}

	public boolean isNavigateAwayDisplayed() {
		return driver.isElementPresent(navigateAwayMsg);
	}

	public void clickSetUpLaterButton() {
		driver.clickLocator(setupLaterbs);
	}

	public boolean isActivityLeftHandtextDisplayed() {
		driver.pauseExecutionFor(1);
		return driver.isElementPresent(leftHandText);
	}
	public boolean isActivityRightHandtextDisplayed() {
		driver.pauseExecutionFor(1);
		return driver.isElementPresent(rightHandText);
	}
	public boolean isGraphDataDisplayed() {
		return driver.isElementPresent(graphData);
	}

	@Step("Verify wellness score title and back CTA is Present in Home screen after clicking on wellness score option")
	public boolean isWellnessScoreTitleAndBackCTADisplayed() {
		driver.isElementPresent(wellnessScoreTitle);
		driver.isElementPresent(wellnessScoreBackCTA);
		return true;
	}

	public boolean isFirstPetProfilePicOrAlphabetDisplayed() {
		return driver.isElementPresent(firstPetProfilePicAlphabet);
	}

	public boolean isFirstPetProfileSelected() {
		if (isAndroidBS()) {
			if (driver.findElement(firstPetProfilePicAlphabet).getSize().getHeight() > 150)
				return true;
			else
				return false;
		} else {
			if (driver.findElement(firstPetProfilePicAlphabet).getSize().getHeight() == 54)
				return true;
			else
				return false;
		}
	}

	@Step("Verify wellness score gathering data displayed in the Wellness screen")
	public boolean isWellnessScoreGatheringDataDisplayed() {
		return driver.isElementPresent(wellnessScoreGatheringData);
	}

	@Step("Verify wellness score description is Present in Home screen after clicking on wellness score option")
	public boolean isWellnessScoreDescriptionDisplayed() {
		return driver.isElementPresent(wellnessScoreDescription);
	}

	@Step("Verify wellness score Measurement bar is Present in Home screen after clicking on wellness score option")
	public boolean iswellnessScoreMeasurementBarDisplayed() {
		return driver.isElementPresent(wellnessScoreMeasurementBar);
	}

	@Step("Verify wellness score Week and Month graph is Present in Home screen after clicking on wellness score option")
	public boolean iswellnessScoreWeekMonthGraphDisplayed() {
		if (isAndroidBS()) {
			driver.clickLocator(wellnessScoreWeekOrMonth);
			driver.isElementPresent(wellnessScoreWeekOrMonth);
			driver.clickLocator(wellnessScoreMonth);
			driver.isElementPresent(wellnessScoreMonth);
		}else {
			driver.clickLocator(wellnessScoreWeekOrMonth);
			driver.isElementPresent(wellnessScoreWeekOrMonth);
			driver.clickLocator(wellnessScoreWeekOrMonth);
			driver.isElementPresent(wellnessScoreWeekOrMonth);
		}
		return true;
	}

	@Step("Verify wellness statuses is present in Home screen after clicking on wellness score option")
	public boolean iswellnessStatusesDisplayed() {
		driver.isElementPresent(wellnessStatuses);
		driver.isElementPresent(wellnessStatusesExcellent);
		driver.isElementPresent(wellnessStatusesOkay);
		driver.isElementPresent(wellnessStatusesLow);
		return true;
	}

	@Step("Verify learn more option is present in Home screen after clicking on wellness score option")
	public boolean isLearnMoreOptionDisplayed() {
		return driver.isElementPresent(learnMore);
	}

	@Step("Verify chat with Vet option is present in Home screen after clicking on wellness score option")
	public boolean isChatWithVetOptionDisplayed() {
		return driver.isElementPresent(chatWithVet);
	}

	public boolean isSecondPetProfileSelected() {
		if(isAndroidBS()) {
			if (driver.findElement(secondPetProfilePicAlphabet).getSize().getHeight() > 150)
				return true;
			else
				return false;
		}
		else
		{
			if (driver.findElement(secondPetProfilePicAlphabet).getSize().getHeight()==54)//android 164
				return true;
			else
				return false;
		}
	}

	public boolean isSecondPetProfilePicOrAlphabetDisplayed() {
		return driver.isElementPresent(secondPetProfilePicAlphabet);
	}

	public String getCurrentUser() {
		return driver.findElement(UserName).getText();
	}

	public boolean isTinyHomeIconDisplayed(){
		return driver.isElementPresent(tinyHomeIcon);
	}

	public void clickPetPickerDropdownone() {
		driver.pauseExecutionFor(2);
		driver.clickLocator(petPickerDropdownone);
	}

	public void clickOnLicking(){
		driver.clickLocator(lickingTab);
	}

	public boolean isDrinkingTitleDisplayed(){
		driver.pauseExecutionFor(1);
		return driver.isElementPresent(drinkingTab);
	}

	public void clickOnDrinkingTab(){
		driver.pauseExecutionFor(1);
		driver.clickLocator(drinkingTab);
	}

	@Step("Clicking on Scratching detail in home screen")
	public void clickScratchingDetailInHomeScreen() {
		driver.clickLocator(scratchingTab);
	}

	public void clickOnSleeping(){
		driver.clickLocator(sleepingTab);
	}

	@Step("Click Activity Widget on Home dashboard")
	public ActivityPage clickActivityWidget() {
		driver.pauseExecutionFor(2);
		driver.clickLocator(activityLabel);
		return new ActivityPage(driver);
	}

	/**
	 * @return string value for Active minutes and Activity goal divisor in Android and iOS
	 * from Activity Widget in Home screen
	 */
	@Step("Get Active minutes from Home dashboard\"")
	public String getActiveMinutesFromHome() {
		String activeMins = "";
		driver.pauseExecutionFor(3);
		if(isAndroidBS()){
			activeMins = driver.findElement(activityFirst).getText().trim()+driver.findElement(activitySecond).getText().trim()
					+driver.findElement(activityThird).getText().trim()+" "+driver.findElement(activityFourth).getText().trim();
		}else
		{
			activeMins = driver.getText(activeMinutesHome,"Get Active minutes from Home dashboard").trim();
		}
		return activeMins;
	}
	public void clickOnHealthOptions(String options){
		if(!isAndroidBS()){
			driver.pauseExecutionFor(5);
			driver.findElement(MobileBy.id(""+options+"")).click();

		}else{
			driver.pauseExecutionFor(5);
			driver.findElement(MobileBy.xpath("//*[@text='"+options+"']")).click();
		}

	}
}

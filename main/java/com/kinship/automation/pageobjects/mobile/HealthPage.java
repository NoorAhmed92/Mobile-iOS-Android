package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import static com.kinship.automation.utils.commonutils.TestDriver.ScrollDirection.UP;

/**
 * Created by hpatel on 29 Mar, 2022
 */
public class HealthPage extends WhistleBasePage {

    TestDriver driver;

    private By wellnessTitleTxt = ByT.locator(By.id(""), By.id("wellness_index_title"));
    private By healthTrendText = ByT.locator(By.id(""), By.id("health_trend_card_title"));
    private By healthTrendTexts = ByT.locator(By.xpath("//XCUIElementTypeStaticText[@name='Gathering Data'] | //XCUIElementTypeStaticText[@name='Wellness Score']"),
                                                By.xpath("//android.widget.ImageView[@content-desc='Null state image']/following-sibling::android.widget.TextView"));
    private By wellnessScoreLabel = ByT.locator(By.id("Gathering Data"), By.id("gathering_data_label"));
    private By chatWithVet = ByT.locator(By.id("Chat with a Vet"), By.id("health_tab_list_item_chat_with_vet"));
//    private By shareReport = ByT.locator(By.id("Share Health Report"), By.id("health_tab_list_item_share_health_report"));
    private By research = ByT.locator(By.id("Contribute to research"), By.id("health_tab_list_item_join_insights_lab"));
    private By drinkingStatusTitle= ByT.locator(By.id("Drinking Statuses"),By.xpath("//android.widget.TextView[@text='Drinking Statuses']"));
    private By drinkingBelowAvgStatus =ByT.locator(By.xpath("(//XCUIElementTypeStaticText[@name='Below Average'])[2]"),By.xpath("//android.widget.TextView[@text='Below Average']"));
    private By drinkingAvgStatus =ByT.locator(By.xpath("(//XCUIElementTypeStaticText[@name='Average'])[2]"),By.xpath("//android.widget.TextView[@text='Average']"));
    private By drinkingAboveAvgStatus = ByT.locator(By.xpath("(//XCUIElementTypeStaticText[@name='Above Average'])[2]"),By.id("//android.widget.TextView[@text='Above Average']"));
    private By learnAboutLink= ByT.locator(By.id("Learn about drinking"),By.xpath("//android.widget.TextView[@text='Learn about Drinking']"));
    private By chatWithAVetLink= ByT.locator(By.id("Chat with a Vet"),By.xpath("//android.widget.TextView[@text='Chat with a Vet']"));
    private By scratchingStatusesTitle = ByT.locator(By.id("Scratching Statuses"), By.id("health_graph_threshold_legend_header"));
    private By scratchingStatusInfrequent = ByT.locator(By.id("Infrequent"), By.xpath("(//android.widget.TextView[@id='health_trend_status_text'])[1]"));
    private By scratchingStatusOccational = ByT.locator(By.id("Occational"), By.xpath("(//android.widget.TextView[@id='health_trend_status_text'])[2]"));
    private By scratchingStatusElevated = ByT.locator(By.id("Elevated"), By.xpath("(//android.widget.TextView[@id='health_trend_status_text'])[3]"));
    private By scratchingStatusSevere = ByT.locator(By.id("Severe"), By.xpath("(//android.widget.TextView[@id='health_trend_status_text'])[4]"));
    private By learnAboutScratching = ByT.locator(By.id("Learn about scratching"), By.xpath("//*[@text='Learn about Scratching']"));
    private By topCardTrendStatus = ByT.locator(By.xpath("(//XCUIElementTypeOther//XCUIElementTypeStaticText)[2]"), By.id("health_trend_status_text"));
    private By topCardDateRange = ByT.locator(By.xpath("(//XCUIElementTypeOther//XCUIElementTypeStaticText)[3]"), By.id("health_graph_date_range"));
    private By graphSection= ByT.locator(By.id("health graph - week/month toggle"),By.id("health_graph_timeframe_sliding_tabs"));
    private By weekToggle= ByT.locator(By.xpath("//android.widget.TextView[@text='Week']"));
    private By monthToggle= ByT.locator(By.xpath("//android.widget.TextView[@text='Month']"));
    private By backToHomeScreen = ByT.locator(By.id("ChubbyBackArrow"),By.xpath("//*[@content-desc='Navigate up']"));

    public HealthPage(TestDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyOnHealthPage() {
        List<WebElement> searchElement;
        searchElement = driver.findElements(healthTrendTexts);
        log.info("Verifying Wellness Heading Title Text");
        for (int i = 0; i < searchElement.size(); i++) {
            log.info("Found This Text for Wellness = " + searchElement.get(i).getText());
            Assert.assertNotNull(searchElement.get(i).getText());
        }
    }

    public void verifyChatWithVet() {
        Assert.assertTrue(driver.isDisplayedWait(chatWithVet, 3), "Missing Chat with Bet option");
    }

    public void clickChatWithVet() {
        driver.clickLocator(chatWithVet, 3);
    }

    public void verifyResearch() {
        Assert.assertTrue(driver.isDisplayedWait(research, 3), "Missing Research option");
    }

    public void clickResearch() {
        driver.clickLocator(research, 3);
    }

    public void verifyLearnAndChat(String sHealthType) {
        if(!isAndroidBS()) {
            driver.findElement(MobileBy.xpath("//XCUIElementTypeStaticText[contains(@name,'" + sHealthType + "')]")).click();
            driver.pauseExecutionFor(2);
            driver.swipe(UP);
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Learn about')]")).click();

            log.info("Verifying URL and Close the Window");
            VerifyNCloseBrowserWindow();

            driver.swipe(UP);
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Chat with a Vet']")).click();

            log.info("Verifying URL and Close the Window");
            VerifyNCloseBrowserWindow();

            navigateBackPage();
        }else{
            driver.findElement(MobileBy.xpath("//android.view.View[contains(@text,'" + sHealthType + "')]")).click();
            driver.pauseExecutionFor(2);
            driver.swipe(UP);
            driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Learn about')]")).click();

            log.info("Verifying URL and Close the Window");
            VerifyNCloseBrowserWindow();

            driver.swipe(UP);
            driver.findElement(By.xpath("//android.widget.TextView[@text='Chat with a Vet']")).click();

            log.info("Verifying URL and Close the Window");
            VerifyNCloseBrowserWindow();

            navigateBackPage();
        }
    }

    public boolean isDrinkingStatusTitleDisplayed(){
        return driver.isElementPresent(drinkingStatusTitle);
    }

    public boolean isDrinkingStatusDisplayed(){
        driver.isElementPresent(drinkingBelowAvgStatus);
        driver.isElementPresent(drinkingAvgStatus);
        driver.isElementPresent(drinkingAboveAvgStatus);
        return true;
    }
    
    public boolean isLearnAboutLinkDisplayed(){
        return driver.isElementPresent(learnAboutLink);
    }

    public boolean isChatWithAVetLinkDisplayed(){
        return driver.isElementPresent(chatWithAVetLink);
    }

    public boolean isScratchingStatusesTitleDisplayed() {
        driver.pauseExecutionFor(2);
        return driver.isElementPresent(scratchingStatusesTitle);
    }

    @Step("Verify Scratching statuses is present in Scratching screen")
    public boolean isScratchingStatusesDisplayed() {
        driver.isElementPresent(scratchingStatusInfrequent);
        driver.isElementPresent(scratchingStatusOccational);
        driver.isElementPresent(scratchingStatusElevated);
        driver.isElementPresent(scratchingStatusSevere);
        return true;
    }

    @Step("Verify Learn about scratching option is present in Scratching detail screen")
    public boolean isLearnAboutScratchingDisplayed() {
        return driver.isElementPresent(learnAboutScratching);
    }
    @Step("Verify Top card Health Trend Status and Date Range")
    public boolean isTopCardDisplayed() {
        driver.pauseExecutionFor(2);
        driver.isElementPresent(topCardTrendStatus);
        driver.isElementPresent(topCardDateRange);
        return true;
    }

    @Step("Verify if Graph section is displayed")
    public boolean isGraphSectionDisplayed() {
        driver.isElementPresent(graphSection);
        return true;
    }

    @Step("Verify if Week's toggle in Graph section is displayed")
    public boolean isWeekToggleDisplayed() {
        driver.isElementPresent(weekToggle);
        return true;
    }

    @Step("Verify if Week's toggle is default selection")
    public boolean isWeekToggleDefaultSelected() {
        driver.isElementSelected(weekToggle);
        return true;
    }

    @Step("Verify if Month's toggle in Graph section is displayed")
    public boolean isMonthToggleDisplayed() {
        driver.isElementPresent(monthToggle);
        return true;
    }
    public void backToHomeScreen(){
        driver.clickLocator(backToHomeScreen);
    }
}
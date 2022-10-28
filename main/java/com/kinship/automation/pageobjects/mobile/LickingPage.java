package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LickingPage extends WhistleBasePage {
    TestDriver driver;

    private By topCard = ByT.locator(By.xpath("(//XCUIElementTypeScrollView//XCUIElementTypeOther)[4]"), By.id("health_graph_status_legend"));
    private By graphSection= ByT.locator(By.id("Bar Chart. 1 dataset. "),By.id("health_graph_bar_graph"));
    private By weekToggle= ByT.locator(By.id("health graph - week/month toggle"),By.xpath("//*[@text='Week']"));
    private By monthToggle= ByT.locator(By.id(""),By.xpath("//*[@text='Month']"));
    private By lickingStatusTitle= ByT.locator(By.id("Licking Statuses"),By.id("health_graph_threshold_legend_header"));
    private By infrequentTitle= ByT.locator(By.id("Infrequent"),By.xpath("//*[@text='Infrequent']"));
    private By occasionalTitle= ByT.locator(By.id("Occasional"),By.xpath("//*[@text='Occasional']"));
    private By elevatedTitle= ByT.locator(By.id("Elevated"),By.xpath("//*[@text='Elevated']"));
    private By severeTitle= ByT.locator(By.id("Severe"),By.xpath("//*[@text='Severe']"));
    private By learnAboutLink= ByT.locator(By.id("Learn about licking"),By.xpath("//*[@text='Learn about Licking']"));
    private By chatWithAVetLink= ByT.locator(By.id("Chat with a Vet"),By.xpath("//*[@text='Chat with a Vet']"));
    private By graphView= ByT.locator(By.xpath("//XCUIElementTypeOther[@name='Bar Chart. 1 dataset. ']//following-sibling::XCUIElementTypeOther"),By.xpath(""));
    private By dateView= ByT.locator(By.xpath("(//XCUIElementTypeOther//XCUIElementTypeStaticText)[3]"),By.id("health_graph_date_range"));

    public LickingPage(TestDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public boolean isTopCardDisplayed(){
        driver.waitForElementToBeVisible(topCard);
        return driver.isElementPresent(topCard);
    }
    public boolean isGraphSectionDisplayed(){
        driver.waitForElementToBeVisible(graphSection);
        return driver.isElementPresent(graphSection);
    }
    public boolean isWeekToggleDisplayed(){
        return driver.isElementPresent(weekToggle);
    }
    public boolean isMonthToggleDisplayed(){
        return driver.isElementPresent(monthToggle);
    }
    public boolean isLickingStatusTitleDisplayed(){
        return driver.isElementPresent(lickingStatusTitle);
    }
    public boolean isInfrequentTitleDisplayed(){
        return driver.isElementPresent(infrequentTitle);
    }
    public boolean isOccasionalTitleDisplayed(){
        return driver.isElementPresent(occasionalTitle);
    }
    public boolean isElevatedTitleDisplayed(){
        return driver.isElementPresent(elevatedTitle);
    }
    public boolean isSevereTitleDisplayed(){
        return driver.isElementPresent(severeTitle);
    }
    public boolean isLearnAboutLinkDisplayed(){
        return driver.isElementPresent(learnAboutLink);
    }
    public boolean isChatWithAVetLinkDisplayed(){
        return driver.isElementPresent(chatWithAVetLink);
    }
    public void clickOnMonthToggle(){
        driver.clickLocator(weekToggle);
    }
    /**
     * This is the method which makes use of Graph view change verification.
     *    @return true.
     */
    public boolean verifyGraphViewForMonth(){
        driver.pauseExecutionFor(10);
        List<WebElement> graphViewList = driver.findElements(graphView);
        if(graphViewList.size()==30){
            log.info("Graph view for month is presented");
        }else{
            log.info("Graph view for month is not presented");
        }
        return true;
    }
    public boolean isDateViewDisplayed(){
        driver.pauseExecutionFor(5);
        return driver.isElementPresent(dateView);
    }
    public void clickOnMonth(){
        driver.clickLocator(monthToggle);
    }
    public void clickOnWeek(){
        driver.clickLocator(weekToggle);
    }
    /**
     * This is the method which makes use of Graph change from Month to Week view verification.
     *    @return true.
     */
    public boolean verifyGraphViewForWeek(){
        driver.pauseExecutionFor(10);
        List<WebElement> graphViewList = driver.findElements(graphView);
        if(graphViewList.size()==7){
            log.info("Graph view for Week is presented");
        }else{
            log.info("Graph view for Week is not presented");
        }
        return true;
    }
}

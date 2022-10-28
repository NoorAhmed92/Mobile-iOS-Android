package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import org.openqa.selenium.By;

public class SleepingPage extends WhistleBasePage {
    TestDriver driver;

    private By sleepingHeader= ByT.locator(By.id("Sleeping"),By.xpath("//*[@text='Sleeping']"));
    private By topCard = ByT.locator(By.xpath("(//XCUIElementTypeTable//XCUIElementTypeOther)[4]"), By.id("health_graph_status_legend"));
    private By graphSection= ByT.locator(By.xpath("(//XCUIElementTypeOther//XCUIElementTypeCell)[1]"),By.id("sleeping_graph_rows_recycler"));

    public SleepingPage(TestDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isSleepingHeaderDisplayed(){
        driver.waitForElementToBeVisible(sleepingHeader);
        return driver.isElementPresent(sleepingHeader);
    }

    public boolean isTopCardDisplayedOnSleepingPage(){
        return driver.isElementPresent(topCard);
    }

    public boolean isGraphSectionDisplayedOnSleepingPage(){
        return driver.isElementPresent(graphSection);
    }
}

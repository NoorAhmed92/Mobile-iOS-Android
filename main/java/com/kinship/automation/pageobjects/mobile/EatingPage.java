package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import org.openqa.selenium.By;

public class EatingPage  extends WhistleBasePage {

    TestDriver driver;

    private By eatingHeader = ByT.locator(By.id("Eating"), By.xpath("//*[@text='Eating']"));

    public EatingPage(TestDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isEatingHeaderDisplayed(){
        driver.pauseExecutionFor(2);
        return driver.isElementPresent(eatingHeader);
    }
}

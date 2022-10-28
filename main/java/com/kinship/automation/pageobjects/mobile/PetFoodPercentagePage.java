package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PetFoodPercentagePage extends WhistleBasePage {

    TestDriver driver;

    private By navigateUpBackButton= ByT.locator(By.id("ChubbyBackArrow"), By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    private By assetIcon= ByT.locator(By.id("FoodScale"), By.id("pet_food_portions_scale"));
    private By assetHeader= ByT.locator(By.id("What percent of each?"), By.id("pet_food_portions_header"));
    private By subCopy = ByT.locator(By.id("Move the slider to select the percentages of each food fed."), By.id("pet_food_portions_instructions"));
    private By percentageSlidersFoodDisplayed = ByT.locator(By.id("nutrition - percentage slider"), By.id("snapping_seek_bar"));
    private By doneCTAEnabled= ByT.locator(By.id("nutrition - food percentage continue button"), By.id("pet_food_portions_done_btn"));

    public PetFoodPercentagePage(TestDriver driver) {
        this.driver=driver;
    }

    public boolean isBackCTAisDisplayed() {
       return driver.isElementPresent(navigateUpBackButton);
    }

    public boolean isAssetDisplayed() {
        return driver.isElementPresent(assetIcon);
    }

    public boolean isHeaderDisplayed() {
        return driver.isElementPresent(assetHeader);
    }

    public boolean isSubCopyDisplayed() {
        return driver.isElementPresent(subCopy);
    }

    public boolean isDoneCTADisEnabled() {
        return driver.isElementEnabled(doneCTAEnabled);
    }

    public boolean isFoodPercentageSlidersDisplayed() {
        boolean flag=false;
        List<WebElement> elements= driver.findElements(percentageSlidersFoodDisplayed);
        for(WebElement e:elements)
        {
            if(e.isDisplayed() &&(e.getText().equals("50%") || e.getText().equals("50.0")) )
                flag = true;
            else
                return flag;
        }
        return flag;
    }
}

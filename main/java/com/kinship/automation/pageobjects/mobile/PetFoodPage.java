package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PetFoodPage extends WhistleBasePage {

    TestDriver driver;
    protected final Logger log = LogManager.getLogger(WhistleBasePage.class);
    private By navigateUpBackButton= ByT.locator(By.id("ChubbyBackArrow"), By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    private By dogFoodText= ByT.locator(By.xpath("//*[@text='Dog Food']"), By.xpath("//android.widget.TextView[@text=\"Dog Food\"]"));
    private By cantFindFood= ByT.locator(By.id("nutrition - food not found button"), By.id("menu_item_pet_food_not_found"));
    private By petFoodHeader= ByT.locator(By.id("What food does he eat?"), By.id("pet_food_header"));
    private By petFoodField= ByT.locator(By.xpath("//XCUIElementTypeTextField"), By.id("pet_food_field"));
    private By petFoodTextField = ByT.locator(By.xpath("//*[@placeholder='Search dog foods'] |  //XCUIElementTypeTextField"), By.id("textinput_placeholder"));
    private By petFoodListField= ByT.locator(By.xpath("//XCUIElementTypeTable[@class='UIATable'] | //XCUIElementTypeTable"), By.id("pet_food_list"));
    private By petFoodGroup= ByT.locator(By.id(""),By.xpath("//*[@class='android.view.ViewGroup' and ./*[@id='pet_food_selected_chip_group']]"));
    private By foodRemoveBtn= ByT.locator(By.id("nutrition - selected dog food delete button"),By.xpath("//android.view.View[contains(@content-desc,'Remove')]"));
    private By petFoodCTAContinue= ByT.locator(By.id("nutrition - pet food continue button"),By.id("pet_food_continue_button"));
    private By petCustomFoodCTAContinue= ByT.locator(By.id("nutrition - pet food suggestion continue button"),By.id("pet_food_not_found_continue_button"));
    private By addOneMoreText = ByT.locator(By.xpath("//*[@value='Add 1 more (optional)']"),By.xpath("//android.widget.EditText[@text='Add 1 more (optional)']"));
    private By selectedFoodToolBar = ByT.locator(By.id("Acana Duck & Pear Formula"),By.xpath("//*[@text='Acana Duck & Pear Formula']"));
    private By doneButton =ByT.locator(By.id("nutrition - food percentage continue button"),By.id("pet_food_portions_done_btn"));
    private By selectedFood = ByT.locator(By.xpath("//*[@text and (./preceding-sibling::* | ./following-sibling::*)[@text='ChubbyClose']]"),By.xpath("//*[@text and @class='android.view.View']"));
    private By selectSecondItem= ByT.locator(By.id("Acana Beef & Pumpkin Formula"),By.xpath("//*[@text='Acana Free-Run Poultry']"));

    public PetFoodPage(TestDriver driver) {
        this.driver=driver;
    }

    public PetEditProfilePage navigateBackPagetoPetPage()
    {
        driver.clickLocator(navigateUpBackButton);
        return  new PetEditProfilePage(driver);
    }

    public boolean isDogFoodDisplayed() {
        if(isAndroidBS())
        return driver.isElementPresent(dogFoodText);
        else
            return true;
    }

    public boolean isCantFindFoodDisplayed() {
        return driver.isElemneVisibleOnScreen(cantFindFood);
    }

    public boolean isPetFoodHeaderDisplayed() {
        return driver.isElementPresent(petFoodHeader);
    }

    public boolean isPetFoodFieldDisplayed() {
        driver.pauseExecutionFor(2);
        return driver.isElementPresent(petFoodField);
    }

    public boolean isPetFoodTextInputFieldDisplayed() {
        return driver.isElementPresent(petFoodTextField);
    }

    public boolean isPetFoodListFieldDisplayed() {
        return driver.isElementPresent(petFoodListField);
    }

    public void clearFood() {
        if(isAndroidBS()) {
            driver.pauseExecutionFor(2);
            do {
                driver.clickLocator(foodRemoveBtn);
            } while (driver.isElementPresent(petFoodGroup));
        }
    }

    public boolean isPetFoodContinueCTADisabled() {
        return driver.isElementEnabled(petFoodCTAContinue);
    }

    public String getPetFoodContinueCTAClickableAttribute() {
        return driver.getAttribute(petFoodCTAContinue,"clickable", "Get Attribute value for clickable");
    }

    public String getPetCustomFoodContinueCTAClickableAttribute() {
        return driver.getAttribute(petCustomFoodCTAContinue,"clickable", "Get Attribute value for clickable");
    }

    public boolean isPetCustomFoodContinueCTAEnabled() {
        return driver.isElementEnabled(petCustomFoodCTAContinue);
    }

    public PetFoodCantFindPage clickPetFoodCantFind() {
        clearFood();
        driver.clickLocator(cantFindFood);
        return new PetFoodCantFindPage(driver);
    }

    public boolean isNavigateUpBackButtonDisplay() {
        driver.pauseExecutionFor(3);
        return driver.isElementPresent(navigateUpBackButton);
    }

    public boolean isAddOneMoreTextDisplay() {
        return driver.isElementPresent(addOneMoreText);
    }

    public void enterFoodName(String typeFood){
        driver.pauseExecutionFor(2);
        driver.type(petFoodField,typeFood);
    }

    public boolean isFoodAlreadySelected(){
        return driver.isElementPresent(foodRemoveBtn);
    }

    public boolean isCantFindFoodEnable(){
        clearFood();
        return driver.isElementEnabled(cantFindFood);
    }

    public boolean isAddOneMoreTextDisplayed(){
       driver.clickLocator(selectedFoodToolBar);
       driver.pauseExecutionFor(3);
        return driver.isElementPresent(addOneMoreText);
    }

    public boolean isSelectedFoodPopulated(){
        return driver.isElementPresent(selectedFoodToolBar);
    }

    public boolean isContinueButtonDisplayed(){
        return driver.isElementPresent(petFoodCTAContinue);
    }

    public void clickOnSelectedFood(){
        driver.clickLocator(selectedFoodToolBar);
    }

    public PetFoodPercentagePage clickOnContinueButton(){
        driver.clickLocator(petFoodCTAContinue);
        return new PetFoodPercentagePage(driver);
    }

    public PetEditProfilePage clickOnContinueCTA(){
        driver.clickLocator(petFoodCTAContinue);
        return new PetEditProfilePage(driver);
    }

    public void clickOnDoneButton(){
        driver.clickLocator(doneButton);
    }

    public void clickOnMultipleFoodItems(){
        driver.clickLocator(selectedFoodToolBar);
        driver.clickLocator(selectSecondItem);
    }

    public void foodOption(){
        List<WebElement> foodOptions = driver.findElements(selectedFood);
        for(int i=1;i<=foodOptions.size();i++){
        }
        log.info(foodOptions.size());
        log.info("Validating food list : "+ driver.isElementPresent(selectedFood));
    }
}

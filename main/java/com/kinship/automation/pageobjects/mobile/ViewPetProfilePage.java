package com.kinship.automation.pageobjects.mobile;

import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ViewPetProfilePage extends WhistleBasePage {
	TestDriver driver;
	private By petEditIconBtn = ByT.locator(By.id("edit"), By.id("pet_tab_edit_icon"));
	private By petEditProfileLabel= ByT.locator(By.id("Edit Profile"), By.xpath("//android.widget.TextView[@text='Edit Profile']"));
	private By petPhotoLabel= ByT.locator(MobileBy.AccessibilityId("pet edit - photo clicked"), By.id("pet_profile_pet_name"));
	private By petEditPhotoBtn= ByT.locator(MobileBy.AccessibilityId("pet edit - photo clicked"), By.id("pet_profile_photo"));
	private By petBreedText= ByT.locator(MobileBy.AccessibilityId("edit pet profile - breed"), By.xpath("//android.widget.TextView[@text='Breed']"));
	private By petSexText= ByT.locator(MobileBy.AccessibilityId("edit pet profile - gender"),By.xpath("//android.widget.TextView[@text='Sex']"));
	private By PetNeuteredSpayedText= ByT.locator(MobileBy.AccessibilityId("edit pet profile - spay/neuter"),By.xpath("//android.widget.TextView[@text='Neutered Status']"));
	private By petAgeText= ByT.locator(MobileBy.AccessibilityId("edit pet profile - age"),By.xpath("//android.widget.TextView[@text='Age']"));
	private By petWeightText= ByT.locator(MobileBy.AccessibilityId("edit pet profile - weight"),By.xpath("//android.widget.TextView[@text='Weight']"));
	private By petTimeZoneText= ByT.locator(MobileBy.AccessibilityId("edit pet profile - timezone"),By.xpath("//android.widget.TextView[@text='Timezone']"));
	private By petFoodText= ByT.locator(MobileBy.AccessibilityId("edit pet profile - pet food"),By.xpath("//android.widget.TextView[@text='Pet Food']"));
	private By petProfileBreedItem=ByT.locator(By.xpath("//XCUIElementTypeStaticText[contains(@text,'Breed')]"),By.id("pet_tab_breed"));
	private By petBreedName = ByT.locator(MobileBy.AccessibilityId("edit pet profile - breed"), By.xpath("//android.widget.TextView[@text='Breed']"));
	private By petBreedEditBar = ByT.locator(By.xpath("//*[@class='UIATextField' and ./parent::*[@accessibilityLabel='edit pet profile - breed']]"), By.id("edit_breed_search_bar"));
	private By petBreedNameList=ByT.locator(By.xpath(""), By.id("breeds_list_item_text"));
	private By petPageBackBtn=ByT.locator(By.id("ChubbyBackArrow"),MobileBy.AccessibilityId("Navigate up"));
	private By petNameLabel = ByT.locator(By.xpath("//XCUIElementTypeNavigationBar[@name='Edit Profile']//following::XCUIElementTypeTextField[1]"), By.id("pet_profile_pet_name"));
	private By petNameEditInput = ByT.locator(By.xpath("//*[@placeholder='Name']"), By.id("android:id/input"));
	private By petNameSaveBtn = ByT.locator(By.id("Human - tab - 5 of 5"), By.id("md_buttonDefaultPositive"));
	private By petNameTag= ByT.locator(By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]"),By.id("pet_tab_name"));
	private By petAgeLabel=ByT.locator(By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]"),By.id("pet_tab_age_years_label"));
	private By petAgeValue=ByT.locator(By.xpath(""),By.id("pet_tab_age_value"));
	private By petWeightLabel=ByT.locator(By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[3]"),By.id("pet_tab_weight_label"));
	private By petWeightValue=ByT.locator(By.xpath(""),By.id("pet_tab_weight_value"));
	private By petBreedLabel=ByT.locator(By.xpath("//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[4]"),By.id("pet_tab_breed_label"));
	private By petBreedValue=ByT.locator(By.xpath(""),By.id("pet_tab_breed"));
	private By petPencilIcon=ByT.locator(By.id("edit"),By.id("pet_tab_edit_icon"));
	private By petDeviceTab=ByT.locator(By.id("pet - pet and device tab"),By.xpath("//*[@text='Pet & Device']"));
	private By achievementsStatsTab=ByT.locator(By.id("pet - achievements and stats tab"),By.xpath("//*[@text='Achievements & Stats']"));

	public ViewPetProfilePage(TestDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickEditIcon() {
		driver.clickLocator(petEditIconBtn);
	}

	public void editPetNameValue(String name) {
		driver.clickLocator(petNameLabel);
		driver.type(petNameEditInput, name);

		if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("andriod"))
		{
			driver.clickLocator(petNameSaveBtn);
		}
	}

	public boolean isCheckPetNameDisplayed() {
		if(isAndroidBS()) {
			return driver.isElementPresent(petNameLabel);
		}
		else
		return driver.findElement(By.xpath("//XCUIElementTypeNavigationBar[@name='Edit Profile']//following::XCUIElementTypeTextField[1]")).isDisplayed();
	}

	public boolean isEditIconPresent() {
		driver.pauseExecutionFor(2);
		return driver.isElementPresent(petEditIconBtn);
	}

	public boolean isCheckPetEditProfileLabelDisplayed() {
		return driver.isElementPresent(petEditProfileLabel);
	}

	public boolean isCheckPetEditPhotoDisplayed() {
		return driver.isElementPresent(petEditPhotoBtn);
	}

	public boolean isCheckPetBreedDisplayed() {
		return driver.isElementPresent(petBreedText);
	}

	public boolean isCheckPetGenderDisplayed() {
		return driver.isElementPresent(petSexText);
	}

	public boolean isCheckPetNeuteredSpayedStatusDisplayed() {
		return driver.isElementPresent(PetNeuteredSpayedText);
	}

	public boolean isCheckAgeDisplayed() {
		return driver.isElementPresent(petAgeText);
	}

	public boolean isCheckWeightDisplayed() {
		return driver.isElementPresent(petWeightText);
	}

	public boolean isCheckTimeZoneDisplayed() {
		driver.pauseExecutionFor(3);
		return driver.isElementPresent(petTimeZoneText);
	}

	public boolean isCheckPetFoodDisplayed() {
		return driver.isElementPresent(petFoodText);
	}

	public String getProfilePageBreedValue() {
		String value;
		if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios"))
			value=driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@id,'Breed')]")).getText();
		else
	 		value=driver.findElement(petProfileBreedItem).getText();
		return value;
	}

	public boolean isCheckBreedFieldDisplayed() {
		return driver.isElementPresent(petBreedName);
	}

	public void editBreedField(String name, int index) {
		if (FrameworkConfigFactory.getConfig().platform().toString().equalsIgnoreCase("ios")) {
			//insert pick  wheeler code
			driver.clickLocator(petBreedName);
			driver.type(petBreedEditBar, name);
			driver.findElementsById(petBreedNameList, index).click();
		}
		else {
			driver.clickLocator(petBreedName);
			driver.type(petBreedEditBar, name);
			driver.findElementsById(petBreedNameList, index).click();
		}
	}

	public void clickBackBtnToPetProfilePage() {
		driver.clickLocator(petPageBackBtn);
	}

	public boolean selectPetBreedEdit() {
		return driver.isElementPresent(petBreedName);
	}

	@Step("Click on Edit icon of Pet")
	public PetEditProfilePage selectEditIcon() {

		driver.clickLocator(petEditIconBtn);
		return new PetEditProfilePage(driver);
	}

	public boolean isCheckPetNameTabDisplayed() {
		return driver.isElementPresent(petNameTag);
	}

	public boolean isCheckPetAgeDisplayed() {
		int age;
		if(isAndroidBS()) {
			age = Integer.parseInt(driver.findElement(petAgeValue).getText());
		}
		else
		{
			String str=driver.findElement(petAgeLabel).getText();
			char[] num = str.toCharArray();
			String tempAge="";
			for(char c : num){
				if(Character.isDigit(c)||c=='.'){
					tempAge+=c;
				}
			}
			age=Integer.parseInt(tempAge);
		}
			if (driver.isElementPresent(petAgeLabel) && age > 0)
				return true;
			else
				return false;

	}

	public boolean isCheckPetWeightDisplayed() {
		float weight;
		if(isAndroidBS()) {
			weight = Float.parseFloat(driver.findElement(petWeightValue).getText());
		}
		else
		{
			String str=driver.findElement(petAgeLabel).getText();
			char[] num = str.toCharArray();
			String tempWeight="";
			for(char c : num){
				if(Character.isDigit(c)||c=='.'){
					tempWeight+=c;
				}
			}
			weight=Float.parseFloat(tempWeight);
		}


		if(driver.isElementPresent(petWeightLabel)&& weight>0)

			return  true;
		else
			return false;
	}

	public boolean isCheckPetBreedDetailsDisplayed() {
		String breedName;
		if(isAndroidBS())
			breedName=driver.findElement(petBreedValue).getText();
		else {
			breedName=driver.findElement(petBreedLabel).getText();
			breedName=breedName.substring(6);
		}
		if(driver.isElementPresent(petBreedLabel)&& breedName!=null)
			return  true;
		else
			return false;
	}

	public boolean isCheckPencilEditIconDisplayed() {
		return driver.isElementPresent(petPencilIcon);
	}

	public boolean isCheckTwoTabsDisplayed() {
		return driver.isElementPresent(petDeviceTab)&&driver.isElementPresent(achievementsStatsTab);
	}

	public boolean isDefaultTabSelected() {
		if (isAndroidBS())
		return driver.findElement(petDeviceTab).isSelected();
		else
		{
			return driver.isElementEnabled(petDeviceTab);
		}
	}
}

package com.kinship.automation.pageobjects.mobile;

/**
 * Created by jBasera on 11 Mar, 2022
 */
import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AccountInformationPage extends WhistleBasePage {

	TestDriver driver;

	private By logoutBtn = ByT.locator(By.id("Logout"), By.id("account_list_item_log_out"));
	private By logoutPopUpBtn = ByT.locator(By.id("Logout"), By.id("md_buttonDefaultPositive"));
	private By csContactLink = ByT.locator(By.id("Whistle Customer Contract"), By.id("account_list_item_customer_contract"));
	private By accountInfo = ByT.locator(By.id("Account Information"), By.id("Account Information"));


	public AccountInformationPage(TestDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Click on Logout Button")
	public AccountInformationPage clickLogout() {
		driver.waitForElementToBeVisible(logoutBtn);
		driver.clickLocator(logoutBtn);
		return this;
	}

	@Step("Click on Logout pop-up Button")
	public WhistleBasePage clickLogoutPopUpBtn() {
		driver.waitForElementToBeVisible(logoutPopUpBtn);
		driver.clickLocator(logoutPopUpBtn);
		return new WhistleBasePage(driver);
	}

	@Step("Click on Whistle Customer Service")
    public void clickOnCsContact() {
		driver.isElementPresent(csContactLink);
		driver.clickLocator(csContactLink);
    }

	@Step("Click on Whistle Account information")
	public  WhistleBasePage clickOnAccountInfo() {
		driver.pauseExecutionFor(2);
		driver.clickLocator(accountInfo);
		return new WhistleBasePage(driver);
	}
}

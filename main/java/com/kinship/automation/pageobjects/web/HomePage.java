package com.kinship.automation.pageobjects.web;

import com.kinship.automation.utils.commonutils.ByT;
import com.kinship.automation.utils.commonutils.TestDriver;
import com.kinship.automation.utils.commonutils.Utils;
import com.kinship.automation.constants.WildestConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends WildestBasePage {

	TestDriver driver;
	 
	 private By profileIconImage = ByT.locator(By.xpath("//*[text()=\"The Wildest Profile Icon\"]"));
	 private By profiileIconButton= ByT.locator(By.xpath("//*[text()='The Wildest Profile Icon’]//ancestor::button"));
	 private By signUpLink= ByT.locator(By.xpath("//button[contains(text(),\"Sign up\")]"));
	 private By navigationBar= ByT.locator(By.xpath("//ul[@class=\"bw_cv\"]"));
	 private By navigationBarOptions= ByT.locator(By.xpath("//ul[@class=\"bw_c\"]/li"));
	 private By pageBody= ByT.locator(By.xpath("//*[@id=‘content']"));
	 private By footer= ByT.locator(By.xpath("//footer"));
	 private By footerPrimaryNavigation= ByT.locator(By.xpath("//footer//ul[@class='bw_cv bw_hq’]"));
	 private By footerSecondaryNavigation= ByT.locator(By.xpath("//footer//ul[@aria-label=\"secondary navigation”]"));
	 private By signInPopUp= ByT.locator(By.xpath("//div[@class=‘p_bp’]"));
	 private By loginform= ByT.locator(By.xpath("//form[@class=‘ch_ks’]"));
	 private By emailTextBox= ByT.locator(By.xpath("//input[@id=\"email\"]"));
	 private By passwordTextBox= ByT.locator(By.xpath("//input[@id=\"password\"]"));
	 private By loginButton= ByT.locator(By.xpath("//button[text()=\"Log In\"]"));
	 private By myPetSlider= ByT.locator(By.xpath("//button[text()=\"My Pets\"]"));
	 private By myPetSliderOptions= ByT.locator(By.xpath("//button[@role=\"menuitem\"]"));
	 private String myPetSliderOptionText = "//button[@role=\"menuitem\"][%s]/div[2]";
	 private By invalidCredErrorMessage = ByT.locator(By.xpath("//div//span[text()=\"Login or password is incorrect\"]"));
	 private By forgotPasswordLink = ByT.locator(By.xpath("//a[text()=\"Forgot password\"]"));
	 private By getStartedButton = ByT.locator(By.xpath("//a[text()=\"Get Started\"]"));
	 private By nextButton= ByT.locator(By.xpath("//button[text()=\"Next\"]"));
	    public HomePage(){

	    }

	  
	    public HomePage(TestDriver driver){
	    	super(driver);
	        this.driver=driver;
	    }
	    
	    @Step ("verify present of Profile Icon")
		public boolean isProfileIconImagePresent() {
			boolean flag = false;
			flag = driver.isElementPresent(profileIconImage);
			return flag;
		}
		
		@Step ("Click on the login button")
		public HomePage clickProfileIconBtn() {
			driver.clickLocator(profiileIconButton);
			return this;
		}
		
		@Step ("Verify Sign Up link")
		public boolean isSignUpLinkPresent() {
			boolean flag = false;
			flag = driver.isElementPresent(signUpLink);
			return flag;
		}

		@Step("Click on the sign in link.")
		public HomePage clickSignUpLink() {
			driver.waitForElementToBeVisible(signUpLink);
			driver.clickLocator(signUpLink);
			return this;
		}

		@Step("Verify navigation bar is present.")
		public boolean isNavigationBarPresent() {
			boolean flag = false;
			flag = driver.isElementPresent(navigationBar);
			return flag;
		}
		
		public ArrayList<String> getNavigationBarOptions() {
			List<WebElement> options = new ArrayList<WebElement>();
			ArrayList<String> optionName = new ArrayList<String>();
			options = driver.findElements(navigationBarOptions);
			for (WebElement ele : options) {
				optionName.add(ele.getText());
			}
			return optionName;
		}
		
		@Step("Verify Home page content.")
		public boolean isHomePageContentPresent() {
			boolean flag = false;
			flag = driver.isElementPresent(pageBody);
			return flag;
		}
		
		@Step("Verify Fotter is present.")
		public boolean isFooterPresent() {
			boolean flag = false;
			flag = driver.isElementPresent(footer);
			return flag;
		}
		
		@Step("Verify footer navigation options is present.")
		public boolean isFooterPrimaryNavOptionsPresent() {
			boolean flag = false;
			flag = driver.isElementPresent(footerPrimaryNavigation);
			return flag;
		}

		public ArrayList<String> getFooterPrimaryNavOptions() {
			List<WebElement> options = new ArrayList<WebElement>();
			ArrayList<String> optionName = new ArrayList<String>();
			options = driver.findElements(footerPrimaryNavigation);
			for (WebElement ele : options) {
				optionName.add(ele.getText());
			}
			return optionName;
		}
		
		@Step("Verify fotter secondary navigation options are present.")
		public boolean isFooterSecondaryNavOptionsPresent() {
			boolean flag = false;
			flag = driver.isElementPresent(footerSecondaryNavigation);
			return flag;
		}

		public ArrayList<String> getFooterSecondaryNavOptions() {
			List<WebElement> options = new ArrayList<WebElement>();
			ArrayList<String> optionName = new ArrayList<String>();
			options = driver.findElements(footerSecondaryNavigation);
			for (WebElement ele : options) {
				optionName.add(ele.getText());
			}
			return optionName;
		}
		
		@Step("Verify Sign In popup is present.")
		public boolean isSignInPopupPresent() {
			boolean flag = false;
			flag = driver.isElementPresent(signInPopUp);
			return flag;
		}
		
		@Step ("Verify that Login Form is present .")
		public boolean isLogInFormPresent() {
			boolean flag = false;
			flag = driver.isElementPresent(loginform);
			return flag;
		}

		@Step ("Enter the username in filed")
		public HomePage setEmail(String username) {
			driver.type(emailTextBox, username);
			return this;
		}

		@Step ("Enter the password in filed")
		public HomePage setPassword(String pass) {
			driver.type(passwordTextBox, pass);
			return this;
		}

		@Step ("Click on the login button.")
		public HomePage clickLoginButton() {
			driver.clickLocator(loginButton);
			return this;
		}

		@Step("Click on the next in Page.")
		public HomePage clickNextButton() {
			driver.waitForElementToBeVisible(nextButton);
			driver.clickLocator(nextButton);
			return this;
		}
		
		@Step ("Verify Pet slider.")
		public boolean isMyPetSliderPresent() {
			boolean flag = false;
			flag = driver.isElementPresent(myPetSlider);
			return flag;
		}

		@Step ("Click on My pet slider.")
		public HomePage clickMyPetSlider() {
			driver.clickLocator(myPetSlider);
			return this;
		}
		
		@Step ("Enter invalid Passowrd details.")
		public HomePage invalidPassword() throws InterruptedException {
			Thread.sleep(15);
			driver.waitForElementToBeVisible(passwordTextBox).sendKeys(Utils.getValuesFromPropertiesFile("global", "InvalidPasswordWildest"));
			driver.clickLocator(loginButton);
			return this;
		}
		
		@Step ("Enter invalid email details.")
		public HomePage invalidEmailAddress() throws InterruptedException {
			Thread.sleep(15);
			driver.waitForElementToBeVisible(emailTextBox).sendKeys(Utils.getValuesFromPropertiesFile("global", "invalidEmail"));
			return this;
		}

		@Step ("Error message with invalid credentials")
		public String errorMessageInvalidlogin() {
			String ele = driver.waitForElementToBeVisible(invalidCredErrorMessage).getText();
			return ele;
		}
		
		/*@Step ("Click on Forgot password link")
		public ForgotPasswordPage clickForgotPasswordLink() throws InterruptedException {
			driver.waitForElementToBeVisible(forgotPasswordLink);
			driver.clickLocator(forgotPasswordLink);
			return new ForgotPasswordPage(driver);
		}

		@Step ("Click on signup link")
		public AccountInfoPage signUp() throws InterruptedException {
			Thread.sleep(15);
			driver.clickLocator(signUpLink);
			return new AccountInfoPage(driver);
		}

		@Step ("Click on signup link")
		public SignUpPage signUplink() throws InterruptedException {
			Thread.sleep(15);
			driver.clickLocator(signUpLink);
			return new SignUpPage(driver);
		}

		@Step ("Click on signup link")
		public SignUpPage clickSignUplink() throws InterruptedException {
			Thread.sleep(15);
			driver.clickLocator(signUpLink);
			return new SignUpPage(driver);
		}
		*/
		@Step ("Fetch options form My pet slider")
		public ArrayList<String> getMyPetSliderOptions() {
			List<WebElement> options = new ArrayList<WebElement>();
			ArrayList<String> optionName = new ArrayList<String>();
			options = driver.findElements(myPetSliderOptions);
			By loc;
			for (int i=1;i<=options.size();i++) {
				loc = By.xpath(String.format(myPetSliderOptionText, i+""));
				optionName.add(driver.getText(loc,"get option name"));
				System.out.println(driver.getText(loc,"get option name"));
			}
			return optionName;
		}

	@Step("Login to the Wildest app")
	public void login(){
		clickSignUpLink();
		try {
			setEmail(WildestConstants.VALID_EMAIL);
			clickNextButton();
			setPassword(WildestConstants.VALID_PASSWORD);
			clickLoginButton();
		}catch (Exception e){
		}
	}

	/*@Step("Click on the GetStarted Button.")
	public SignUpPage clickGetStartedButton() {
		driver.clickLocator(getStartedButton);
		return new SignUpPage(driver);
	}*/

	@Step("Verify content in page --Cat image.")
	public boolean isgetStartedButtonPresent() {
		boolean flag = false;
		flag = driver.isElementPresent(getStartedButton);
		return flag;
	}

	@Step ("verify Forgot password link")
	public boolean isForgotPasswordLinkPresent() {
		boolean flag = false;
		//driver.waitForElementToBePresent(forgotPasswordLink);
		flag = driver.isElementPresent(forgotPasswordLink);
		return flag;
	}
}

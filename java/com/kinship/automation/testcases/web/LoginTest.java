package com.kinship.automation.testcases.web;

//import com.kinship.automation.utils.Retry;
import com.kinship.automation.base.WebBaseTest;
import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.pageobjects.web.HomePage;
import com.kinship.automation.pageobjects.web.WildestBasePage;
import com.kinship.automation.utils.listeners.Retry;
import com.kinship.automation.utils.listeners.TestListener;
import com.kinship.automation.utils.testrail.TestRails;
import com.kinship.automation.constants.WildestConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Listeners(TestListener.class)
public class LoginTest extends WebBaseTest {

	private ArrayList<String> options;
	@TestRails(id="1010026")
	@Description("Test to login and verify the My Pet options.")
	@Test(groups = {"P0", "BAT"}, priority=0, retryAnalyzer = Retry.class)
	@Feature("Login")
    public void testVerifyHomePageAndLogin() {
		System.out.println(FrameworkConfigFactory.getConfig().browser());
		System.out.println(FrameworkConfigFactory.getConfig().remoteType());
		log.info(" Starting test case to validate Home Page and login ");
		homePageWildest = wildestBasePage.navigateToHomePage(FrameworkConfigFactory.getConfig().url());
		Assert.assertTrue(homePageWildest.isProfileIconImagePresent(),"Verifying the presence of profile icon");
		Assert.assertTrue(homePageWildest.isSignUpLinkPresent(),"Verifying the presence of signup link");
		homePageWildest.login();
		if(!homePageWildest.isMyPetSliderPresent())
			homePageWildest.clickMyPetSlider();
		options = homePageWildest.getMyPetSliderOptions();
		log.info(" Verifying contnt in page ");
		Assert.assertTrue(options.contains("Checklist"),"Verifying the presence of checklist option");
		Assert.assertTrue(options.contains("Training"),"Verifying the presence of training option");
		Assert.assertTrue(options.contains("Nutrition Calculator"),"Verifying the presence of nutrition calculator option");
		log.info(" Test Case Execution Finished ");
	}
}

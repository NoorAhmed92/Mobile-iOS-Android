package com.kinship.automation.base;

import com.kinship.automation.pageobjects.mobile.LandingPage;
import com.kinship.automation.pageobjects.mobile.WhistleBasePage;
import com.kinship.automation.utils.commonutils.TestDriver;
import com.kinship.automation.utils.drivers.KinshipDriver;
import com.kinship.automation.pageobjects.mobile.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class MobileBaseTest extends BaseTest {

    protected TestDriver testDriver;
    public WebDriver driver = null;
    protected WhistleBasePage whistleBasePage;
    protected HomePageWhistle homePageWhistle;
    protected SignInPage signInPage;
    protected WhistleSetupPage whistleSetUpPage;
    protected SelectDevicePage selectDevicePage;
    protected ResetPasswordPage resetPasswordPage;
    protected AssembleDevicePage assembleDevicePage;
    protected HumanStuffPage humanStuffPage;
    protected AccountInformationPage accountInformationPage;
    protected SoftAssert softassert;
    protected LandingPage landingPage;
    protected PetEditProfilePage petEditProfilePage;
    protected ViewPetProfilePage viewPetProfilePage;
    protected PetFoodPage petFoodPage;
    protected PetFoodCantFindPage petFoodCantFindPage;
    protected PetFoodPercentagePage petFoodPercentagePage;
    protected final Logger log = LogManager.getLogger(MobileBaseTest.class);
    protected LocationPage locationPage;
    protected SafePlacesPage safePlacesPage;
    protected ActivityPage activityPage;

    @BeforeMethod
    public void beforeSuite() {
        KinshipDriver.getInstance().setUpMobileDriver();
        testDriver = new TestDriver();
        whistleBasePage = new WhistleBasePage(testDriver);

    }

    @AfterMethod
    public void afterSuite(){
        KinshipDriver.getInstance().tearDownDriver();
    }

}

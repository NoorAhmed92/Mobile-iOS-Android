package com.kinship.automation.base;

import com.kinship.automation.pageobjects.web.HomePage;
import com.kinship.automation.pageobjects.web.WildestBasePage;
import com.kinship.automation.utils.commonutils.TestDriver;
import com.kinship.automation.utils.drivers.KinshipDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class WebBaseTest extends BaseTest {

    protected TestDriver testDriver;
    protected WildestBasePage wildestBasePage;
    protected HomePage homePageWildest;
    protected final Logger log = LogManager.getLogger(WebBaseTest.class);

    @BeforeSuite
    public void beforeSuite() {
        KinshipDriver.getInstance().setUpBrowserDriver();
        testDriver = new TestDriver();
        wildestBasePage = new WildestBasePage(testDriver);
    }

    @AfterSuite
    public void afterSuite(){
        KinshipDriver.getInstance().tearDownDriver();
    }

}

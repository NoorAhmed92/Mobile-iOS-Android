package com.kinship.automation.base;

import com.kinship.automation.pageobjects.mobile.WhistleBasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class ApiBaseTest extends BaseTest {
    protected final Logger log = LogManager.getLogger(ApiBaseTest.class);
    @BeforeSuite
    public void beforeSuite() throws IOException {
        WhistleBasePage.getAuthorizationToken();
        WhistleBasePage.getPetID();
    }

    @AfterSuite
    public void afterSuite(){

    }
}

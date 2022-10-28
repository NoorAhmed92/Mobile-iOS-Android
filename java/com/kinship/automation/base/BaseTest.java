package com.kinship.automation.base;

import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.constants.Constants;
import com.kinship.automation.utils.allure.AllureUtils;
import com.kinship.automation.utils.commonutils.Utils;
import com.kinship.automation.utils.slack.SlackUtils;
import com.kinship.automation.utils.testrail.APIException;
import com.kinship.automation.utils.testrail.TestRail;
import com.kinship.automation.utils.testrail.TestRails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

public class BaseTest {
    protected final Logger log = LogManager.getLogger(BaseTest.class);
    long lTestStartTime;
    static int pass = 0;
    static int fail = 0;
    static int skip = 0;
    ReentrantLock lock = new ReentrantLock();
    public static String testCaseId;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext testContext) throws IOException, APIException {
        log.info("Before Suite initiated");
        AllureUtils.copyAllureHistory();
        //Create a new test run if specified else update the results to existing test run
        if (FrameworkConfigFactory.getConfig().updateTestRailFlag().equalsIgnoreCase("true")) {
            if (FrameworkConfigFactory.getConfig().createNewTestRun().equalsIgnoreCase("true"))
                TestRail.createTestRunSuiteId(testContext);
            else {
                testContext.setAttribute("suiteId", Long.valueOf(FrameworkConfigFactory.getConfig().existingRunID()));
            }
        }
        lTestStartTime = System.currentTimeMillis();
        log.info("Current Date and Time before initiating Suite: " + lTestStartTime);
    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult result, ITestContext testContext) throws Exception {
        log.info("After Method initiated");
        lock.lock();
        try {
            int status = 1;
            String message = "Test case passed via automation";

            if (result.getStatus() == ITestResult.SUCCESS) {
                status = 1;
                pass++;
            } else if (result.getStatus() == ITestResult.SKIP) {
                status = 6;
                skip++;
            } else {
                message = result.getThrowable().toString();
                status = 5;
                fail++;
            }
            testCaseId = method.getAnnotation(TestRails.class).id();
            Constants.testCaseIds.put(testCaseId, status + "|" + message);
        } finally {
            lock.unlock();
        }
    }

    @AfterSuite
    public void resultSummary() throws Exception {
        long endTime = System.currentTimeMillis();
        log.info("End Date and Time after running Suite: " +endTime);
        String timeTaken = Utils.getTimeDifference(endTime, lTestStartTime);
        TestRail.addResultsInTestRail(Constants.testCaseIds);
        SlackUtils.sendMessage("KinshipAutomation", "Automation Execution Summary: " + pass +
                " passed | " + fail + " failed | " + skip + " skipped." + timeTaken +
                "\n" + "Automation Suite ran From " + System.getProperty("user.name") +
                "\n" + "Execution Platform  = " + FrameworkConfigFactory.getConfig().platform().toString().toUpperCase() +
                "\n" + "Click on the link to view the report :  https://whistlelabs.github.io/kinship_qa_auto/");
        AllureUtils.generateReport();
    }
}

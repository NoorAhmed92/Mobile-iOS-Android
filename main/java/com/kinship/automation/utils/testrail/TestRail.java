package com.kinship.automation.utils.testrail;

import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.constants.Constants;
import io.qameta.allure.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.ITestContext;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRail {

	public static String testRailId = "";
	public final static String TESTRAIL_URL = "/";
	public static final String TEST_RAIL_ID_PATTERN = "<testcaseid>.*</testcaseid>";
	public static final String SPRINT = "2019.1";
	static APIClient client = null;
	public static List<String> untestedTestCaseList = new ArrayList<String>();
	public static List<String> retestTestCaseList = new ArrayList<String>();
	public static List<String> failedTestCaseList = new ArrayList<String>();
	public static List<String> failedTestCaseListWithBug = new ArrayList<String>();
	public static List<String> passedTestCaseList = new ArrayList<String>();
	public static List<String> skippedTestCaseList = new ArrayList<String>();
	public static boolean isAlreadyFetched = false;
	public static List<String> listOfTCs = new ArrayList<String>();

	static int passedTCcode = 1;
	static int blockedTCcode = 2;
	static int untestedTCcode = 3;
	static int retestTCcode = 4;
	static int failedTCcode = 5;
	static int skippedTCcode = 6;
	
	static {
		client = new APIClient(Constants.TEST_RAIL_URL);
		client.setUser(FrameworkConfigFactory.getConfig().testRailUsername());
		client.setPassword(FrameworkConfigFactory.getConfig().testRailPassword());
	}
	@Step("Test Rail Initialization")
	public void testRail(int Status, String testCaseID, String runId, String errorMsg) throws MalformedURLException, IOException, APIException {
		Map<String, Comparable> data = new HashMap<String, Comparable>();
		data.put("status_id", new Integer(Status));
		data.put("comment", errorMsg);
		if (!runId.isEmpty()) {
			JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + runId + "/" + testCaseID, data);
		}
	}
	@Step("Get failed Test Cases")
	public static List<String> getFailedTCs(String runId) throws MalformedURLException, IOException, APIException {
		try{
			Map<String, Comparable> data = new HashMap<String, Comparable>();
			JSONArray response = (JSONArray) client.sendGet("get_tests/" + runId + "&status_id=5");
			for (Object obj : response) {
				JSONObject jsonObj = (JSONObject) obj;
				Long case_id = (Long) jsonObj.get("case_id");
				failedTestCaseList.add(case_id.toString());
			}
			System.out.println();
		}catch(Exception e){
			
		}
		return failedTestCaseList;
	}
	
	@Step("Fetch Test Cases from Test Run")
	public static List<String> fetchTestCasesFromTestRun(String runId) throws Exception{
		try{
			Map<String, Comparable> data = new HashMap<String, Comparable>();
			JSONArray response = (JSONArray) client.sendGet("get_tests/" + runId + "&status_id=3");
			for (Object obj : response) {
				JSONObject jsonObj = (JSONObject) obj;
				Long case_id = (Long) jsonObj.get("case_id");
				untestedTestCaseList.add(case_id.toString());
				}
		}catch(Exception e) {
		}
		return null;
	}
	
	@Step("Create Test Run Suite Id")
	public static void createTestRunSuiteId(ITestContext testContext) throws IOException, APIException {
			String PROJECT_ID = Constants.TEST_RAIL_PROJECT_ID;
			System.out.println("Creating a test run");
			Map data = new HashMap();
			data.put("include_all",true);
			data.put("name","Test Run "+System.currentTimeMillis());
			JSONObject c = null;
			c = (JSONObject)client.sendPost("add_run/"+PROJECT_ID,data);
			Constants.NEW_RUN_ID = (Long)c.get("id");
			testContext.setAttribute("suiteId",Constants.NEW_RUN_ID);
	}
	
	@Step("Get Test Case Id")
	public static String getTestCaseId(Method method, final ITestContext testContext) throws NoSuchMethodException, SecurityException, IOException {
		String testCaseId = "*";
		if(FrameworkConfigFactory.getConfig().updateTestRailFlag().equalsIgnoreCase("true")) {
		if (method.isAnnotationPresent(TestRails.class)) {
			TestRails ta = method.getAnnotation(TestRails.class);
			testCaseId = ta.id();
			System.out.println(testCaseId);
			testContext.setAttribute("caseId", testCaseId);
			}
		}
		return testCaseId;
	}
	
	@Step("Add results corresponding to Test Cases in TestRail")
	public static void addResultsInTestRail(int status, String errorMessage, ITestContext testContext) throws Exception {
		if(FrameworkConfigFactory.getConfig().updateTestRailFlag().equalsIgnoreCase("true")) {
		Map<String, Object> data = new HashMap<String, Object>();

    	if(status==5)
    		data.put("comment", errorMessage);
		data.put("status_id", status);
		client.sendPost("add_result_for_case/"+Constants.NEW_RUN_ID+"/"+"caseId",data);
		}
	}

	@Step("Add results corresponding to Test Cases in TestRail")
	public static void addResultsInTestRail(HashMap<String, String> testCaseIds) throws Exception {
		if(FrameworkConfigFactory.getConfig().updateTestRailFlag().equalsIgnoreCase("true")) {
			System.out.println("---------->>> Updating results in  test rail <<<-------------");
			int status = 1;
			String message = "";
			Map<String, Object> data = new HashMap<String, Object>();
			String runid = FrameworkConfigFactory.getConfig().createNewTestRun().equalsIgnoreCase("true")?String.valueOf(Constants.NEW_RUN_ID):String.valueOf(FrameworkConfigFactory.getConfig().existingRunID());

			for (Map.Entry<String, String> entry : testCaseIds.entrySet()) {
				status = Integer.valueOf(entry.getValue().split("\\|")[0]);
				message = entry.getValue().split("\\|")[1];
				data.put("comment", message);
				data.put("status_id", status);
				client.sendPost("add_result_for_case/" + runid + "/" + entry.getKey(), data);
			}
		}
	}
}

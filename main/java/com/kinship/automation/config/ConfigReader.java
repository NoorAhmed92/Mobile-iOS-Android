package com.kinship.automation.config;

import com.kinship.automation.constants.MobileDriverType;
import com.kinship.automation.constants.RemoteType;
import com.kinship.automation.constants.RunType;
import com.kinship.automation.constants.WebDriverType;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:${user.dir}/src/test/resources/config.properties",
        "file:${user.dir}/src/test/resources/android.properties",
        "file:${user.dir}/src/test/resources/ios.properties",
        "file:${user.dir}/src/test/resources/testData.properties",
        "system:properties"
       // "file:${user.dir}/src/test/resources/{platform}.properties",
})
public interface ConfigReader extends Config {

    @Key("baseUrl")
    String url();

    @ConverterClass(value = StringToWebDriverTypeConverter.class)
    @DefaultValue("chrome")
    WebDriverType browser();

    @ConverterClass(value = StringToRemoteTypeConverter.class)
    @DefaultValue("browserstack")
    RemoteType remoteType();

    @ConverterClass(value = StringToRunTypeConverter.class)
    @Key("runType")
    RunType runType();

    @Config.Key("gridusername")
    String gridUserName();

    @Config.Key("gridaccesskey")
    String gridAccessKey();

    @ConverterClass(value = StringToMobileDriverTypeConverter.class)
    MobileDriverType platform();

    @Config.Key("appActivity")
    String appActivity();

    @Config.Key("appPackage")
    String appPackage();

    @Config.Key("androidDevice")
    String androidDevice();

    @Config.Key("iosDevice")
    String iosDevice();

    @Config.Key("iosVersion")
    String iosVersion();

    @Config.Key("androidVersion")
    String androidVersion();

    @Config.Key("androidApp")
    String androidApp();

    @Config.Key("iosApp")
    String iosApp();

    @Config.Key("timeout")
    String mobileTimeout();

    @Config.Key("bundleId")
    String bundleId();

    @Config.Key("udid")
    String udid();

    @Config.Key("baseUrlAPI")
    String baseUrlAPI();

    @Config.Key("testRailUsername")
    String testRailUsername();

    @Config.Key("testRailPassword")
    String testRailPassword();

    @Config.Key("updateTestRailFlag")
    String updateTestRailFlag();

    @Config.Key("existingRunID")
    String existingRunID();

    @Config.Key("createNewTestRun")
    String createNewTestRun();

    @Config.Key("slackWebHookURL")
    String slackWebHookURL();

    @Config.Key("emailMobile")
    String emailMobile();

    @Config.Key("passwordMobile")
    String passwordMobile();
  
    @Config.Key("emailMobileAM2")
    String emailMobileAM2();

    @Config.Key("emailMobileSingleAM2")
    String emailMobileSingleAM2();

    @Config.Key("passwordMobileAM2")
    String passwordMobileAM2();
  
    @Config.Key("invalidPasswordMobile")
    String invalidPasswordMobile();

    @Config.Key("passwordBlank")
    String passwordBlank();

    @Config.Key("emailBlank")
    String emailBlank();

    @Config.Key("invalidPasswordLessThanEightChars")
    String invalidPasswordLessThanEightChars();

    @Config.Key("passwordMoreThan128Chars")
    String passwordMoreThan128Chars();

    @Config.Key("emailMobileW05")
    String emailMobileW05();

    @Config.Key("emailMobileW04")
    String emailMobileW04();

    @Config.Key("emailMobileHybridAM2W04")
    String emailMobileHybridAM2W04();

    @Config.Key("emailMoreThan140Chars")
    String emailMoreThan140Chars();

    @Config.Key("nonExistingEmail")
    String nonExistingEmail();

    @Config.Key("invalidEmail")
    String invalidEmail();
}

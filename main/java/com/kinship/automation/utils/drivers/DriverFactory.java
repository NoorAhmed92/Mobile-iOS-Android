package com.kinship.automation.utils.drivers;

import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.constants.RunType;
import io.appium.java_client.AppiumDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {

    private DriverFactory(){}

    private static final Map<RunType, Supplier<WebDriver>> browserMAP = new EnumMap<>(RunType.class);
    private static final Map<RunType, Supplier<AppiumDriver>> mobileMAP = new EnumMap<>(RunType.class);
    private static final Supplier<WebDriver> BROWSER_LOCAL = LocalBrowserFactory::getDriver;
    private static final Supplier<WebDriver> BROWSER_REMOTE = RemoteBrowserFactory::getDriver;
    private static final Supplier<AppiumDriver> MOBILE_LOCAL = LocalMobileFactory::getDriver;
    private static final Supplier<AppiumDriver> MOBILE_REMOTE = RemoteMobileFactory::getDriver;

    static {
        browserMAP.put(RunType.LOCAL, BROWSER_LOCAL);
        browserMAP.put(RunType.REMOTE, BROWSER_REMOTE);
        mobileMAP.put(RunType.LOCAL,MOBILE_LOCAL);
        mobileMAP.put(RunType.REMOTE,MOBILE_REMOTE);
    }

    public static WebDriver getBrowserDriver(){
        System.out.println(FrameworkConfigFactory.getConfig().runType());
        return browserMAP.get(FrameworkConfigFactory.getConfig().runType()).get();
    }

    public static AppiumDriver getMobileDriver(){
        System.out.println("Mobile Driver running for: " +FrameworkConfigFactory.getConfig().runType());
        return mobileMAP.get(FrameworkConfigFactory.getConfig().runType()).get();
    }


}

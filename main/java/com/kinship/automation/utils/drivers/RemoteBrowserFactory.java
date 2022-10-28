package com.kinship.automation.utils.drivers;

import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.constants.RemoteType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class RemoteBrowserFactory {

    private RemoteBrowserFactory(){}

    private static final Map<RemoteType, Supplier<WebDriver>> driverMap = new EnumMap<>(RemoteType.class);

    private static final Supplier<WebDriver> browserStackSupplier = ()-> {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        String url = "https://" + FrameworkConfigFactory.getConfig().gridUserName() + ":" + FrameworkConfigFactory.getConfig().gridAccessKey() + "@hub-cloud.browserstack.com/wd/hub";
        capabilities.setCapability("browser",FrameworkConfigFactory.getConfig().browser());
        capabilities.setCapability("browser_version", "latest");
        try {
            return new RemoteWebDriver(new URL(url),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    };


    private static final Supplier<WebDriver> sauceLabsSupplier = ()-> {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        String url = "https://" + FrameworkConfigFactory.getConfig().gridUserName() + ":" + FrameworkConfigFactory.getConfig().gridAccessKey() + "@hub-cloud.saucelabs.com/wd/hub";
        capabilities.setCapability("browser",FrameworkConfigFactory.getConfig().browser());
        capabilities.setCapability("browser_version", "latest");
        try {
            return new RemoteWebDriver(new URL(url),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    };

    private static final Supplier<WebDriver> lambdaTestSupplier = ()-> {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        String url = "https://" + FrameworkConfigFactory.getConfig().gridUserName() + ":" + FrameworkConfigFactory.getConfig().gridAccessKey() + "@hub-cloud.lambdtests.com/wd/hub";
        capabilities.setCapability("browser",FrameworkConfigFactory.getConfig().browser());
        capabilities.setCapability("browser_version", "latest");
        try {
            return new RemoteWebDriver(new URL(url),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    };



    static {
        driverMap.put(RemoteType.SAUCELABS, sauceLabsSupplier);
        driverMap.put(RemoteType.BROWSERSTACK, browserStackSupplier);
        driverMap.put(RemoteType.LAMBDATEST, lambdaTestSupplier);
    }

    public static WebDriver getDriver(){
        return driverMap.getOrDefault(FrameworkConfigFactory.getConfig().remoteType(),browserStackSupplier).get();
    }
}

package com.kinship.automation.utils.drivers;

import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.constants.MobileDriverType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class RemoteMobileFactory {

    private RemoteMobileFactory(){}

    private static final Map<MobileDriverType, Supplier<AppiumDriver>> driverMap = new EnumMap<>(MobileDriverType.class);

    private static final Supplier<AppiumDriver> androidDriverSupplier = () -> {
        System.out.println(FrameworkConfigFactory.getConfig().androidApp());
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("device-orientation", "portrait");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability("automationName", "uiautomator2");
        cap.setCapability("project", "Project-1");
        cap.setCapability("build", "Build-1");
        cap.setCapability("name", "Android-Test");
        cap.setCapability("appPackage", FrameworkConfigFactory.getConfig().appPackage());
        cap.setCapability("appActivity", FrameworkConfigFactory.getConfig().appActivity());
        cap.setCapability(MobileCapabilityType.FULL_RESET, false);
        cap.setCapability("unicodeKeyboard",true);
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("newCommandTimeout", FrameworkConfigFactory.getConfig().mobileTimeout());
        cap.setCapability("browserstack.user", FrameworkConfigFactory.getConfig().gridUserName());
        cap.setCapability("browserstack.key", FrameworkConfigFactory.getConfig().gridAccessKey());
        cap.setCapability("browserstack.idleTimeout", "3000");
        cap.setCapability("device",FrameworkConfigFactory.getConfig().androidDevice());
        cap.setCapability("os_version",FrameworkConfigFactory.getConfig().androidVersion());
        cap.setCapability("app",FrameworkConfigFactory.getConfig().androidApp());
        cap.setCapability("appiumVersion","1.17.1");
        try {
            return new AndroidDriver(new URL("http://hub-cloud.browserstack.com/wd/hub"),cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    };

    private static final Supplier<AppiumDriver> iosDriverSupplier = () -> {
        System.out.println(FrameworkConfigFactory.getConfig().iosApp());
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("device-orientation", "portrait");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        cap.setCapability("project", "Project-1");
        cap.setCapability("build", "Build-1");
        cap.setCapability("name", "iOS-Test");
        cap.setCapability(MobileCapabilityType.FULL_RESET, false);
        cap.setCapability("browserstack.user", FrameworkConfigFactory.getConfig().gridUserName());
        cap.setCapability("browserstack.key", FrameworkConfigFactory.getConfig().gridAccessKey());
        cap.setCapability("browserstack.idleTimeout", "300");
        cap.setCapability("device",FrameworkConfigFactory.getConfig().iosDevice());
        cap.setCapability("os_version",FrameworkConfigFactory.getConfig().iosVersion());
        cap.setCapability("app",FrameworkConfigFactory.getConfig().iosApp());
        cap.setCapability("autoAcceptAlerts",true);
        cap.setCapability("showXcodeLog",true);
        cap.setCapability("showIOSLog",true);
        cap.setCapability("wdaStartupRetries","3");
        cap.setCapability("appiumVersion","1.22.0");

        try {
            return new IOSDriver(new URL("http://hub-cloud.browserstack.com/wd/hub"),cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    };

    static  {
        driverMap.put(MobileDriverType.ANDROID, androidDriverSupplier);
        driverMap.put(MobileDriverType.IOS, iosDriverSupplier);
    }

    public static final AppiumDriver getDriver(){
        return driverMap.get(FrameworkConfigFactory.getConfig().platform()).get();
    }



}

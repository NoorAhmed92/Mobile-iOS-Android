package com.kinship.automation.utils.drivers;

import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.constants.Constants;
import com.kinship.automation.constants.MobileDriverType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class LocalMobileFactory {

    private LocalMobileFactory(){}

    private static final Map<MobileDriverType, Supplier<AppiumDriver>> driverMap = new EnumMap<>(MobileDriverType.class);
    private static AppiumServiceBuilder builder = null;

    private static final Supplier<AppiumDriver> androidDriverSupplier = () -> {
        System.out.println(FrameworkConfigFactory.getConfig().androidApp());
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("device-orientation", "portrait");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability("automationName", "uiautomator2");
        cap.setCapability("appPackage", FrameworkConfigFactory.getConfig().appPackage());
        cap.setCapability("appActivity", FrameworkConfigFactory.getConfig().appActivity());
        cap.setCapability(MobileCapabilityType.FULL_RESET, false);
        cap.setCapability("unicodeKeyboard", true);
        cap.setCapability("newCommandTimeout", FrameworkConfigFactory.getConfig().mobileTimeout());
        cap.setCapability("deviceName",FrameworkConfigFactory.getConfig().androidDevice());
        cap.setCapability("app",FrameworkConfigFactory.getConfig().androidApp());
        cap.setCapability("appiumVersion","1.17.1");
        cap.setCapability("autoAcceptAlerts","true");
        cap.setCapability("autoGrantPermissions","true");
        try {
            builder = new AppiumServiceBuilder();
            builder.withIPAddress("127.0.0.1");
            builder.usingAnyFreePort();
            builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
            builder.withCapabilities(cap);
            AppiumDriverLocalService server = AppiumDriverLocalService.buildService(builder);
            server.start();
            return new AndroidDriver(new URL("http://localhost:4723/wd/hub"),cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    };

    private static final Supplier<AppiumDriver> iosDriverSupplier = () -> {
        System.out.println(FrameworkConfigFactory.getConfig().iosApp());
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("device-orientation", "portrait");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability("appPackage", FrameworkConfigFactory.getConfig().appPackage());
        cap.setCapability("appActivity", FrameworkConfigFactory.getConfig().appActivity());
        cap.setCapability(MobileCapabilityType.FULL_RESET, false);
        cap.setCapability("noReset", false);
        cap.setCapability("wdaStartupRetries", "3");
        cap.setCapability("deviceName",FrameworkConfigFactory.getConfig().iosDevice());
        cap.setCapability("bundleId", FrameworkConfigFactory.getConfig().bundleId());
        cap.setCapability("udid", FrameworkConfigFactory.getConfig().udid());
        cap.setCapability("platformVersion", FrameworkConfigFactory.getConfig().iosVersion());
        cap.setCapability("autoAcceptAlerts",true);
        cap.setCapability("autoGrantPermissions",true);
        try {
            builder = new AppiumServiceBuilder();
            builder.withIPAddress("127.0.0.1");
            builder.usingAnyFreePort();
            builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
            builder.withCapabilities(cap);
            AppiumDriverLocalService server = AppiumDriverLocalService.buildService(builder);
            server.start();
            return new IOSDriver(new URL("http://localhost:4723/wd/hub"),cap);
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

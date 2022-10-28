package com.kinship.automation.utils.drivers;

import com.kinship.automation.config.FrameworkConfigFactory;
import com.kinship.automation.constants.WebDriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalBrowserFactory {

    private LocalBrowserFactory(){}
    private static final Map<WebDriverType, Supplier<WebDriver>> driverMap = new EnumMap<>(WebDriverType.class);

    //chrome driver supplier
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };

    //safari driver supplier
    private static final Supplier<WebDriver> safariDriverSupplier = () -> {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    };

    //firefox driver supplier
    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };

    //edge driver supplier
    private static final Supplier<WebDriver> edgeDriverSupplier = () -> {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    };

    static  {
        driverMap.put(WebDriverType.CHROME,chromeDriverSupplier);
        driverMap.put(WebDriverType.SAFARI, safariDriverSupplier);
        driverMap.put(WebDriverType.FIREFOX, firefoxDriverSupplier);
        driverMap.put(WebDriverType.EDGE, edgeDriverSupplier);
    }

    //return a new driver from the map
    public static final WebDriver getDriver(){
       // return driverMap.get(FrameworkConfigFactory.getConfig().browser()).get();
        return driverMap.getOrDefault(FrameworkConfigFactory.getConfig().browser(),chromeDriverSupplier).get();
    }

}

package com.kinship.automation.utils.drivers;

import java.util.Objects;

public final class KinshipDriver {

    private static final KinshipDriver driver;

    static {
        driver = new KinshipDriver();
    }

    private KinshipDriver(){}

    public static KinshipDriver getInstance() {
        return driver;
    }

    public KinshipDriver setUpBrowserDriver(){
        if (Objects.isNull(DriverManager.getDriver()))
            DriverManager.setDriver(DriverFactory.getBrowserDriver());
        return this;
    }

    public KinshipDriver setUpMobileDriver(){
        if (Objects.isNull(DriverManager.getDriver()))
            DriverManager.setDriver(DriverFactory.getMobileDriver());
        return this;
    }


    public void tearDownDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.unload();
        }
    }
}
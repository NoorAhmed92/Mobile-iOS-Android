package com.kinship.automation.config;

import org.aeonbits.owner.ConfigCache;

public final class FrameworkConfigFactory {
    private FrameworkConfigFactory(){}

    public static ConfigReader getConfig(){
        return ConfigCache.getOrCreate(ConfigReader.class, System.getProperties());
    }
}

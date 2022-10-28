package com.kinship.automation.config;

import com.kinship.automation.constants.WebDriverType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToWebDriverTypeConverter implements Converter<WebDriverType> {

    @Override
    public WebDriverType convert(Method method, String browername) {

        return WebDriverType.valueOf(browername.toUpperCase());
    }
}

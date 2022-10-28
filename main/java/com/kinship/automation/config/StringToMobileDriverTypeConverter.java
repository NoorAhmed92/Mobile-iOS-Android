package com.kinship.automation.config;

import com.kinship.automation.constants.MobileDriverType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToMobileDriverTypeConverter implements Converter<MobileDriverType> {

    @Override
    public MobileDriverType convert(Method method, String mobileDriverType) {
        return MobileDriverType.valueOf(mobileDriverType.toUpperCase());
    }
}

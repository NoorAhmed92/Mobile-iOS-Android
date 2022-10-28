package com.kinship.automation.config;

import com.kinship.automation.constants.RemoteType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToRemoteTypeConverter implements Converter<RemoteType> {

    @Override
    public RemoteType convert(Method method, String remoteType) {
        return RemoteType.valueOf(remoteType.toUpperCase());
    }
}

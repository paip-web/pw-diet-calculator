package com.paipweb.pwdietcalculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath: version.properties")
public class VersionServiceImpl implements VersionService {

    @Autowired
    Environment environment;

    @Override
    public String getVersion() {

        String major = getMajorVersion();
        String minor = getMinorVersion();
        String patch = getPatch();

        return String.format("%s.%s.%s", major, minor, patch);
    }

    @Override
    public String getMajorVersion() {
        return environment.getProperty("version.major");
    }

    @Override
    public String getMinorVersion() {
        return environment.getProperty("version.minor");
    }

    @Override
    public String getPatch() {
        return environment.getProperty("version.patch");
    }
}

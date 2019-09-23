package com.paipweb.pwdietcalculator.service;

import com.paipweb.pwdietcalculator.data.VersionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:version.properties")
public class VersionServiceImpl implements VersionService {

    private static final String API_VERSION_KEY = "api.version";

    private static final String API_CURRENT_VERSION_KEY = "api.currentVersion";

    private static final String SPEC_VERSION_KEY = "spec.version";

    private static final String SPEC_CURRENT_VERSION_KEY = "spec.currentVersion";

    private static final String VERSION_KEY = "version";

    private static final String CURRENT_VERSION_KEY = "currentVersion";

    @Autowired
    private Environment environment;

    @Override
    public VersionData getApiVersion() {

        VersionData versionData = new VersionData();
        versionData.setVersion(environment.getProperty(API_VERSION_KEY));
        versionData.setCurrentVersion(environment.getProperty(API_CURRENT_VERSION_KEY));
        return versionData;
    }

    @Override
    public VersionData getSpecVersion() {

        VersionData versionData = new VersionData();
        versionData.setVersion(environment.getProperty(SPEC_VERSION_KEY));
        versionData.setCurrentVersion(environment.getProperty(SPEC_CURRENT_VERSION_KEY));
        return versionData;
    }

    @Override
    public VersionData getVersion() {

        VersionData versionData = new VersionData();
        versionData.setVersion(environment.getProperty(VERSION_KEY));
        versionData.setCurrentVersion(environment.getProperty(CURRENT_VERSION_KEY));
        return versionData;
    }
}

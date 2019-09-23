package com.paipweb.pwdietcalculator.data;

public class VersionInfoData {

    private VersionData apiVersion;

    private VersionData specVersion;

    private String version;

    private String currentVersion;

    public VersionData getSpecVersion() {
        return specVersion;
    }

    public void setSpecVersion(VersionData specVersion) {
        this.specVersion = specVersion;
    }

    public VersionData getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(VersionData apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }
}

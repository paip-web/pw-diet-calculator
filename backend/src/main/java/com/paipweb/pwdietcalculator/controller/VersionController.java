package com.paipweb.pwdietcalculator.controller;

import com.paipweb.pwdietcalculator.data.VersionData;
import com.paipweb.pwdietcalculator.data.VersionInfoData;
import com.paipweb.pwdietcalculator.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/version")
public class VersionController {

    @Autowired
    private VersionService versionService;

    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public VersionInfoData getVersionInfo() {

        VersionInfoData versionInfoData = new VersionInfoData();

        VersionData apiVersionData = versionService.getApiVersion();
        VersionData specVersionData = versionService.getSpecVersion();
        VersionData versionData = versionService.getVersion();

        versionInfoData.setApiVersion(apiVersionData);
        versionInfoData.setSpecVersion(specVersionData);
        versionInfoData.setVersion(versionData.getVersion());
        versionInfoData.setCurrentVersion(versionData.getCurrentVersion());

        return versionInfoData;
    }
}

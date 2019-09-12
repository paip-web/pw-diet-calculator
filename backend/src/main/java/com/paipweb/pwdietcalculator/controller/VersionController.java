package com.paipweb.pwdietcalculator.controller;

import com.paipweb.pwdietcalculator.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
public class VersionController {

    @Autowired
    VersionService versionService;

    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.TEXT_PLAIN_VALUE)
    public String version() {

        return versionService.getVersion();
    }
}

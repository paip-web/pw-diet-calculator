package com.paipweb.pwdietcalculator.service;

import com.paipweb.pwdietcalculator.data.VersionData;

public interface VersionService {

    VersionData getApiVersion();

    VersionData getSpecVersion();

    VersionData getVersion();
}

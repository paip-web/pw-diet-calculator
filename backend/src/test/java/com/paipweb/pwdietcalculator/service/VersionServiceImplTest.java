package com.paipweb.pwdietcalculator.service;

import com.paipweb.pwdietcalculator.data.VersionData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VersionServiceImplTest {

    private static final String API_VERSION_KEY = "api.version";

    private static final String API_CURRENT_VERSION_KEY = "api.currentVersion";

    private static final String SPEC_VERSION_KEY = "spec.version";

    private static final String SPEC_CURRENT_VERSION_KEY = "spec.currentVersion";

    private static final String VERSION_KEY = "version";

    private static final String CURRENT_VERSION_KEY = "currentVersion";

    private static final String TEST_API_VERSION_VALUE = "0.0.1";

    private static final String TEST_API_CURRENT_VERSION_VALUE = "1.0.0";

    private static final String TEST_SPEC_VERSION_VALUE = "0.0.2";

    private static final String TEST_SPEC_CURRENT_VERSION_VALUE = "2.0.0";

    private static final String TEST_VERSION_VALUE = "0.0.3";

    private static final String TEST_CURRENT_VERSION_VALUE = "3.0.0";

    @InjectMocks
    private VersionServiceImpl testedService;

    @Mock
    private Environment environment;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        when(environment.getProperty(API_VERSION_KEY)).thenReturn(TEST_API_VERSION_VALUE);
        when(environment.getProperty(API_CURRENT_VERSION_KEY)).thenReturn(TEST_API_CURRENT_VERSION_VALUE);
        when(environment.getProperty(SPEC_VERSION_KEY)).thenReturn(TEST_SPEC_VERSION_VALUE);
        when(environment.getProperty(SPEC_CURRENT_VERSION_KEY)).thenReturn(TEST_SPEC_CURRENT_VERSION_VALUE);
        when(environment.getProperty(VERSION_KEY)).thenReturn(TEST_VERSION_VALUE);
        when(environment.getProperty(CURRENT_VERSION_KEY)).thenReturn(TEST_CURRENT_VERSION_VALUE);
    }

    @Test
    public void testGetApiVersion() {

        VersionData versionData = testedService.getApiVersion();

        assertEquals(TEST_API_VERSION_VALUE, versionData.getVersion());
        assertEquals(TEST_API_CURRENT_VERSION_VALUE, versionData.getCurrentVersion());
    }

    @Test
    public void testGetSpecVersion() {

        VersionData versionData = testedService.getSpecVersion();

        assertEquals(TEST_SPEC_VERSION_VALUE, versionData.getVersion());
        assertEquals(TEST_SPEC_CURRENT_VERSION_VALUE, versionData.getCurrentVersion());
    }

    @Test
    public void testGetVersion() {

        VersionData versionData = testedService.getVersion();

        assertEquals(TEST_VERSION_VALUE, versionData.getVersion());
        assertEquals(TEST_CURRENT_VERSION_VALUE, versionData.getCurrentVersion());
    }
}

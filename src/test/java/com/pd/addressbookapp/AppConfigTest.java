package com.pd.addressbookapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.pd.addressbookapp.Utils.AppConfig;

class AppConfigTest {

    @Test
    void shouldLoadPropertyFromApplicationProperties() {
        AppConfig config = new AppConfig();
        String endpoint = config.getProperty("pd.endpoint");
        assertNotNull(endpoint);
    }

}
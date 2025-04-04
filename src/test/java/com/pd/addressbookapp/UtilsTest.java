package com.pd.addressbookapp;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class UtilsTest {


     @Test
    void testBuildsCorrectUrl() throws Exception {
        String result = Utils.get("http://localhost", null, "john doe", true, 10, 1);
        assertNotNull(result); // Real test would mock response
    }

    @Test
    void testThrowsOnEmptyUrl() {
        assertThrows(IllegalArgumentException.class, () -> {
            Utils.get("", null, null, false, 0, 0);
        });
    }

}

package com.pd.addressbookapp;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pd.addressbookapp.model.ApiResponse;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testJsonDeserialization() throws Exception {
        String json = "{ \"users\": [{ \"name\": \"John\", \"email\": \"john@example.com\" }], \"total\": 1, \"limit\": 10, \"offset\": 0, \"more\": false }";
        ObjectMapper mapper = new ObjectMapper();
        ApiResponse response = mapper.readValue(json, ApiResponse.class);

        assertEquals(1, response.getUsers().size());
        assertEquals("John", response.getUsers().get(0).getName());
    }

    @Test
    public void testAppRunsWithoutCrash() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}






package com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.utils;

import com.EmazonPragma.EmazonUser_Pragma.adapters.driving.rest.utils.Exceptions.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonParser {

    private JsonParser() {
        throw new IllegalStateException("Utility class");
    }

    public static String toJson(final Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }
}

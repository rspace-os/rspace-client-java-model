package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserTest extends AbstractModelTest {

    File userJson = new File("src/test/resources/User.json");

    @Test
    void testUserDeserialisationFromFixture() throws IOException {
        User user = readFileToClass(userJson, User.class);
        assertEquals(42L, user.getId());
        assertEquals("testuser", user.getUsername());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("Test", user.getFirstName());
        assertEquals("User", user.getLastName());
        assertEquals(100L, user.getHomeFolderId());
    }

    @Test
    void testUserIgnoresUnknownFields() throws IOException {
        String json = "{\"id\":1,\"username\":\"user\",\"unknownFutureField\":\"some value\"}";
        User user = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .readValue(json, User.class);
        assertNotNull(user);
        assertEquals(1L, user.getId());
    }

    @Test
    void testAllFieldsDeserialise() throws IOException {
        String json = "{" +
                "\"id\":7," +
                "\"username\":\"jdoe\"," +
                "\"email\":\"jdoe@lab.org\"," +
                "\"firstName\":\"Jane\"," +
                "\"lastName\":\"Doe\"," +
                "\"homeFolderId\":55" +
                "}";
        User user = new ObjectMapper().readValue(json, User.class);
        assertEquals(7L, user.getId());
        assertEquals("jdoe", user.getUsername());
        assertEquals("jdoe@lab.org", user.getEmail());
        assertEquals("Jane", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(55L, user.getHomeFolderId());
    }
}

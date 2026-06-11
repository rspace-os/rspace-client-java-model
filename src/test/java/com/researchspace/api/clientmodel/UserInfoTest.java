package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserInfoTest extends AbstractModelTest {

    private final File fixture = new File("src/test/resources/UserInfo.json");

    @Test
    void testUserInfoDeserialisesFromFixture() throws IOException {
        UserInfo user = readFileToClass(fixture, UserInfo.class);
        assertEquals(101L, user.getId());
        assertEquals("U101", user.getGlobalId());
        assertEquals("jsmith", user.getUsername());
        assertEquals("jsmith@lab.org", user.getEmail());
        assertEquals("John", user.getFirstName());
        assertEquals("Smith", user.getLastName());
        assertEquals(UserRole.ROLE_USER, user.getRole());
        assertEquals("Acme Labs", user.getAffiliation());
        assertTrue(user.isEnabled());
        assertEquals(200L, user.getHomeFolderId());
    }

    @Test
    void testUserInfoIgnoresUnknownFields() throws IOException {
        String json = "{\"id\":1,\"globalId\":\"U1\",\"name\":\"testuser\",\"username\":\"testuser\",\"unknownFutureField\":\"some value\"}";
        UserInfo user = new ObjectMapper().readValue(json, UserInfo.class);
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("testuser", user.getUsername());
    }

    @Test
    void testUserInfoRoleIsNullWhenNotPresent() throws IOException {
        String json = "{\"id\":2,\"username\":\"noRole\"}";
        UserInfo user = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .readValue(json, UserInfo.class);
        assertNull(user.getRole());
    }
}

package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

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
        assertEquals("Acme Labs", user.getAffiliation());
        assertTrue(user.isEnabled());
        assertEquals(200L, user.getHomeFolderId());
    }

    @Test
    void testUserInfoIgnoresUnknownFields() throws IOException {
        UserInfo user = readFileToClass(fixture, UserInfo.class);
        // fixture has unknown fields if added in future — @JsonIgnoreProperties ensures no exception
        assertEquals("jsmith", user.getUsername());
    }
}

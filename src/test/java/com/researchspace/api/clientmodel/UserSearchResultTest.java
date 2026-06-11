package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class UserSearchResultTest extends AbstractModelTest {

    private final File fixture = new File("src/test/resources/UserSearchResult.json");

    @Test
    void testUserSearchResultDeserialisesFromFixture() throws IOException {
        UserSearchResult result = readFileToClass(fixture, UserSearchResult.class);
        assertEquals(1L, result.getTotalHits().longValue());
        assertEquals(0, result.getPageNumber().intValue());
        assertEquals(20, result.getPageSize().intValue());
        assertNotNull(result.getUsers());
        assertEquals(1, result.getUsers().size());

        UserInfo user = result.getUsers().get(0);
        assertEquals(1L, user.getId());
        assertEquals("U1", user.getGlobalId());
        assertEquals("jdoe", user.getUsername());
        assertEquals("jdoe@lab.org", user.getEmail());
        assertEquals("Jane", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(UserRole.ROLE_PI, user.getRole());
        assertEquals("Research Lab", user.getAffiliation());
        assertEquals(10L, user.getHomeFolderId());
    }
}

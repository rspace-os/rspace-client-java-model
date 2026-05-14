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
        assertEquals("admin", result.getUsers().get(0).getUsername());
    }
}

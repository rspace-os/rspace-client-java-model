package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class GroupSearchResultTest extends AbstractModelTest {

    private final File fixture = new File("src/test/resources/GroupSearchResult.json");

    @Test
    void testGroupSearchResultDeserialisesFromFixture() throws IOException {
        GroupSearchResult result = readFileToClass(fixture, GroupSearchResult.class);
        assertEquals(1L, result.getTotalHits().longValue());
        assertEquals(0, result.getPageNumber().intValue());
        assertEquals(20, result.getPageSize().intValue());
        assertNotNull(result.getGroups());
        assertEquals(1, result.getGroups().size());
        GroupInfo group = result.getGroups().get(0);
        assertEquals(10L, group.getId());
        assertEquals("GP10", group.getGlobalId());
        assertEquals("My Lab Group", group.getName());
        assertEquals("LAB_GROUP", group.getType());
    }
}

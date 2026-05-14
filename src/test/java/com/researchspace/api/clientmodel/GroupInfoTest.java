package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GroupInfoTest {

    private ObjectMapper om = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    @Test
    void testGroupInfoDeserialisation() throws IOException {
        String json = "{"
                + "\"id\":10,"
                + "\"globalId\":\"GP10\","
                + "\"name\":\"My Lab Group\","
                + "\"type\":\"LAB_GROUP\","
                + "\"sharedFolderId\":99,"
                + "\"members\":["
                + "  {\"id\":1,\"username\":\"pi_user\",\"role\":\"PI\"}"
                + "],"
                + "\"_links\":[]"
                + "}";
        GroupInfo group = om.readValue(json, GroupInfo.class);
        assertEquals(10L, group.getId());
        assertEquals("GP10", group.getGlobalId());
        assertEquals("My Lab Group", group.getName());
        assertEquals("LAB_GROUP", group.getType());
        assertEquals(99L, group.getSharedFolderId());
        assertEquals(1, group.getMembers().size());
        assertEquals("PI", group.getMembers().get(0).getRole());
        assertEquals(1L, group.getMembers().get(0).getId());
        assertEquals("pi_user", group.getMembers().get(0).getUsername());
    }

    @Test
    void testGroupInfoIgnoresUnknownFields() throws IOException {
        String json = "{"
                + "\"id\":5,"
                + "\"name\":\"Group\","
                + "\"futureField\":\"value\","
                + "\"members\":[]"
                + "}";
        GroupInfo group = om.readValue(json, GroupInfo.class);
        assertNotNull(group);
        assertEquals(5L, group.getId());
    }
}

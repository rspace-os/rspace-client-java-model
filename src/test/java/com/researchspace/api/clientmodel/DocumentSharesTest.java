package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class DocumentSharesTest {

    @Test
    void deserialiseFromFixture() throws Exception {
        try (InputStream is = getClass().getResourceAsStream("/DocumentShares.json")) {
            assertNotNull(is, "DocumentShares.json fixture not found");
            DocumentShares result = new ObjectMapper().readValue(is, DocumentShares.class);
            assertEquals(100L, result.getSharedDocId());
            assertEquals("My Document", result.getSharedDocName());
            assertEquals(1, result.getDirectShares().size());
            assertTrue(result.getNotebookShares().isEmpty());
            DocumentShareEntry entry = result.getDirectShares().get(0);
            assertEquals(1L, entry.getShareId());
            assertEquals("Smith Group", entry.getRecipientName());
            assertEquals("GROUP", entry.getRecipientType());
            assertEquals("READ", entry.getPermission());
        }
    }

    @Test
    void ignoresUnknownFields() throws Exception {
        String json = "{\"sharedDocId\":1,\"directShares\":[],\"notebookShares\":[],\"unknownFutureField\":\"x\"}";
        DocumentShares result = new ObjectMapper().readValue(json, DocumentShares.class);
        assertEquals(1L, result.getSharedDocId());
        assertTrue(result.getDirectShares().isEmpty());
    }

}

package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MoveRequestTest {

    @Test
    void testMoveRequestBuilder() {
        MoveRequest req = MoveRequest.builder()
                .recordId(42L)
                .sourceFolderId(10L)
                .targetFolderId(20L)
                .currentGrandparentId(5L)
                .reason("moving to new location")
                .build();

        assertEquals(42L, req.getRecordId());
        assertEquals(10L, req.getSourceFolderId());
        assertEquals(20L, req.getTargetFolderId());
        assertEquals(5L, req.getCurrentGrandparentId());
        assertEquals("moving to new location", req.getReason());
    }

    @Test
    void testMoveRequestSerialisesCorrectly() throws JsonProcessingException {
        MoveRequest req = MoveRequest.builder()
                .recordId(1L)
                .targetFolderId(2L)
                .build();
        String json = new ObjectMapper().writeValueAsString(req);
        // server API field is "docId"; @JsonProperty maps recordId → docId
        assertTrue(json.contains("\"docId\":1"), "Expected docId in JSON but got: " + json);
        assertTrue(json.contains("\"targetFolderId\":2"), "Expected targetFolderId in JSON but got: " + json);
    }

    @Test
    void testMoveRequestRoundtrip() throws IOException {
        MoveRequest original = MoveRequest.builder()
                .recordId(99L)
                .sourceFolderId(5L)
                .targetFolderId(7L)
                .reason("test move")
                .build();
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(original);
        MoveRequest deserialized = om.readValue(json, MoveRequest.class);
        assertEquals(original, deserialized);
    }
}

package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SharePermissionUpdateTest {

    @Test
    void roundTrip() throws Exception {
        SharePermissionUpdate req = SharePermissionUpdate.builder()
                .shareId(42L).permission("WRITE").build();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(req);
        SharePermissionUpdate result = mapper.readValue(json, SharePermissionUpdate.class);
        assertEquals(req, result);
    }

    @Test
    void noArgConstructorAndSetters() {
        SharePermissionUpdate req = new SharePermissionUpdate();
        req.setShareId(7L);
        req.setPermission("READ");
        assertEquals(7L, req.getShareId());
        assertEquals("READ", req.getPermission());
    }

}

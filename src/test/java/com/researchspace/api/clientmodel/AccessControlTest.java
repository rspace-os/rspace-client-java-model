package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessControlTest {
    
    private ObjectMapper objectMapper;
    
    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
    
    @Test
    void testAccessControlBuilder() {
        AccessControl accessControl = AccessControl.builder()
            .ownerPermissionType("WRITE")
            .groupPermissionType("READ") 
            .worldPermissionType("NONE")
            .build();
            
        assertNotNull(accessControl);
        assertEquals("WRITE", accessControl.getOwnerPermissionType());
        assertEquals("READ", accessControl.getGroupPermissionType());
        assertEquals("NONE", accessControl.getWorldPermissionType());
    }
    
    @Test
    void testAccessControlConstructors() {

        AccessControl ac1 = new AccessControl();
        assertNotNull(ac1);
        assertNull(ac1.getOwnerPermissionType());

        AccessControl ac2 = new AccessControl("WRITE", "READ", "NONE");
        assertEquals("WRITE", ac2.getOwnerPermissionType());
        assertEquals("READ", ac2.getGroupPermissionType());
        assertEquals("NONE", ac2.getWorldPermissionType());
    }
    
    @Test
    void testAccessControlSerialization() throws JsonProcessingException {
        AccessControl accessControl = new AccessControl("WRITE", "READ", "NONE");
        
        String json = objectMapper.writeValueAsString(accessControl);
        assertNotNull(json);
        assertTrue(json.contains("\"ownerPermissionType\":\"WRITE\""));
        assertTrue(json.contains("\"groupPermissionType\":\"READ\""));
        assertTrue(json.contains("\"worldPermissionType\":\"NONE\""));

        AccessControl deserialized = objectMapper.readValue(json, AccessControl.class);
        assertEquals("WRITE", deserialized.getOwnerPermissionType());
        assertEquals("READ", deserialized.getGroupPermissionType()); 
        assertEquals("NONE", deserialized.getWorldPermissionType());
    }
}
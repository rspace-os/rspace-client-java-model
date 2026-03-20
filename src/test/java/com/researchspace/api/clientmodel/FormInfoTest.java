package com.researchspace.api.clientmodel;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FormInfoTest extends AbstractModelTest {
    
    @Test
    void testFormInfoFromFormSearchResult() throws IOException {

        File formSearchResultJson = new File("src/test/resources/FormSearchResult.json");
        FormSearchResult formSearchResult = readFileToClass(formSearchResultJson, FormSearchResult.class);
        
        assertNotNull(formSearchResult.getForms());
        assertFalse(formSearchResult.getForms().isEmpty());
        
        FormInfo firstForm = formSearchResult.getForms().get(0);
        assertNotNull(firstForm);
        assertEquals(Long.valueOf(32785), firstForm.getId());
        assertEquals("FM32785", firstForm.getGlobalId());
        assertEquals("formName", firstForm.getName());
        assertEquals("a,b,c", firstForm.getTags());
        assertEquals(FormState.PUBLISHED, firstForm.getFormState());
        assertNotNull(firstForm.getAccessControl());
        assertEquals("WRITE", firstForm.getAccessControl().getOwnerPermissionType());
        assertEquals("NONE", firstForm.getAccessControl().getGroupPermissionType());
        assertEquals("NONE", firstForm.getAccessControl().getWorldPermissionType());
        assertEquals(Long.valueOf(-1), firstForm.getIconId());
    }
    
    @Test
    void testFormInfoBuilder() {
        AccessControl accessControl = AccessControl.builder()
            .ownerPermissionType("WRITE")
            .groupPermissionType("READ") 
            .worldPermissionType("NONE")
            .build();
            
        FormInfo formInfo = FormInfo.builder()
            .id(123L)
            .globalId("FM123")
            .name("Test Form")
            .stableId("stable123")
            .version(1)
            .tags("tag1,tag2")
            .formState(FormState.NEW)
            .accessControl(accessControl)
            .iconId(456L)
            .build();
            
        assertNotNull(formInfo);
        assertEquals(Long.valueOf(123), formInfo.getId());
        assertEquals("FM123", formInfo.getGlobalId());
        assertEquals("Test Form", formInfo.getName());
        assertEquals("stable123", formInfo.getStableId());
        assertEquals(Integer.valueOf(1), formInfo.getVersion());
        assertEquals("tag1,tag2", formInfo.getTags());
        assertEquals(FormState.NEW, formInfo.getFormState());
        assertEquals(accessControl, formInfo.getAccessControl());
        assertEquals(Long.valueOf(456), formInfo.getIconId());
    }
    
    @Test
    void testFormInfoConstructors() {

        FormInfo formInfo1 = new FormInfo();
        assertNotNull(formInfo1);
        assertNull(formInfo1.getId());

        AccessControl ac = new AccessControl("WRITE", "READ", "NONE");
        FormInfo formInfo2 = new FormInfo("stable", 1, FormState.PUBLISHED, ac, "tags", 123L);
        assertEquals("stable", formInfo2.getStableId());
        assertEquals(Integer.valueOf(1), formInfo2.getVersion());
        assertEquals(FormState.PUBLISHED, formInfo2.getFormState());
        assertEquals(ac, formInfo2.getAccessControl());
        assertEquals("tags", formInfo2.getTags());
        assertEquals(Long.valueOf(123), formInfo2.getIconId());
    }
}
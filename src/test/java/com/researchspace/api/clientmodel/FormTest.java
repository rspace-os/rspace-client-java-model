package com.researchspace.api.clientmodel;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FormTest extends AbstractModelTest {
    
    File formJson = new File("src/test/resources/Form.json");

    @Test
    void testFormDeserialization() throws IOException {
        Form form = readFileToClass(formJson, Form.class);
        
        assertNotNull(form);
        assertEquals(Long.valueOf(123), form.getId());
        assertEquals("FM123", form.getGlobalId());
        assertEquals("Sample Form", form.getName());
        assertEquals("tag1,tag2", form.getTags());
        assertEquals(FormState.PUBLISHED, form.getFormState());
        assertNotNull(form.getAccessControl());
        assertEquals("WRITE", form.getAccessControl().getOwnerPermissionType());

        assertNotNull(form.getFields());
        assertEquals(3, form.getFields().size());

        assertInstanceOf(StringFormField.class, form.getFields().get(0));
        assertInstanceOf(NumberFormField.class, form.getFields().get(1));
        assertInstanceOf(ChoiceFormField.class, form.getFields().get(2));
        
        StringFormField stringField = (StringFormField) form.getFields().get(0);
        assertEquals("Sample Text Field", stringField.getName());
        assertEquals("String", stringField.getType());
        assertEquals("default value", stringField.getDefaultValue());
        
        NumberFormField numberField = (NumberFormField) form.getFields().get(1);
        assertEquals("Sample Number Field", numberField.getName());
        assertEquals("Number", numberField.getType());
        assertEquals(Double.valueOf(10.5), numberField.getDefaultValue());
        assertEquals(Double.valueOf(0.0), numberField.getMin());
        assertEquals(Double.valueOf(100.0), numberField.getMax());
        
        ChoiceFormField choiceField = (ChoiceFormField) form.getFields().get(2);
        assertEquals("Sample Choice Field", choiceField.getName());
        assertEquals("Choice", choiceField.getType());
        assertEquals(3, choiceField.getOptions().size());
        assertEquals(2, choiceField.getDefaultOptions().size());
    }
    
    @Test 
    void testFormBuilder() {
        Form form = Form.builder()
            .id(456L)
            .name("Test Form")
            .tags("test,builder")
            .formState(FormState.NEW)
            .build();
            
        assertNotNull(form);
        assertEquals(Long.valueOf(456), form.getId());
        assertEquals("Test Form", form.getName());
        assertEquals("test,builder", form.getTags());
        assertEquals(FormState.NEW, form.getFormState());
        assertNotNull(form.getFields()); // Should be initialized as empty list
        assertTrue(form.getFields().isEmpty());
    }
    
    @Test
    void testAddField() {
        Form form = Form.builder().build();
        StringFormField field = new StringFormField("test", "default");
        
        form.addField(field);
        
        assertEquals(1, form.getFields().size());
        assertEquals(field, form.getFields().get(0));

        Form result = form.addField(new TextFormField("text", "text default"));
        assertSame(form, result);
        assertEquals(2, form.getFields().size());
    }
}
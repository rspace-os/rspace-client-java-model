package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FormFieldTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Test
    void testStringFormFieldSerialization() throws JsonProcessingException {
        StringFormField field = new StringFormField("Test String Field", "test default");
        field.setId(1L);
        field.setIndex(0);

        String json = objectMapper.writeValueAsString(field);
        assertNotNull(json);
        assertTrue(json.contains("\"type\":\"String\""));
        assertTrue(json.contains("\"defaultValue\":\"test default\""));

        FormField deserialized = objectMapper.readValue(json, FormField.class);
        assertInstanceOf(StringFormField.class, deserialized);
        StringFormField stringField = (StringFormField) deserialized;
        assertEquals("Test String Field", stringField.getName());
        assertEquals("test default", stringField.getDefaultValue());
    }

    @Test
    void testNumberFormFieldSerialization() throws JsonProcessingException {
        NumberFormField field = new NumberFormField("Test Number Field", 50.5, 0.0, 100.0, (byte) 2);
        field.setId(2L);
        field.setIndex(1);

        String json = objectMapper.writeValueAsString(field);
        assertNotNull(json);
        assertTrue(json.contains("\"type\":\"Number\""));
        assertTrue(json.contains("\"min\":0.0"));
        assertTrue(json.contains("\"max\":100.0"));

        FormField deserialized = objectMapper.readValue(json, FormField.class);
        assertInstanceOf(NumberFormField.class, deserialized);
        NumberFormField numberField = (NumberFormField) deserialized;
        assertEquals("Test Number Field", numberField.getName());
        assertEquals(Double.valueOf(50.5), numberField.getDefaultValue());
        assertEquals(Double.valueOf(0.0), numberField.getMin());
        assertEquals(Double.valueOf(100.0), numberField.getMax());
    }

    @Test
    void testChoiceFormFieldSerialization() throws JsonProcessingException {
        ChoiceFormField field = new ChoiceFormField("Test Choice Field", true,
                Arrays.asList("Option A", "Option B", "Option C"),
                Arrays.asList("Option A", "Option B"));
        field.setId(3L);
        field.setIndex(2);

        String json = objectMapper.writeValueAsString(field);
        assertNotNull(json);
        assertTrue(json.contains("\"type\":\"Choice\""));
        assertTrue(json.contains("\"multipleChoice\":true"));

        FormField deserialized = objectMapper.readValue(json, FormField.class);
        assertInstanceOf(ChoiceFormField.class, deserialized);
        ChoiceFormField choiceField = (ChoiceFormField) deserialized;
        assertEquals("Test Choice Field", choiceField.getName());
        assertTrue(choiceField.isMultipleChoice());
        assertEquals(3, choiceField.getOptions().size());
        assertEquals(2, choiceField.getDefaultOptions().size());
    }

    @Test
    void testDateFormFieldSerialization() throws JsonProcessingException {
        Date defaultDate = new Date(1640995200000L); // 2022-01-01
        Date minDate = new Date(1609459200000L);     // 2021-01-01
        Date maxDate = new Date(1672531200000L);     // 2023-01-01

        DateFormField field = new DateFormField("Test Date Field", defaultDate, minDate, maxDate);
        field.setId(4L);
        field.setIndex(3);

        String json = objectMapper.writeValueAsString(field);
        assertNotNull(json);
        assertTrue(json.contains("\"type\":\"Date\""));

        FormField deserialized = objectMapper.readValue(json, FormField.class);
        assertInstanceOf(DateFormField.class, deserialized);
        DateFormField dateField = (DateFormField) deserialized;
        assertEquals("Test Date Field", dateField.getName());
        assertNotNull(dateField.getDefaultValue());
        assertNotNull(dateField.getMin());
        assertNotNull(dateField.getMax());
    }

    @Test
    void testTimeFormFieldSerialization() throws JsonProcessingException {
        long defaultTime = 3600000L;
        TimeFormField field = new TimeFormField("Test Time Field", defaultTime);
        field.setId(7L);
        field.setIndex(6);
        String json = objectMapper.writeValueAsString(field);
        assertNotNull(json);
        assertTrue(json.contains("\"type\":\"Time\""));
        assertTrue(json.contains("\"defaultValue\":" + defaultTime));
        FormField deserialized = objectMapper.readValue(json, FormField.class);
        assertInstanceOf(TimeFormField.class, deserialized);
        TimeFormField timeField = (TimeFormField) deserialized;
        assertEquals("Test Time Field", timeField.getName());
        assertEquals(defaultTime, timeField.getDefaultValue());
    }

    @Test
    void testConstructors() {
        StringFormField stringField = new StringFormField("String Test", "default");
        assertEquals("String Test", stringField.getName());
        assertEquals("String", stringField.getType());
        assertEquals("default", stringField.getDefaultValue());
    }
}
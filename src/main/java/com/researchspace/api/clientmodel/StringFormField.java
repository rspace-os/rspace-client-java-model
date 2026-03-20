package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * A String form field - for short text input (max 255 characters).
 * @author rspace
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@JsonPropertyOrder(value = {"id", "globalId", "name", "type", "lastModified", "index", "defaultValue"})
public class StringFormField extends FormField {

    private String defaultValue;
    
    public StringFormField(String name, String defaultValue) {
        super();
        setName(name);
        setType("String");
        this.defaultValue = defaultValue;
    }
}
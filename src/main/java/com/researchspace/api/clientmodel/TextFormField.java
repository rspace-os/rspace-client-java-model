package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * A Text form field - for longer text input that can include HTML.
 * @author rspace
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@JsonPropertyOrder(value = {"id", "globalId", "name", "type", "lastModified", "index", "defaultValue"})
public class TextFormField extends FormField {

    private String defaultValue;
    
    public TextFormField(String name, String defaultValue) {
        super();
        setName(name);
        setType("Text");
        this.defaultValue = defaultValue;
    }
}
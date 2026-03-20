package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * A Time form field - for time input values stored as milliseconds.
 * @author rspace
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@JsonPropertyOrder(value = {"id", "globalId", "name", "type", "lastModified", "index", "defaultValue"})
public class TimeFormField extends FormField {

    private Long defaultValue;
    
    public TimeFormField(String name, Long defaultValue) {
        super();
        setName(name);
        setType("Time");
        this.defaultValue = defaultValue;
    }
}
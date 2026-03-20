package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.researchspace.api.jackson.ISO8601DateSerialiser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * A Date form field - defines a DateField.
 * @author rspace
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@JsonPropertyOrder(value = {"id", "globalId", "name", "type", "lastModified", "index", 
    "defaultValue", "min", "max"})
public class DateFormField extends FormField {
    

    @JsonSerialize(using = ISO8601DateSerialiser.class)
    private Date defaultValue;
    @JsonSerialize(using = ISO8601DateSerialiser.class)
    private Date min;

    @JsonSerialize(using = ISO8601DateSerialiser.class)
    private Date max;
    
    public DateFormField(String name, Date defaultValue, Date min, Date max) {
        super();
        setName(name);
        setType("Date");
        this.defaultValue = defaultValue != null ? new Date(defaultValue.getTime()) : null;
        this.min = min != null ? new Date(min.getTime()) : null;
        this.max = max != null ? new Date(max.getTime()) : null;
    }
}
package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;

/**
 * A Number form field - for numeric input with constraints.
 * @author rspace
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@JsonPropertyOrder(value = {"id", "globalId", "name", "type", "lastModified", "index", 
    "min", "max", "decimalPlaces", "defaultValue"})
public class NumberFormField extends FormField {
    private Double min;
    private Double max;
    @Min(0)
    private Byte decimalPlaces;
    private Double defaultValue;
    
    public NumberFormField(String name, Double defaultValue, Double min, Double max, Byte decimalPlaces) {
        super();
        setName(name);
        setType("Number");
        this.defaultValue = defaultValue;
        this.min = min;
        this.max = max;
        this.decimalPlaces = decimalPlaces;
    }
}
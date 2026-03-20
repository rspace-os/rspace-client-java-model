package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * A Form. A complete form definition including field definitions.
 * @author rspace
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@JsonPropertyOrder(value = {
    "id", "globalId", "stableId", "version", "name", "tags", 
    "formState", "accessControl", "fields", "_links"
})
public class Form extends FormInfo {

    @Builder.Default
    private List<FormField> fields = new ArrayList<>();
    
    /**
     * Adds a field to this form
     * @param field the FormField to add
     * @return this Form for method chaining
     */
    public Form addField(FormField field) {
        if (this.fields == null) {
            this.fields = new ArrayList<>();
        }
        this.fields.add(field);
        return this;
    }
}
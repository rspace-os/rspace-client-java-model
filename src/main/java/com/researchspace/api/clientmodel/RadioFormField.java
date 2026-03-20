package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * A Radio form field defines a list of radio buttons, one of which can be selected by default.
 * @author rspace
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@JsonPropertyOrder(value = {"id", "globalId", "name", "type", "lastModified", "index", 
    "options", "defaultOption"})
public class RadioFormField extends FormField {

    @Size(min = 1, message = "Please provide at least one option")
    @Builder.Default
    private List<String> options = new ArrayList<>();
    private String defaultOption;
    
    public RadioFormField(String name, List<String> options, String defaultOption) {
        super();
        setName(name);
        setType("Radio");
        this.options = options != null ? options : new ArrayList<>();
        this.defaultOption = defaultOption;
    }
}
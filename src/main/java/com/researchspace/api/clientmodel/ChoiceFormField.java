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
 * A Choice form field defines a list of checkboxes, some of which can be selected by default.
 * @author rspace
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@JsonPropertyOrder(value = {"id", "globalId", "name", "type", "lastModified", "index", 
    "multipleChoice", "options", "defaultOptions"})
public class ChoiceFormField extends FormField {

    private boolean multipleChoice;
    @Size(min = 1, message = "Please provide at least one option")
    @Builder.Default
    private List<String> options = new ArrayList<>();
    @Builder.Default
    private List<String> defaultOptions = new ArrayList<>();
    
    public ChoiceFormField(String name, boolean multipleChoice, List<String> options, List<String> defaultOptions) {
        super();
        setName(name);
        setType("Choice");
        this.multipleChoice = multipleChoice;
        this.options = options != null ? options : new ArrayList<>();
        this.defaultOptions = defaultOptions != null ? defaultOptions : new ArrayList<>();
    }
}
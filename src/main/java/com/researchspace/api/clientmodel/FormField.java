package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

/**
 * A FormField definition. This is an abstract type for all form field types.
 * The properties listed here are common to all types.
 * @author rspace
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonTypeInfo(
        use = Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
    @Type(value = ChoiceFormField.class, name = "Choice"),
    @Type(value = TextFormField.class, name = "Text"),
    @Type(value = StringFormField.class, name = "String"),
    @Type(value = NumberFormField.class, name = "Number"),
    @Type(value = RadioFormField.class, name = "Radio"),
    @Type(value = DateFormField.class, name = "Date"),
    @Type(value = TimeFormField.class, name = "Time"),
})
@JsonPropertyOrder(value = {"id", "globalId", "name", "type", "lastModified", "index"})
public abstract class FormField extends IdentifiableNameable {

    @JsonProperty("lastModified")
    private String lastModifiedMillis;
    private Integer index;
    @JsonProperty("type")
    private String type;
}
package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagInfo {
    @JsonProperty("value")
    private String value;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("ontologyName")
    private String ontologyName;

    @JsonProperty("ontologyVersion")
    private String ontologyVersion;
}

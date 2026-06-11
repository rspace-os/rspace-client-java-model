package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A single share entry within a {@link DocumentShares} response.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentShareEntry {

    private Long shareId;
    private Long sharerId;
    private String sharerName;
    private Long recipientId;
    private String recipientName;
    private String recipientType;
    private String permission;
    private Long parentId;
    private String path;
    private Long grandparentId;

}

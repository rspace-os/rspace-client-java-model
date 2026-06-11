package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request to move a document or notebook to a target folder.
 * The server API field name is {@code docId}; the Java field is {@code recordId}.
 *
 * @since 1.98.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoveRequest {

    @JsonProperty("docId")
    private Long recordId;
    private long sourceFolderId;
    private Long targetFolderId;
    private Long currentGrandparentId;
    private String reason;
}
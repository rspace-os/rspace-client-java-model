package com.researchspace.api.clientmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request to move a document or notebook to a target folder
 *
 * @author rspac
 * @since 1.98.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoveRequest {

    private Long recordId;
    private long sourceFolderId;
    private Long targetFolderId;
    private Long currentGrandparentId;
    private String reason;
}
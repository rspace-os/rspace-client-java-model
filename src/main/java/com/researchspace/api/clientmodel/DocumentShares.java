package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Response for GET /share/document/{id} — all shares for a document, notebook or snippet.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentShares {

    private Long sharedDocId;
    private String sharedDocName;
    private List<DocumentShareEntry> directShares = new ArrayList<>();
    private List<DocumentShareEntry> notebookShares = new ArrayList<>();

}

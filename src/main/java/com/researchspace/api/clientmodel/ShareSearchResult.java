package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ShareSearchResult
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShareSearchResult extends PaginatedResultList {

    private List<ApiShareInfo> shares = new ArrayList<>();

}

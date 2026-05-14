package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Paginated list of groups returned by the sysadmin group-listing endpoint.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupSearchResult extends PaginatedResultList {
    private List<GroupInfo> groups = new ArrayList<>();
}

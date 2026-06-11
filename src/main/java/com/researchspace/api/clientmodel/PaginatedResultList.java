package com.researchspace.api.clientmodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Common fields for paginated API search results.
 */
@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public abstract class PaginatedResultList extends Linkable {
    private Long totalHits = null;
    private Integer pageNumber = null;
    private Integer pageSize = null;
}

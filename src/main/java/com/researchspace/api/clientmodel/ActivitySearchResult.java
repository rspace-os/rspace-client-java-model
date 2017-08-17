
package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

/**
 * ActivitySearchResults
 */
@Value
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class ActivitySearchResult extends PaginatedResultList {

    private List<Activity> activities = new ArrayList<>();

}

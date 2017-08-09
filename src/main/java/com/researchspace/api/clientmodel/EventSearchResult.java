
package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

/**
 * DocumentSearchResults
 */
@Value
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class EventSearchResult extends PaginatedResultList {

    private List<Event> events = new ArrayList<>();

}

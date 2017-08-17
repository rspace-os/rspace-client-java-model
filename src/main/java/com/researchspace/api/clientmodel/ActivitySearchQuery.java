package com.researchspace.api.clientmodel;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

/**
 * Uses a Builder pattern to construct queries, e.g. 
 * <pre>
 * Date from = getDateFrom();
 * EventSearchQuery query = EventSearchQuery.builder()
       .user("user1")
       .user("user2")
       .dateFrom(from).build
 * </pre>
 * 
 * @author rspace
 * @since 1.2
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivitySearchQuery {
	@Singular
	private List<ActivityDomain> domains;
	
	@Singular
	private List<ActivityAction> actions;
	
	@Singular
	private List<String> usernames;
	
	private String oid;
	
	private Date dateFrom;
	
	private Date dateTo;
}

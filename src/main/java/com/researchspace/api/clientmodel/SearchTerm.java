package com.researchspace.api.clientmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchTerm {
	/**
	 * The query term
	 */
	private String query;

	private QueryType queryType;
	/**
	 * Simple static factory for SearchTerms
	 * @param query The query string
	 * @param queryType The {@link QueryType}
	 * @return A {@link SearchTerm}
	 */
	public static SearchTerm createTerm (String query, QueryType queryType) {
		return new SearchTerm(query, queryType);
	}
	
	/**
	 * Simple static factory for SearchTerms using default QueryType.GLOBAL which searches all content
	 * @param query The query string
	 * @return A {@link SearchTerm}
	 */
	public static SearchTerm createTerm (String query) {
		return new SearchTerm(query, QueryType.GLOBAL);
	}

}

package com.researchspace.api.clientmodel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

/**
 * Uses a Builder pattern to construct queries, e.g. 
 * <pre>
 * DocumentSearchQuery query2 = DocumentSearchQuery.builder()
 *      .operator(SearchOperator.AND) // this is the default.
       .term(createTerm("default All query"))
       .term(createTerm("pcr", QueryType.TAG)).build();
 * </pre>
 * 
 * @author rspace
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentSearchQuery {
	/**
	 * AND is the  default if not set
	 */
	@Builder.Default
	private SearchOperator operator = SearchOperator.AND;
	
	@Singular
	private List<SearchTerm> terms;

}

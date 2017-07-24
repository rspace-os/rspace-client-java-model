package com.researchspace.api.clientmodel;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
/**
 * Models the request body of a /documents POST request
 * @author rspace
 *
 */
@Data
@Builder
public class DocumentPost {

	private String tags;	
	private String name;
	@Singular
	private List<FieldPost> fields;
	
	/**
	 * Appends a {@link FieldPost} to the list of Fields
	 * @param toAdd
	 * @return
	 */
	public boolean addField(FieldPost toAdd) {
		return fields.add(toAdd);
	}
}

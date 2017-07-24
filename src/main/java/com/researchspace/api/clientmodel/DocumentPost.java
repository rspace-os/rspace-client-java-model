package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
/**
 * Models the request body of a /documents POST request
 * @author rspace
 * @since 1.1.0
 *
 */
@Data
@Builder
public class DocumentPost {

	/**
	 * Comma separated tags
	 */
	private String tags;
	/**
	 * name of document
	 */
	private String name;
	@Singular
	private List<FieldPost> fields;
	
	private FormRef form;
	
	/**
	 * Appends a {@link FieldPost} to the list of Fields
	 * @param toAdd
	 * @return
	 */
	public boolean addField(FieldPost toAdd) {
		if(fields == null) {
			fields = new ArrayList<>();
		}
		return fields.add(toAdd);
	}
}

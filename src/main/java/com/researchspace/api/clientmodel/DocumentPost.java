package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
/**
 * Models the request body of a /documents POST request. All content is optional.
 * If a form ID is set then the field content must match the field types defined by the Form
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
	 * @param toAdd a {@link FieldPost}
	 * @return <code>true</code> if added, <code>false</code> otherwise
	 */
	public boolean addField(FieldPost toAdd) {
		if(fields == null) {
			fields = new ArrayList<>();
		}
		return fields.add(toAdd);
	}
}

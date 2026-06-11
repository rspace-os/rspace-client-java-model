package com.researchspace.api.clientmodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Extends FieldPost with a field Id property to specify the Field whose content is to be updated.
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class FieldPut extends FieldPost {
	/**
	 * Cannot be null
	 */
	@NonNull
	private Long id;

	/** Constructor for updating a specific field by ID only (content left as default). */
	public FieldPut(Long id) {
		this.id = id;
	}

	/** Constructor for updating the content of a specific field by ID. */
	public FieldPut(String content, Long id) {
		super(content);
		this.id = id;
	}

}

package com.researchspace.api.clientmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldPost {

	private static final String FILE_REF_TEMPLATE = "<fileId=%d/>";

	/**
	 * Convenience method to return a FieldPost with empty content
	 * 
	 * @return
	 */
	public static FieldPost emptyField() {
		return new FieldPost("");
	}

	private String content = "";

	/**
	 * Adds a reference to the file identified by <code>fileId</code> to the 
	 *  content of the field.
	 * @param fileId
	 * @return the altered content
	 */
	public String appendFileReference(Long fileId) {
		this.content =  content + generateFileRef(fileId);
		return content;
	}

	private String generateFileRef(Long fileId) {
		return String.format(" " + FILE_REF_TEMPLATE, fileId);
	}

}

package com.researchspace.api.clientmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Field content when creating or updating a Document.
 * @author rspace
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldPost {

	private static final String FILE_REF_TEMPLATE = "<fileId=%d>";

	/**
	 * Convenience method to return a FieldPost with empty content.
	 * 
	 * @return A new {@link FieldPost} with empty content.
	 */
	public static FieldPost emptyField() {
		return new FieldPost("");
	}

	private String content = "";

	/**
	 * Adds a reference to the file identified by <code>fileId</code> to the 
	 *  content of the field.
	 * @param fileId the id of the media element to link
	 * @return the altered content
	 */
	public String appendFileReference(Long fileId) {
		this.content =  content + generateFileRef(fileId);
		return content;
	}
	
	/**
	 * Appends content to this field
	 * @param contentToAppend The content to append to the  current content.
	 * @return the altered content
	 */
	public String appendContent(String contentToAppend) {
		this.content =  content + contentToAppend;
		return content;
	}

	private String generateFileRef(Long fileId) {
		return String.format(" " + FILE_REF_TEMPLATE, fileId);
	}

}

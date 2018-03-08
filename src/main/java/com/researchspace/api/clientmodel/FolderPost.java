package com.researchspace.api.clientmodel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FolderPost {
	/**
	 * The name of the folder or notebook to be created
	 */
	private String name;
	/**
	 * <code>true</code> if creating a notebook, <code>false</code>otherwise.
	 */
	private Boolean notebook;
	/**
	 * An id for the folder in which to create the notebook.
	 */
	private Long parentFolderId;

}

package com.researchspace.api.clientmodel;

/**
 * Query type for advanced queries
 * 
 * @author rspace
 *
 */
public enum QueryType {
	/**
	 * Searches all categories
	 */
	GLOBAL("global"),
	/**
	 * Searches full text of documents and attached text files
	 */
	FULL_TEXT("fullText"),
	/**
	 * Searches tags
	 */
	TAG("tag"),
	/**
	 * Searches document and attachment names
	 */
	NAME("name"),
	/**
	 * Search by creation date range
	 */
	CREATED("created"),
	/**
	 * LAst modification date range
	 */
	LAST_MODIFIED("lastModified"),
	/**
	 * Search for documents created using a form
	 */
	FORM("form"),
	/**
	 * Searches text of attached text files
	 */
	ATTACHMENT("attachment"),
	/**
	 * Searches for documents created by user with given username
	 */
	OWNER("owner");

	private String value;

	QueryType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}

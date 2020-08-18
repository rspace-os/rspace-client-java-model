package com.researchspace.api.clientmodel;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public class SelectionExportPost extends AbstractExportPost {

	private List<Long> ids = new ArrayList<Long>();

	/**
	 * 
	 * @param exportFormat
	 * @param ids          a list of ids to export
	 * @since 1.62
	 */
	public SelectionExportPost(ExportFormat exportFormat, List<Long> ids) {
		super(ExportScope.SELECTION, exportFormat);
		this.ids = ids;
	}

	/**
	 * 
	 * @param exportFormat
	 * @since 1.62
	 */
	public SelectionExportPost(ExportFormat exportFormat) {
		super(ExportScope.SELECTION, exportFormat);
	}

	/**
	 * Appends Id to list to export
	 * 
	 * @param id
	 */
	public void addId(Long id) {
		ids.add(id);
	}

	/**
	 * Gets Ids as comma-separated string
	 * 
	 * @return
	 */
	public String toRequestString() {
		return ids.stream().map(id -> id + "").collect(joining(","));
	}

}

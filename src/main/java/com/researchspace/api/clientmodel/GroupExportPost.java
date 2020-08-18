package com.researchspace.api.clientmodel;

import lombok.Getter;

@Getter
public class GroupExportPost extends AbstractExportPost {
	
	private Long groupId;
	
	/**
	 * 
	 * @param exportFormat
	 * @param groupId optional group ID if exporting another group
	 * @since 1.62
	 */
	public  GroupExportPost(ExportFormat exportFormat, Long groupId) {
		super(ExportScope.GROUP, exportFormat);
		this.groupId = groupId;
	}

}

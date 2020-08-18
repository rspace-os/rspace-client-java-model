package com.researchspace.api.clientmodel;

import lombok.Getter;

@Getter
public class UserExportPost extends AbstractExportPost {
	
	private Long userId;
	
	public  UserExportPost(ExportFormat exportFormat, Long userId) {
		super(ExportScope.USER, exportFormat);
		this.userId = userId;
	}

}

package com.researchspace.api.clientmodel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FolderPost {
	
	private String name;
	private Boolean notebook;

}

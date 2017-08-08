package com.researchspace.api.clientmodel;

import java.io.File;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class FilePost {

	@NonNull
	private File file;
	private Long folderId;
	private String caption;
	
}

package com.researchspace.api.clientmodel;

import java.io.File;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class FileUpdatePost {

	@NonNull
	private File file;
	/**
	 * The id of the RSpace file to replace.
	 */
	private Long rspaceFileId;
}

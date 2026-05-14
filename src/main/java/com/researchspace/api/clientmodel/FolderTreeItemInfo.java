package com.researchspace.api.clientmodel;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *Item returned from a folders/tree listing
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class FolderTreeItemInfo extends IdentifiableNameable {
	
	private Date created = null;

	private Date lastModified = null;
	
	private Long parentFolderId;
	
	private User owner = null;
		
	private String type = null;
	
}

package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class FolderTreeItemListing extends PaginatedResultList  {
	
	/**
	 * The id of the containing folder of this list
	 */
	private Long parentId;

	@JsonProperty("records")
	private List<FolderTreeItemInfo> records = new ArrayList<>();

}


package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderTreeItemListing extends PaginatedResultList  {
	
	/**
	 * The id of the containing folder of this list
	 */
	private Long parentId;

	@JsonProperty("records")
	private List<FolderTreeItemInfo> records = new ArrayList<>();

}


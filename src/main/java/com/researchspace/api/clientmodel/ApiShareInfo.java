package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 * Information about resource generated after sharing a single item with a single sharee (user or group)
 * @author rspace
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonPropertyOrder(value={"id", "sharedItemId", "sharedTargetType", "permission", })
public class ApiShareInfo  {
	
	private Long id, sharedItemId;
	private String sharedTargetType, permission;


}

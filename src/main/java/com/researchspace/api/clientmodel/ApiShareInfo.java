package com.researchspace.api.clientmodel;



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
public class ApiShareInfo  {
	
	private Long id, sharedItemId,sharedItemName;
	private String sharedTargetType, permission;


}

package com.researchspace.api.clientmodel;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiShareInfo  {

	private Long id;
	private Long sharedItemId;
	private String sharedItemName;
	private String sharedTargetType;
	private String permission;


}

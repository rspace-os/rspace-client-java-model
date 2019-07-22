package com.researchspace.api.clientmodel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

/**
 * Data structure for posting to create a new group.
 * <br>
 * There must be &gt;= 1 PI user in the list of UserGroupPost objects
 * @author rspace
 * @since 1.5.4
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public  class GroupPost {
	
	private String displayName;

	@Singular
	private List<UserGroupPost> users;
}
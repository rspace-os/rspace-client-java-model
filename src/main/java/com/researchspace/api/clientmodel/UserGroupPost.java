package com.researchspace.api.clientmodel;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Defines the role in a group for a group member
 * @author rspace
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGroupPost {
	
	public static enum RoleInGroup {
		DEFAULT,
		RS_LAB_ADMIN,
		PI,
		GROUP_OWNER
	}
	
	private String username;
	private RoleInGroup roleInGroup;

}

package com.researchspace.api.clientmodel;


import org.junit.jupiter.api.Test;

import com.researchspace.api.clientmodel.UserGroupPost.RoleInGroup;

public class GroupPostTest {

	@Test
	public void groupPostUsage() {
		UserPost userPost = UserPost.builder().username("pi")
				.email("email").password("password")
				.firstName("first").lastName("last")
				.role(UserRole.ROLE_PI).build();
		// create user, then can create group.
		
		GroupPost grpPost = GroupPost.builder().displayName("groupName").type(GroupType.LAB_GROUP)
		   .user(UserGroupPost.builder().username("pi").roleInGroup(RoleInGroup.PI).build())
		   .user(UserGroupPost.builder().username("pi").roleInGroup(RoleInGroup.RS_LAB_ADMIN).build())
		   .build();
	}
}

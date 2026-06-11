package com.researchspace.api.clientmodel;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.researchspace.api.clientmodel.UserGroupPost.RoleInGroup;

public class GroupPostTest {

	@Test
	public void groupPostUsage() {
		UserPost userPost = UserPost.builder().username("pi")
				.email("email").password("password")
				.firstName("first").lastName("last")
				.role(UserRole.ROLE_PI).build();
		assertEquals("pi", userPost.getUsername());
		assertEquals(UserRole.ROLE_PI, userPost.getRole());

		GroupPost grpPost = GroupPost.builder().displayName("groupName").type(GroupType.LAB_GROUP)
		   .user(UserGroupPost.builder().username("pi").roleInGroup(RoleInGroup.PI).build())
		   .user(UserGroupPost.builder().username("pi").roleInGroup(RoleInGroup.RS_LAB_ADMIN).build())
		   .build();
		assertEquals("groupName", grpPost.getDisplayName());
		assertEquals(GroupType.LAB_GROUP, grpPost.getType());
		assertEquals(2, grpPost.getUsers().size());
		assertEquals(RoleInGroup.PI, grpPost.getUsers().get(0).getRoleInGroup());
		assertEquals(RoleInGroup.RS_LAB_ADMIN, grpPost.getUsers().get(1).getRoleInGroup());
	}
}

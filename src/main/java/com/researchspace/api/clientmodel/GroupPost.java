package com.researchspace.api.clientmodel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public  class GroupPost {
	
	private String displayName;

	@Singular
	private List<UserGroupPost> users;
}
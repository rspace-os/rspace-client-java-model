package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@ToString(callSuper=true)
public class GroupInfo extends IdentifiableNameable{
	
	private String type;
	private Long sharedFolderId;
	private List<UserGroupInfo> members = new ArrayList<>();

}

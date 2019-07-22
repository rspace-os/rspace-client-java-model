package com.researchspace.api.clientmodel;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * For creating new users. 
 * <br>
 * username, email, password, firstNname and lastName are mandatory.
 * @author rspace
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public  class UserPost {
	
	private String username;
	@Size(min=8)
	private String password;
	
	private String email;
	@Size(min=1)
	private String firstName;
	@Size(min=1)
	private String lastName;

	private UserRole role;
	
	@Size(min=1)
	private String affiliation;
	
	@Size(min = 16, max = 32)
	private String apiKey;
	/**
	 * Whether or not to create a group up-front for a PI user.
	 */
	@Builder.Default
	private boolean createGroupForPi = false;
	
}


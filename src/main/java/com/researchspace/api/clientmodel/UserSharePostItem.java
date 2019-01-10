package com.researchspace.api.clientmodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSharePostItem {

	@NotNull(message="Must specify id of the user")
	@Min(1)
	private Long id;
	
	@Pattern(regexp = "(READ|EDIT|read|edit)")
	private String permission;

}

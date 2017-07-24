package com.researchspace.api.clientmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldPost {
	
	/**
	 * Convenience method to return an empty FieldPost
	 * @return
	 */
	public static FieldPost emptyField () {
		return new FieldPost("");
	}
	
	private String content="";

}

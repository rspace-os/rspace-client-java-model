package com.researchspace.api.clientmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
/**
 * Extends FieldPost with a field Id property to specify the Field whose content is to be updated. 
 * @author rspace
 *
 */
public class FieldPut extends FieldPost {
	/**
	 * Optional content, can be empty.
	 */
	private String content="";
	/**
	 * Cannot be null
	 */
	@NonNull
	private Integer id;	

}

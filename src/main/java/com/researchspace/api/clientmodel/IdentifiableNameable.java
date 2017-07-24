package com.researchspace.api.clientmodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public abstract class IdentifiableNameable extends Linkable {
	private Long id = null;
	private String globalId = null;
	private String name = null;
}

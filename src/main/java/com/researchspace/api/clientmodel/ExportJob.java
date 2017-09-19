package com.researchspace.api.clientmodel;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
/**
 * An export job
 * @author rspace
 * @since 1.3
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Setter(value=AccessLevel.PACKAGE)
public class ExportJob extends Job {
	
	private  ExportJobResult result;

	@Override
	public ExportJobResult getResult() {
		return result;
	}

}

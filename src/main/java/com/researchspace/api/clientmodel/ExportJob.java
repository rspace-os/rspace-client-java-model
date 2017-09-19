package com.researchspace.api.clientmodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * An export job
 * @author rspace
 * @since 1.3
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class ExportJob extends Job {
	
	private  ExportJobResult result;

	@Override
	public ExportJobResult getResult() {
		return result;
	}

}

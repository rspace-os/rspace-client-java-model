package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * An export job
 * @author rspace
 * @since 1.3
 */
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExportJob extends Job {
	
	private  ExportJobResult result;

	@Override
	public ExportJobResult getResult() {
		return result;
	}

}

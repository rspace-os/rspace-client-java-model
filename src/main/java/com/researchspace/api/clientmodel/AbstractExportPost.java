package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractExportPost {
	
	private ExportScope scope = ExportScope.USER;
	private ExportFormat format =  ExportFormat.HTML;
	
	@JsonIgnore
	public String getScopeAsString() {
		return scope.name().toLowerCase();
	}

	@JsonIgnore
	public String getFormatAsString() {
		return format.name().toLowerCase();
	}


}

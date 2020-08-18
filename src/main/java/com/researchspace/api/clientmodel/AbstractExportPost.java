package com.researchspace.api.clientmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractExportPost {
	
	private ExportScope scope = ExportScope.USER;
	private ExportFormat format =  ExportFormat.HTML;


}

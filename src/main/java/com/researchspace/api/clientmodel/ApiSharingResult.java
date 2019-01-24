package com.researchspace.api.clientmodel;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor

public class ApiSharingResult  {

	private List<ApiShareInfo> shareInfos;
	private List<Long> failedShares;
	public ApiSharingResult(List<ApiShareInfo> shared, List<Long> failed) {
		this.shareInfos = shared;
		this.failedShares = failed;
	}

}

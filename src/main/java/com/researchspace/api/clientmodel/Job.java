package com.researchspace.api.clientmodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 
 * @author rspace
 * @since 1.3
 */
@Data
@EqualsAndHashCode(callSuper=true)
public abstract class Job  extends Linkable {
	
	private Long id;
	private String status;
	/**
	 * requires 1.69.19
	 */
	private float percentComplete;
	
	/**
	 * Job completed successfully
	 * @return <code>true</code> if completed successfully, <code>false</code> otherwise
	 */
	public boolean isCompleted() {
		return "COMPLETED".equals(status);
	}
	/**
	 * Job is terminated; either COMPLETED, FAILED or ABANDONED
	 * @return <code>true</code> if terminated, <code>false</code> otherwise
	 */
	public boolean isTerminated() {
		return isCompleted() || isFailed();
	}

	/**
	 * Job is terminated with failure
	 * @return <code>true</code> if terminated with failure, <code>false</code> otherwise
	 */
	public boolean isFailed() {
		return "ABANDONED".equals(status) || "FAILED".equals(status);
	}	
	
	public abstract Result getResult();
}

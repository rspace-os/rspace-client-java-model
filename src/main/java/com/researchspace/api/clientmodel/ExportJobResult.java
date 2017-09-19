package com.researchspace.api.clientmodel;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * An export job result
 * @author rspace
 * @since 1.3
 *
 */
@Data
public class ExportJobResult implements Result {
	
	private String checksum;
	private String algorithm;
	private Long size;
	/**
	 * An expiry time after which the result may no longer be acce
	 */
	private Date expiryDate;

}

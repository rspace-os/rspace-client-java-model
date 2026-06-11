package com.researchspace.api.clientmodel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * An export job result
 * @author rspace
 * @since 1.3
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExportJobResult implements Result {
	
	private String checksum;
	private String algorithm;
	private Long size;
	/**
	 * An expiry time after which the result may no longer be acce
	 */
	private Date expiryDate;

}

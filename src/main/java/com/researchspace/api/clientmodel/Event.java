package com.researchspace.api.clientmodel;

import java.util.Date;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 
 * @author rspace
 * @since 1.2
 */
@Data
@EqualsAndHashCode(of={"timestamp", "username", "domain","actions"})

public class Event {

	private Date timestamp;
	private String username;
	private String fullName;
	private EventDomain domain;
	private EventAction actions;
	private Map<String, Object> payload;
}

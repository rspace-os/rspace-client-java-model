package com.researchspace.api.clientmodel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
/**
 * Serialises a long millis-since-epoch to simple ISO date format with no time.
 * @author rspace
 *
 */
public class ISO8601DateSerialiser extends StdSerializer<Date> {
	
    static final String ISO8601_FORMAT_DATE = "yyyy-MM-dd";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ISO8601DateSerialiser() {
		this(null);
	}

	public ISO8601DateSerialiser(Class<Date> t) {
		super(t);
	}

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {	
		SimpleDateFormat iso8601 = new SimpleDateFormat(ISO8601_FORMAT_DATE);
		
		 gen.writeString(iso8601.format(value));
	}

}

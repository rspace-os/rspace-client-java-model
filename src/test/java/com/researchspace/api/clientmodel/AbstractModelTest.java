package com.researchspace.api.clientmodel;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public abstract class AbstractModelTest {

	<T> T readFileToClass(File jsonFile, Class<T> clazz) throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper reader = new ObjectMapper();
		reader.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		reader.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		reader.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// Uses Enum.toString() for deserialization of an Enum
		T d = reader.readValue(jsonFile, clazz);
		return d;
	}
}

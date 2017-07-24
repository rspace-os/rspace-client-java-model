package com.researchspace.api.clientmodel;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractModelTest {
	
	 <T> T readFileToClass(File jsonFile, Class<T> clazz) throws IOException, JsonParseException, JsonMappingException {
			ObjectMapper reader =new ObjectMapper();
			T d = reader.readValue(jsonFile,clazz);
			return d;
		}

}

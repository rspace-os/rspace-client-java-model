package com.researchspace.api.clientmodel;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DocumentTest {
	
	File documentJson = new File("src/test/resources/Document.json");

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper reader =new ObjectMapper();
		Document d = reader.readValue(documentJson, Document.class);
		System.err.println(d);
	}

}

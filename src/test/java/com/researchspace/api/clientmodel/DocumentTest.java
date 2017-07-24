package com.researchspace.api.clientmodel;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DocumentTest extends AbstractModelTest {
	
	File documentJson = new File("src/test/resources/Document.json");

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		Document d = readFileToClass(documentJson, Document.class);
		assertEquals(2,d.getFields().size());
		System.err.println(d);
	}

}

package com.researchspace.api.clientmodel;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class FileTest extends AbstractModelTest {

	File documentJson = new File("src/test/resources/File.json");

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		ApiFile file = readFileToClass(documentJson, ApiFile.class);
		assertNotNull(file.getCaption());
	}

}

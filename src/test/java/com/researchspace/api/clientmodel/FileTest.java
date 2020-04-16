package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class FileTest extends AbstractModelTest {

	File documentJson = new File("src/test/resources/File.json");

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		ApiFile file = readFileToClass(documentJson, ApiFile.class);
		assertNotNull(file.getCaption());
	}

}

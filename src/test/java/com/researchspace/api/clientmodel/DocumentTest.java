package com.researchspace.api.clientmodel;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class DocumentTest extends AbstractModelTest {
	
	File documentJson = new File("src/test/resources/Document.json");

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		Document d = readFileToClass(documentJson, Document.class);
		assertEquals(2,d.getFields().size());
		System.err.println(d);
	}

}

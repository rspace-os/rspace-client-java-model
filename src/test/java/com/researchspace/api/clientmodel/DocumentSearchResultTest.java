package com.researchspace.api.clientmodel;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class DocumentSearchResultTest extends AbstractModelTest {
	
	File DocumentSearchResultJson = new File("src/test/resources/DocumentSearchResult.json");

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		DocumentSearchResult searchTerm = readFileToClass(DocumentSearchResultJson, DocumentSearchResult.class);
		assertEquals(0,searchTerm.getPageNumber().intValue());
		assertEquals(8,searchTerm.getTotalHits().intValue());
		System.err.println(searchTerm);
	}

}

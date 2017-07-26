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

public class DocumentSearchResultTest extends AbstractModelTest {
	
	File DocumentSearchResultJson = new File("src/test/resources/DocumentSearchResult.json");

	@Before
	public void setUp() throws Exception {
	}

	@After
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

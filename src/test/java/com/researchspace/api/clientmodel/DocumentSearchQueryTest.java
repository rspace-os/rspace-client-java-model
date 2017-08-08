package com.researchspace.api.clientmodel;

import static com.researchspace.api.clientmodel.SearchTerm.createTerm;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class DocumentSearchQueryTest extends AbstractModelTest {
	
	File DocumentSearchQueryJson = new File("src/test/resources/DocumentSearchQuery.json");

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		System.err.println(SearchOperator.AND.toString());
		DocumentSearchQuery query = readFileToClass(DocumentSearchQueryJson, DocumentSearchQuery.class);
		assertEquals(2,query.getTerms().size());
		assertEquals(SearchOperator.OR, query.getOperator());
		
		
		DocumentSearchQuery query2 = DocumentSearchQuery.builder()
				.operator(SearchOperator.AND)
				.term(createTerm("default All query"))
				.term(createTerm("pcr", QueryType.TAG)).build();
		assertEquals(2,query2.getTerms().size());
	}

}

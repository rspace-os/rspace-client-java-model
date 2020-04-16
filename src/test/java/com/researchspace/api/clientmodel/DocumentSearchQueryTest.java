package com.researchspace.api.clientmodel;

import static com.researchspace.api.clientmodel.SearchTerm.createTerm;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class DocumentSearchQueryTest extends AbstractModelTest {
	
	File DocumentSearchQueryJson = new File("src/test/resources/DocumentSearchQuery.json");

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
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

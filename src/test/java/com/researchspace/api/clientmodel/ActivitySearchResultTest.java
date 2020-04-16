package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ActivitySearchResultTest extends AbstractModelTest {
	
	File ActivitySearchResultJson = new File("src/test/resources/ActivitySearchResult.json");

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		ActivitySearchResult searchRes = readFileToClass(ActivitySearchResultJson, ActivitySearchResult.class);
		assertEquals(0,searchRes.getPageNumber().intValue());
		assertEquals(1,searchRes.getTotalHits().intValue());
		assertNotNull(searchRes.getActivities().get(0).getTimestamp());	
		Map<String,Object> payload = searchRes.getActivities().get(0).getPayload();
		assertNotNull(payload.get("data"));
	}
}

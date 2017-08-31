package com.researchspace.api.clientmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ActivitySearchResultTest extends AbstractModelTest {
	
	File ActivitySearchResultJson = new File("src/test/resources/ActivitySearchResult.json");

	@Before
	public void setUp() throws Exception {
	}

	@After
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

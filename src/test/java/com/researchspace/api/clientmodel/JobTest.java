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

public class JobTest extends AbstractModelTest {
	
	File jobJson = new File("src/test/resources/completedJob.json");

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		ExportJob job = readFileToClass(jobJson, ExportJob.class);
		assertNotNull(job.getResult());
		assertEquals(1024, job.getResult().getSize().longValue());
		
	}

}

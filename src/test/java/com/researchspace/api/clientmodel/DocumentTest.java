package com.researchspace.api.clientmodel;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		assertEquals(2, d.getFields().size());
		assertEquals(23L, d.getId());
		assertEquals("SD23", d.getGlobalId());
		assertEquals("MyExperiment", d.getName());
		assertNotNull(d.getCreated());
		assertNotNull(d.getLastModified());
		assertNotNull(d.getOwner());
		assertEquals(1L, d.getOwner().getId());
		assertEquals("bsmith", d.getOwner().getUsername());
		assertNotNull(d.getForm());
		assertEquals(123L, d.getForm().getId());
		assertEquals(12L, d.getParentFolderId());
		assertNotNull(d.getFields().get(0).getType());
		assertNotNull(d.getFields().get(0).getName());
	}

}

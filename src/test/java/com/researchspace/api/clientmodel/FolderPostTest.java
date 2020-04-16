package com.researchspace.api.clientmodel;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class FolderPostTest extends AbstractModelTest {
	
	File FolderJson = new File("src/test/resources/Folder.json");

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void folderPost() {
		assertEquals("Test folder", FolderPost.builder()
				.name("Test folder").notebook(true).build().getName());
	}
	
	@Test
	public void folderReat() throws JsonParseException, JsonMappingException, IOException {
		Folder folder = readFileToClass(FolderJson, Folder.class);
		assertTrue(folder.isNotebook());
		assertEquals(295, folder.getId().longValue());
		assertEquals(271, folder.getParentFolderId().longValue());
	}

}

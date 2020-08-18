package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SelectionExportPostTest {

	@Test
	void test() {
		SelectionExportPost sePost = new SelectionExportPost(ExportFormat.HTML);
		sePost.addId(1L);
		sePost.addId(2L);
		assertEquals("1,2", sePost.toRequestString());
	}

}

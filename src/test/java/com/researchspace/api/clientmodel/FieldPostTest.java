package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FieldPostTest {
	FieldPost fieldPost;

	@BeforeEach
	public void setUp() throws Exception {
		fieldPost = new FieldPost("some content");
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testAppendFileReference() {
		assertEquals("some content <fileId=123>", fieldPost.appendFileReference(123L));
	}

}

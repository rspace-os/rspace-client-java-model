package com.researchspace.api.clientmodel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FieldPostTest {
	FieldPost fieldPost;

	@Before
	public void setUp() throws Exception {
		fieldPost = new FieldPost("some content");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAppendFileReference() {
		assertEquals("some content <fileId=123>", fieldPost.appendFileReference(123L));
	}

}

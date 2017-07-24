package com.researchspace.api.clientmodel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.researchspace.api.clientmodel.DocumentPost.DocumentPostBuilder;

public class DocumentPostTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateDocumentWith3Fields() {
		DocumentPost post = new DocumentPostBuilder().name("myDocument").tags("a,b,c")
		  .field(new FieldPost("content1"))
		  .field(new FieldPost("content2"))
		  .field(new FieldPost("content3"))
		  .build();
		assertEquals(3, post.getFields().size());
	}

}

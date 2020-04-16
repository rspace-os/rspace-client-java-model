package com.researchspace.api.clientmodel;

import static com.researchspace.api.clientmodel.FieldPost.emptyField;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.researchspace.api.clientmodel.DocumentPost.DocumentPostBuilder;

public class DocumentPostTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateDocumentWith4Fields() {
		DocumentPostBuilder builder = new DocumentPostBuilder();
		DocumentPost post = builder.name("myDocument").tags("a,b,c")
		  .field(new FieldPost("content1"))
		  .field(new FieldPost("content2"))
		  .field(new FieldPost("content3"))
		  .field(emptyField())
		  .form(new FormRef(23))
		  .build();
		assertEquals(4, post.getFields().size());
		// use builder to add another, will c reate new object
		DocumentPost post2 =  builder.field(new FieldPost("content3")).build();
		assertEquals(5, post2.getFields().size());
		assertFalse(post2 == post);
		
	}

}

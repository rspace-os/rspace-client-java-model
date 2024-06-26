package com.researchspace.api.clientmodel;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.researchspace.api.clientmodel.FormPost.ChoiceFieldPost;
import com.researchspace.api.clientmodel.FormPost.DateFieldPost;
import com.researchspace.api.clientmodel.FormPost.NumberFieldPost;
import com.researchspace.api.clientmodel.FormPost.RadioFieldPost;
import com.researchspace.api.clientmodel.FormPost.TimeFieldPost;
import com.researchspace.api.clientmodel.FormPost.StringFieldPost;
import com.researchspace.api.clientmodel.FormPost.TextFieldPost;

public class FormPostTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonProcessingException {
		List<String> choices = Arrays.asList(new String [] {"a","b","c"});
		List<String> defaultChoices = Arrays.asList(new String [] {"a","b"});
		List<String> radios = Arrays.asList(new String [] {"x","y","z"});
		String defaultRadio= "z";
		FormPost.Form toSubmit = FormPost.Form.builder().name("formName").tags("a,b,c")
		.field(NumberFieldPost.builder().name("numberField").min(0d).max(10d).defaultValue(4d).build())
		.field(DateFieldPost.builder().name("dateName").min(new Date()).build())
		.field(StringFieldPost.builder().name("name").defaultValue("defaut string").build())
		.field(TextFieldPost.builder().name("text-name").defaultValue("<em>html</em").build())
		.field(ChoiceFieldPost.builder().name("choices").multipleChoice(true).options(choices).defaultOptions(defaultChoices).build())
		.field(TimeFieldPost.builder().name("MyTime").defaultValue(9900000L).build())
		.field(RadioFieldPost.builder().name("radios").options(radios).defaultOption(defaultRadio).build())
		.build();
		ObjectMapper reader = new ObjectMapper();
		System.err.println(reader.writeValueAsString(toSubmit));
	}
}

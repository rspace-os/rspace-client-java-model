package com.researchspace.api.clientmodel;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormSearchResultTest extends AbstractModelTest {

    File formSearchResultJson = new File("src/test/resources/FormSearchResult.json");

    @Test
    void test() throws IOException {
        FormSearchResult formSearchResult = readFileToClass(formSearchResultJson, FormSearchResult.class);
        assertEquals(0, formSearchResult.getPageNumber().intValue());
        assertEquals(5, formSearchResult.getTotalHits().intValue());
        System.err.println(formSearchResult);
    }

}
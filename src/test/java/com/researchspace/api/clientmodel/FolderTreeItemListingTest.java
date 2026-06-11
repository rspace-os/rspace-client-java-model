package com.researchspace.api.clientmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FolderTreeItemListingTest extends AbstractModelTest {

    File listingJson = new File("src/test/resources/FolderTreeItemListing.json");

    @Test
    void testFolderTreeListingDeserialises() throws IOException {
        FolderTreeItemListing listing = readFileToClass(listingJson, FolderTreeItemListing.class);
        assertNotNull(listing);
        assertEquals(2L, listing.getTotalHits());
        assertEquals(0, listing.getPageNumber());
        assertEquals(10, listing.getPageSize().intValue());
        assertEquals(1L, listing.getParentId());
        assertFalse(listing.getRecords().isEmpty());
    }

    @Test
    void testFolderItemFields() throws IOException {
        FolderTreeItemListing listing = readFileToClass(listingJson, FolderTreeItemListing.class);
        FolderTreeItemInfo first = listing.getRecords().get(0);
        assertEquals(10L, first.getId());
        assertEquals("FL10", first.getGlobalId());
        assertEquals("Subfolder A", first.getName());
        assertEquals("FOLDER", first.getType());
        assertNotNull(first.getCreated());
        assertNotNull(first.getLastModified());
        assertEquals(1L, first.getParentFolderId());
        assertNotNull(first.getOwner());
        assertEquals("bsmith", first.getOwner().getUsername());
    }
}

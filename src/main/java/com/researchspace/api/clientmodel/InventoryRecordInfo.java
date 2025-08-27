package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class InventoryRecordInfo extends IdentifiableNameable {

    private String description;

    @Builder.Default
    private List<TagInfo> tags = new ArrayList<>();

    @Builder.Default
    private InventorySharingMode sharingMode = InventorySharingMode.OWNER_GROUPS;

    public enum InventorySharingMode {OWNER_GROUPS, WHITELIST, OWNER_ONLY}

    private List<SharedWith> sharedWith;

    @JsonProperty(value = "type")
    private InventoryType type;

    public enum InventoryType {
        SAMPLE,
        SUBSAMPLE,
        CONTAINER,
        SAMPLE_TEMPLATE
    }

    @Builder.Default
    private List<Barcode> barcodes = new ArrayList<>();
}

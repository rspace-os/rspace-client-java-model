package com.researchspace.api.clientmodel.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.researchspace.api.clientmodel.IdentifiableNameable;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class RecordInfo extends IdentifiableNameable {

    private String description;

    @Builder.Default
    private List<TagInfo> tags = new ArrayList<>();

    @Builder.Default
    private SharingMode sharingMode = SharingMode.OWNER_GROUPS;

    public enum SharingMode {OWNER_GROUPS, WHITELIST, OWNER_ONLY}

    private List<SharedWith> sharedWith;

    private Type type;

    public enum Type {
        SAMPLE,
        SUBSAMPLE,
        CONTAINER,
        SAMPLE_TEMPLATE
    }

    @Builder.Default
    private List<Barcode> barcodes = new ArrayList<>();
}

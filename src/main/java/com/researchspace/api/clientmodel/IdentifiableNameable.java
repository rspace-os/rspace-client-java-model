package com.researchspace.api.clientmodel;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class IdentifiableNameable extends Linkable {
    private Long id;
    private String globalId;
    private String name;
    private String description;

    @Builder.Default
    private InventorySharingMode sharingMode = InventorySharingMode.OWNER_GROUPS;
    public enum InventorySharingMode { OWNER_GROUPS, WHITELIST, OWNER_ONLY }

    private List<SharedWith> sharedWith;
}

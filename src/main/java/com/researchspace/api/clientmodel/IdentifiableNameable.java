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
}

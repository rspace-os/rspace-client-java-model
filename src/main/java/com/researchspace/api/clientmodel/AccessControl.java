package com.researchspace.api.clientmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Information about the permissions to view or edit a form.
 *
 * @author rspace
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessControl {
    private String ownerPermissionType;
    private String groupPermissionType;
    private String worldPermissionType;
}
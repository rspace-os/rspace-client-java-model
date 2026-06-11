package com.researchspace.api.clientmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request body for PUT /share — updates the permission level of an existing share.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SharePermissionUpdate {

    private Long shareId;
    private String permission;

}

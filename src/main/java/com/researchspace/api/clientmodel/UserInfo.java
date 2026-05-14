package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Full user information as returned by the sysadmin user-listing endpoint.
 * @since 1.5
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo extends IdentifiableNameable {

    private String email;
    private String firstName;
    private String lastName;
    private UserRole role;
    private String affiliation;
    private boolean enabled;
    private Long homeFolderId;

}

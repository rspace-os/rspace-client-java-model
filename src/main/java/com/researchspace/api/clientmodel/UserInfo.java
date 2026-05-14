package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Full user information as returned by the sysadmin user-listing endpoint.
 * <p>
 * Note: {@code name} (inherited from {@link IdentifiableNameable}) is the display name of the user,
 * while {@code username} is the unique login identifier used for authentication and API calls.
 * Both fields are populated from the server response.
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo extends IdentifiableNameable {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private UserRole role;
    private String affiliation;
    private boolean enabled;
    private Long homeFolderId;

}

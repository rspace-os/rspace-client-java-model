package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representation of a User. Read only — there are no API methods to alter user properties.
 * @since 1.1.0
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Long homeFolderId;

}

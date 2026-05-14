package com.researchspace.api.clientmodel;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * An image, attachment or linked resource object, but without its binary data.
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class ApiFile extends IdentifiableNameable {

    private String contentType = null;
    private Long size = null;
    private String caption;
    private Date created;
    private Integer version = null;
    
}

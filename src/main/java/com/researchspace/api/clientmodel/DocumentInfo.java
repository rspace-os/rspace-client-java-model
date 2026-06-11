package com.researchspace.api.clientmodel;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Basic information about RSpace Document
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@ToString(callSuper=true)
public class DocumentInfo extends IdentifiableNameable {

    private Date created = null;  
    private Date lastModified = null;
    private Boolean signed = null;
    private String tags = null;
    private String tagMetaData = null;
    private FormInfo form = null;
    private User owner = null;
    private Long parentFolderId = null;
    private Long grandParentId = null;
    private Long version;

}

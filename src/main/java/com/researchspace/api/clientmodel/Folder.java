package com.researchspace.api.clientmodel;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * RSpace Folder or notebook
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@ToString(callSuper=true)
public class Folder extends IdentifiableNameable {

    private Date created = null;  
    private Date lastModified = null;
    private boolean notebook = false;
    private Long parentFolderId = null;

}

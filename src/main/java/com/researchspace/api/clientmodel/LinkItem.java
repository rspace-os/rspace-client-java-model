package com.researchspace.api.clientmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A metadata link
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkItem {
    
    public static final String NEXT_REL = "next";
    public static final String PREV_REL = "prev";
    public static final String FIRST_REL = "first";
    public static final String LAST_REL = "last";
    public static final String SELF_REL = "self";
    public static final String ENCLOSURE_REL = "enclosure";
    
    private String link = null;
    private String rel = null;

}

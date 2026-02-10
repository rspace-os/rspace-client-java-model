package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public abstract class Linkable {
    

    @JsonProperty("_links")
    protected List<LinkItem> links = new ArrayList<>();

    public String getLinkByType (String relType){
        for (LinkItem link : links) {
            if (relType.equals(link.getRel())) {
                return link.getLink();
            }
        }
        return null;
    }
    
}

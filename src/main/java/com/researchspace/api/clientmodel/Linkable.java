package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Linkable {
    

    protected List<LinkItem> _links = new ArrayList<LinkItem>();

    public String getLinkByType (String relType){
        for (LinkItem link : _links) {
            if (relType.equals(link.getRel())) {
                return link.getLink();
            }
        }
        return null;
    }
    
}

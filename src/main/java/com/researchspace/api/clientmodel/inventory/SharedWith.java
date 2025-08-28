package com.researchspace.api.clientmodel.inventory;

import com.researchspace.api.clientmodel.GroupInfo;
import lombok.Data;

@Data
public class SharedWith {
    public GroupInfo group;
    public boolean shared;
    private Boolean itemOwnerGroup;
}


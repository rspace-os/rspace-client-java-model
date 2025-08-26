package com.researchspace.api.clientmodel;

import lombok.Data;

@Data
public class SharedWith {
    public GroupInfo group;
    public boolean shared;
    private Boolean itemOwnerGroup;
}


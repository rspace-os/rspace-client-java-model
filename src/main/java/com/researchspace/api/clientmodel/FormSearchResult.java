package com.researchspace.api.clientmodel;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class FormSearchResult extends PaginatedResultList {

    List<FormInfo> forms = new ArrayList<>();

}

package com.researchspace.api.clientmodel;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SharePost {
 
  @Size(min=1,max=255, message="There must be at least 1 document or notebook to share")
  @Singular("itemToShare")
  private List<Long> itemsToShare = new ArrayList<>();
  
  @Valid
  @Singular
  private List<GroupSharePostItem> groups = new ArrayList<>();
  @Valid
  @Singular  
  private List<UserSharePostItem> users = new ArrayList<>();
}

package com.dtoconvertway.domain.portal.corporationgroup.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CorporationGroupResponse {

  private Long id;
  private String name;
}

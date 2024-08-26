package com.dtoconvertway.domain.portal.corporationgroup.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CorporationGroupDto {

  private Long id;
  private String name;
}

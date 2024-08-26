package com.dtoconvertway.domain.portal.corporation.dto.flat;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CorporationFlatDto {

  private Long id;
  private String name;
  private String corporationNumber;
  private String address;
  private Long corporationGroupId;
  private String corporationGroupName;
}

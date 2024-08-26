package com.dtoconvertway.domain.portal.corporation.dto;


import com.dtoconvertway.domain.portal.corporationgroup.dto.CorporationGroupDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CorporationDto {

  private Long id;
  private String name;
  private String corporationNumber;
  private String address;
  private CorporationGroupDto corporationGroupDto;

//  public static Corporation toEntity(CorporationDto dto) {
//    return Corporation.of(dto.getName(), dto.getCorporationNumber(), dto.getAddress());
//  }
}

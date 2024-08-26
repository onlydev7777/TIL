package com.dtoconvertway.domain.portal.corporation.mapper;

import com.dtoconvertway.domain.portal.corporation.Corporation;
import com.dtoconvertway.domain.portal.corporation.api.request.CorporationRequest;
import com.dtoconvertway.domain.portal.corporation.api.response.CorporationFlatResponse;
import com.dtoconvertway.domain.portal.corporation.api.response.CorporationResponse;
import com.dtoconvertway.domain.portal.corporation.dto.CorporationDto;
import com.dtoconvertway.domain.portal.corporation.dto.flat.CorporationFlatDto;
import com.dtoconvertway.domain.portal.corporationgroup.mapper.CorporationGroupMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CorporationGroupMapper.class})
public interface CorporationMapper {

  CorporationDto toDto(CorporationRequest request);

  //  @Mapping(target = "corporationGroupDto", expression = "java(corporationGroupDto)")
//  CorporationDto toDto(Corporation entity, @Context CorporationGroupDto corporationGroupDto);

  @Mapping(source = "corporationGroup", target = "corporationGroupDto")
  CorporationDto toDto(Corporation entity);

  @Mapping(source = "corporationGroupDto", target = "corporationGroup")
  Corporation toEntity(CorporationDto dto);

  @Mapping(source = "corporationGroupDto", target = "corporationGroupResponse")
  CorporationResponse toResponse(CorporationDto dto);

  CorporationFlatResponse toFlatResponse(CorporationFlatDto flatDto);
//  @Mapping(target = "corporationGroupResponse", expression = "java(corporationGroupDto)")
//  CorporationResponse toResponse(CorporationDto dto, @Context CorporationGroupDto corporationGroupDto);
}

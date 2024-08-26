package com.dtoconvertway.domain.portal.corporationgroup.mapper;

import com.dtoconvertway.domain.portal.corporationgroup.CorporationGroup;
import com.dtoconvertway.domain.portal.corporationgroup.api.response.CorporationGroupResponse;
import com.dtoconvertway.domain.portal.corporationgroup.dto.CorporationGroupDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CorporationGroupMapper {

  CorporationGroup toEntity(CorporationGroupDto dto);

  CorporationGroupDto toDto(CorporationGroup entity);

  CorporationGroupResponse toResponse(CorporationGroupDto dto);
}

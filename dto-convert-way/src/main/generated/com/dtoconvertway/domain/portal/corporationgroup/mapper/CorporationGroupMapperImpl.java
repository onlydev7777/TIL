package com.dtoconvertway.domain.portal.corporationgroup.mapper;

import com.dtoconvertway.domain.portal.corporationgroup.CorporationGroup;
import com.dtoconvertway.domain.portal.corporationgroup.api.response.CorporationGroupResponse;
import com.dtoconvertway.domain.portal.corporationgroup.dto.CorporationGroupDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-26T18:06:29+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class CorporationGroupMapperImpl implements CorporationGroupMapper {

    @Override
    public CorporationGroup toEntity(CorporationGroupDto dto) {
        if ( dto == null ) {
            return null;
        }

        CorporationGroup.CorporationGroupBuilder corporationGroup = CorporationGroup.builder();

        corporationGroup.name( dto.getName() );

        return corporationGroup.build();
    }

    @Override
    public CorporationGroupDto toDto(CorporationGroup entity) {
        if ( entity == null ) {
            return null;
        }

        CorporationGroupDto.CorporationGroupDtoBuilder corporationGroupDto = CorporationGroupDto.builder();

        corporationGroupDto.id( entity.getId() );
        corporationGroupDto.name( entity.getName() );

        return corporationGroupDto.build();
    }

    @Override
    public CorporationGroupResponse toResponse(CorporationGroupDto dto) {
        if ( dto == null ) {
            return null;
        }

        CorporationGroupResponse.CorporationGroupResponseBuilder corporationGroupResponse = CorporationGroupResponse.builder();

        corporationGroupResponse.id( dto.getId() );
        corporationGroupResponse.name( dto.getName() );

        return corporationGroupResponse.build();
    }
}

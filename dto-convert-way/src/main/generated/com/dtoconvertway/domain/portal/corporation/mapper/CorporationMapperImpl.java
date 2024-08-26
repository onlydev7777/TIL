package com.dtoconvertway.domain.portal.corporation.mapper;

import com.dtoconvertway.domain.portal.corporation.Corporation;
import com.dtoconvertway.domain.portal.corporation.api.request.CorporationRequest;
import com.dtoconvertway.domain.portal.corporation.api.response.CorporationFlatResponse;
import com.dtoconvertway.domain.portal.corporation.api.response.CorporationResponse;
import com.dtoconvertway.domain.portal.corporation.dto.CorporationDto;
import com.dtoconvertway.domain.portal.corporation.dto.flat.CorporationFlatDto;
import com.dtoconvertway.domain.portal.corporationgroup.mapper.CorporationGroupMapper;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-26T18:06:28+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class CorporationMapperImpl implements CorporationMapper {

    @Autowired
    private CorporationGroupMapper corporationGroupMapper;

    @Override
    public CorporationDto toDto(CorporationRequest request) {
        if ( request == null ) {
            return null;
        }

        CorporationDto.CorporationDtoBuilder corporationDto = CorporationDto.builder();

        corporationDto.name( request.getName() );
        corporationDto.corporationNumber( request.getCorporationNumber() );
        corporationDto.address( request.getAddress() );

        return corporationDto.build();
    }

    @Override
    public CorporationDto toDto(Corporation entity) {
        if ( entity == null ) {
            return null;
        }

        CorporationDto.CorporationDtoBuilder corporationDto = CorporationDto.builder();

        corporationDto.corporationGroupDto( corporationGroupMapper.toDto( entity.getCorporationGroup() ) );
        corporationDto.id( entity.getId() );
        corporationDto.name( entity.getName() );
        corporationDto.corporationNumber( entity.getCorporationNumber() );
        corporationDto.address( entity.getAddress() );

        return corporationDto.build();
    }

    @Override
    public Corporation toEntity(CorporationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Corporation.CorporationBuilder corporation = Corporation.builder();

        corporation.corporationGroup( corporationGroupMapper.toEntity( dto.getCorporationGroupDto() ) );
        corporation.name( dto.getName() );
        corporation.corporationNumber( dto.getCorporationNumber() );
        corporation.address( dto.getAddress() );

        return corporation.build();
    }

    @Override
    public CorporationResponse toResponse(CorporationDto dto) {
        if ( dto == null ) {
            return null;
        }

        CorporationResponse.CorporationResponseBuilder corporationResponse = CorporationResponse.builder();

        corporationResponse.corporationGroupResponse( corporationGroupMapper.toResponse( dto.getCorporationGroupDto() ) );
        corporationResponse.id( dto.getId() );
        corporationResponse.name( dto.getName() );
        corporationResponse.corporationNumber( dto.getCorporationNumber() );
        corporationResponse.address( dto.getAddress() );

        return corporationResponse.build();
    }

    @Override
    public CorporationFlatResponse toFlatResponse(CorporationFlatDto flatDto) {
        if ( flatDto == null ) {
            return null;
        }

        CorporationFlatResponse.CorporationFlatResponseBuilder corporationFlatResponse = CorporationFlatResponse.builder();

        corporationFlatResponse.id( flatDto.getId() );
        corporationFlatResponse.name( flatDto.getName() );
        corporationFlatResponse.corporationNumber( flatDto.getCorporationNumber() );
        corporationFlatResponse.address( flatDto.getAddress() );
        corporationFlatResponse.corporationGroupId( flatDto.getCorporationGroupId() );
        corporationFlatResponse.corporationGroupName( flatDto.getCorporationGroupName() );

        return corporationFlatResponse.build();
    }
}

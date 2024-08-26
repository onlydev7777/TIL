package com.dtoconvertway.domain.portal.corporation.service;

import com.dtoconvertway.domain.portal.corporation.CorporationRepository;
import com.dtoconvertway.domain.portal.corporation.dto.CorporationDto;
import com.dtoconvertway.domain.portal.corporation.dto.flat.CorporationFlatDto;
import com.dtoconvertway.domain.portal.corporation.mapper.CorporationMapper;
import com.dtoconvertway.domain.portal.corporationgroup.CorporationGroup;
import com.dtoconvertway.domain.portal.corporationgroup.CorporationGroupRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class CorporationService {

  private final CorporationRepository repository;
  private final CorporationGroupRepository corporationGroupRepository;
  private final CorporationMapper mapper;

  @Transactional(readOnly = true)
  public CorporationDto findById(Long id) {
    return mapper.toDto(repository.findById(id).orElseThrow());
  }

  @Transactional(readOnly = true)
  public List<CorporationFlatDto> findFlatDtoAllByCorpGroup(Long corporationGroupId) {
    CorporationGroup corporationGroup = corporationGroupRepository.getReferenceById(corporationGroupId);
    return repository.findFlatDtoAllByCorpGroup(corporationGroup);
  }
}

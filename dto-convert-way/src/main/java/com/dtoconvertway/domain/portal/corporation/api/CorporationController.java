package com.dtoconvertway.domain.portal.corporation.api;

import com.dtoconvertway.domain.portal.corporation.api.response.CorporationFlatResponse;
import com.dtoconvertway.domain.portal.corporation.api.response.CorporationResponse;
import com.dtoconvertway.domain.portal.corporation.mapper.CorporationMapper;
import com.dtoconvertway.domain.portal.corporation.service.CorporationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/corp")
@RestController
public class CorporationController {

  private final CorporationService service;
  private final CorporationMapper mapper;

  @GetMapping("/{id}")
  public ResponseEntity<CorporationResponse> get(@PathVariable Long id) {
    return ResponseEntity.ok(
        mapper.toResponse(service.findById(id))
    );
  }

  @GetMapping("/group/{corporationGroupId}")
  public ResponseEntity<List<CorporationFlatResponse>> getListOfCorpGroup(@PathVariable Long corporationGroupId) {
    return ResponseEntity.ok(
        service.findFlatDtoAllByCorpGroup(corporationGroupId).stream()
            .map(mapper::toFlatResponse)
            .toList()
    );
  }
}

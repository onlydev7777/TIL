package com.dtoconvertway.domain.portal.corporation.api.response;

import com.dtoconvertway.domain.portal.corporationgroup.api.response.CorporationGroupResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CorporationResponse {

  @Schema(description = "회사 key", example = "1")
  @NotBlank
  private Long id;

  @Schema(description = "회사명", example = "네이버")
  @NotBlank
  private String name;

  @Schema(description = "사업자번호", example = "123-45-67891")
  @NotBlank
  private String corporationNumber;

  @Schema(description = "회사주소", example = "서울특별시 강남구 영동대로", nullable = true)
  private String address;

  @Schema(description = "그룹사 정보")
  private CorporationGroupResponse corporationGroupResponse;
}

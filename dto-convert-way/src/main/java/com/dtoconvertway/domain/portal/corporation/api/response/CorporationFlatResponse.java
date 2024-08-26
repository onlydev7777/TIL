package com.dtoconvertway.domain.portal.corporation.api.response;


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
public class CorporationFlatResponse {

  @Schema(description = "회사 key", example = "1")
  @NotBlank
  private Long id;

  @Schema(description = "회사명", example = "삼성전자")
  @NotBlank
  private String name;

  @Schema(description = "사업자번호", example = "123-45-67891")
  @NotBlank
  private String corporationNumber;

  @Schema(description = "회사주소", example = "서울특별시 강남구 영동대로", nullable = true)
  private String address;

  @Schema(description = "회사 그룹 key", example = "1")
  @NotBlank
  private Long corporationGroupId;
  
  @Schema(description = "회사 그룹명", example = "삼성그룹")
  @NotBlank
  private String corporationGroupName;
}

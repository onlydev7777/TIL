package com.dtoconvertway.domain.portal.corporation.api.request;

import com.dtoconvertway.domain.portal.corporation.dto.CorporationDto;
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
public class CorporationRequest {

  @Schema(description = "회사명", example = "네이버")
  @NotBlank
  private String name;

  @Schema(description = "사업자번호", example = "123-45-67891")
  @NotBlank
  private String corporationNumber;

  @Schema(description = "회사주소", example = "서울특별시 강남구 영동대로", nullable = true)
  private String address;

  //address는 회원가입 화면이 아닌 다른 화면에서 입력 된다고 가정
  public static CorporationDto of(CorporationRequest request) {
    return CorporationDto.builder()
        .name(request.getName())
        .corporationNumber(request.getCorporationNumber())
        .build();
  }
}

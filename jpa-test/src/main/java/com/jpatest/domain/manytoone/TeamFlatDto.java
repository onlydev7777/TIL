package com.jpatest.domain.manytoone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class TeamFlatDto {
    private Long teamId;
    private Long memberId;
    private String teamName;
    private String memberName;
}

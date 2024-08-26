package com.dtoconvertway.domain.portal.corporationgroup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "corp_grp")
@Entity
public class CorporationGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Builder
  public CorporationGroup(String name) {
    this.name = name;
  }

  public static CorporationGroup of(String name) {
    return CorporationGroup.builder()
        .name(name)
        .build();
  }
}

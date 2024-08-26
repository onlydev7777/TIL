package com.dtoconvertway.domain.portal.corporation;

import com.dtoconvertway.domain.portal.corporationgroup.CorporationGroup;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "corp")
@Entity
public class Corporation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String corporationNumber;
  private String address;

  @JoinColumn(name = "corp_grp_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private CorporationGroup corporationGroup;

  @Builder
  public Corporation(String name, String corporationNumber, String address, CorporationGroup corporationGroup) {
    this.name = name;
    this.corporationNumber = corporationNumber;
    this.address = address;
    this.corporationGroup = corporationGroup;
  }

  public static Corporation of(String name, String corporationNumber, String address, CorporationGroup corporationGroup) {
    return Corporation.builder()
        .name(name)
        .corporationNumber(corporationNumber)
        .address(address)
        .corporationGroup(corporationGroup)
        .build();
  }
}

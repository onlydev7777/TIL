package com.multitenant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "temp_members", schema = "newbp_local")
@Entity
public class TempMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "team_nm")
    private String teamName;    // CorpGroupCode 개념

    @Column(name = "member_nm")
    private String name;

    public TempMember(String teamName, String name) {
        this.teamName = teamName;
        this.name = name;
    }
}

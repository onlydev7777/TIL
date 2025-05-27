package com.multitenant.entity;

import com.multitenant.resolver.TenantIdentifierResolver;
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
@Table(name = "team_schema", schema = TenantIdentifierResolver.DEFAULT_SCHEMA)
@Entity
public class TeamSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "team_nm")
    private String teamName;    // CorpGroupCode 개념

    @Column(name = "schema_nm")
    private String schemaName;

    public TeamSchema(String teamName, String schemaName) {
        this.teamName = teamName;
        this.schemaName = schemaName;
    }
}

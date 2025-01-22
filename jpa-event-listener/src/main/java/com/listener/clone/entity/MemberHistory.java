package com.listener.clone.entity;

import com.listener.constant.EntityType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name = "member_hist")
@Entity
public class MemberHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_id")
    private Long entityId;

    @Enumerated(EnumType.STRING)
    @Column(name = "entity_type")
    private EntityType entityType;

    @Column(name = "field_nm")
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

    @Column(name = "change_reason")
    private String changeReason;

    @Column(name = "mod_dttm")
    private LocalDateTime modDttm;

    @Builder
    public MemberHistory(Long entityId, EntityType entityType, String fieldName, String oldValue, String newValue, String changeReason, LocalDateTime modDttm) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.changeReason = changeReason;
        this.modDttm = modDttm;
    }
}

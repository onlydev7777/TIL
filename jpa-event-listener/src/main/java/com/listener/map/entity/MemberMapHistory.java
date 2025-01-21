package com.listener.map.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "member_map_hist")
@Entity
public class MemberMapHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

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
    public MemberMapHistory(Long memberId, String fieldName, String oldValue, String newValue, String changeReason, LocalDateTime modDttm) {
        this.memberId = memberId;
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.changeReason = changeReason;
        this.modDttm = modDttm;
    }
}

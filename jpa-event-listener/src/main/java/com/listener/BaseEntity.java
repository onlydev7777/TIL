package com.listener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {
    @CreatedBy
    @Column(name= "reg_corp_user_id", updatable = false)
    @Comment("등록자 id")
    private Long regCorporationUserId;

    @LastModifiedBy
    @Column(name= "mod_corp_user_id")
    @Comment("수정자 id")
    private Long modCorporationUserId;
}

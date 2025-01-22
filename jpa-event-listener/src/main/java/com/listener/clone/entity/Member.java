package com.listener.clone.entity;

import com.listener.annotation.Trackable;
import com.listener.clone.listener.MemberListener;
import com.listener.constant.EntityType;
import com.listener.trackable.AbstractTrackable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
//@Configurable
@EntityListeners(MemberListener.class)
@Table(name = "members")
@Entity
public class Member extends AbstractTrackable<Member> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Trackable
    @Column(name = "addr", nullable = false)
    private String addr;

    @Trackable
    @Column(name = "assets")
    private BigDecimal assets;

    @Trackable private String field1;
    @Trackable private String field2;
    @Trackable private String field3;
    @Trackable private String field4;
    @Trackable private String field5;
    @Trackable private String field6;
    @Trackable private String field7;
    @Trackable private String field8;
    @Trackable private String field9;
    @Trackable private String field10;
    @Trackable private String field11;
    @Trackable private String field12;
    @Trackable private String field13;
    @Trackable private String field14;
    @Trackable private String field15;
    @Trackable private String field16;
    @Trackable private String field17;
    @Trackable private String field18;
    @Trackable private String field19;
    @Trackable private String field20;
    @Trackable private String field21;
    @Trackable private String field22;
    @Trackable private String field23;
    @Trackable private String field24;
    @Trackable private String field25;
    @Trackable private String field26;
    @Trackable private String field27;
    @Trackable private String field28;
    @Trackable private String field29;
    @Trackable private String field30;
    @Trackable private String field31;
    @Trackable private String field32;
    @Trackable private String field33;
    @Trackable private String field34;
    @Trackable private String field35;
    @Trackable private String field36;
    @Trackable private String field37;
    @Trackable private String field38;
    @Trackable private String field39;
    @Trackable private String field40;
    @Trackable private String field41;
    @Trackable private String field42;
    @Trackable private String field43;
    @Trackable private String field44;
    @Trackable private String field45;
    @Trackable private String field46;
    @Trackable private String field47;
    @Trackable private String field48;
    @Trackable private String field49;
    @Trackable private String field50;
    @Trackable private String field51;
    @Trackable private String field52;
    @Trackable private String field53;
    @Trackable private String field54;
    @Trackable private String field55;
    @Trackable private String field56;
    @Trackable private String field57;
    @Trackable private String field58;
    @Trackable private String field59;
    @Trackable private String field60;
    @Trackable private String field61;
    @Trackable private String field62;
    @Trackable private String field63;
    @Trackable private String field64;
    @Trackable private String field65;
    @Trackable private String field66;
    @Trackable private String field67;
    @Trackable private String field68;
    @Trackable private String field69;
    @Trackable private String field70;
    @Trackable private String field71;
    @Trackable private String field72;
    @Trackable private String field73;
    @Trackable private String field74;
    @Trackable private String field75;
    @Trackable private String field76;
    @Trackable private String field77;
    @Trackable private String field78;
    @Trackable private String field79;
    @Trackable private String field80;
    @Trackable private String field81;
    @Trackable private String field82;
    @Trackable private String field83;
    @Trackable private String field84;
    @Trackable private String field85;
    @Trackable private String field86;
    @Trackable private String field87;
    @Trackable private String field88;
    @Trackable private String field89;
    @Trackable private String field90;
    @Trackable private String field91;
    @Trackable private String field92;
    @Trackable private String field93;
    @Trackable private String field94;
    @Trackable private String field95;
    @Trackable private String field96;
    @Trackable private String field97;
    @Trackable private String field98;
    @Trackable private String field99;
    @Trackable private String field100;

//    @Transient
//    private Member snapshot;

//    @Transient
//    private String changeReason;

//    public void saveSnapshot() {
//        this.snapshot = this.clone();
//    }

    @Builder
    public Member(String name, Integer age, String addr, BigDecimal assets) {
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.assets = assets;
    }

    public void updateAssets(BigDecimal changeAssets, String changeReason){
        this.assets = this.assets.add(changeAssets);
        this.changeReason = changeReason;
    }

    public void changeAddress(String changeAddr, String changeReason){
        this.addr = changeAddr;
        this.changeReason = changeReason;
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.Member;
    }
}

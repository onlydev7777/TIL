package com.jpatest.domain.manytoone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
//@SequenceGenerator(
//        name = "team_seq_generator",
//        sequenceName = "team_seq",
//        initialValue = 10)
@Table
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ColumnTransformer(
//            read = "decrypt(name, 'name')",
//            write = "encrypt(?, 'name')"
//    )
    @Column(name = "name", nullable = false)
    private String name;

    public Team(String name) {
        this.name = name;
    }
}

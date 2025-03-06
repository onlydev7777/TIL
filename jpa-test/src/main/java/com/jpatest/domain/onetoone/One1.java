package com.jpatest.domain.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class One1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}

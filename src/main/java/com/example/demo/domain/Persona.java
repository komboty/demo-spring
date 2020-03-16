package com.example.demo.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * Persona
 */
@Data
@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @SequenceGenerator(name = "sec_per", sequenceName = "persona_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "sec_per", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nombre")
    private String name;
}
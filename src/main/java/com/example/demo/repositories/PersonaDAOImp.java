package com.example.demo.repositories;

import javax.persistence.EntityManager;

import com.example.demo.domain.Persona;

import org.springframework.stereotype.Repository;

/**
 * PersonaDAOImp
 */
@Repository
public class PersonaDAOImp extends GenericDAOImp<Persona, Integer> implements PersonaDAO {

    public PersonaDAOImp(EntityManager entityManager) {
        super(entityManager, Persona.class);
    }
}
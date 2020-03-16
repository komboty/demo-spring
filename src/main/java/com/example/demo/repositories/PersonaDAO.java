package com.example.demo.repositories;

import com.example.demo.domain.Persona;

import org.springframework.stereotype.Repository;

/**
 * PersonaDAO
 */
@Repository
public interface PersonaDAO extends GenericDAO<Persona,Integer>{

    
}
package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Persona;

/**
 * PersonaService
 */
public interface PersonaService {

    public Persona findById(Integer id);
    public List<Persona> findAll();
}
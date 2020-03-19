package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Persona;
import com.example.demo.repositories.PersonaDAO;

import org.springframework.stereotype.Service;

/**
 * PersonaServiceImp
 */
@Service
public class PersonaServiceImp implements PersonaService {

    private PersonaDAO personaDAO;

    public PersonaServiceImp(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    @Override
    public Persona findById(Integer id) {
        return personaDAO.findById(id);
    }

    @Override
    public List<Persona> findAll() {
        return personaDAO.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        return personaDAO.save(persona);
    }
}
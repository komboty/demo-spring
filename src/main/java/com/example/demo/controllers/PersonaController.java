package com.example.demo.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.demo.domain.Persona;
import com.example.demo.repositories.PersonaDAO;
import com.example.demo.repositories.PersonaDAOImp;
import com.example.demo.service.PersonaService;
import com.example.demo.service.PersonaServiceImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonaController
 */
@RestController
@RequestMapping("/personas")
public class PersonaController {
    private static Logger LOG = LoggerFactory.getLogger(PersonaController.class);

    private PersonaService personaService;
    
    private PersonaService getPersonaService() {
        LOG.debug("inicializar()");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-tests-memoria");
        EntityManager entityManager = emf.createEntityManager();
        PersonaDAO personaDAO = new PersonaDAOImp(entityManager);
        return new PersonaServiceImp(personaDAO);
    }

    @GetMapping
    public List<Persona> getPersonas() { 
        return getPersonaService().findAll();
    }
}
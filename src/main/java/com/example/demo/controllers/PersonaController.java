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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonaController
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
//@RequestMapping("/personas")
public class PersonaController {
    private static Logger LOG = LoggerFactory.getLogger(PersonaController.class);
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-tests-memoria");
    public static EntityManager entityManager = emf.createEntityManager();

    private PersonaService personaService;
    
    private PersonaService getPersonaService() {
        LOG.debug("inicializar()");
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-tests");        
        //EntityManager entityManager = emf.createEntityManager();
        PersonaDAO personaDAO = new PersonaDAOImp(entityManager);
        return new PersonaServiceImp(personaDAO);
    }

    @GetMapping("/personas")
    public List<Persona> findAll() { 
        LOG.debug("findAll()");
        personaService = getPersonaService();
        return personaService.findAll();
    }

    @GetMapping("/persona/{id}")
    public Persona findById(@PathVariable("id") Integer id) {
        LOG.debug("findById()");
        personaService = getPersonaService();
        return personaService.findById(id);
    }

    @PostMapping("/persona")
    public Persona save(@RequestBody Persona persona) {
        LOG.debug("findById()");
        personaService = getPersonaService();
        return personaService.save(persona);
    }
}
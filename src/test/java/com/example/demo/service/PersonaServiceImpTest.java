package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.controllers.PersonaController;
import com.example.demo.domain.Persona;
import com.example.demo.repositories.PersonaDAO;
import com.example.demo.repositories.PersonaDAOImp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PersonaServiceImpTest
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonaServiceImpTest {
    private static Logger LOG = LoggerFactory.getLogger(PersonaServiceImpTest.class);
    
    private static EntityManager entityManager;
    private static PersonaService personaService;

    @BeforeAll
    public static void inicializar() {
        LOG.debug("inicializar()");
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-tests-memoria");
        //entityManager = emf.createEntityManager();
        entityManager = PersonaController.entityManager;
        PersonaDAO personaDAO = new PersonaDAOImp(entityManager);
        personaService = new PersonaServiceImp(personaDAO);
    }

    @Test
    @Order(1)
    public void findByIdTest() {
        LOG.debug("findByIdTest()");
        Persona persona = personaService.findById(1);
        
        assertEquals(1, persona.getId());
        assertEquals("JUANITO", persona.getName());
    }

    @Test
    @Order(2)
    public void findAllTest() {
        LOG.debug("findAllTest()");
        List<Persona> personas = personaService.findAll();
        
        assertEquals(3, personas.size());
        assertEquals(1, personas.get(0).getId());
        assertEquals("JUANITO", personas.get(0).getName());
    }

    @Test
    @Order(3)
    public void saveTest() {
        LOG.debug("saveTest()");
        Persona persona = new Persona();
        persona.setName("New Persona");
        Persona personaSave = personaService.save(persona);

        assertNotNull(personaSave);
        assertEquals(persona.getName(), personaSave.getName());
    }
}
package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.controllers.PersonaController;
import com.example.demo.domain.Persona;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * PersonaDAOImpTest
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonaDAOImpTest {
    private static Logger LOG = LoggerFactory.getLogger(PersonaDAOImpTest.class);

    private static EntityManager entityManager;
    private static PersonaDAO personaDAO;

    @BeforeAll
    public static void inicializar() {
        LOG.debug("inicializar()");
        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-tests-memoria");
        // entityManager = emf.createEntityManager();
        entityManager = PersonaController.entityManager;
        personaDAO = new PersonaDAOImp(entityManager);
    }

    @Test
    @Order(1)
    public void findByIdTest() {
        LOG.debug("findByIdTest()");
        Persona persona = personaDAO.findById(1);
        
        assertEquals(1, persona.getId());
        assertEquals("JUANITO", persona.getName());
    }

    @Test
    @Order(2)
    public void findAllTest() {
        LOG.debug("findAllTest()");
        List<Persona> personas = personaDAO.findAll();

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
        Persona personaSave = personaDAO.save(persona);

        assertNotNull(personaSave);
        assertEquals(persona.getName(), personaSave.getName());
    }
}
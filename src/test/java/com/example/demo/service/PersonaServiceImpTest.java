package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.demo.domain.Persona;
import com.example.demo.repositories.PersonaDAO;
import com.example.demo.repositories.PersonaDAOImp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * PersonaServiceImpTest
 */
@SpringBootTest
public class PersonaServiceImpTest {
    private static Logger LOG = LoggerFactory.getLogger(PersonaServiceImpTest.class);
    
    private static EntityManager entityManager;
    private static PersonaService personaService;

    @BeforeAll
    public static void inicializar() {
        LOG.debug("inicializar()");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-tests-memoria");
        entityManager = emf.createEntityManager();
        PersonaDAO personaDAO = new PersonaDAOImp(entityManager);
        personaService = new PersonaServiceImp(personaDAO);
    }

    @Test
    public void findByIdTest() {
        LOG.debug("findByIdTest()");
        Persona persona = personaService.findById(1);
        assertEquals(1, persona.getId());
        assertEquals("JUANITO", persona.getName());
    }

    @Test
    public void findAllTest() {
        LOG.debug("findAllTest()");
        List<Persona> personas = personaService.findAll();
        assertEquals(3, personas.size());
    }
}
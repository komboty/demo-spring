package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.demo.domain.Persona;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * PersonaDAOImpTest
 */
@SpringBootTest
public class PersonaDAOImpTest {
    private static Logger LOG = LoggerFactory.getLogger(PersonaDAOImpTest.class);

    private static EntityManager entityManager;
    private static PersonaDAO personaDAO;

    @BeforeAll
    public static void inicializar() {
        LOG.debug("inicializar()");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-tests-memoria");
        entityManager = emf.createEntityManager();
        personaDAO = new PersonaDAOImp(entityManager);
    }

    @Test
    public void findByIdTest() {
        LOG.debug("findByIdTest()");
        Persona persona = personaDAO.findById(1);
        assertEquals(1, persona.getId());
        assertEquals("JUANITO", persona.getName());
    }

    @Test
    public void findAllTest() {
        LOG.debug("findAllTest()");
        List<Persona> personas = personaDAO.findAll();
        assertEquals(3, personas.size());
    }
}
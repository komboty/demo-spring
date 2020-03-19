package com.example.demo.controllers;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.domain.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * PersonaControllerTest
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
public class PersonaControllerTest {
    private static Logger LOG = LoggerFactory.getLogger(PersonaControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void findAllTest() {
        LOG.debug("findAllTest()");

        try {
            mockMvc.perform(get("/personas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("JUANITO"));

        } catch (Exception e) {
            LOG.error("findAllTest()", e);
        }
    }

    @Test
    @Order(2)
    public void findByIdTest() {
        LOG.debug("findByIdTest()");

        try {
            mockMvc.perform(get("/persona/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("JUANITO"));

        } catch (Exception e) {
            LOG.error("findByIdTest()", e);
        }
    }

    @Test
    @Order(3)
    public void saveTest() {
        LOG.debug("saveTest()");
        Persona persona = new Persona();
        persona.setName("New Persona");

        try {
            mockMvc.perform(post("/persona")
            .content(new ObjectMapper().writeValueAsString(persona))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value(persona.getName()));

        } catch (Exception e) {
            LOG.error("saveTest()", e);
        }
    }
}
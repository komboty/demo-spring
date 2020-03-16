package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * PersonaControllerTest
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PersonaControllerTest {
    private static Logger LOG = LoggerFactory.getLogger(PersonaControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllTest() {
        LOG.debug("findAllTest()");

        try {
            mockMvc.perform(get("/personas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("JUANITO"));

        } catch (Exception e) {
            LOG.error("findAllTest()", e);
        }
    }

    @Test
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
}
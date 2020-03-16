package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.demo.domain.Persona;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	private static Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

	@Test
	void contextLoads() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-tests-memoria");
        EntityManager em = emf.createEntityManager();

		LOG.debug(em.find(Persona.class, 1).toString());
		LOG.debug(em.find(Persona.class, 1).getName());
	}

}

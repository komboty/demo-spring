package com.example.demo.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * GenericImp
 */
public abstract class GenericDAOImp<T,PK> implements GenericDAO<T,PK>{

    private EntityManager entityManager;
    private Class<T> clase;

    public GenericDAOImp(EntityManager entityManager, Class<T> clase) {
        this.entityManager = entityManager;
        this.clase = clase;
    }

    @Override
    public T findById(PK id) {
        return this.entityManager.find(this.clase, id);
    }

    @Override
    public List<T> findAll() {
        Query query = this.entityManager.createQuery("SELECT a FROM " + clase.getSimpleName() + " a");
        return query.getResultList();
    }

    @Override
    public T save(T a) {
        this.entityManager.getTransaction().begin();
        T aNew = this.entityManager.merge(a);
        this.entityManager.getTransaction().commit();
        return aNew;
    }

    @Override
    public void remove(T a) {
        this.entityManager.remove(a);
    }
}
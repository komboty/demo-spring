package com.example.demo.repositories;

import java.util.List;

/**
 * GenericDAO
 */
public interface GenericDAO<T,PK> {

    public T findById(PK id);
    public List<T> findAll();
    public T save(T t);    
    public void remove(T t);
}
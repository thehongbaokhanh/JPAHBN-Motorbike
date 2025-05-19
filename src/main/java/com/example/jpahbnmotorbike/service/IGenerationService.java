package com.example.jpahbnmotorbike.service;

import java.util.List;

public interface IGenerationService<T> {
    List<T> findAll();
    T findById(long id);
    List<T> findByName(String name);
    List<T> findByBestSelling();
    void save(T t);
    void delete(long id);
}

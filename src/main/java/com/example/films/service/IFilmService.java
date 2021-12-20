package com.example.films.service;

import java.util.Set;

public interface IFilmService<T> {
    boolean save(T t);
    boolean delete(Integer id);
    T findById(Integer id);
    Set<T> findAll(String director);
    T update(T t);

}

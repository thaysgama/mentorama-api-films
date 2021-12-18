package com.example.films.service;

import java.util.List;

public interface IFilmService<T> {
    boolean save(T t);
    boolean delete(Integer id);
    T findById(Integer id);
    List<T> findAll(String director);
    T update(T t);

}

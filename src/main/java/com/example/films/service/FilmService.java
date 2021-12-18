package com.example.films.service;

import com.example.films.entities.Film;
import com.example.films.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService implements IFilmService<Film>{

    @Autowired
    private FilmRepository filmRepository;


    @Override
    public boolean save(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public boolean delete(Integer id) {
        return filmRepository.delete(id);
    }

    @Override
    public Film findById(Integer id) {
        return filmRepository.findById(id);
    }

    @Override
    public List<Film> findAll(String director) {
        if(director!=null){
            return filmRepository.findAll(director);
        }
        return filmRepository.findAll();
    }

    @Override
    public Film update(Film film) {
        return filmRepository.update(film);
    }
}

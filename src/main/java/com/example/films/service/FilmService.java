package com.example.films.service;

import com.example.films.entities.Film;
import com.example.films.processor.Processor;
import com.example.films.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FilmService implements IFilmService<Film>{

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private List<Processor> processes;

    public FilmService() {
    }


    @Override
    public boolean save(Film film) {
        boolean validation = true;
        for (Processor p : processes){
            if(!p.process(film)){
                validation=false;
                break;
            }
        }
        if(validation){
            film.setId(filmRepository.idGenerator());
            return filmRepository.save(film);
        }
        return false;
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
    public Set<Film> findAll(String director) {
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

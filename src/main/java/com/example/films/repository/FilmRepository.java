package com.example.films.repository;

import com.example.films.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class FilmRepository {

    private final Set<Film> filmSet;
    private static int count = 1;


    @Autowired
    public FilmRepository() {
        this.filmSet = new HashSet<>();
    }

    public boolean save(Film film){
        return filmSet.add(film);
    }

    public int idGenerator(){
        return count++;
    }

    public boolean delete(Integer id){
        Film film = findById(id);
        if(film!=null){
            return filmSet.remove(film);
        }
        return false;
    }

    public Film findById(Integer id){
        return filmSet.stream()
                .filter(item-> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Set<Film> findAll(){
        return filmSet;
    }

    public  Set<Film> findAll(String director){
        return filmSet.stream()
                .filter(item->item.getDirector().contains(director))
                .collect(Collectors.toSet());
    }

    public Film update(Film film){
        Film item = findById(film.getId());
        if(item!=null){
            if(film.getDirector()!=null)
                item.setDirector(film.getDirector());
            if(film.getTitle()!=null)
                item.setTitle(film.getTitle());
            if(film.getRating()!=null)
                item.setRating(film.getRating());
            if (film.getYear() !=null)
                item.setYear(film.getYear());
        }
        return item;
    }


}

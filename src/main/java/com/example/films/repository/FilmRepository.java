package com.example.films.repository;

import com.example.films.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilmRepository {

    private final List<Film> filmsList;
    static private Integer count = 1;


    @Autowired
    public FilmRepository() {
        this.filmsList = new ArrayList<>();
    }

    public boolean save(Film film){
        film.setId(count);
        count++;
        return filmsList.add(film);
    }

    public boolean delete(Integer id){
        Film film = findById(id);
        if(film!=null){
            return filmsList.remove(film);
        }
        return false;
    }

    public Film findById(Integer id){
        return filmsList.stream()
                .filter(item-> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Film> findAll(){
        return filmsList;
    }

    public  List<Film> findAll(String director){
        return filmsList.stream()
                .filter(item->item.getDirector().contains(director))
                .collect(Collectors.toList());
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

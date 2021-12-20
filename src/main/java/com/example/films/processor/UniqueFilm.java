package com.example.films.processor;

import com.example.films.entities.Film;
import com.example.films.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueFilm implements Processor<Film> {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public boolean process(Film film) {
            boolean validation = true;
            for (Film item : filmRepository.findAll()){
                if(film.getTitle().compareTo(item.getTitle())==0
                        && film.getDirector().compareTo(item.getDirector())==0
                        && film.getRating().compareTo(item.getRating())==0
                        && film.getYear().compareTo(item.getYear())==0){
                    validation = false;
                    break;
                }
            }
            return validation;
    }
}

package com.example.films.processor;

import com.example.films.entities.Film;
import org.springframework.stereotype.Component;

@Component
public class ConfirmRangeRating implements Processor<Film>{
    @Override
    public boolean process(Film film) {
        return film.getRating() > 0 && film.getRating() <= 5;
    }
}

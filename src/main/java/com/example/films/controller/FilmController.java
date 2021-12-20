package com.example.films.controller;

import com.example.films.entities.Film;
import com.example.films.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class FilmController {

    @Autowired
    private FilmService filmService;


    @PostMapping
    public ResponseEntity<String> save(@RequestBody Film film){
        boolean saved = filmService.save(film);
        if(saved)
            return new ResponseEntity<String>("Filme Cadastrado",HttpStatus.CREATED);
        return new ResponseEntity<>("Ops! Verifique se o filme já está cadastrado ou se a nota está entre 1-5.", HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        boolean deleted = filmService.delete(id);
        if(deleted)
            return new ResponseEntity<String>("Filme Deletado",HttpStatus.OK);
        return new ResponseEntity<>("Ops! Esse filme não foi encontrado.", HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<Set<Film>> findAll(@RequestParam(required = false) String director){
        return new ResponseEntity<>(filmService.findAll(director), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Film found = filmService.findById(id);
        if(found!=null)
            return new ResponseEntity<Film>(found, HttpStatus.OK);
        return new ResponseEntity<String>("Ops! Esse filme não foi encontrado.", HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Film film){
        Film updated = filmService.update(film);
        if(updated != null)
            return new ResponseEntity<String>("Filme Atualizado",HttpStatus.OK);
        return new ResponseEntity<>("Ops! Esse filme não foi encontrado.", HttpStatus.NOT_FOUND);
    }
}

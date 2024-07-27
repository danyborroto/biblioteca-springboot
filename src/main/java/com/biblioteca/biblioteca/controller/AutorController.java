package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.entities.Autor;
import com.biblioteca.biblioteca.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> getAll(){
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable Long id){
        return autorService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Autor> createAutor(@Valid @RequestBody Autor autor){
        Autor newAutor = autorService.create(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAutor);
    }

    @PutMapping("/{id}")
    public Autor updateAutor(@PathVariable Long id, @Valid @RequestBody Autor newAutor){
        return autorService.update(id, newAutor);
    }

    @DeleteMapping("/{id}")
    public String deleteAutor(@PathVariable Long id){
        return autorService.delete(id);
    }
}

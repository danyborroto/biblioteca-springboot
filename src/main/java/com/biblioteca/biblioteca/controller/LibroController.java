package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.entities.Libro;
import com.biblioteca.biblioteca.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> getAll(){
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Long id){
        return libroService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Libro> createLibro(@Valid @RequestBody Libro libro){
        Libro newLibro = libroService.create(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLibro);
    }

    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id, @Valid @RequestBody Libro libro){
        return libroService.update(id, libro);
    }

    @DeleteMapping("/{id}")
    public String deleteLibro(@PathVariable Long id){
        return libroService.delete(id);
    }
}

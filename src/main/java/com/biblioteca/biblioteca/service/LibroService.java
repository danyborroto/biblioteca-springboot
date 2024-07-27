package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.entities.Libro;
import com.biblioteca.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll(){
        return libroRepository.findAll();
    }

    public Libro findById(Long id){
        Libro libro = libroRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Book with ID: "+id+" not found"));
        return libro;
    }

    public Libro create(Libro libro){
        return libroRepository.save(libro);
    }

    public Libro update(Long id, Libro libroDetails){
        Libro libro = libroRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Book with ID: "+id+" not found"));
        libro.setNombre(libroDetails.getNombre());
        libro.setId_autor(libroDetails.getId_autor());
        return libroRepository.save(libro);
    }

    public String delete(Long id){
        Libro libro = libroRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Book with ID: "+id+" not found"));
        libroRepository.delete(libro);
        return "Book deleted successfully";
    }
}

package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.entities.Autor;
import com.biblioteca.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll(){
        return autorRepository.findAll();
    }

    public Autor findById(Long id){
        Autor autor = autorRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Author not found"));
        return autor;
    }

    public Autor create(Autor autorNew){
        return autorRepository.save(autorNew);
    }

    public Autor update(Long id, Autor autorDetails){
        Autor autor = autorRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Author not found"));
        autor.setNombre(autorDetails.getNombre());
        return autorRepository.save(autor);
    }

    public String delete(Long id){
        Autor autor = autorRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Author not found"));
        autorRepository.delete(autor);
        return "Author deleted successfully";
    }
}

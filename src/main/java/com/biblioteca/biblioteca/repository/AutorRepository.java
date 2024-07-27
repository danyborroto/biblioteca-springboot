package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AutorRepository extends JpaRepository<Autor, Long> {
}

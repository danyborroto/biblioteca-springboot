package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Long> {
}

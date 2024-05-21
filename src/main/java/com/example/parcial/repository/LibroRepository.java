package com.example.parcial.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.parcial.entity.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long> {

}

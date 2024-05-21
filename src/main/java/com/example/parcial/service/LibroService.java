package com.example.parcial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.example.parcial.repository.LibroRepository;
import com.example.parcial.dto.LibroDTO;
import com.example.parcial.entity.Libro;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LibroService(LibroRepository libroRepository, ModelMapper modelMapper) {
        this.libroRepository = libroRepository;
        this.modelMapper = modelMapper;
    }

    public LibroDTO save(LibroDTO libroDTO) {
        if (libroDTO == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");

        }

        Libro libro = modelMapper.map(libroDTO, Libro.class);
        libro.setStatus(0);
        libro = libroRepository.save(libro);
        return modelMapper.map(libro, LibroDTO.class);
    }

    public List<LibroDTO> findAll() {
        List<Libro> libros = (List<Libro>) libroRepository.findAll();
        return libros.stream().map(libro -> modelMapper.map(libro, LibroDTO.class)).collect(Collectors.toList());
    }

    public LibroDTO findById(Long id) {
        Libro libro = libroRepository.findById(id).orElse(null);
        if (libro == null) {
            throw new IllegalArgumentException("El libro no existe");
        }
        return modelMapper.map(libro, LibroDTO.class);
    }

    public LibroDTO update(LibroDTO libroDTO) {
        if (libroDTO == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
        if (libroDTO.getId() == null) {
            throw new IllegalArgumentException("El id del libro no puede ser nulo");
        }

        Libro libro = libroRepository.findById(libroDTO.getId()).orElse(null);
        libro = modelMapper.map(libroDTO, Libro.class);
        libro = libroRepository.save(libro);
        return modelMapper.map(libro, LibroDTO.class);
    }

    private LibroDTO delete(Long id) {
        Libro libro = libroRepository.findById(id).orElse(null);
        if (libro == null) {
            throw new IllegalArgumentException("El libro no existe");
        }
        libro.setStatus(1);
        libro = libroRepository.save(libro);
        return modelMapper.map(libro, LibroDTO.class);
    }

}

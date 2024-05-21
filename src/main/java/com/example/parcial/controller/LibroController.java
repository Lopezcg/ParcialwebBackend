package com.example.parcial.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parcial.dto.LibroDTO;
import com.example.parcial.service.LibroService;
// Remove the conflicting import statement
// import org.apache.tomcat.util.http.parser.MediaType;



@RequestMapping("/libro")
@RestController
public class LibroController {
    
        private final LibroService libroService;
    
        public LibroController(LibroService libroService) {
            this.libroService = libroService;
        }
    
        @CrossOrigin
        @PostMapping
        public  ResponseEntity<LibroDTO> save(@RequestBody LibroDTO libroDTO) {
            LibroDTO savedDTO = libroService.save(libroDTO);
            return  ResponseEntity.ok().body(savedDTO);
        }
    
        @CrossOrigin
        @GetMapping
        public ResponseEntity<List<LibroDTO>> findAll() {
            return ResponseEntity.ok().body(libroService.findAll());
        }
    
        @CrossOrigin
        @GetMapping(value = "/{id}")
        public ResponseEntity<LibroDTO> findById(@PathVariable Long id) {
            LibroDTO libroDTO = libroService.findById(id);
            return ResponseEntity.ok().body(libroDTO);
        }
    
        @CrossOrigin
        @PutMapping
        public ResponseEntity<LibroDTO> update(@RequestBody LibroDTO libroDTO) {
            LibroDTO updatedDTO = libroService.update(libroDTO);
            return ResponseEntity.ok().body(updatedDTO);
        }

}

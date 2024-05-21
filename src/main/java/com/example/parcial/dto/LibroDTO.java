package com.example.parcial.dto;

import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {
    private Long id;
    private String nombre;
    private LocalDate fechaEscritura;
    private String autor;
    private String numEdicion;
    private Long precio;
    private String tipo;
    private String fama;
}

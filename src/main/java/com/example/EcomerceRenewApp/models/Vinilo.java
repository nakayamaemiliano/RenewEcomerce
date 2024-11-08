package com.example.EcomerceRenewApp.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;

@Data
@Entity
public class Vinilo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String artista;
    private String descripcion;
    private BigDecimal precio;
    private int stock;
    private String genero;
    @Column(name = "anio")
    private int anio;

    private String imagenUrl;


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}

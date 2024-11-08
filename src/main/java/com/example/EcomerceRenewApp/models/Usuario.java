package com.example.EcomerceRenewApp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String email;


    private String contrasenia;

    @Enumerated(EnumType.STRING)
    private Rol rol;


    @OneToMany(mappedBy = "usuario")
    private Carrito carrito;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    enum Rol {
        USUARIO, ADMINISTRADOR
    }




}

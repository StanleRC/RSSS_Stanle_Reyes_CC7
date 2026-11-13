package com.example.rsss_stanle_reyes_cc7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Vheiculos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vheiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String marca;
    private String modelo;
    private String propietario;
    private boolean activo;
}

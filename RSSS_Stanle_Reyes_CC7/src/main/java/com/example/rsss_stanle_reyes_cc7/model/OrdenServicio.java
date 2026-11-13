package com.example.rsss_stanle_reyes_cc7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OrdenServicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Double costo;

    @Enumerated(EnumType.STRING)
    private EnumTipo tipo;

    @Enumerated(EnumType.STRING)
    private EnumEstado estado;

    @OneToOne
    @JoinColumn(name = "vheiculo_id")
    private Vheiculo vehiculo;

}

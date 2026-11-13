package com.example.rsss_stanle_reyes_cc7.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VheiculoDTO {
    @NotNull(message = "El id del vheiculo es obligatoria")
    private Long vheiculo_id;

    @NotBlank(message = "La placa es obligatoria")
    private String placa;

    @NotBlank(message = "La marca es obligatoria")
    private String marca;

    @NotBlank(message = "El modelo es obligatoria")
    private String modelo;

    @NotBlank(message = "El propietario es obligatoria")
    private String propietario;

    @NotBlank(message = "El esyado es obligatorio")
    private boolean activo;
}

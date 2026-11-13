package com.example.rsss_stanle_reyes_cc7.controller.dto;

import com.example.rsss_stanle_reyes_cc7.model.EnumEstado;
import com.example.rsss_stanle_reyes_cc7.model.EnumTipo;
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
public class OrdenServicioDTO {

    @NotNull(message = "El id del vheiculo es obligatoria")
    private Long vheiculo_id;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotBlank(message = "El tipo de servicio es obligatorio")
    private EnumEstado estado;

    @NotBlank(message = "El tipo de servicio es obligatorio")
    private EnumTipo tipo;
}

package com.example.rsss_stanle_reyes_cc7.controller.dto;

import com.example.rsss_stanle_reyes_cc7.model.EnumEstado;
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
public class DesactivarVheiculoDTO {
    @NotNull(message = "El id de la orden es obligatoria")
    private Long vheiculo_id;

    @NotBlank(message = "El estado del vheiculo es obligatorio")
    private EnumEstado estado;
}

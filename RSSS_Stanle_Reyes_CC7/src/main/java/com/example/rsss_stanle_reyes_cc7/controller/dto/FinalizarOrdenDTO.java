package com.example.rsss_stanle_reyes_cc7.controller.dto;

import com.example.rsss_stanle_reyes_cc7.model.EnumEstado;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinalizarOrdenDTO {
    @NotNull(message = "El id de la orden es obligatoria")
    private Long orden_id;

    @NotBlank(message = "El estado de la orden es obligatoria")
    private EnumEstado estado;

    @NotBlank(message = "El costo es obligatorio")
    @Positive(message = "El costo debe ser positivo")
    private double costo;
}

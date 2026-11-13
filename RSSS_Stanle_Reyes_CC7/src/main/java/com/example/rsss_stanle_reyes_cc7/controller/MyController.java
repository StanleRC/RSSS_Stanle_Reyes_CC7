package com.example.rsss_stanle_reyes_cc7.controller;

import com.example.rsss_stanle_reyes_cc7.controller.dto.FinalizarOrdenDTO;
import com.example.rsss_stanle_reyes_cc7.controller.dto.OrdenServicioDTO;
import com.example.rsss_stanle_reyes_cc7.controller.dto.DesactivarVheiculoDTO;
import com.example.rsss_stanle_reyes_cc7.controller.dto.VheiculoDTO;
import com.example.rsss_stanle_reyes_cc7.model.OrdenServicio;
import com.example.rsss_stanle_reyes_cc7.model.Vheiculo;
import com.example.rsss_stanle_reyes_cc7.service.MyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controlador")
@CrossOrigin("*")
public class MyController {

    private final MyService servicio;
    public MyController(MyService servicio) {
        this.servicio = servicio;
    }

    @Valid
    @PostMapping("/crearOrden")
    public ResponseEntity<OrdenServicio> ordenServicioResponseEntity (@RequestBody @Valid OrdenServicioDTO payload) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(servicio.crearOrdenServicio(payload));
    }

    @Valid
    @PatchMapping("/finalizarOrden")
    public ResponseEntity<OrdenServicio> ordenServicioResponseEntity (@RequestBody @Valid FinalizarOrdenDTO payload){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(servicio.finalizarOrden(payload));
    }

    @Valid
    @PatchMapping("/desactivarVheiculo")
    public ResponseEntity<Vheiculo> vheiculoResponseEntity (@RequestBody @Valid DesactivarVheiculoDTO payload){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(servicio.desactivarVheiculo(payload));
    }

    @Valid
    @PostMapping("/crearVheiculo")
    public ResponseEntity<Vheiculo> vheiculoResponseEntity (@RequestBody @Valid VheiculoDTO payload) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(servicio.registrarVheiculo(payload));
    }
}
